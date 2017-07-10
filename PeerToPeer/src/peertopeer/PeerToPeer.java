/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peertopeer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author jairo
 */
public class PeerToPeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto =5000;
        String hostname="127.0.0.1";
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.submit(new Servidor(puerto));
        ex.submit(new Cliente(hostname, puerto));
    }
    
}
