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
    
    public  Object runMethod(RemoteMessage message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {

        return message.getMethod().invoke(remoteObject, message.getArgs());
    }
    
}
