package chat.client;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 *
 * @author Aluno
 */
public class UIChat extends javax.swing.JFrame{
    
    private JButton envia;
    private static JTextArea visor;
    private JTextField caixaTexto;
    private static String nomeUser;
    private static int porta;
    private JScrollPane jScrollPane1;
    
    private void initComponents(){
        visor = new JTextArea();
        caixaTexto = new JTextField();
        envia = new JButton();
        jScrollPane1 = new JScrollPane();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        visor.setEditable(false);
        visor.setColumns(20);
        visor.setRows(5);
        jScrollPane1.setViewportView(visor);
        
        envia.setText("Enviar");
        
        envia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviaActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(caixaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(envia, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caixaTexto)
                    .addComponent(envia, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
        );

        pack();
    }
                
    private void enviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String mensagem = this.caixaTexto.getText();
        try {
            if(caixaTexto.getText() != null)
                SendMensage.enviaMensagem("127.0.0.1", 12345, this.nomeUser + " -> " + mensagem);   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Servidor não disponível ou problemas ao enviar o arquivo");
        }
    }
    
    public static void setInVisor(String texto){
        visor.setText(visor.getText() + "\n" + texto);
    }
    
    public static void main(String args[]) throws Exception{
        
        Scanner scan = new Scanner(System.in);
        // Pega os dados necessarios
        System.out.print("Digite o nome de usuario que deseja usar: ");
        UIChat.nomeUser = scan.nextLine();
        System.out.print("\nDigite o numero da porta que deseja usar: ");
        UIChat.porta = scan.nextInt();
        System.out.println();
        
        // Envia a porta para o servidor Salvar
        SendMensage.enviaMensagem("127.0.0.1", 12345,"Porta:" + Integer.toString(UIChat.porta));
        SendMensage.enviaMensagem("127.0.0.1", 12345,UIChat.nomeUser + " conectado...");
        
        // Inicializa a Thread para cuidar de receber mensagem
        Thread t = new Thread(new ReceiverOfMessage(UIChat.porta));
        t.start();
        
        // Inicializa a tela
        UIChat chat = new UIChat();
        chat.initComponents();
        chat.setTitle(UIChat.nomeUser);
        chat.setVisible(true);
        
        // Interrompe a Thread        
        t.interrupt();
    }
    
}
