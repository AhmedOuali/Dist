import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Hashtable;


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
	public String getPartenaireUserName(String adress,int port){
		String user = null;
		try {
			Registry reg= LocateRegistry.getRegistry(adress,port);
			Server_Interface op = (Server_Interface)reg.lookup("mymsg");
			user=op.getUserName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//--------tester la connection sur un ip bien determiné----------------------------
	//////////////////////////////////////////////////////////////////////////////////
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
	
	//----------Methode pour la recherche des connection ouvertes---------------
	//--------------------------------------------------------------------------
	
}
