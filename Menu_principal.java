package Gestion_superette;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Menu_principal extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal frame = new Menu_principal();
					
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	ventes v = new ventes();
	stock s = new stock();
	facturation f = new facturation();
	ventes_vrai r =new ventes_vrai(); 
	
	public Menu_principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1288, 691);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(0, 0, 321, 825);
		contentPane.add(panel);
		
		JPanel ventes = new JPanel();
		ventes.setBounds(0, 252, 329, 91);
		
		
		ventes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ventes.setBackground(new Color(148, 0, 211));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ventes.setBackground(new Color(75, 0, 130));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				f.setVisible(false);
				s.setVisible(false);
				r.setVisible(false);
				v.setVisible(true);
			}
		});
		panel.setLayout(null);
		ventes.setBackground(new Color(75, 0, 130));
		panel.add(ventes);
		ventes.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("GESTION DES CLIENTS");
		lblNewLabel_2.setBounds(97, 39, 225, 29);
		ventes.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 77, 58);
		ventes.add(lblNewLabel_3);
		
		JPanel stock = new JPanel();
		stock.setBounds(0, 340, 329, 82);
		
		stock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				stock.setBackground(new Color(148, 0, 211));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stock.setBackground(new Color(75, 0, 130));
			}
			@Override
			
			public void mouseClicked(MouseEvent e) {
				r.setVisible(false);
				v.setVisible(false);
				f.setVisible(false);
				s.setVisible(true);
			}
		});
		
		stock.setBackground(new Color(75, 0, 130));
		panel.add(stock);
		stock.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("GESTION DES STOCKS");
		lblNewLabel_2_1.setBounds(97, 21, 210, 29);
		stock.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(10, 10, 77, 58);
		stock.add(lblNewLabel_3_1);
		
		JPanel facturation = new JPanel();
		facturation.setBounds(0, 419, 329, 76);
		
		facturation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				facturation.setBackground(new Color(148, 0, 211));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				facturation.setBackground(new Color(75, 0, 130));
			}
			@Override 
			public void mouseClicked(MouseEvent e) {
				v.setVisible(false);
				s.setVisible(false);
				r.setVisible(false);
				f.setVisible(true);
				
				
			}
		});
		facturation.setBackground(new Color(75, 0, 130));
		panel.add(facturation);
		facturation.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("FACTURATION");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(120, 25, 139, 29);
		facturation.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(10, 10, 77, 58);
		facturation.add(lblNewLabel_3_2);
		
		JPanel dernier_truck = new JPanel();
		dernier_truck.setBounds(0, 496, 329, 76);
		
		dernier_truck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dernier_truck.setBackground(new Color(148, 0, 211));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dernier_truck.setBackground(new Color(75, 0, 130));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				v.setVisible(false);
				s.setVisible(false);
				f.setVisible(false);
				r.setVisible(true);
			}
		});
		
		dernier_truck.setBackground(new Color(75, 0, 130));
		panel.add(dernier_truck);
		dernier_truck.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBounds(24, 10, 77, 58);
		dernier_truck.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("GESTION DES VENTES");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(85, 25, 210, 29);
		dernier_truck.add(lblNewLabel_2_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 161, 200, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_2_3 = new JLabel("La gloire");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Snap ITC", Font.PLAIN, 21));
		lblNewLabel_2_3.setBounds(109, 130, 117, 29);
		panel.add(lblNewLabel_2_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		panel_1.setBounds(307, 35, 989, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("...Projet Structurant...");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(670, 58, 265, 30);
		panel_1.add(lblNewLabel_1_1);
		
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
				lblNewLabel.setForeground(Color.BLACK);
			}
		});
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(1258, 0, 16, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion de la superette");
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(339, 12, 224, 13);
		contentPane.add(lblNewLabel_1);
		
		JPanel affiche_optionM = new JPanel();
		affiche_optionM.setBackground(Color.WHITE);
		affiche_optionM.setBounds(326, 150, 948, 504);
		contentPane.add(affiche_optionM);
		affiche_optionM.setLayout(null);
		v.setBounds(24, 27, 914, 453);
		affiche_optionM.add(v); // affiche_optionM contient le jpanel ventes
		s.setSize(914, 453);
		s.setLocation(24, 27);
		affiche_optionM.add(s);
		f.setBounds(24, 27, 914, 453);
		affiche_optionM.add(f);
		r.setSize(914, 453);
		r.setLocation(24, 27);
		affiche_optionM.add(r);
		
		
		
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
				Menu_principal.this.setLocation(x - xy,y - xy);
				}
				
			});
	}
}
