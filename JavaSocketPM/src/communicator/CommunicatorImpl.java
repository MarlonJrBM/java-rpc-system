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
    
    public void callbak(Callback callbak, String text)
    {
        callbak.callMeBack(text);
    }
    
    public Callback getCallback()
    {
        return this.callbak;
    }
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    
     public void subscribe(String name) {
         this.name = name;
         System.out.println(name + " entrou no servidor.");
         
     }
    
    public String getName() {
        return this.name;
    }
    
    public void sendMsg(String message) {
        System.out.println(message);
//        this.callbak.callMeBack("Fala vei!");
    }
    
}
