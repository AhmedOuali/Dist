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
	String UserName;
   Server_Implementation(JTextArea zonetext,String UserName) throws RemoteException {
		super();
		this.zonetext=zonetext;
		this.UserName=UserName;
		// TODO Auto-generated constructor stub
	}

//--------------------------------------------------------------------
	//Implementation de la methode textmsg
//-------------------------------------------------------------------
	public void textmsg(String msg) throws RemoteException{
		try{
			zonetext.setText(zonetext.getText()+"\n"+UserName+" :"+msg);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getUserName() throws RemoteException{
		return UserName;
	}

}
