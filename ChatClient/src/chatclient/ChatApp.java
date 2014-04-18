/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatclient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import chatinterface.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;

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
        String userName, msg, addr;
        int exitCode = 0;
        ServerInterface server = null;
        ClientInterface client = null;
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the chat's IP address: (localhost for local) ");
        addr = br.readLine();
        Registry r = LocateRegistry.getRegistry(addr, 1099);
        System.out.println("Looking for rmi://" + addr + ":1099" + "/ChatServer");
        //server = (ServerInterface) Naming.lookup("rmi://" + addr + ":1099" + "/ChatServer");
        System.out.println("Server was found!");
        server = (ServerInterface) r.lookup("ChatServer");
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
