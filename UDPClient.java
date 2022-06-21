// L� uma linha do teclado
// Envia o pacote (linha digitada) ao servidor

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.ArrayList;

class UDPClient {
   public static void main(String args[]) throws Exception {
      ArrayList<Pacote> pacotes = new ArrayList<Pacote>();
      ArrayList<String> arquivo = Arquivo.leitor("txt.txt");
      ArrayList<String> binario = new ArrayList<String>();
      // int data2[] = { 1, 1, 0, 1, 1, 0, 1 };
      int polynomial[] = { 1, 0, 1, 0, 1 };
      int count = 0;
      Integer sequencia = 1;

      for (String elementoArquivo : arquivo) {
         binario.add(StringToBinary.convertStringToBinary(elementoArquivo));
         System.out.println(StringToBinary.convertStringToBinary(elementoArquivo));
      }

      for (int k = 1; k < arquivo.size()+1; k++) {
         count++;
         if(k%10 == 0 || k == arquivo.size()){
            String dataString = "";
            for (int i = 0; i < count; i++) {
               dataString += binario.get(0);
               binario.remove(binario.get(0));
            }

            int data[] = new int[dataString.length()];

            for (int j = 0; j < dataString.length(); j++) {
               data[j] = Integer.parseInt(String.valueOf(dataString.charAt(j)));
            }
            

            Pacote p1 = new Pacote("origem", "destino", "00", sequencia.toString(), data,
                  Crc.divideDataWithDivisor(data, polynomial));
            pacotes.add(p1);
            System.out.println(p1.toString());
            sequencia++;
            count = 0;
         }
      }
      // declara socket cliente
      DatagramSocket clientSocket = new DatagramSocket();

      // obtem endere�o IP do servidor com o DNS
      InetAddress IPAddress = InetAddress.getByName("localhost");

      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];

      // while (true) {
      // l� uma linha do teclado

      for (byte b : receiveData) {
         
      String sentence = p1.toString();
      sendData = sentence.getBytes();
      
      }

      // cria pacote com o dado, o endere�o do server e porta do servidor
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

      // envia o pacote
      clientSocket.send(sendPacket);

      // }

   }
}
