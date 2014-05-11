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
import java.net.Socket;

/**
 *
 * @author Marlon
 */
public class WorkerRunnable implements Runnable {
    protected Socket clientSocket = null;
    protected String serverText   = null;
    protected Object remoteObject = null;

    public WorkerRunnable(Socket clientSocket, String serverText, Object remoteObject) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
        this.remoteObject = remoteObject;
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
//            ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
            
           output.writeObject(remoteObject.getClass().getInterfaces());

//            output.writeObject(remoteObject);
            System.out.println("Escreveu remoteObject na stream: " + remoteObject.toString());
            
            output.close();
//            input.close();
//            System.out.println("Request processed: " + time);
        } catch (Exception e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
    
}

