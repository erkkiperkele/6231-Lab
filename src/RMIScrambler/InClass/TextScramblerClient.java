//package RMIScrambler.InClass;
//
//import java.net.MalformedURLException;
//import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.RMISecurityManager;
//import java.rmi.RemoteException;
//
//
//public class TextScramblerClient implements TextScramblerInterface {
//
//    public static void main(String[] args) {
//        try{
//            System.setSecurityManager(new RMISecurityManager());
//            TextScramblerInterface server = (TextScramblerInterface) Naming.lookup("rmi://localhost:2020/test");
//        }
//
//        catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public String testInputText(String inputText) throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public String reverse(String inputText) throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public String scramble(String inputText) throws RemoteException {
//        return null;
//    }
//}

package RMIScrambler.InClass; /**
 * @author Alexandre Hudon
 * @date 18/09/2013
 * RMI-Tutorial, COMP 6231 - Text Scrambler Client
 * This class needs to be modified by the students in order to define it as a Java RMI Client.
 * Enables a user to send in a sentence to the server and select 4 different options: 3 to
 * process the sentence, 1 to exit the server.
 */

import RMIScrambler.InClass.TextScramblerServer;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class TextScramblerClient {

    //Return basic menu.
    public static void showMenu() {
        System.out.println("\n****Welcome to TextScrambler****\n");
        System.out.println("Please select an option (1-4)");
        System.out.println("1. Test sample input.");
        System.out.println("2. Reverse input");
        System.out.println("3. Scramble input");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {

        String policyPath = "./TextScramblerSecurity.policy";
        File test = new File(policyPath);
        boolean exists = test.exists();

        System.setProperty("java.security.policy",policyPath);

        TextScramblerInterface server = null;

        try {
            server = (TextScramblerInterface) Naming.lookup("rmi://localhost:2020/test");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e1) {
            e1.printStackTrace();
        }

        int userChoice = 0;
        String userInput = "";
        String requestInput = "Please enter a random string.";
        Scanner keyboard = new Scanner(System.in);


        showMenu();

        while (true) {
            Boolean valid = false;

            // Enforces a valid integer input.
            while (!valid) {
                try {
                    userChoice = keyboard.nextInt();
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Invalid Input, please enter an Integer");
                    valid = false;
                    keyboard.nextLine();
                }
            }


            try {
                // Manage user selection.
                switch (userChoice) {
                    case 1:
                        System.out.println(requestInput);
                        userInput = keyboard.next();
                        System.out.println(server.testInputText(userInput));
                        showMenu();
                        break;
                    case 2:
                        System.out.println(requestInput);
                        userInput = keyboard.next();
                        System.out.println(server.reverse(userInput));
                        showMenu();
                        break;
                    case 3:
                        System.out.println(requestInput);
                        userInput = keyboard.next();
                        System.out.println(server.scramble(userInput));
                        showMenu();
                        break;
                    case 4:
                        System.out.println("Have a nice day!");
                        keyboard.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Input, please try again.");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}

