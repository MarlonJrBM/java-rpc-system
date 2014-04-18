/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatclient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import chatinterface.*;
import java.io.*;

/**
 *
 * @author Marlon
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        String userName, msg;
        int exitCode = 0;
        ServerInterface server = null;
        ClientInterface client = null;
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        server = (ServerInterface) Naming.lookup("//localhost/ChatServer");
        System.out.print("Please enter your username: ");
        userName = br.readLine();
        client =  (ClientInterface) new ChatClient(userName);
        System.out.println("Welcome to teh chat " + userName +"! Type /quit to quit the application.");
        server.connect(client); 
        msg = br.readLine();
        while (!msg.contentEquals("/quit"))
        {
            server.send(client.getClientName(), msg);
            msg = br.readLine();
        }
        
        
        //server.disconnect(client);
        //System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("ChatClient Exception!" + e);
            exitCode = 666;
        }
        finally
        {
 
            if (server!= null && client != null)      
                server.disconnect(client);
            System.out.println("Exiting the application");
            System.exit(exitCode);
        }
    }
    
}
