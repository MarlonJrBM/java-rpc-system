/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
/**
 *
 * @author Marlon
 */
public class ProxyFactory {
    
  
    
    public static Object getProxy(Class[] intf, String name, 
      Socket skt) {
        return (Object)
          Proxy.newProxyInstance(intf[0].getClassLoader(),
                intf,
                new ConnectionHandler(name,skt));
    }
    
    
}


