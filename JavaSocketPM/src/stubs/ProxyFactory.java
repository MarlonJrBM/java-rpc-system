/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stubs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import javasocketpm.*;
/**
 *
 * @author Marlon
 */
public class ProxyFactory {
    
    
    public static Object getProxy(Class intf, 
      final Object obj) {
        return (Object) 
          Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class[] { intf },
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, 
                      Object[] args) throws Throwable {
                        return method.invoke(obj, args);
                    }
                });
    }
    
    
    
}
