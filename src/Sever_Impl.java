import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 */

/**
 * @author root
 *
 */
public class Sever_Impl extends UnicastRemoteObject implements Server{

	protected Sever_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
//--------------------------------------------------------------------
	//Implementation de la methode textmsg
//-------------------------------------------------------------------
	public String textmsg(String msg){
		String s=null;
		// TODO implementation
		return s;
	}

}
