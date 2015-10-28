package Corba.animal;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BehaviorServer {

	public static void main(String[] args) 
			throws InvalidName, ServantAlreadyActive, WrongPolicy, ObjectNotActive, FileNotFoundException, AdapterInactive {

		ORB orb = ORB.init(args, null);
		POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		
		//Obtain a reference
		BehaviorImpl aBehavior = new BehaviorImpl();
		byte[] id = rootPOA.activate_object(aBehavior);
		org.omg.CORBA.Object ref = rootPOA.id_to_reference(id);
			
		//Translate to ior and write it to a file
		String ior = orb.object_to_string(ref);
		System.out.println(ior);
		
		PrintWriter file = new PrintWriter("ior.txt");
		file.println(ior);
		file.close();
		
		//initialize the ORB
		rootPOA.the_POAManager().activate();
		orb.run();
	}
}
