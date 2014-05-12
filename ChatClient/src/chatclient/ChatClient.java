/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatclient;

import chatinterface.ClientInterface;

import idmr3.*;
/**
 *
 * @author Marlon
 */
public class ChatClient extends RemoteObject implements ClientInterface {
    
    private final String userName;
    private final ChatFrame frame;
    
    public ChatClient(String userName, ChatFrame frame) 
    {
        this.userName = userName;
        this.frame = frame;
    }
    
   @Override
   public String getClientName() 
   {
       return this.userName;
   }
   @Override
   public void displayMsg(String sender, String msg) 
   {
       this.frame.displayMsg(sender, msg);
       System.out.println(sender +  ": " + msg);
   }
    
    
    
}
