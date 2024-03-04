package Gestion_superette;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class login extends JFrame {

	private JPanel contentPane;
	int xx , xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					login frame = new login();
					
					frame.setUndecorated(true);// la methode undecorated permet de spprimmer la tittle bar , position dans le code 
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	connection_BD a = new connection_BD();
	private JTextField nom;
	private JPasswordField pass;
	
	
	
	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		 
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(0, -30, 479, 639);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("...Projet Structurant...");
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(111, 414, 265, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("realiser par Mbou et Dongmo");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(158, 522, 180, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gestion d'une superette");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(134, 467, 263, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("L:\\projet Structurant\\Gestion_d'une_superette\\src\\Gestion_superette\\Image\\chef-de-departement4.jpg"));
		lblNewLabel_3.setBounds(0, 29, 479, 341);
		panel.add(lblNewLabel_3);
		
		Button button = new Button("Connexion");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		//
				
				try {
					a.connection();
					a.requetLog("select* from login where user='"+nom.getText()+"'and password='"+pass.getText()+"'");
					
					
					
				}catch(Exception a) { System.err.println(a);}
				
				
				
				
				
				
				
				
				
			}
		});
		button.setFont(new Font("Georgia", Font.PLAIN, 14));
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		button.setBounds(574, 446, 181, 32);
		contentPane.add(button);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("L:\\projet Structurant\\Gestion_d'une_superette\\src\\Gestion_superette\\Image\\user-icon-vector-male-person-symbol-profile-circle-avatar-sign-in-flat-color-glyph-pictogram-illustration-400-168677638.jpg"));
		lblNewLabel_4.setBounds(636, 70, 45, 65);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("nom d'utilisateur");
		lblNewLabel_5.setBounds(537, 226, 218, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("mot de passe");
		lblNewLabel_5_1.setBounds(537, 302, 218, 16);
		contentPane.add(lblNewLabel_5_1);
		
		nom = new JTextField();
		nom.setBounds(537, 252, 229, 16);
		contentPane.add(nom);
		nom.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(537, 328, 229, 19);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.GRAY);
			}
		});
		
		
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(807, 0, 16, 13);
		contentPane.add(lblNewLabel);
		
		
		
		// CODE permettent de faire bouger un frame lorsque on a utilser la methode undecorated(boolean)
		
	     // faut chercher a comprendre papa	
		
		
		panel.addMouseListener(new MouseAdapter() {
			
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		xx=arg0.getX();
		xy=arg0.getY();
		
		}});
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			
			public void mouseDragged(MouseEvent arg0) {
				
			int x = arg0.getXOnScreen();	
			int y = arg0.getYOnScreen();
			login.this.setLocation(x - xy,y - xy);
			}
			
		});
		
		
		
		
	}
}
