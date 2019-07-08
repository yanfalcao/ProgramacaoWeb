package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author yanfalcao
 */
public class ReceiverOfMessage implements Runnable {
    
    int porta;
    
    public ReceiverOfMessage(int porta) {
        this.porta = porta;
    }           

    @Override
    public void run() {
        try {
            ServerSocket sv = new ServerSocket(this.porta);
            Socket cl;
            BufferedReader ler;
                
            while(true){
                cl = sv.accept();
                ler = new BufferedReader(new InputStreamReader(cl.getInputStream()));
                String msg = ler.readLine();
                UIChat.setInVisor(msg);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReceiverOfMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
