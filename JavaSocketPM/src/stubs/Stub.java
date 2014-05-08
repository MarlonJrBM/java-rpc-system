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
    
    
    
    /**
     * Exporta um objeto remoto para fazê-lo disponivel a acesso remoto através da porta 1099
     * @param o objeto remoto que vai ser convertido para uma stub
     * @return uma stub do objeto remoto (feita com proxy dinâmico)
     */
    public static Stub exportObject(Object o)
    {
        return null;
    }
    
    
    
    public Stub(Class remoteClass)
    {
        //TODO - de alguma maneira esse cara aqui vai fazer a conexão do cliente com o servidor...
        proxy = (Object) Proxy.newProxyInstance(remoteClass.getClassLoader(), remoteClass.getInterfaces(), 
                new ConnectionHandler(proxy));
    }

    
}
