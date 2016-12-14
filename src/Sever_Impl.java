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
public class Sever_Impl extends UnicastRemoteObject implements Server{
	JTextField textField_1;
	protected Sever_Impl(JTextField textfield) throws RemoteException {
		super();
		textField_1=textfield;		
		// TODO Auto-generated constructor stub
	}
	
//--------------------------------------------------------------------
	//Implementation de la methode textmsg
//-------------------------------------------------------------------
	public void textmsg(String msg){
		// TODO implementation
		textField_1.setText(msg);
	}

}
