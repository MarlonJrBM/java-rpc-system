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
import java.util.HashMap;

/**
 *
 * @author Marlon
 */
public class WorkerRunnable implements Runnable {
    protected Socket clientSocket = null;
    protected String serverText   = null;
    protected Skeleton remoteObject = null;
   
    protected boolean interfaceIsSent;
    protected HashMap remoteObjects;
    protected CallbackHandler callbackHandler;
    ObjectOutputStream output;
    ObjectInputStream input;
    protected CallbackHandler[] callbackHandlers;
    

    public WorkerRunnable(Socket clientSocket,
            HashMap<String,Object> remoteObjects) throws IOException {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
        this.interfaceIsSent = false;
        this.remoteObjects = remoteObjects;
        this.output = new ObjectOutputStream(clientSocket.getOutputStream());
        this.input = new ObjectInputStream(clientSocket.getInputStream());
        this.callbackHandler = new CallbackHandler(null,clientSocket, output, input);
        
//        this.remoteObject = ProxyFactory.getProxy(remoteObject.getClass(), remoteObject);
    }
    
    

    public void run() {
        try {

            //recebe nome do objeto
            String objectName = (String) input.readObject();
            String callbackObjectName = null;

            remoteObject = new Skeleton(remoteObjects.get(objectName), clientSocket, output);
            

           //manda interface para o cliente 
            if (!interfaceIsSent) {
                //Isso pode dar pau!!!
           output.writeObject(remoteObject.getObjectInterfaces());
           interfaceIsSent = true;
           
            }
            
            while (!this.clientSocket.isClosed()) {

           
           String methodName = input.readObject().toString();
           if (methodName.contentEquals("Bye Bye Server!")) {
               this.clientSocket.close();
           }
           else {
        

           Object[] args =(Object[]) input.readObject();
           Object[] newArgs = null;

                   
//           Parte do callback
           if (args!=null) {
               callbackHandlers = new CallbackHandler[args.length];
               newArgs = new Object[args.length];
               for (int ii=0;ii<args.length;ii++) {
                   if (args[ii].toString().startsWith("interface ")) {
                       callbackObjectName = input.readObject().toString();
                       callbackHandlers[ii] = new CallbackHandler(callbackObjectName, clientSocket, output, input ); 
                       newArgs[ii] = StubFactory.getStub(new Class[] { (Class)input.readObject()},
                               callbackHandlers[ii]);
                 
                   }
                   else {
                        newArgs[ii]=args[ii];
                       
                   }
               }
           }
           

           
           //envia retorno para o cliente
//           Object returnObject =  this.remoteObject.runMethod(methodName, args);
           output.writeObject(this.remoteObject.runMethod(methodName,args, newArgs));
           }
            }
            
            output.close();
            input.close();

        } catch (Exception e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
    
}

