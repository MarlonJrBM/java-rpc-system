/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatserver;



import idmr3.*;
import java.io.*;


/**
 *
 * @author Marlon
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String command = "";
        
         try {
       BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
       Registry r = new Registry();
       r.startServer(1099);
       Chat chatServer = new Chat();
       r.bind("ChatServer", chatServer);
       System.out.println ("ChatServer is running. Type /quit to shut it down");
       while (!command.contentEquals("/quit"))
       {
           command = rd.readLine();
       }
       
       //r.unbind("ChatServer");
       r.stopServer();
      
    } catch (Exception e) {
      System.out.println ("ChatServer failed: " + e);
    }
        
        
    }
    
    
}
