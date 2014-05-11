/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marlon
 */
public class Skeleton extends RemoteObject {
    
    private Object remoteObject = null;
    
    public Skeleton(Object remoteObject) {
        this.remoteObject = remoteObject;
    }
    
    public Object getObjectInterfaces() {
    return this.remoteObject.getClass().getInterfaces();
}
    
    public Object runMethod(String methodName, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException
    {
       Class [] parameterTypes = new Class[args.length];
       for (int ii=0;ii<args.length;ii++) {
           parameterTypes[ii] = args[ii].getClass();
       }
        Method method = this.remoteObject.getClass().getMethod(methodName, parameterTypes);
                
        return method.invoke(remoteObject, args);
        
    }
    
}
