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
public interface RemoteMessageInterface extends Remote {
    
     public Method getMethod();
     
     public Object[] getArgs();
    
}
