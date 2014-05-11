/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author Marlon
 */
public class ConnectionHandler implements InvocationHandler, Serializable {
    //Responsável por fazer a conexão com o servidor através dos sockets
    
   
    
    private Socket skt;
    
    private String name;
    
 
 
public ConnectionHandler(String name, Socket skt)
{
    this.skt = skt;
    this.name = name;
}
    
  
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
    {
        //TODO - tudo
        
        System.out.println("Fui invocado: " + method.getName() );
//       return method.invoke(target, args);
        
        ObjectOutputStream outToServer = new ObjectOutputStream(skt.getOutputStream());
        
        
        
        
        outToServer.close();
 
        
       
        
        return new Object();
        
    }
    
    
    
}
