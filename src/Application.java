import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

//---------------------------------------------------------------------------
//------------Avoir l'adresse Local du client -------------------------------
//---------------------------------------------------------------------------
	
	public String getlocalip(){
		String ip="0 . 0 . 0 . 0";
		try {
			ip = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}

//-----------------------------------------------------------------------------	
// ----------------Avoir l'adresse Public du client----------------------------
//-----------------------------------------------------------------------------
	
	public String getpublicip() {
		URL url;
		String line="0 . 0 . 0 . 0";
		try {
			url = new URL("http://yveran.ephian.net/test/ipaddress.php");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			BufferedReader rd = new BufferedReader(isr);

			line = rd.readLine();
			rd.close();
		} catch (Exception e) {
		}
		return line;
	}
	
	//----------Methode pour la recherche des connection ouvertes---------------
		//--------------------------------------------------------------------------
	public Hashtable ipReachable(String adressparent,int port){
		
		Hashtable tableIp = new Hashtable();
		int nbrecon=0;
		
		for (int i=1;i<255;i++){
		       String host=adressparent + "." + i;
		       try {
		    	   
				if (InetAddress.getByName(host).isReachable(20) && (portIsOpen(host, 1099, 50))){
						Registry reg= LocateRegistry.getRegistry(host,port);
						Server_Interface op = (Server_Interface)reg.lookup("mymsg");
						tableIp.put(op.getUserName(), host);
						nbrecon++;
				   }
		       } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return tableIp;
	}
	
	///////////////////////////////////////////////////////////////////////////
	//----------Methode qui teste l'ouverture d'un port----------------
	private boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();                                     //
            socket.connect(new InetSocketAddress(ip, port), timeout);         // utilisation des socket pour tester le port d'une adress
            socket.close();                                                   //
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
