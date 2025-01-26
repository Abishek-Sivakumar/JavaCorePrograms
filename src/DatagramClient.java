import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte buffer[] = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,1024);
        datagramSocket.receive(datagramPacket);
        String msg = new String(datagramPacket.getData(),0 ,datagramPacket.getLength());
        System.out.println(msg);
        datagramSocket.close();
    }
}
