import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.Semaphore;

public class Recebe extends Thread {

    private byte[] receiveData = new byte[1024];
    private DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    private DatagramSocket Socket;
    private Semaphore sem;

    public Recebe(DatagramSocket Socket, Semaphore sem) {
        this.Socket = Socket;
        this.sem = sem;
    }

    @Override
    public void run() {

    }

}
