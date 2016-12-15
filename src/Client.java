import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

	public void envoyermsg(String msg, String adress,int port){
		try {
			Registry reg= LocateRegistry.getRegistry(adress,port);
			Server_Interface op = (Server_Interface)reg.lookup("mymsg");
			op.textmsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean testconnection(String adress,int port){
		boolean b=true;
		try {
			Registry reg= LocateRegistry.getRegistry(adress,port);
			Server_Interface op = (Server_Interface)reg.lookup("mymsg");
		}
		catch(Exception ex){
			b=false;
		}
		finally{
		 return b;
		}
	}
}
