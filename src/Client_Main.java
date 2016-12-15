import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class Client_Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private Server server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Main window = new Client_Main();
					window.frame.setVisible(true);
					
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 504, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		final JTextArea discArea = new JTextArea();
		discArea.setEditable(false);
		discArea.setBackground(Color.GRAY);
		JLabel lblPartnerip = new JLabel("Partner_Ip (Ip:Port)");
		
		JLabel lblYourip = new JLabel("Your_Ip :");
		server=new Server();
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client client=new Client();
				client.envoyermsg(textField_2.getText(), textField.getText(),1099);
				String Newligne=System.getProperty("line.separator"); 
				discArea.setText(discArea.getText()+"\n"+"Moi :"+textField_2.getText());
				
			}
		});
		
		JLabel label = new JLabel("(public) " + "0 . 0 . 0 . 0");  
		Application application=new Application();
		label.setText("(Public) "+ application.getpublicip());  // l'appel du methode getpublicip
		JLabel label_1 = new JLabel("(Local) "+ "0 . 0 . 0 . 0");
		label_1.setText("(Local) "+ application.getlocalip()); // l'appel du methode getlocalip
		
		final JButton Connect = new JButton("Connect");
		Connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client client=new Client();
				if(client.testconnection(textField.getText(),1099))
					Connect.setForeground(Color.GREEN);
				else
					Connect.setForeground(Color.RED);
			}
		});
		Connect.setForeground(Color.RED);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDiscussion = new JLabel("Discussion");
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPartnerip))
									.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_1)
												.addComponent(label))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(Connect))
										.addComponent(lblYourip)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_2, 358, 358, 358)
										.addComponent(lblDiscussion, Alignment.LEADING))
									.addGap(18)
									.addComponent(btnEnvoyer))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(discArea, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(Connect))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYourip)
								.addComponent(lblPartnerip))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(3)
									.addComponent(label_1))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDiscussion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(discArea, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEnvoyer))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		server.start(discArea);
	}
}
