package RMIScrambler;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;


public class TextScramblerClient implements TextScramblerInterface {

    public static void main(String[] args) {
        try{
            System.setSecurityManager(new RMISecurityManager());
            TextScramblerInterface server = (TextScramblerInterface) Naming.lookup("rmi://localhost:2020/test");
        }

        catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
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
