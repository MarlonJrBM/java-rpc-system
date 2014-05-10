/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stubs;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 *
 * @author Marlon
 */
public class ProxyFactory {
    
  
    
    public static<T> T getProxy(Class<T> intf, 
      final T obj) {
        return (T) 
          Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class[] { intf },
                new ConnectionHandler(obj));
    }
    
    
}


