package negocio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class AdvinhaNumero implements Runnable {
	Socket client;
	int numeroSorteado;
        boolean venceu;
	int tentativa;

	public AdvinhaNumero(Socket client) {
		this.client = client;
		this.numeroSorteado = new Random().nextInt(1000);
                this.tentativa = 0;
                this.venceu = false;
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(this.client.getInputStream());
			PrintWriter out = new PrintWriter(this.client.getOutputStream(), true);
			out.println("ACERTE O NUMERO SORTEADO DE 0 - 1000");
			while (! this.venceu) {
                            int numeroEscolhido = Integer.parseInt(in.nextLine());
				if (this.verificaNumero(numeroEscolhido)) {
					out.println("PARABENS VOCE GANHOU COM " + this.tentativa + " TENTATIVA(S)");
					this.venceu = true;
				} else
					out.println(this.maiorOuMenor(numeroEscolhido));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verificaNumero(int numeroEscolhico) {
		boolean acertou = false;

		if(numeroEscolhico == this.numeroSorteado)
                    acertou = true;
		else
                    ++this.tentativa;
                
		return acertou;
	}
        
        public String maiorOuMenor(int numeroEscolhido) {
            if(numeroEscolhido > this.numeroSorteado)
                return "O numero sorteado é menor --- Tentativa " + this.tentativa;
            return "O numero sorteado é maior --- Tentativa " + this.tentativa;
        }

}