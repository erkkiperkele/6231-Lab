package RMIScrambler;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TextScramblerServer implements TextScramblerInterface {

    public static void main(String[] args) {
        try {
            (new TextScramblerServer()).exportServer();
            System.out.println("Server is up and running! (great)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportServer() throws Exception {
        Remote obj = UnicastRemoteObject.exportObject(this, 2020);
        Registry r = LocateRegistry.createRegistry(2020);
        r.bind("test", obj);
    }

    @Override
    public String testInputText(String inputText) throws RemoteException {
        return null;
    }

    @Override
    public String reverse(String inputText) throws RemoteException {
        return null;
    }

    @Override
    public String scramble(String inputText) throws RemoteException {
        return null;
    }
}
