import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JList;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Client_Main {

	private JFrame frmProjetdistribue;
	private Server server; //object server
	private Client client; //objet Client
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_UserName;
	private String UserName; //username
	private Hashtable tableIp; //Hashtable contenant les username et les ip
	private Application app; //objet application contenant les (utilitaire) 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Main window = new Client_Main();
					window.frmProjetdistribue.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjetdistribue = new JFrame();
		frmProjetdistribue.setTitle("Projet_Distribuée_(by Ahmed Ouali)");
		frmProjetdistribue.setResizable(false);
		frmProjetdistribue.setBounds(100, 100, 558, 473);
		frmProjetdistribue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server=new Server();
		client=new Client();
		Application application=new Application();
		frmProjetdistribue.getContentPane().setLayout(null);
		
		final JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 556, 438);
		frmProjetdistribue.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(24, 163, 338, 213);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 95, 179, 19);
		panel2.add(textField);
		
		JLabel label = new JLabel("Partner_Ip (Ip:Port)");
		label.setBounds(12, 54, 135, 15);
		panel2.add(label);
		
		JLabel label_1 = new JLabel("(Local) 127.0.1.1");
		label_1.setBounds(226, 99, 114, 15);
		panel2.add(label_1);
		
		JLabel label_2 = new JLabel("(Public) 41.227.65.215");
		label_2.setBounds(226, 81, 151, 15);
		panel2.add(label_2);
		
		final JLabel label_5 = new JLabel("0");
		label_5.setBounds(454, 195, 70, 15);
		panel2.add(label_5);
		panel2.show(false);
		
		final List list = new List();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(""+tableIp.get(list.getSelectedItem()));
			}
		});
		list.setBounds(410, 216, 114, 144);
		panel2.add(list);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			
			//-----------------------Bouton recherche-------------------------------------
			//----------------------------------------------------------------------------
			public void actionPerformed(ActionEvent arg0) {
				
				tableIp=app.ipReachable("192.168.1",1099);
				label_5.setText(""+tableIp.size());
				Enumeration enu;
				enu= tableIp.keys();
				while(enu.hasMoreElements()){
					
					list.addItem(enu.nextElement().toString());
				}
				
			}
			//////////////////////////////////////////////////////////////////////////////
		});
		btnRecherche.setForeground(Color.RED);
		btnRecherche.setBounds(400, 158, 114, 25);
		panel2.add(btnRecherche);
		
		JLabel label_3 = new JLabel("Your_Ip :");
		label_3.setBounds(226, 54, 60, 15);
		panel2.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 388, 358, 38);
		panel2.add(textField_1);
		
		JLabel label_4 = new JLabel("Discussion");
		label_4.setBounds(12, 136, 76, 15);
		panel2.add(label_4);
		
		JButton button_1 = new JButton("Envoyer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.envoyermsg(textField_1.getText(),textField.getText(),1099);
				textArea.setText(textArea.getText()+"\n"+"Moi :"+textField_1.getText());
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		button_1.setBounds(388, 401, 90, 25);
		panel2.add(button_1);
		panel2.add(textArea);
		final JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 556, 438);
		frmProjetdistribue.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		
		btnSeConnecter.setBounds(110, 272, 344, 36);
		panel1.add(btnSeConnecter);
		
		textField_UserName = new JTextField();
		textField_UserName.setBounds(229, 236, 225, 24);
		panel1.add(textField_UserName);
		textField_UserName.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setBounds(120, 236, 129, 24);
		panel1.add(lblUsername);
		
		//--------------Bouton-connecter----------------------------------------------
		//----------------------------------------------------------------------------
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserName=textField_UserName.getText();
				if(UserName.isEmpty()==false && !UserName.startsWith(" ")){
					server.start(textArea, UserName);
					app=new Application();
					
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "          Voullez vous faire un scan du reseau"+"\n"+"(cette operation peut prendre quelques secondes) ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
				    if(response == JOptionPane.YES_OPTION){	 
						 tableIp=app.ipReachable("192.168.1",1099);
							label_5.setText(""+tableIp.size());
							Enumeration enu;
							enu= tableIp.keys();
							while(enu.hasMoreElements()){
								list.addItem(enu.nextElement().toString());
							}
					 }
					 panel1.show(false);
					 panel2.show(true);
				}
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
