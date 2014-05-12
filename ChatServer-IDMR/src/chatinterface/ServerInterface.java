/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatinterface;

import idmr3.*;

/**
 *
 * @author Marlon
 */
public interface ServerInterface extends Remote {
    public void send(ClientInterface sender, String msg) ;
    public void connect(ClientInterface c) ;
    public void disconnect(ClientInterface c) ;
    
}
