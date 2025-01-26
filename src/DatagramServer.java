import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String msg = "Hello Abishek I am a Datagram Server";
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),msg.length(),ip,9999);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
