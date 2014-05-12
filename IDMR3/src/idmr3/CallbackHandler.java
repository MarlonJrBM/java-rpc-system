/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 *
 * @author Marlon
 */
public class CallbackHandler extends RemoteObject implements InvocationHandler {
    
    private Socket skt;
    
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    private String name;
    

    
 
 
    public CallbackHandler(String name, Socket skt, ObjectOutputStream oos, ObjectInputStream ois)
    {
    this.skt = skt;
    this.name = name;
    this.oos = oos;
    this.ois = ois;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
       
        Object returnValue = null;
        System.out.println("KD VC CARALHO?!?!");
//        System.out.println("Nome do objeto: " + o.toString());
        oos.writeObject(method.getName()); //envia nome do método
        oos.writeObject(args);
        
        System.out.println("Método de callback: "  + method.getName());
        System.out.println("Argumentos de callback: "  + args[0].toString());
        
//        System.out.println("Objeto invocador: " + o.toString());
        
        //escuta pelo valor de retorno
        
        returnValue = ois.readObject();
        
        return returnValue;
       
        
        
    }
    
}
