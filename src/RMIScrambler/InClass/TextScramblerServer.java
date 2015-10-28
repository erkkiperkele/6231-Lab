package RMIScrambler.InClass;

import java.rmi.Remote;
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

    @Override //Return input text as-is.
    public String testInputText(String inputText) {

        return "Your input text is: " + inputText;
    }

    @Override //Return the string reversed.
    public String reverse(String inputText) {
        String reversedInput = "";
        for(int i=0; i<inputText.length();i++)
        {
            reversedInput=reversedInput+inputText.charAt((inputText.length()-1)-i);
        }
        System.out.println("Server sending back: " + reversedInput);
        return "Result: "+reversedInput;
    }

    @Override //Return the string scrambled.
    public String scramble(String inputText) {
        String scrambledInput="";

        for(int i=0; i<inputText.length();i++)
        {
            if(i%2==0)
            {
                scrambledInput=scrambledInput+inputText.charAt(i);
            }
            else
            {
                scrambledInput=inputText.charAt(i)+scrambledInput;
            }
        }
        return "Result: "+scrambledInput;
    }
}
