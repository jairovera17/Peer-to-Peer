/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peertopeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class Cliente implements Runnable{
    
    Socket socket;
    String hostname;
    int portNumber;
    public Cliente(String hostname,int portNumber) {
        this.hostname=hostname;
        this.portNumber=portNumber;
    }

    @Override
    public void run() {
        try {
            this.socket=new Socket(hostname,portNumber);
            PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String msj = br.readLine();
                out.println(msj);
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    
    
}
