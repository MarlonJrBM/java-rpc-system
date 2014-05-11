/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import idmr3.*;
/**
 *
 * @author Marlon
 */
public interface Human extends Remote
{
    public String getFirstName() ;
    
    public String getLastName() ;
    
    public void setName(String first, String last) ; 
}

