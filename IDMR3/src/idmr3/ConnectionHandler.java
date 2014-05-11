/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package idmr3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author Marlon
 */
public class ConnectionHandler extends RemoteObject implements InvocationHandler {
    //Responsável por fazer a conexão com o servidor através dos sockets
    
   
    
    private Socket skt;
    
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    private String name;
    
    private RemoteMessage remoteMessage = null;
    
 
 
    public ConnectionHandler(String name, Socket skt, ObjectOutputStream oos, ObjectInputStream ois)
    {
    this.skt = skt;
    this.name = name;
    this.oos = oos;
    this.ois = ois;
    }
    
    private Object getRemoteObject() throws IOException, ClassNotFoundException
    {
//        ObjectInputStream inFromServer = new ObjectInputStream(skt.getInputStream());
        return (ois.readObject());
    }
    
    private void sendRemoteObject(Object remoteObject) throws IOException{
//         ObjectOutputStream output = new ObjectOutputStream(skt.getOutputStream());
//         output.flush();
         oos.writeObject(remoteObject);
//         output.flush();
    }
  
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
    {
        //TODO - tudo
        
        System.out.println("Fui invocado: " + method.getName() );
//       return method.invoke(target, args);
        
        //envia método e argumentos para o servidor executar no objeto
        remoteMessage = new RemoteMessage(method.getName(), args);
//        Person test = new Person ("marlon", "marques");
        this.sendRemoteObject(method.getName()); //envia nome do método
        System.out.println("Escrevi objeto remoto na stream: " + method.getName());
        this.sendRemoteObject(args); //envia os argumentos
        System.out.println("Escrevi objeto remoto na stream: " + args[0].toString());
        System.out.println("Escrevi objeto remoto na stream: " + args[1].toString());
        
        //E se um dos args for um objeto remoto do cliente? 
        //Tem que fazer lógica do callback
 
        //espera retorno do método que foi executado no server
//       return this.getRemoteObject();
        
        
        return new Object();
    }
    
    
    
}
