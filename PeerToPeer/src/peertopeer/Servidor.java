/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peertopeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class Servidor implements Runnable{

    int portNumber;
    ServerSocket serversocket;
    public Servidor(int portNumber) {
        this.portNumber = portNumber;
       
        
    }
    
    private void iniciarServidor(){
        try {
            serversocket = new ServerSocket(portNumber);
            Socket socket = serversocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String ingreso = in.readLine();
                System.out.println("El men dice:\t"+ingreso);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        iniciarServidor();
    }
    
    
    
    
    
}
