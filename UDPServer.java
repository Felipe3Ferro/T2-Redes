// Recebe um pacote de algum cliente
// Separa o dado, o endere�o IP e a porta deste cliente
// Imprime o dado na tela

import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.List;

class UDPServer {
   public static void main(String args[])  throws Exception
      {
         // // cria socket do servidor com a porta 9876
         // DatagramSocket serverSocket = new DatagramSocket(9876);

         //    byte[] receiveData = new byte[1024];
         //    while(true)
         //       {
         //          // declara o pacote a ser recebido
         //          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

         //          // recebe o pacote do cliente
         //          serverSocket.receive(receivePacket);

         //          // pega os dados, o endere�o IP e a porta do cliente
         //          // para poder mandar a msg de volta
         //          String sentence = new String(receivePacket.getData());
         //          InetAddress IPAddress = receivePacket.getAddress();
         //          int port = receivePacket.getPort();

         //          System.out.println("Mensagem recebida: " + sentence);
         //       }
         List<String> arquivo = Arquivo.leitor("txt.txt");
         byte[]  byteArray = arquivo.get(0).getBytes("UTF-8");
         System.out.println(byteArray[0]);
         BigInteger one = new BigInteger(byteArray);
         String strResult = one.toString(2);
         System.out.println("ByteArray to Binary = "+strResult);

      }
}
