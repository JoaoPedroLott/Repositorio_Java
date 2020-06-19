package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class AFDAFN {

	private static ArrayList<Integer> iniciais = new ArrayList<Integer>();
	private static ArrayList<Integer> finais = new ArrayList<Integer>();
	private static ArrayList<Integer> alfabeto = new ArrayList<Integer>();
	private static ArrayList<Integer> transferencias = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
	lerAfn();
	}

	public static void lerAfn(){
		try {
			File afd = new File("afn.txt");
			Reader in = new FileReader(afd);
			LineNumberReader reader = new LineNumberReader(in);
			reader.readLine();
			
			String[] vetoralfabeto = reader.readLine().replace("AB: ", "").trim().split(" ");
			for(int i = 0; i < vetoralfabeto.length; i++ ){
			alfabeto.add(Integer.parseInt(vetoralfabeto[i]));
			}
			
			String[] vetoresiniciais = reader.readLine().replace("i: ", "").trim().split(" ");
			for(int i = 0; i < vetoresiniciais.length; i++ ){
				iniciais.add(Integer.parseInt(vetoresiniciais[i]));
			}
			
			
			String[] vetoresfinais = reader.readLine().replace("f: ", "").trim().split(" ");
			for(int i = 0; i < vetoresfinais.length; i++ ){
				finais.add(Integer.parseInt(vetoresfinais[i]));
			}
			
			int fim = 0;
			while(fim == 0){		
				String[] vetortransferencia = reader.readLine().trim().split(" ");
				if (vetortransferencia != null)	{
					for(int i = 0; i < vetortransferencia.length; i++ ){
						transferencias.add(Integer.parseInt(vetortransferencia[i]));
					}
				}else
				fim = 1;
			}
			
//			int fim = 0;
//			while(fim == 0){
//			String[] vetortransferencia = reader.readLine().trim().split(" ");
//			if (vetortransferencia != null)	{
//			for(int i = 0; i < vetortransferencia.length; i++ ){
//			transferencias.add(Integer.parseInt(vetortransferencia[i]));
//			}
//			}else
//				fim = 1;
//			}
			
//			
//			int fim = 0;
//			while (fim == 0)
//	        {
//	            String[] transicao = null;
//				try {
//					transicao = reader.readLine().trim().split(" ");;
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//
//	            if (transicao != null)
//	            {
//	                transferencias.add(Integer.parseInt(transicao));
//	            }
//	            else
//	            {
//	                fim = 1;
//	            }
//	        }
		
			for (Integer s : alfabeto) { 
				System.out.println("ALFABETO");
				System.out.println(s);
			}
			
			for (Integer s : iniciais) { 
				System.out.println("INICIAL");			
				System.out.println(s);
			}
			
			for (Integer s : finais) { 
				System.out.println("FINAIS");
				System.out.println(s);
			}
			
			for (Integer s : transferencias) { 
				System.out.println("TRANSICOES");
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
