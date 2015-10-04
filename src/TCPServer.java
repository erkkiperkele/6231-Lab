import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aymeric on 15-09-28.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {


        //Initialization
        String server_inputMsg = "";
        String server_reversedMsg = "";

        //Create a socket at agreed port (5000)
        ServerSocket serverSocket = new ServerSocket(5000);

        while (true) {
            //Client-Server connection initialization
            Socket connectionSocket = serverSocket.accept();

            //Get
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream())
            );

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            server_inputMsg = inFromClient.readLine();
            System.out.println("Received: " + server_inputMsg);

            //TO FINISH

        }
    }

}
