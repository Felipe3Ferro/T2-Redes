// L� uma linha do teclado
// Envia o pacote (linha digitada) ao servidor

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.ArrayList;

class UDPClient {
   public static void main(String args[]) throws Exception {

      ArrayList<String> arquivo = Arquivo.leitor("txt.txt");
      ArrayList<String> binario = new ArrayList<String>();
      int data2[] = { 1, 1, 0, 1, 1, 0, 1 };
      int polynomial[] = { 1, 0, 1, 0, 1 };

      for (String elementoArquivo : arquivo) {
         binario.add(StringToBinary.convertStringToBinary(elementoArquivo));
      }

      String dataString = String.join("", binario);

      int data[] = new int[dataString.length()];

      for (int j = 0; j < dataString.length(); j++) {
         data[j] = Integer.parseInt(String.valueOf(dataString.charAt(j)));
      }

      Pacote p1 = new Pacote("origem", "destino", "00", "0", binario,
            Crc.divideDataWithDivisor(data, polynomial));

      // declara socket cliente
      DatagramSocket clientSocket = new DatagramSocket();

      // obtem endere�o IP do servidor com o DNS
      InetAddress IPAddress = InetAddress.getByName("localhost");

      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];

      // while (true) {
      // l� uma linha do teclado
      String sentence = p1.toString();
      sendData = sentence.getBytes();

      // cria pacote com o dado, o endere�o do server e porta do servidor
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

      // envia o pacote
      clientSocket.send(sendPacket);

      // }

   }
}
