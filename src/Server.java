import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {
	public static void main(String[] args){
		try{
			Registry reg=LocateRegistry.createRegistry(1099);
			Server_Implementation op = new Server_Implementation();
			reg.rebind("mymsg", op);
			System.out.println("server is ready...");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
