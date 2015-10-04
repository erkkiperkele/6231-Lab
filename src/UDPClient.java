/**
 * Created by Aymeric on 15-09-28.
 */

import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String[] args)
    {
        DatagramSocket aSocket = null;
        try{

            //Setup the socket
            aSocket = new DatagramSocket();
            String message = "Hello!";
            byte[] m = message.getBytes();
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 6789;

            //Setup the package and send it
            DatagramPacket request = new DatagramPacket(m, message.length(), aHost, serverPort);
            aSocket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));



        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " +e.getMessage());
            e.printStackTrace();
        } finally {
            if (aSocket != null)
            {
                aSocket.close();
            }
        }
    }
}
