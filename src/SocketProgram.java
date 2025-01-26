import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketProgram {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",9999);
        DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
        String msg = dataInputStream.readUTF();
        System.out.println("Message from server : " + msg);
    }
}
