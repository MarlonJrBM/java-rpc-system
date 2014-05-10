/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stubs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author Marlon
 */
public class ConnectionHandler implements InvocationHandler {
    //Responsável por fazer a conexão com o servidor através dos sockets
    
    private Object target;
    // esse é o cara do servidor (que tem que ser alcançado através do socket)
 
    public ConnectionHandler()
    {
        
    }
    
    public ConnectionHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
    {
        //TODO - tudo
        
       return method.invoke(proxy, args);
        
    }
    
    
    
}
