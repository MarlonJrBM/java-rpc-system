/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.lang.reflect.Method;

/**
 *
 * @author Marlon
 */
public class RemoteMessage extends RemoteObject   {
    
    String methodName;
    Object[] args;
    
    public RemoteMessage(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = args;
    }
    
    public String getMethod() {
        return this.methodName;
    }
    
    public Object[] getArgs() {
    return this.args;
}
    
}
