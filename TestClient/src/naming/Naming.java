/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package naming;


import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marlon
 */
public class Naming implements Serializable{
   
    
    /**
     * Retorna uma referência (stub), para o objeto remotado associado a uma determinada url
     * @param url Uma url para o cliente se conectar ao servidor
     * @return uma referência ao objeto remoto (Stub)
     */
    public static <T> T lookup(String url)
    {
//        Stub stub = null;
        T obj = null;
        try {
            //TODO - Lógica do socket para conectar ao servidor através da url
            Socket skt = new Socket(url, 1099);
            ObjectOutputStream outToServer = new ObjectOutputStream(skt.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(skt.getInputStream());
            
            obj = (T) inFromServer.readObject();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Naming.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Naming.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause().toString());
        }
        
        return obj;
    }
    
    
    /**
     * Associa um nome a um objeto remoto (em forma de stub)
     * @param name nome identificador do objeto remoto
     * @param stub uma referência para o objeto remoto (uma stub) 
     */
    public static<T> void bind (String name, T stub) throws ClassNotFoundException
    {
        try {
            //TODO- Lógica de socket para o servidor ficar "disponível", associando
//    a String name ao Stub stub
            
            ServerSocket srvr = new ServerSocket(1099);
            Socket clientSkt = srvr.accept(); 
            ObjectOutputStream outToClient = new ObjectOutputStream(clientSkt.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(clientSkt.getInputStream());
            //Stub remoteObject = Stub.exportObject(stub);
            
            outToClient.writeObject(stub);
            
        } catch (IOException ex) {
            Logger.getLogger(Naming.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause().toString());
        }
        
    }
    
    
    
    
}
