/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import idmr3.Server;

/**
 *
 * @author marlon
 */
public class Naming {
    
    private static Socket skt = null;
   
   
    private static Class[] getInterfaces()
    {
        Class[] interfaces = null;
        try {
            ObjectInputStream inFromServer = new ObjectInputStream(skt.getInputStream());
            
            interfaces = (Class[]) inFromServer.readObject();
            
            inFromServer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return interfaces;
    }
    
    public static void disconnect()
    {
        if (skt!=null)
            try {
                skt.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void connect()
    {
        
    }
    
    /**
     * Retorna uma referência (stub), para o objeto remotado associado a uma determinada url
     * @param url Uma url para o cliente se conectar ao servidor
     * @return uma referência ao objeto remoto (Stub)
     */
    public static Object lookup(String url)
    {
//        Stub stub = null;
        Object obj = null;
        Class[] interfaces = null;
        try {
            //TODO - Lógica do socket para conectar ao servidor através da url
            skt = new Socket(url, 9000);
            
            
                  
//            outToServer.writeObject("ObjetoRemoto");
            
            interfaces = getInterfaces() ; //Lê as interfaces
            System.out.println(interfaces.toString());
            obj =  (ProxyFactory.getProxy(interfaces, "ObjetoRemoto", skt)); //Cria o proxy
            
        
//           skt.close();
            
        } catch (Exception e)
        {
            System.out.println("Deu merda no lookup!");
            e.printStackTrace();
        }
        
        return obj;
    }
    
    
    /**
     * Associa um nome a um objeto remoto (em forma de stub)
     * @param name nome identificador do objeto remoto
     * @param stub uma referência para o objeto remoto (uma stub) 
     */
    public static void bind (String name,final Object stub) throws ClassNotFoundException
    {
        
        try {
            //TODO- Lógica de socket para o servidor ficar "disponível", associando
//    a String name ao Stub stub
            
            Server server = new Server(9000, name, stub);
            new Thread(server).start();

            try {
                    Thread.sleep(20 * 100000);
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                System.out.println("Stopping Server");
                server.stop();
            
            
            //Stub remoteObject = Stub.exportObject(stub);
            
            
            
            
        } catch (Exception e)
        {
            System.out.println("Deu merda no bind!");
            e.printStackTrace();
        }
        
    }
        
    }
    
    
    
    

