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
    Callback callbak;
    
    public CommunicatorImpl() {
        
    }
    
    public CommunicatorImpl(String name, Callback callbak) {
        this.setName(name);
        this.callbak = callbak;
    }
    
    public void callbak(Callback c, String text)
    {
        c.callMeBack(text);
    }
    
    public Callback getCallback()
    {
        return this.callbak;
    }
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    
     public void subscribe(Callback callbak) {
         this.callbak = callbak;
         
     }
    
    public String getName() {
        return this.name;
    }
    
    public void greet(String greeting) {
        System.out.println(greeting);
//        this.callbak.callMeBack("Fala vei!");
    }
    
}
