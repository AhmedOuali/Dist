import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author root
 *
 */
public class Server_Implementation extends UnicastRemoteObject implements Server_Interface{
	JTextArea zonetext;
   Server_Implementation(JTextArea zonetext) throws RemoteException {
		super();
		this.zonetext=zonetext;
		
		// TODO Auto-generated constructor stub
	}

//--------------------------------------------------------------------
	//Implementation de la methode textmsg
//-------------------------------------------------------------------
	public void textmsg(String msg) throws RemoteException{
		try{
			zonetext.setText(zonetext.getText()+"\n"+"partenaire :"+msg);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
