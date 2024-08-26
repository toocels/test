import java.rmi.*;                   // Import RMI classes for remote method invocation.
import java.rmi.server.*;            // Import RMI server classes for creating remote objects.

public class MyServer {
	public static void main(String[] args) {
		try {
			MyServerImpl servImp = new MyServerImpl();
			Naming.rebind("servImp", servImp);
			System.out.println("Server Started...");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}

class MyServerImpl extends UnicastRemoteObject implements MyServerIntf {
	MyServerImpl() throws RemoteException {	}

	public double add(double a, double b) throws RemoteException {
		return a + b;
	}
}

interface MyServerIntf extends Remote {
	double add(double a, double b) throws RemoteException;
}
