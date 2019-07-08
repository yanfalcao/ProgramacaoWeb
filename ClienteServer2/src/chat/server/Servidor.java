package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String args[]) throws IOException{
        ServerSocket server = new ServerSocket(12345);
        ArrayList<Integer> portas = new ArrayList<>();
        String mensagem;
        
        while(1 == 1){
            Socket cliente = server.accept();
            System.out.println("Cliente conectado...");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            mensagem = br.readLine();
            
            if(mensagem.contains("Porta:")){
                portas.add(Integer.parseInt(mensagem.substring(6)));
                System.out.println("Cliente adicionado...\n" + mensagem + "\n");
            }    
            else{
                System.out.println("Enviando Mensagem...");
                Thread t = new Thread(new SendClass(portas, mensagem));
                t.start();
                System.out.println();
            }
        }
    }
}
