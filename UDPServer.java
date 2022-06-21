// L� uma linha do teclado
// Envia o pacote (linha digitada) ao servidor

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.nio.charset.StandardCharsets;

class UDPServer {
   static Socket connection;

   public static void main(String args[]) throws Exception {

      InetAddress addr = InetAddress.getByName("Localhost");
      System.out.println(addr);
      connection = new Socket(addr, 8011);
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      DataInputStream in = new DataInputStream(connection.getInputStream());

      int iteracoes = in.read();
      for (int i = 0; i < iteracoes; i++) {
         int tam = in.read();
         char string[] = new char[tam];
         int v[] = new int[tam];
         for (int j = 0; j < tam; j++) {
            v[j] = in.read();
         }
         convert(v, string);
         System.out.println(string);
         String crc = "";
         for (int j = 0; j < v.length - 3; j++) {
            if (string[j] == 'c' && string[j + 1] == 'r' && string[j + 2] == 'c') {
               while (string[j + 4] == '0' || string[j + 4] == '1') {
                  crc += string[j + 4];
               }
            }
         }
         System.out.println("aaa");
      }
   }

   public static void convert(int[] array, char[] array1) {
      int length = array.length;
      for (int i = 0; i < length; i++) {
         // this converts a integer into a character
         array1[i] = (char) array[i];
      }
   }
}
