/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatinterface;

import java.rmi.*;

/**
 *
 * @author Marlon
 */
public interface ClientInterface extends Remote {
    
    public void displayMsg(String sender, String msg) throws RemoteException;
    
    public String getClientName() throws RemoteException;
    
}
