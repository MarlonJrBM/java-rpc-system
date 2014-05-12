/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;
import idmr3.*;

/**
 *
 * @author Marlon
 */
public interface Communicator extends Remote {
    
    public void subscribe(Callback callbak);
    
    public String getName();
    
    public Callback getCallback();
    
    public void greet(String greeting);
    
    public void callbak(String text);
}
