/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

import idmr3.RemoteObject;

/**
 *
 * @author Marlon
 */
public class CommunicatorImpl extends RemoteObject implements Communicator {
    
    String name;
    
    public CommunicatorImpl() {
        
    }
    
    public CommunicatorImpl(String name) {
        this.setName(name);
    }
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    
     public void subscribe() {
         
     }
    
    public String getName() {
        return this.name;
    }
    
    public void greet(String greeting) {
        System.out.println(greeting);
    }
    
}
