/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.client;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author yanfalcao
 */
public class SendMensage {
    
    public static void enviaMensagem(String ipServer, int portaServer, String mensagem) throws Exception{
        Socket cliente = new Socket(ipServer, portaServer);
            
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
        bw.write(mensagem);
        bw.flush();
            
        cliente.close();
        bw.close();
    }
}