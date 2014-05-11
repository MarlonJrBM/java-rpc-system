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
import java.lang.reflect.Method;
import java.net.Socket;

/**
 *
 * @author Marlon
 */
public class WorkerRunnable implements Runnable {
    protected Socket clientSocket = null;
    protected String serverText   = null;
    protected Skeleton remoteObject = null;
    protected RemoteMessage remoteMessage = null;
    protected boolean interfaceIsSent;

    public WorkerRunnable(Socket clientSocket, String serverText, Object remoteObject) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
        this.remoteObject =  new Skeleton(remoteObject);
        this.interfaceIsSent = false;
//        this.remoteObject = ProxyFactory.getProxy(remoteObject.getClass(), remoteObject);
    }
    
    

    public void run() {
        try {
//            InputStream input  = clientSocket.getInputStream();
//            OutputStream output = clientSocket.getOutputStream();
//            long time = System.currentTimeMillis();
//            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
//                this.serverText + " - " +
//               time +
//            "").getBytes());
            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
            
           //manda interface para o cliente 
            if (!interfaceIsSent) {
           output.writeObject(remoteObject.getObjectInterfaces());
           interfaceIsSent = true;
           System.out.println("Escreveu remoteObject na stream: " + remoteObject.getObjectInterfaces().toString());
            }
            
            while (!this.clientSocket.isClosed()) {

           //Lê mensagem enviada pelo stub do client
           
//           remoteMessage = (RemoteMessage) input.readObject();
           String methodName = (String) input.readObject();
           if (methodName.contentEquals("Bye Bye Server!")) {
               this.clientSocket.close();
               
           }
           else {
           System.out.println("Li objeto remoto da stream: " + methodName);
//           Method method = (Method) input.readObject();
           Object[] args =(Object[]) input.readObject();
           System.out.println("Li objeto remoto da stream: " + args[0].toString());
//             Person pessoa =  (Person) input.readObject();
//             System.out.println(input.readObject().toString());
//             System.out.println(pessoa.getFirstName());
           this.remoteObject.runMethod(methodName, args);
           }
            }
            
            output.close();
            input.close();
//            System.out.println("Request processed: " + time);
        } catch (Exception e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
    
}

