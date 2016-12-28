import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JTextArea;


public class Server {
	
	public boolean start(JTextArea zonetext,String UserName){
		boolean b=true;
		try{
			Registry reg=LocateRegistry.createRegistry(1099);
			Server_Implementation op = new Server_Implementation(zonetext,UserName);
			reg.rebind("mymsg", op);
		}
		catch(Exception ex){
			b=false;
		}
		return b;	
	}

}
