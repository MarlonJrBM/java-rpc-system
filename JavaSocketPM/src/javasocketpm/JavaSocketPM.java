/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javasocketpm;


import java.io.Serializable;
import idmr3.*;


/**
 *
 * @author Marlon
 */







public class JavaSocketPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Person vinicius = new Person("Vinicius", "Grossi");
//        Human clone = (Human) ProxyFactory.getProxy(Human.class, vinicius);
        // TODO code application logic here
        String teste = "vsf";
//        CharSequence clone_teste = ProxyFactory.getProxy(CharSequence.class, teste);
        Registry r = new Registry();
        r.startServer(9000);
        r.bind("ObjetoRemoto", vinicius);
        
        System.out.println(vinicius.getFirstName());
//        System.out.println(clone.getFirstName());
        
//        vinicius.setName("Marlon", "Marques");
        
        Thread.sleep(10000);
        
       
        System.out.println(vinicius.getFirstName());
        
//        System.out.println(clone.getFirstName());
    }
    
    
    
}
