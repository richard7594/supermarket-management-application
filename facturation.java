package Gestion_superette;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class facturation extends JPanel {
	private JTextField mat;
	private JTextField np;
	private JTextField qte;
	private JTextField pu;
	private JTextField mt;
	 private JTextField numfac;

	/**
	 * Create the panel.
	 */
	
	Connection con;
	PreparedStatement pst;
	ResultSet t;
	Statement st;
	String nom;
	String pre;
	 int ref;
	 int q;	
	 boolean ver;
	

	public facturation() {
		
		setBackground(Color.WHITE);
		setBounds(326, 150, 940, 500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(23, 39, 310, 273);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMatriculeClient = new JLabel("Matricule client");
		lblMatriculeClient.setBounds(10, 20, 85, 13);
		panel.add(lblMatriculeClient);
		lblMatriculeClient.setForeground(Color.WHITE);
		lblMatriculeClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNomProduit = new JLabel("Nom produit");
		lblNomProduit.setForeground(Color.WHITE);
		lblNomProduit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomProduit.setBounds(10, 57, 85, 13);
		panel.add(lblNomProduit);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setForeground(Color.WHITE);
		lblQuantite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantite.setBounds(10, 97, 85, 13);
		panel.add(lblQuantite);
		
		JLabel lblMontantVerse = new JLabel("Montant verse");
		lblMontantVerse.setForeground(Color.WHITE);
		lblMontantVerse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMontantVerse.setBounds(10, 166, 85, 13);
		panel.add(lblMontantVerse);
		
		JLabel lblNomProduit_1 = new JLabel("Prix unitaire");
		lblNomProduit_1.setForeground(Color.WHITE);
		lblNomProduit_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomProduit_1.setBounds(10, 134, 85, 13);
		panel.add(lblNomProduit_1);
		
		mat = new JTextField();
		mat.setBounds(130, 18, 170, 19);
		panel.add(mat);
		mat.setColumns(10);
		
		np = new JTextField();
		np.setColumns(10);
		np.setBounds(130, 55, 170, 19);
		panel.add(np);
		
		qte = new JTextField();
		qte.setColumns(10);
		qte.setBounds(130, 95, 101, 19);
		panel.add(qte);
		
		pu = new JTextField();
		pu.setColumns(10);
		pu.setBounds(130, 132, 101, 19);
		panel.add(pu);
		
		mt = new JTextField();
		mt.setColumns(10);
		mt.setBounds(130, 164, 101, 19);
		panel.add(mt);
		
		JButton btnOk = new JButton("OK\r\n");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Enregistrefac(mat.getText(),np.getText(),qte.getText() ,pu.getText(),mt.getText());
				 
			}
		});
		btnOk.setBounds(228, 193, 56, 21);
		panel.add(btnOk);
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(new Color(75, 0, 130));
		
		JLabel lblNfacture = new JLabel("N\u00B0facture");
		lblNfacture.setForeground(Color.WHITE);
		lblNfacture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNfacture.setBounds(10, 230, 85, 13);
		panel.add(lblNfacture);
		
		numfac = new JTextField();
		numfac.setColumns(10);
		numfac.setBounds(130, 228, 101, 19);
		panel.add(numfac);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(357, 20, 557, 410);
		add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea fac = new JTextArea();
		fac.setBounds(10, 10, 537, 390);
		panel_2.add(fac);
		setVisible(true);
		
		JButton btnAppercueDeLa = new JButton("Imprimer de la facture");
		btnAppercueDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Affichefac(fac,numfac.getText());
				
				
			}
		});
		btnAppercueDeLa.setForeground(Color.WHITE);
		btnAppercueDeLa.setBackground(new Color(75, 0, 130));
		btnAppercueDeLa.setBounds(87, 350, 190, 21);
		add(btnAppercueDeLa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actualiser");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clean ( mat, np, qte, pu, mt,numfac) ;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				 lblNewLabel_1_1.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 lblNewLabel_1_1.setForeground(Color.black);
			}
		});
		lblNewLabel_1_1.setBounds(10, 20, 69, 13);
		add(lblNewLabel_1_1);
		
		
       
	}
	
