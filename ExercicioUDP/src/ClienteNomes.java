import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteNomes {
	
	public static void main(String[] args) {
			
		String hostName;

		int porta = 6666;
		int tamanho = 1024;
		DatagramPacket sPacket, rPacket;

		if (args.length > 0)
			hostName = args[0];
		else
			hostName = "localhost";

		try {
			InetAddress ia = InetAddress.getByName(hostName);
			DatagramSocket datasocket = new DatagramSocket();
			BufferedReader stdinp = new BufferedReader(new InputStreamReader(
					System.in));
			boolean insert = true;
			while (true) {
				try {
					System.out.println("Favor Iformar o Comando: ");
					String comandLine = stdinp.readLine();

					if (comandLine.equals("fim"))
						break;

					if (comandLine.startsWith("inserir")) {
						insert = true;
					} else if (comandLine.startsWith("procurar")) {
						insert = false;
					} else {
						System.out
								.println("Comando não reconhecido. Informe um comando valido.");
						continue;
					}

					byte[] buffer = new byte[comandLine.length()];
					buffer = comandLine.getBytes();

					sPacket = null;
					sPacket = new DatagramPacket(buffer, buffer.length, ia,
							porta);
					datasocket.send(sPacket);

					byte[] rbuffer = new byte[tamanho];
					rPacket = null;
					rPacket = new DatagramPacket(rbuffer, rbuffer.length);
					datasocket.receive(rPacket);

					String retstring = new String(rPacket.getData(), 0,
							rPacket.getLength());

					if (insert && retstring.equals("0")) {
						System.out
								.println("Não foi possível inserir o nome lógico.");
					} else if (insert && retstring.equals("1")) {
						System.out.println("Nome lógico inserido com sucesso.");
					} else if (!insert && retstring.equals("-1")) {
						System.out
								.println("Não foi possivel encontrar o nome logico no servidor.");
					} else if (!insert && !retstring.equals("-1")) {
						System.out.println(retstring);
					} else {
						System.out.println("A string retornada é invalida: "
								+ retstring);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
