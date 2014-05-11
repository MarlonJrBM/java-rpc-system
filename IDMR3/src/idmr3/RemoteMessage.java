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
public class RemoteMessage extends RemoteObject {
    
    Method method;
    Object[] args;
    
    public RemoteMessage(Method method, Object[] args) {
        this.method = method;
        this.args = args;
    }
    
    public Method getMethod() {
        return this.method;
    }
    
    public Object[] getArgs() {
    return this.args;
}
    
}
