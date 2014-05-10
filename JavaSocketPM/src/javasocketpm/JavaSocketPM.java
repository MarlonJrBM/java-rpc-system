/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javasocketpm;

import naming.*;
import stubs.*;

/**
 *
 * @author Marlon
 */


interface Human
{
    public String getFirstName() throws Throwable;
    
    public String getLastName() throws Throwable;;
    
    public void setName(String first, String last) throws Throwable;;  
}

class Person implements Human
{
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
    
    public String getFirstName() throws Throwable
    {
        return this.firstName;
    }
    
 
    public String getLastName() throws Throwable
    {
        return this.lastName;
    }
    
    public void setName(String first, String last) throws Throwable
    {
        this.firstName = first;
        this.lastName = last;
    }
    
    
    
}



public class JavaSocketPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Person vinicius = new Person("Vinicius", "Grossi");
        Human clone = (Human) ProxyFactory.getProxy(Human.class, vinicius);
        // TODO code application logic here
        
        System.out.println(vinicius.getFirstName());
        System.out.println(clone.getLastName());
    }
    
    
    
}
