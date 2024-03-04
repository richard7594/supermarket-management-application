package Gestion_superette;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stock extends JPanel {
	private JTextField npro;
	private JTextField mq;
	private JTextField qte;
	private JTextField mat;
	private JTable table;

	/**
	 * Create the panel.
	 */
	Connection con;
	PreparedStatement pst;
	ResultSet t;
	Statement st;
	

	
	
	
	public stock() {
		
		setBackground(Color.WHITE);
		setBounds(326, 150, 940, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(10, 10, 246, 438);
		add(panel);
		panel.setLayout(null);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 EnregistrePro(npro.getText(),mq.getText(),qte.getText(),mat);
				
				
			}
		});
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setBackground(new Color(75, 0, 130));
		btnEnregistrer.setBounds(64, 347, 121, 21);
		panel.add(btnEnregistrer);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Recherchepro(mat.getText(), npro , mq, qte);
				
				
			}
		});
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setBackground(new Color(75, 0, 130));
		btnRechercher.setBounds(64, 388, 121, 21);
		panel.add(btnRechercher);
		
		JLabel lblNomProduit = new JLabel("Nom produit");
		lblNomProduit.setForeground(Color.WHITE);
		lblNomProduit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomProduit.setBounds(0, 46, 85, 13);
		panel.add(lblNomProduit);
		
		JLabel lblQuantite = new JLabel("Marque");
		lblQuantite.setForeground(Color.WHITE);
		lblQuantite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantite.setBounds(0, 94, 85, 13);
		panel.add(lblQuantite);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setForeground(Color.WHITE);
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatricule.setBounds(0, 195, 85, 13);
		panel.add(lblMatricule);
		
		npro = new JTextField();
		npro.setBounds(102, 44, 115, 19);
		panel.add(npro);
		npro.setColumns(10);
		
		mq = new JTextField();
		mq.setColumns(10);
		mq.setBounds(102, 92, 115, 19);
		panel.add(mq);
		
		qte = new JTextField();
		qte.setColumns(10);
		qte.setBounds(102, 139, 59, 19);
		panel.add(qte);
		
		mat = new JTextField();
		mat.setColumns(10);
		mat.setBounds(102, 193, 115, 19);
		panel.add(mat);
		
		JLabel lblQuantite_1 = new JLabel("Quantite");
		lblQuantite_1.setForeground(Color.WHITE);
		lblQuantite_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantite_1.setBounds(0, 141, 85, 13);
		panel.add(lblQuantite_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actualiser");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clean (npro,mq,qte, mat);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_1.setForeground(Color.red);
				
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_1.setForeground(Color.white);
			}
		});
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(92, 324, 69, 13);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Appercue du stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Appercue();
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setBounds(489, 10, 156, 21);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 56, 612, 392);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.menu);
		setVisible(true);

	}
	
public void connection() {
		
		
		try {
			
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	   con = DriverManager.getConnection("jdbc:mysql://localhost/superette","root","");
	  
	   System.out.println("connection succesfull......");
			
		}catch( Exception e) {System.err.println(e);}
	}



public String matpro() {
	  
	  Random R = new Random();
	 	
	ArrayList<String> Mat = new ArrayList<String>();
	int i;
	String mat;
	  
	 for (i=0;i<=11;i++) {
		 
	   mat="Pro"+R.nextInt()+"#sup"+R.nextInt()+"ri#"; 
	   Mat.add(mat);
		 
	 }
	 
	 return Mat.get(R.nextInt(10));	
	
}
	
	
	
	
	
	
	
	public void EnregistrePro(String b,String c,String d,JTextField mat) {
		
		connection();
		String a = matpro();
		
		
		try {
			
			String sql5="select* from produit where nompro ='"+b+"' and  marque ='"+c+"'";
			
			pst= con.prepareStatement(sql5);
			st= con.createStatement();
			t=st.executeQuery(sql5);
			
			if(t.next()) {
			   
			    	 
			    		  String sql4=" update produit set Qte = Qte+"+d+" where nompro ='"+b+"' and marque='"+c+"'";
			    	    
					      pst=con.prepareStatement(sql4);
					     
					      pst.executeUpdate();
					      
					      JOptionPane.showMessageDialog(null,"La quantite de produit a ete ajouter");
					      
					     
					      
			            }else {
			     
			
			
			 
			 
			 pst = con.prepareStatement("insert into produit(matpro,nompro,marque,Qte) values (?,?,?,?)");
				
             pst.setString(1, a);
             pst.setString(2, b);
             pst.setString(3, c);
             pst.setString(4, d);

             pst.executeUpdate();


            JOptionPane.showMessageDialog(null,"Le produit a ete enregistre avec succes ");

            mat.setText(a);
            
			}
            
		}catch(Exception e) {System.err.println(e);}
		
		
		
	}
	
	
	public void Recherchepro(String mat,JTextField npro,JTextField mq,JTextField qte) {
		connection();
	
		String	sql="select* from produit where matpro='"+mat+"'";
		
		try {
			
			pst= con.prepareStatement(sql);
			st= con.createStatement();
			t=st.executeQuery(sql);
			
			if(t.next()) {
				
				JOptionPane.showMessageDialog(null,"Le produit figure dans la base de donnees des stocks ");
				
				               pst= con.prepareStatement(sql);
				               st= con.createStatement();
				   			   t=st.executeQuery(sql);
				   			   
				   			   while(t.next()) {
				   				   npro.setText(t.getString("nompro"));
				   				   mq.setText(t.getString("marque"));
				   				   qte.setText(String.valueOf(t.getInt("Qte")));
				   				   
				   			   }
			             
			
			             }else {
				            
			            	 JOptionPane.showMessageDialog(null,"Le produit ne figure pas dans la base de donnees des stocks ");
				
			                    }
			
			
			
		}catch(Exception e) {System.err.println(e);}
		
		
	}
	
	public void Appercue() {
		connection();
		
		String	sql="select* from produit ";
		
		try {
			
			String [] Entete = {"Matricule","Nom du produit","Marque","Quantite"};
			String [] ligne = new String [4];
			
			DefaultTableModel model = new DefaultTableModel(null,Entete);
			
			
			pst = con.prepareStatement(sql);
			st = con.createStatement();
			t= st.executeQuery(sql);
			
			while(t.next()) {
				
				ligne [0] = t.getString("matpro");
				ligne [1] = t.getString("nompro");
				ligne [2] = t.getString("marque");
				ligne [3] = t.getString("Qte");
				
				model.addRow(ligne);
				
			}
			
			table.setModel(model);
			
			
			
			
		   }catch(Exception e) {System.err.println(e);}
		
		
	}
	
    public void clean (JTextField npro,JTextField mq,JTextField qte,JTextField mat) {
    	
    	npro.setText("");
    	mq.setText("");
    	qte.setText("");
    	mat.setText("");
    
    	
    	
    }
	
	
	
}
