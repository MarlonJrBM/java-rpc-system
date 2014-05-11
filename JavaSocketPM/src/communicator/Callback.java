/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

import idmr3.Remote;

/**
 *
 * @author Marlon
 */
public interface Callback extends Remote {
    
    public void callMeBack(String text);
    
}
