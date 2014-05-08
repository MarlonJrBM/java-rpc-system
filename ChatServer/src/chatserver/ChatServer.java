/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatserver;


import java.rmi.registry.Registry;

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
       Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
       Chat chatServer = new Chat();
       r.rebind ("ChatServer", chatServer);
       System.out.println ("ChatServer is running. Type /quit to shut it down");
       while (!command.contentEquals("/quit"))
       {
           command = rd.readLine();
       }
       
       r.unbind("ChatServer");
       Chat.unexportObject(chatServer, false);
      
    } catch (Exception e) {
      System.out.println ("ChatServer failed: " + e);
    }
        
        
    }
    
    
}
