import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 */

/**
 * @author root
 *
 */
public interface Server_Interface extends Remote {
	
//-----------Methode qui affiche un message envoyé par le partenaire--------------------
	public void textmsg(String msg)throws RemoteException;	
	public String getUserName() throws RemoteException;
}
