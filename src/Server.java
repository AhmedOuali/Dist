import java.rmi.Remote;

/**
 * 
 */

/**
 * @author root
 *
 */
public interface Server extends Remote {
	
//-----------Methode qui affiche un message envoyé par le partenaire--------------------
	public void textmsg(String msg);
	

}
