package Gestion_superette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import javax.swing.JOptionPane;




public class connection_BD {

	ResultSet r;
    Connection con ;
	PreparedStatement pst;
	Statement st;
    String sql=null;
    String sql1=null;

    Menu_principal m = new Menu_principal();
    
	public void connection() {
		
		
		try {
			
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	   con = DriverManager.getConnection("jdbc:mysql://localhost/superette","root","");
	  
	   System.out.println("connection succesfull......");
			
		}catch( Exception e) {
			
			System.err.println(e);
		}
		
	}	
	
	
	// pourquoi la boucle try....catch et essaye d expliquer les Synthase

	
	
    
	public void requetLog(String sql) {
	
    
    	try {
		       
		        pst = con.prepareStatement(sql);
		      	st=con.createStatement();
		      	r=st.executeQuery(sql);
		      	
   if(r.next()) {
	                 JOptionPane.showMessageDialog(null, "Identite confirmer!!");
	                 
	                 m.setUndecorated(true);
						m.setVisible(true);//permet d'ouvrir une classe 
						//dispose();;// permet de fermer la classe presse de l ouverture de celle appeles
						
		      		
		      	}else
		      	
		      	{
		      		JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe erronne !!!");
		      		JOptionPane.showMessageDialog(null, "veuillez ressayez !!");
		      	}
		      	
		      
	       }catch(Exception e1) {System.err.println(e1);}
	  
        }
	

	
     public void recent(String value) {
    	  
    	   sql="DELETE recent from recent";
    	   sql1="insert into recent(recent) values (?)";
    	 
    	   
    	   try {
    	   
    		 pst = con.prepareStatement(sql); // Supprimer tout les element de la table recent
    		 pst.executeUpdate();
	   
    	  	 }catch(Exception q) {System.err.println(q);}
    	 
    	  
    	   try {
  	      	 pst = con.prepareStatement(sql1); // on insert le parametre value dans la bd
  		     pst.setString(1, value);
  	      	
  		     pst.executeUpdate();
  	   
      	 
      	   }catch(Exception a) {System.err.println(a);}
      	 
     }
     
     
     public String afficher() {
    	 
    	 String afficher = null;
    	 sql="select* from recent";
    	   
    	 try {
        	   
      		 pst = con.prepareStatement(sql); // introduire la requete
  	      	 st=con.createStatement();
  	      	 r=st.executeQuery(sql);
      	 
  	      	while(r.next()) {
  	      		afficher= r.getString("recent");
  	      	}
  	      	
  	           }catch(Exception o) {System.err.println(o);}
      	
    	 return afficher;
    	
    	 
     }



		/*  try.....catch est une boucle qui permet de capturer les erreurs du code contenue dans ce dernier 
		a fin de ne pas bloquer l enchainement des sequences d'instruction du programme	*/
		
    
	
	// where matcli='client1#superette*36ri#'
    public void test() {
    	  
    	  
    	 connection();
    	  String nom = null,pre = null,mat=null;
    	  String sql="select* from client where matcli='client1#superette*36ri#'";
    	  
    	  try {
    			
    			
    			pst= con.prepareStatement(sql);
    			st=con.createStatement();
    			r=st.executeQuery(sql);
    		
    			while(r.next()) {
    				
    				nom=r.getString("nomcli");
    				pre=r.getString("precli");
    				
    			}
    		
    			System.out.println(nom+" "+pre);
    		  
    	  }catch(Exception o) {System.err.println(o);}
    	  
      }
       	 
       public void test1() {
    	   
    	   
    		try {
    			
    			  Class.forName("com.mysql.cj.jdbc.Driver");
    			  
    			   con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
    			  
    			   System.out.println("connection succesfull......");
    			   
    				  
    			   String sql4=" update test set qte=qte-1";
    			    	
    			      pst=con.prepareStatement(sql4);
    			     
    			      pst.executeUpdate();
    			        
    			      
    					
    				}catch( Exception e) {
    					
    					System.err.println(e);
    				}
    				  
    	   
    	   
    	   
    	   
    	   
    	   
    	   
       }
       	 
       	 
        }
     
  
      
     
     
     
     
     
	
	



