package Gestion_superette;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
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
import javax.swing.JScrollPane;

public class ventes extends JPanel {
	private JTextField nom;
	private JTextField pre;
	private JTextField mat;
	private JTextField stat;
	private JTextField ncom;
	private JTextField qcom;
	private JTextField dcom;
	private JTextField dSym;
	private JTable table;

	/**
	 * Create the panel.
	 */
	ResultSet r;
    Connection con ;
	PreparedStatement pst;
	Statement st;
	
	
	public ventes() {
		
		
		
		setBackground(Color.WHITE);
	    setBounds(326, 150, 940, 500);
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(61, 27, 308, 256);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 34, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrenom.setBounds(10, 71, 45, 13);
		panel.add(lblPrenom);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setForeground(Color.WHITE);
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatricule.setBounds(10, 106, 59, 13);
		panel.add(lblMatricule);
		
		Button button = new Button("Rechercher");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connection();
				recherchecli(mat.getText(),nom,pre,ncom,qcom,dcom,dSym);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(75, 0, 130));
		button.setBounds(180, 212, 94, 21);
		panel.add(button);
		
		JLabel lblStatut = new JLabel("Statut");
		lblStatut.setForeground(Color.WHITE);
		lblStatut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatut.setBounds(10, 137, 59, 13);
		panel.add(lblStatut);
		
		nom = new JTextField();
		nom.setBounds(98, 32, 161, 19);
		panel.add(nom);
		nom.setColumns(10);
		
		pre = new JTextField();
		pre.setColumns(10);
		pre.setBounds(98, 69, 161, 19);
		panel.add(pre);
		
		mat = new JTextField();
		mat.setColumns(10);
		mat.setBounds(98, 104, 161, 19);
		panel.add(mat);
		
		stat = new JTextField();
		stat.setColumns(10);
		stat.setBounds(98, 135, 96, 19);
		panel.add(stat);
		
		Button button_1 = new Button("Enregistrer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connection();
				
				enregistrecli(nom.getText(),pre.getText(),stat,mat);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(75, 0, 130));
		button_1.setBounds(35, 212, 94, 21);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		panel_1.setBounds(482, 27, 448, 256);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomDeLarticle = new JLabel("Nom de l'article ");
		lblNomDeLarticle.setForeground(Color.WHITE);
		lblNomDeLarticle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomDeLarticle.setBounds(25, 39, 107, 13);
		panel_1.add(lblNomDeLarticle);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setForeground(Color.WHITE);
		lblQuantite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantite.setBounds(25, 89, 80, 13);
		panel_1.add(lblQuantite);
		
		JLabel lblDateDelai = new JLabel("Date delai");
		lblDateDelai.setForeground(Color.WHITE);
		lblDateDelai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateDelai.setBounds(25, 134, 80, 13);
		panel_1.add(lblDateDelai);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date commande");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(25, 175, 94, 13);
		panel_1.add(lblNewLabel_3_1);
		
