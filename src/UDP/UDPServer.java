package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Aymeric on 15-09-28.
 */
public class UDPServer {

    public static void main(String[] args)
    {
        DatagramSocket aSocket = null;
        try{

            //Setup the socket
            int serverPort = 6789;
            aSocket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[1000];

            //Setup the loop to process request
            while(true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(
                        request.getData(),
                        request.getLength(),
                        request.getAddress(),
                        request.getPort()
                );
                aSocket.send(reply);
            }
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