public void connection() {
		
		
		try {
			
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	   con = DriverManager.getConnection("jdbc:mysql://localhost/superette","root","");
	  
	   System.out.println("connection succesfull......");
			
		}catch( Exception e) {System.err.println(e);}
	}
	
	
	
	
	

	public void Enregistrefac(String a,String b,String c,String d,String e) {
		
		connection();
		
		try {
			
			
			String sql="select* from client where matcli='"+a+"'";
			
			pst= con.prepareStatement(sql);
			st= con.createStatement();
			t=st.executeQuery(sql);
			
			while(t.next()) {
				nom=t.getString("nomcli");
				pre=t.getString("precli");
				
			}
			
			
			
		// recupere la date du System et la formater
			Date dt = new Date();
			
			SimpleDateFormat df= new SimpleDateFormat("Y-MM-dd");
			
			String date = df.format(dt);
			
		
			//sequence permettant d'incrementer le numero des factures grace a la table ref de le bd
			
			   String sql1="DELETE ref from ref";
	    	   String sql2="insert into ref(ref) values (?)";
	    	   String sql3="select* from ref";
	    	   
	    	   
	    	    pst= con.prepareStatement(sql3);
				st= con.createStatement();
				t=st.executeQuery(sql3);
				
				while(t.next()) {
					ref= t.getInt("ref");
				  }
	    	   
	    	       ref=ref+1;
	    	   
	    		 pst = con.prepareStatement(sql1); // Supprimer tout les element de la table ref
	    		 pst.executeUpdate();
	    	   
	  	      	 pst = con.prepareStatement(sql2); // on insert le parametre value dans la bd
	  		     pst.setString(1, String.valueOf(ref));
	  	      	
	  		     pst.executeUpdate();

	  		     
			int pt= Integer.parseInt(c)*Integer.parseInt(d);
			int remb = Integer.parseInt(e)-pt;
			
			
			if( remb<0 || pt<=0) {
				
			JOptionPane.showMessageDialog(null, "Erreur le montant verse est inferieur au prix total \n ou la Quantite d'article est null");
			
			}else {
			
//Doit permettre de desingrementer la quantite d'un produit b
				
	
			
				
	String Sql3= "select* from produit where nompro='"+b+"'";
		
	    pst=con.prepareStatement(Sql3);
		st=con.createStatement();
	    t=st.executeQuery(Sql3);			 

	    
	    
if(t.next()) {
	    	   
	    	pst=con.prepareStatement("select* from produit where nompro ='"+b+"'" );
	    	st= con.createStatement();
	    	t=st.executeQuery("select* from produit where nompro ='"+b+"'");
	    	
	    	while(t.next()) {
	    		
	    	    q= t.getInt("Qte");
	    		
	    	}
	   
	    	System.out.println(q);
	    	System.out.println(Integer.parseInt(c));
	    	
	    	if( Integer.parseInt(c) < q ) {
	    	  
	    
	    	String sql4=" update produit set Qte = Qte-"+c+" where nompro ='"+b+"'";
	    
		      pst=con.prepareStatement(sql4);
		     
		      pst.executeUpdate();
		        
		      ver = true;
	    	     
	    	}else { JOptionPane.showMessageDialog(null, "La quantite de produit dans le stock est insuffisante pour cette operation \n veuillez vous reaprovisionez "); }
	    	    	
		 
		
	
	    
	  }else { JOptionPane.showMessageDialog(null, "Ce produit ne figure pas dans la base de donnees"); }
				
	    
	    
	    


//Enregistre les donnees dans la table facture
		
     if(ver==true) {
			
    	    pst=con.prepareStatement("insert into Facture(numfac,datef,nomcli,precli,nompro,qte,pu,pt,mv,remb) values (?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1,String.valueOf(ref) );
			pst.setString(2,date );
			pst.setString(3,nom );
			pst.setString(4,pre );
			pst.setString(5, b);
			pst.setString(6,c );
			pst.setString(7, d);
			pst.setString(8, String.valueOf(pt));
			pst.setString(9,e );
			pst.setString(10,String.valueOf(remb) );
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, " Facture N°"+ref+" generer avec succes........");
			numfac.setText(String.valueOf(ref));
			
			// Enregistre dans Ventes
			
			pst=con.prepareStatement("insert into ventes(nompro,Qte,matcli,datev) values (?,?,?,?)");
			
			pst.setString(1,b);
			pst.setString(2,c );
			pst.setString(3,a );
			pst.setString(4,date );
			
			pst.executeUpdate();
			
			
			
     }
			
			
			
			}
			
		  }catch(Exception ex) {System.err.println(ex);}
		
		
		
	}
	
	
	
	
	
	public void Affichefac(JTextArea fac,String a) {
		
		connection();
		
     	
		
     	String numfac=null,datef=null,nomcli=null,precli=null,nompro=null,qte=null,pu=null,pt=null,mv=null,remb=null;
     	
     	
     	
     	try {
     		String sql="select* from Facture where numfac='"+a+"'";
     	        
    		
			
			pst= con.prepareStatement(sql);
			st=con.createStatement();
			t=st.executeQuery(sql);
		
			while(t.next()) {
				
				numfac =t.getString("numfac");
				datef=t.getString("datef");
				nomcli=t.getString("nomcli");
				precli=t.getString("precli");
				nompro =t.getString("nompro");
				qte=t.getString("qte");
				pu=t.getString("pu");
				pt=t.getString("pt");
				mv=t.getString("mv");
				remb=t.getString("remb");
				
			}
		
			
     		
			String l1 ="*************************************************************************************************************************************************************************";
			String l2 ="                                @+---------*****FACTURE_SUPERETTE_DE_LA_GLOIRE*****---------+@";
			String l3 ="*************************************************************************************************************************************************************************";
			String l4 ="\n\n";
			String l5 ="  Conctat: 6782536982";
			String l6 ="  Email:superette-la-gloire@gmail.com";
			String l7 ="---------------------------------\n";
			String l8 ="   Fait a Douala le "+datef+"";
			String l9 ="\n";
			String l10 ="           Facture  N°"+numfac;
			String l11 ="\n";
			String l12 ="           Nom du client:-------------------------------------------------"+nomcli;
			String l13 ="           Prenom client:-------------------------------------------------"+precli;
			String l14 ="           Designation  :-------------------------------------------------"+nompro;
			String l15 ="           Quantite     :--------------------------------------------------"+qte;
			String l16 ="           Prix unitaire:--------------------------------------------------"+pu+"F";
			String l17 ="           Prix total   :--------------------------------------------------"+pt+"F";
			String l18 ="           Versement    :--------------------------------------------------"+mv+"F";
			String l19 ="           Relicat      :--------------------------------------------------"+remb+"F";
			String l20 ="";
			
     		
     		   fac.setText(l1+"\n"+l2+"\n"+l3+"\n"+l4+"\n"+l5+"\n"+l6+"\n"+l7+"\n"+l8+"\n"+l9+"\n"+l10+"\n"+l11+"\n"+l12+"\n"+l13+"\n"+l14+"\n"+l15+"\n"+l16+"\n"+l17+"\n"+l18+"\n"+l19+"\n"+l20);
     	
     	
     	
     	
     	
     	
		
     	}catch(Exception e) {System.err.println(e);}
	}
	
	
	
	
	 
	   public void clean (JTextField mat,JTextField np,JTextField qte,JTextField pu,JTextField mt,JTextField numfac) {
	    	
	    	np.setText("");
	    	pu.setText("");
	    	qte.setText("");
	    	mat.setText("");
	    	mt.setText("");
	    	numfac.setText("");
	    	
	      }
	
	
}
