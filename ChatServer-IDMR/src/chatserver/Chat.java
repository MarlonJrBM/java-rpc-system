/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatserver;

import chatinterface.ClientInterface;
import chatinterface.ServerInterface;
import java.util.ArrayList;
import idmr3.*;


/**
 *
 * @author Marlon
 */
public class Chat extends RemoteObject implements ServerInterface {
    
    ArrayList<ClientInterface> clientList;
    
    public Chat() 
    {
        this.clientList = new ArrayList();
    }
    
    @Override
    public void connect(ClientInterface c) 
    {
        this.clientList.add(c);
//        this.send("SERVER", c.getClientName() + " has joined the chat.");
    }
    
    @Override
    public void send(ClientInterface sender, String msg) 
    {
        for (ClientInterface c: clientList)
        {
            c.displayMsg(sender.getClientName(), msg);
        }
    }
    
    @Override
    public void disconnect(ClientInterface c) 
    {
//        c.displayMsg("SERVER", "Thanks for using teh chat! Bye Bye!");
        clientList.remove(c);
//        this.send("SERVER", c.getClientName() + " has left the chat.");
        
    }
    
    
}
