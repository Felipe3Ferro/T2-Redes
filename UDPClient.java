// Recebe um pacote de algum cliente
// Separa o dado, o endere�o IP e a porta deste cliente
// Imprime o dado na tela

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

class UDPCliente {

   public static ArrayList<Pacote> pacotes = new ArrayList<Pacote>();
   static ServerSocket Serversocket;
   static DataInputStream dis;
   static DataOutputStream dos;
   static int canal = 5;
   public static byte[] sendData = new byte[1024];

   public static void main(String args[]) throws Exception {

      criaPacote();

      Serversocket = new ServerSocket(8011);
      System.out.println("waiting for connection");
      Socket client = Serversocket.accept();
      dis = new DataInputStream(client.getInputStream());
      dos = new DataOutputStream(client.getOutputStream());

      dos.write(pacotes.size());
      dos.flush();

      for (Pacote pacote : pacotes) {
         String inputString = pacote.toString();
         Charset charset = Charset.forName("ASCII");

         byte[] byteArrray = inputString.getBytes(charset);

         dos.write(byteArrray.length);
         dos.flush();

         for (int i = 0; i < byteArrray.length; i++) {
            dos.write(byteArrray[i]);
            dos.flush();
         }

         int ack = dis.readInt();

         while(ack != 11){
            inputString = pacote.toString();
            charset = Charset.forName("ASCII");
   
            byteArrray = inputString.getBytes(charset);
   
            dos.write(byteArrray.length);
            dos.flush();
   
            for (int i = 0; i < byteArrray.length; i++) {
               dos.write(byteArrray[i]);
               dos.flush();
            }
            ack = dis.readInt();
         }
      }
      System.out.println("Enviada com sucesso!");

   }

   public static void criaPacote() throws IOException {
      ArrayList<String> arquivo = Arquivo.leitor("txt.txt");
      ArrayList<String> binario = new ArrayList<String>();
      // int data2[] = { 1, 1, 0, 1, 1, 0, 1 };
      int polynomial[] = { 1, 0, 1, 0, 1 };
      int count = 0;
      Integer sequencia = 1;

      for (String elementoArquivo : arquivo) {
         binario.add(StringToBinary.convertStringToBinary(elementoArquivo));
         // System.out.println(StringToBinary.convertStringToBinary(elementoArquivo));
      }

      for (int k = 1; k < arquivo.size() + 1; k++) {
         count++;
         if (k % 10 == 0 || k == arquivo.size()) {
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
            // System.out.println(p1.toString());
            sequencia++;
            count = 0;
         }
      }
   }
}