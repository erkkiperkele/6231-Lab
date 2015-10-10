package RMIScrambler.InClass;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface TextScramblerInterface extends Remote {

    String testInputText(String inputText) throws RemoteException;
    String reverse(String inputText) throws RemoteException;
    String scramble(String inputText) throws RemoteException;
}
