import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author root
 *
 */
public class Server_Implementation extends UnicastRemoteObject implements Server_Interface{
	
   Server_Implementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//--------------------------------------------------------------------
	//Implementation de la methode textmsg
//-------------------------------------------------------------------
	public void textmsg(String msg) throws RemoteException{
		try{
		System.out.println(msg);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
