import java.rmi.*;

public class MyClient {
	public static void main(String[] args) {
		try {
			MyServerIntf servImp = (MyServerIntf) Naming.lookup("rmi://localhost/servImp");
			System.out.println("Addition: " + servImp.add(2000, 500));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
