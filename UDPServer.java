// L� uma linha do teclado
// Envia o pacote (linha digitada) ao servidor

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

class UDPServer {
   static Socket connection;

   public static void main(String args[]) throws Exception {

      int polynomial[] = { 1, 0, 1, 0, 1 };

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
         String tripa = "";
         for (int j = 0; j < v.length; j++) {
            tripa += string[j];
         }
         String dados[] = tripa.split(Pattern.quote(","));
         Charset charset = Charset.forName("ASCII");
      
         String crc = dados[0].toString();
         String data = dados[1].toString();

         byte[] byteCrc = crc.getBytes(charset);
         byte[] byteData = data.getBytes(charset);

         int[] intCrc = new int[byteCrc.length];
         int[] intData = new int[byteData.length];

         for (int j = 0; j < byteCrc.length; j++) {
             intCrc[j]= byteCrc[j] ;
         }

         for (int j = 0; j < byteData.length; j++) {
            intData[j]= byteData[j] ;
        }

        String result = Crc.receiveData(intData, polynomial, intCrc);
        out.writeInt(Integer.parseInt(result));
         
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
