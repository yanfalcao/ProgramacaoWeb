/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanfalcao
 */
public class SendClass implements Runnable{
    
    ArrayList<Integer> portas = new ArrayList<>();
    String mensagem;
    
    public SendClass(ArrayList<Integer> portas, String mensagem){
        this.portas = portas;
        this.mensagem = mensagem;
    }
    
    @Override
    public void run() {
        for(int i : portas){
            try {
                Socket cliente = new Socket("127.0.0.1", i);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
                bw.write(mensagem);
                bw.flush();
                    
                cliente.close();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(SendClass.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    
}
