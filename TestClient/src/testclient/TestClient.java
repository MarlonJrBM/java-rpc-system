/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testclient;


import communicator.Callback;
import communicator.CallbackImpl;
import communicator.Communicator;
import idmr3.Registry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        System.out.println("Please enter your name: ");
        try {
            name = rd.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.connectToRemote("localhost", 9000);
        Communicator chat =  (Communicator) r.lookup("ObjetoRemoto");
        chat.subscribe(name);
        
       
        Callback callbak = new CallbackImpl();
        chat.callbak(callbak, "Welcome to the jungle, " + name + "!");
        
        String message = null;
        do {
            try {
                message = rd.readLine();
                chat.sendMsg(message);
               
            } catch (IOException ex) {
                Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } while (!message.contentEquals("/quit"));
//        chat.callbak("VAI TOMAR NO CUUUU");
//        teste2.greet("Fala servidor! Firmeza cara?");
//        System.out.println("Seu nome é " + teste2.getName() + ", né?");
        
        r.disconnectFromRemote();
        
        
//        Naming.disconnect();
        
        
    }
    
}
