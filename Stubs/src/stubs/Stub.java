/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stubs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author Marlon
 */
public class Stub {
    
    Object proxy = new Object();
    
    public Stub(Class remoteClass)
    {
        //TODO - de alguma maneira esse cara aqui vai fazer a conexão do cliente com o servidor...
        proxy = (Object) Proxy.newProxyInstance(remoteClass.getClassLoader(), remoteClass.getInterfaces(), 
                new ConnectionHandler(proxy));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
