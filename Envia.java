import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.Semaphore;

public class Envia extends Thread {

    private DataInputStream in;
    private DataInputStream out;
    private Semaphore s;

    public Envia(DataInputStream in, DataInputStream out, Semaphore s) {
        this.in = in;
        this.out = out;
        this.s = s;
    }

    @Override
    public void run() {

    }

}