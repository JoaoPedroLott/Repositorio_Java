package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

public class ServidorLocadora {

	public static void main(String[] args) throws Exception {

		HashMap<String, String> clientes = new HashMap<String, String>();
		Vector<Conexao> fila = new Vector<Conexao>();
		ServerSocket serverSocket = new ServerSocket(2018);

		while (true) {
			final Socket socketPai = serverSocket.accept();
			final Socket socketAux = serverSocket.accept();
			Conexao conexao = new Conexao(socketPai, socketAux, clientes, fila);
			fila.add(conexao);
			new Thread(conexao).start();
		}
	}
}
