/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testclient;

import communicator.Communicator;
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
        Communicator teste2 =  (Communicator) r.lookup("ObjetoRemoto");
        teste2.greet("Fala servidor! Firmeza cara?");
        System.out.println("Seu nome é " + teste2.getName() + ", né?");
        
        r.disconnectFromRemote();
        
        
//        Naming.disconnect();
        
        
    }
    
}
