package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aymeric on 15-09-28.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {

        //Initialization
        String client_inputMsg = "";
        String client_reversedMsg = "";

        //Create a socket at agreed port (5000)
        Socket clientSocket = new Socket("localhost", 5000);

        //Get outputStream to server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //Get inputStream to get values from server
        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        //Get inputStream to get values from user
        BufferedReader inFromUser = new BufferedReader(
                new InputStreamReader(
                        System.in));
        client_inputMsg = inFromUser.readLine();

        //Send the message to server
        outToServer.writeBytes(client_inputMsg + '\n');

        //Read answer from server
        client_reversedMsg = inFromServer.readLine();
        System.out.println("From Server: " + client_reversedMsg);

        //Close socket
        clientSocket.close();
    }
}
