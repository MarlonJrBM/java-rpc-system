/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testclient;

import idmr3.Registry;
import javasocketpm.*;

/**
 *
 * @author Marlon
 */
public class TestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //CharSequence teste;
//        teste = (CharSequence) Naming.lookup("localhost");
//        System.out.println("teste = " + teste);
        Registry r = new Registry();
        r.connectToRemote("localhost", 9000);
        Human teste2 =  (Human) r.lookup("ObjetoRemoto");
//        System.out.println(teste2.getFirstName());
        teste2.setName("Marlon", "Marques");
        teste2.setName("Rita", "cássia");
        
        r.disconnectFromRemote();
        
        
//        Naming.disconnect();
        
        
    }
    
}
