import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketProgramServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket s = serverSocket.accept();
        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        dataOutputStream.writeUTF("Hello Abishek I am the server");
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
