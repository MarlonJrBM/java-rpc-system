/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javasocketpm;

import java.io.Serializable;
import naming.*;
import stubs.*;

/**
 *
 * @author Marlon
 */



class Person implements Human, Serializable
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



public class JavaSocketPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Person vinicius = new Person("Vinicius", "Grossi");
        Human clone = (Human) ProxyFactory.getProxy(Human.class, vinicius);
        // TODO code application logic here
        String teste = "vsf";
        CharSequence clone_teste = ProxyFactory.getProxy(CharSequence.class, teste);
        
        Naming.bind("ObjetoRemoto", clone);
        
        System.out.println(vinicius.getFirstName());
        System.out.println(clone.getFirstName());
        
        vinicius.setName("Marlon", "Marques");
        
        System.out.println(vinicius.getFirstName());
        System.out.println(clone.getFirstName());
    }
    
    
    
}
