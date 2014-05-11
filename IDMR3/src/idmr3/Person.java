/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import idmr3.RemoteObject;

/**
 *
 * @author Marlon
 */
public class Person extends RemoteObject implements Human {
    
    String firstName, lastName;
    int age;
    
    public Person()
    {
        this.firstName = "John";
        this.lastName = "Doe";
    }
    
    public Person(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;     
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
 
    public String getLastName() 
    {
        return this.lastName;
    }
    
    public void setName(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
    }
    
    
    
}
    

