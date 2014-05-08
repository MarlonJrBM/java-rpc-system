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
public interface ServerInterface extends Remote {
    public void send(String sender, String msg) throws RemoteException;
    public void connect(ClientInterface c) throws RemoteException;
    public void disconnect(ClientInterface c) throws RemoteException;
}
