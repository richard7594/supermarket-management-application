package Gestion_superette;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventes_vrai extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	PreparedStatement pst ;
	Statement st;
	ResultSet r;
	Connection con;
	
	
	public ventes_vrai() {
		setBackground(Color.WHITE);

		setBounds(326, 150, 940, 500);
		setVisible(true);
		setLayout(null);
		
		JButton btnAppercueDesVentes = new JButton("Appercue des Ventes");
		btnAppercueDesVentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AfficheVente();
			}
		});
		btnAppercueDesVentes.setForeground(Color.WHITE);
		btnAppercueDesVentes.setBackground(new Color(148, 0, 211));
		btnAppercueDesVentes.setBounds(31, 28, 156, 21);
		add(btnAppercueDesVentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 64, 878, 394);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.menu);
	}

	public void connection() {
		
		try {
			
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
			   con = DriverManager.getConnection("jdbc:mysql://localhost/superette","root","");
			  
			   System.out.println("connection succesfull......");
					
				}catch( Exception e) {System.err.println(e);}
		
		
		
		
		
	}
	
	
	public void  AfficheVente() {
		
		connection();
		String sql = " select* from ventes";
		
		try{
			
			String [] column= {"Nom produit","Quantite","Matricule client","Date"};
			String [] ligne = new String [4];
			
			DefaultTableModel model = new DefaultTableModel(null,column);
			
			pst = con.prepareStatement(sql);
			st= con.createStatement();
			r= st.executeQuery(sql);
			
			while(r.next()) {
				
				ligne [0] = r.getString("nompro");
				ligne [1] = String.valueOf(r.getString("Qte"));
				ligne [2] = r.getString("matcli");
				ligne [3] = r.getString("datev");
				
				model.addRow(ligne);
			}
			
			
			table.setModel(model);
			
			
			
		}catch(Exception e) { System.err.println(e);}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
