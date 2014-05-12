/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author Marlon
 */
public class StubFactory {
    
    public static Object getStub(Class[] interfaces, InvocationHandler invocationHandler) {
        
        
        return (Proxy.newProxyInstance(interfaces[0].getClassLoader(),
                interfaces,
                invocationHandler));
    }
    

       
}
