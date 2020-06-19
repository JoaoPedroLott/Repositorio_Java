package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;


public class Conexao implements Runnable{
	
	private Socket s1;
	private Socket s2;
	private HashMap<String, String> clientes = new HashMap<String, String>();
	private Vector<Conexao> filiais = new Vector<Conexao>();

	
	public Conexao(Socket s1, Socket s2, HashMap<String, String> clientes, Vector<Conexao> filiais){
		this.s1 = s1;
		this.s2 = s1;
		this.clientes = clientes;
		this.filiais = filiais;
	}
	
	public void run() {
		try {
			
		
		while(true){
				String opcao = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
				switch (Integer.parseInt(opcao)) {
				case 1: realizaDebito(); break;
				case 2: atualizarDebito(); break;
				case 3: adicionarCliente(); break;
				case 4: excluirCliente(); break;
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	

	public void adicionarCliente() throws IOException {
		
		String cpf = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		
		if(!(clientes.get(cpf) instanceof String)){
			System.out.println(s1.toString());
			clientes.put(cpf, s1.toString());
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("Cliente cadastrado com sucesso.");
			out.flush();
		} else {
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("");
			out.flush();
		}
		
	}
	
	public void excluirCliente() throws IOException {
		
		String cpf = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		
		if(clientes.remove(cpf) instanceof String){
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("Removido com Sucesso.");
			out.flush();
		}
		else{
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("");
			out.flush();
		}
		
	}	
	
	public void realizaDebito() throws IOException {
		
		String cpf = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		String ip1 = clientes.get(cpf);
		
		if(ip1 instanceof String){
			
			for(Conexao filial: filiais){
				System.out.println(ip1+" = "+filial.s1.toString());
				if(ip1.equals(filial.s1.toString())){
					PrintWriter out = new PrintWriter(s2.getOutputStream());
					out.println(cpf+"&search");
					out.flush();
					out = new PrintWriter(s1.getOutputStream());
					out.println(new BufferedReader(new InputStreamReader(s2.getInputStream())).readLine());
					out.flush();					
					break;
				}
			}
			
		} else{
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("");
			out.flush();
		}
		
	}	
	
	public void atualizarDebito() throws IOException {
		
		String number = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		String debit = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		String socketToString = clientes.get(number);
		
		if(socketToString instanceof String){
			
			for(Conexao filial: filiais){
				System.out.println(socketToString+" = "+filial.s1.toString());
				if(socketToString.equals(filial.s1.toString())){
					PrintWriter out = new PrintWriter(s2.getOutputStream());
					out.println(number+"&update&"+debit);
					out.flush();
					out = new PrintWriter(s1.getOutputStream());
					out.println("Atualização realizada com sucesso.");
					out.flush();					
					break;
				}
			}
			
		} else {
			PrintWriter out = new PrintWriter(s1.getOutputStream());
			out.println("");
			out.flush();			
		}
	}	

}