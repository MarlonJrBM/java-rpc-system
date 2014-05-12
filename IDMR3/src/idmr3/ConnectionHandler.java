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
        Object[] newArgs = null;
        Object returnObject = null;
        Boolean isCallback;
        String methodName;
        Object [] argsAgain;
        System.out.println("Fui invocado: " + method.getName() );
//       return method.invoke(target, args);
        
        //envia método e argumentos para o servidor executar no objeto

//        Person test = new Person ("marlon", "marques");
        this.sendRemoteObject(method.getName()); //envia nome do método
        System.out.println("Escrevi objeto remoto na stream: " + method.getName());
        //E se um dos args for um objeto remoto do cliente? 
        //Tem que fazer lógica do callback
        
        
        if (args!=null) {
            newArgs = new Object[args.length];
            for (int ii=0; ii<args.length;ii++) {
                if (args[ii] instanceof RemoteObject) {
                    newArgs[ii] = args[ii].getClass().getInterfaces()[0];
                    System.out.println(args[ii].getClass().getInterfaces()[0].getName());
                }
                else {
                    newArgs[ii] = args[ii];
                    System.out.println("Não entrei nesse if maldito");
                }
            }
            }
            this.sendRemoteObject(newArgs);
            if (newArgs!=null)
            for (Object arg: newArgs) {
                if (arg.toString().startsWith("interface ")) {
                    System.out.println("Mandou interface");
                    oos.writeObject(arg); //envia interface por interface
                }
                else {
                    System.out.println("Não to mandando nada");
                }
            }
            
        
        
        returnObject = this.getRemoteObject();
        //Começa a testar pra ver se deve esperar por callback
        Object remoteCallbackObject;
        Class [] parameterTypes;
       
        
        if (returnObject.toString().contentEquals("Begin of callback")) {
            isCallback = true;
            while (isCallback) {
                methodName = ois.readObject().toString();
                System.out.println("Método de callback: "  + methodName);
                if (methodName.contentEquals("End of callback")) {
                    isCallback = false;
                }
                else {
                    remoteCallbackObject = args[0]; //mudar
                    argsAgain = (Object[]) ois.readObject();
                    if (argsAgain == null) {
                       parameterTypes = null;
                     }
                    else {
                        parameterTypes = new Class[argsAgain.length];
                        for (int ii=0;ii<parameterTypes.length;ii++) {
                            parameterTypes[ii] = argsAgain[ii].getClass();
                        }
                    }
                    Method callbackMethod = remoteCallbackObject.getClass().getMethod(methodName, parameterTypes);
                    oos.writeObject(callbackMethod.invoke(remoteCallbackObject, argsAgain));
                }
            }   
        }
       
        
        
        
         //envia os argumentos
//        System.out.println("Escrevi objeto remoto na stream: " + args[0].toString());
//        System.out.println("Escrevi objeto remoto na stream: " + args[1].toString());
        
        
 
        //espera retorno do método que foi executado no server
       return this.getRemoteObject();
        
        
//        return new Object();
    }
    
    
    
}
