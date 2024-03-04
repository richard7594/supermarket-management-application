package Gestion_superette;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		connection_BD c = new connection_BD();
	 c.connection();
	
		int qpro = Integer.parseInt(JOptionPane.showInputDialog("Entrer un nombre")) ;
		
		qpro= qpro+10;
		
		JOptionPane.showMessageDialog(null, qpro);
		
		
	}

	
	
	
	
}
