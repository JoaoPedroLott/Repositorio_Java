
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class NameServer {

	public static void main(String[] args) {

		DatagramPacket dataInput, dataOutput;
		int porta = 6666;
		int tamanho = 1024;

		try {
			DatagramSocket dataSocket = new DatagramSocket(porta);
			byte[] buffer = new byte[tamanho];

			while (true) {
				dataInput = new DatagramPacket(buffer, buffer.length);
				dataSocket.receive(dataInput);

				String strIn = new String(dataInput.getData(), 0, dataInput.getLength());
				String strOut = TabelaNomes.verificaComando(strIn);

				dataOutput = new DatagramPacket(strOut.getBytes(), strOut.length(), dataInput.getAddress(),
						dataInput.getPort());
				dataSocket.send(dataOutput);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
