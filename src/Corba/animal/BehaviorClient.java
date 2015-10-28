package Corba.animal;

import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BehaviorClient {

    public static void main(String[] args) throws IOException {

        ORB orb = ORB.init(args, null);

        //Fetch ior
        BufferedReader br = new BufferedReader(new FileReader("ior.txt"));
        String ior = br.readLine();
        br.close();

        //Transform ior to CORBA obj
        org.omg.CORBA.Object o = orb.string_to_object(ior);
        Behavior aBehavior = BehaviorHelper.narrow(o);
        aBehavior.eat();

    }
}
