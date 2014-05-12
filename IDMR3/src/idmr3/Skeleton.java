/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marlon
 */
public class Skeleton extends RemoteObject {
    
    
    
    private Object remoteObject = null;
    private Socket skt          = null;
    private ObjectOutputStream oos = null;
    
    public Skeleton(Object remoteObject, Socket skt, ObjectOutputStream oos) {
        this.remoteObject = remoteObject;
        this.skt = skt;
        this.oos = oos;
    }
    
    public Object getObjectInterfaces() {
    return this.remoteObject.getClass().getInterfaces();
}
    
    public Object runMethod(String methodName, Object[] args, Object[] newArgs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, IOException
    {
       Object returnObject;
       boolean isCallback = false;
        Class [] parameterTypes ;
       if (args == null) {
           parameterTypes = null;
       }
       else {
        parameterTypes = new Class[args.length];
       System.out.println(newArgs[0].getClass().getName());
       for (int ii=0;ii<args.length;ii++) {
           if (newArgs[ii].getClass().getName().startsWith("com.sun.proxy")) {
               System.out.println("Deu certoooo!!!");
               parameterTypes[ii] = (Class) args[ii];
               oos.writeObject("Begin of callback");
               isCallback = true;
           } else
           parameterTypes[ii] = args[ii].getClass();
           System.out.println(parameterTypes[ii].getName());
       }
       }
       System.out.println(methodName);
        Method method = this.remoteObject.getClass().getMethod(methodName, parameterTypes);
                
       returnObject = method.invoke(remoteObject, newArgs);
       
      if (isCallback) { oos.writeObject("End of callback");
      System.out.println("FIm dos métodos de callback");
      }
      else oos.writeObject("Go on!");
       
      return returnObject; 
    }
    
}