		Button button_1_1 = new Button("Enregistrer la commande");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    
			connection();
			enregistrecom(ncom.getText(),qcom.getText(),dcom.getText(),mat.getText(), dSym);// obtenir la date du System avec format bd et parraport a la recherche du client doit etre lie a sa commande
				
			}
		});
		button_1_1.setForeground(Color.WHITE);
		button_1_1.setBackground(new Color(75, 0, 130));
		button_1_1.setBounds(136, 225, 192, 21);
		panel_1.add(button_1_1);
		
		ncom = new JTextField();
		ncom.setColumns(10);
		ncom.setBounds(165, 37, 210, 19);
		panel_1.add(ncom);
		
		qcom = new JTextField();
		qcom.setColumns(10);
		qcom.setBounds(165, 87, 80, 19);
		panel_1.add(qcom);
		
		dcom = new JTextField();
		dcom.setColumns(10);
		dcom.setBounds(165, 132, 161, 19);
		panel_1.add(dcom);
		
		dSym = new JTextField();
		dSym.setColumns(10);
		dSym.setBounds(165, 173, 161, 19);
		panel_1.add(dSym);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 318, 869, 172);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_1 = new JLabel("Appercue generale des clients");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Table();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.red);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.black);
			}
		});
		lblNewLabel_1.setBounds(44, 301, 174, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actualiser");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clean ( nom, pre, mat, stat,ncom, qcom, dcom,dSym);
				
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
		lblNewLabel_1_1.setBounds(61, 4, 69, 13);
		add(lblNewLabel_1_1);
		
		
	}
	
	
	
	
	
	
	
	public void connection() {
		
		
		try {
			
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	   con = DriverManager.getConnection("jdbc:mysql://localhost/superette","root","");
	  
	   System.out.println("connection succesfull......");
			
		}catch( Exception e) {System.err.println(e);}
	}
	
	
    public String matcli() {
  	  
  	  Random R = new Random();
  	 	
  	ArrayList<String> Mat = new ArrayList<String>();
  	int i;
  	String mat;
  	  
  	 for (i=0;i<=11;i++) {
  		 
  	   mat="client"+R.nextInt()+"#sup"+R.nextInt()+"ri#"; 
  	   Mat.add(mat);
  		 
  	 }
  	 
  	 return Mat.get(R.nextInt(10));	
  	
 }

    
    public void enregistrecli( String b ,String c,JTextField stat,JTextField mat) {
  	  
  	 
    	String sql="select* from client where nomcli='"+b+"' and precli= '"+c+"'";
    	
    	try {
    		
    	
    	pst=con.prepareStatement(sql);
    	st=con.createStatement();
    	r=st.executeQuery(sql);
    	
    	if (r.next()) {
    		JOptionPane.showMessageDialog(null,"Statut du client : Ancien");
    		JOptionPane.showMessageDialog(null,"Enregistrement interompue");
    		stat.setText("Ancien");
    		
    		pst=con.prepareStatement(sql);
    		r=st.executeQuery(sql);
    		
    		while(r.next()) {
    		                  mat.setText(r.getString("matcli").toString());
    		                }
    		
    	}else {
    		
    		JOptionPane.showMessageDialog(null,"Statut du client : Nouveau");
    		stat.setText("Nouveau");
    		
    		  String a= matcli();
    		 
    		  pst = con.prepareStatement("insert into client(matcli,nomcli,precli) values (?,?,?)");
     		  pst.setString(1, a);
     		  pst.setString(2, b);
     		  pst.setString(3, c);
     		  
     		  pst.executeUpdate();
     		  
     		  JOptionPane.showMessageDialog(null, "Le client "+b+" "+c+" a ete enregistre avec succes");
     		  JOptionPane.showMessageDialog(null,"son matricule est: "+a);
     		  
     		  mat.setText(a);
     		  
    	}
    	
    	
    	}catch(Exception ex){System.err.println(ex);}
    	
   
    }

     public void recherchecli(String a,JTextField nom,JTextField pre,JTextField ncom,JTextField qcom,JTextField dcom,JTextField dSym) {
    	 
    	 String sql="select* from client where matcli ='"+a+"'";
    	 String sql1="select* from commande where matcli ='"+a+"'";
    		
    	try { 
    		 pst=con.prepareStatement(sql);
    		 st=con.createStatement();
    		 r=st.executeQuery(sql);
    		
    	if(r.next()) {
    		
    		 
    		 JOptionPane.showMessageDialog(null,"Client retrouve ");
    		pst=con.prepareStatement(sql);
     		r=st.executeQuery(sql);
     		
     		while(r.next()) {
     		                  nom.setText(r.getString("nomcli").toString());
     		                  pre.setText(r.getString("precli").toString());
  
     		                }
    	
     		//Recherche si le client a une commande 
     		 pst=con.prepareStatement(sql1);
    		 st=con.createStatement();
    		 r=st.executeQuery(sql1);
    		 
    		 if(r.next()) {
    			          
    			             JOptionPane.showMessageDialog(null,"Le client a effectue une commande ");
    			             
    			             pst=con.prepareStatement(sql1);
    			      		r=st.executeQuery(sql1);
    			      		
    			      		while(r.next()) {
    			      			 
    			      			 ncom.setText(r.getString("nomcom").toString());
    			      			 qcom.setText(r.getString("Qte").toString());
    			      			 dcom.setText(r.getString("deadtime").toString());
    			      			 dSym.setText(r.getString("datecom").toString());
    			      			
    			      		                 }
    			             
    			 
    		               }else {
    		            	   JOptionPane.showMessageDialog(null,"Le client n'a pas effectue de commande ");
    			 
    		               }
    		 
    		
     		
     		
    	}else {
    		JOptionPane.showMessageDialog(null,"Client ne figure pas dans la base de donnees ");
    		
    	     }
    	 
    	}catch(Exception ex){System.err.println(ex);}
     }
     
     
     
     public void enregistrecom(String a,String b,String c,String d,JTextField dSym) {
    	 
    	
    	 try {
    		 
    		 pst = con.prepareStatement("insert into commande(nomcom,Qte,deadtime,matcli,datecom) values (?,?,?,?,?)");
    		  pst.setString(1, a);
    		  pst.setString(2, b);
    		  pst.setString(3, c);
    		  pst.setString(4, d);
    		  pst.setString(5, date_sys());
    		  
    		  pst.executeUpdate();
    		  
    		  JOptionPane.showMessageDialog(null,"La commande a ete enregistrer avec succes..... ");
    		  dSym.setText(date_sys());
    		  	 
    	 }catch(Exception ex){System.err.println(ex);}
    	 
        }

    
     
     
public String date_sys() {
    	 
         Date d = new Date();
         
         SimpleDateFormat df = new  SimpleDateFormat("Y-MM-dd");// Y pour annee MM pour mois en chiffre et dd pour jour 
         
         
        return df.format(d);
     }
     
        public void Table() {
        	
        	connection();
        	String sql="select* from client";
        	
        	try {
        	
        	String [] column = {"Matricule","Nom","Prenom"};
        	String [] ligne = new String[3];
        	
        	DefaultTableModel model = new DefaultTableModel(null, column);
        	
        	pst= con.prepareStatement(sql);
        	st=con.createStatement();
        	r=st.executeQuery(sql);
        	
        	while(r.next()) {
        		
        		ligne[0]= r.getString("matcli");
        		ligne[1]= r.getString("nomcli");
        		ligne[2]= r.getString("precli");
        		
        		model.addRow(ligne); // addRow ajouter les lignes
        		
        	}
        	
        	table.setModel(model);
        	}catch(Exception ex){System.err.println(ex);}
        	
        	
        	
        }
        
        
        public void clean (JTextField nom,JTextField pre,JTextField mat,JTextField stat,JTextField ncom,JTextField qcom,JTextField dcom,JTextField dSym) {
        	
        	nom.setText("");
        	pre.setText("");
        	mat.setText("");
        	stat.setText("");
        	ncom.setText("");
        	qcom.setText("");
        	dcom.setText("");
        	dSym.setText("");
        	
        	
        	
        }
}
