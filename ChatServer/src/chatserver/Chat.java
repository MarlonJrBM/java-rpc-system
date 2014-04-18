/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatserver;

import chatinterface.ClientInterface;
import chatinterface.ServerInterface;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;


/**
 *
 * @author Marlon
 */
public class Chat extends UnicastRemoteObject implements ServerInterface {
    
    ArrayList<ClientInterface> clientList;
    
    public Chat() throws RemoteException
    {
        this.clientList = new ArrayList();
    }
    
    @Override
    public void connect(ClientInterface c) throws RemoteException
    {
        this.clientList.add(c);
        this.send("SERVER", c.getClientName() + " has joined the chat.");
    }
    
    @Override
    public void send(String sender, String msg) throws RemoteException
    {
        for (ClientInterface c: clientList)
        {
            c.displayMsg(sender, msg);
        }
    }
    
    @Override
    public void disconnect(ClientInterface c) throws RemoteException
    {
        c.displayMsg("SERVER", "Thanks for using teh chat! Bye Bye!");
        clientList.remove(c);
        this.send("SERVER", c.getClientName() + " has left the chat.");
        
    }
    
    
}
