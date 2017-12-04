import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.* ;

import javax.swing.*;



public class GSB_FenetreConnectionVisiteur extends JFrame   {

	//Attributs Prives 
		
		private JLabel lblMessageAccueil ;
		private AfficheImage monImg ;
		private JPanel imgPanel ;
		private JPanel unPanel ;
		private JLabel lblLogin ;
		private JLabel lblMdp ;
		
		private JTextField jtfLogin ;
		private JPasswordField jtfMdp ;
		
		private JButton btnValider ;
		
	public GSB_FenetreConnectionVisiteur () {
		this.setTitle("PPE 2: Connection Visiteur ") ;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400) ;
		this.setResizable (false) ;
		
	//JBUTTON
		this.btnValider = new JButton ("Valider ") ;
		this.unPanel  = new JPanel();
	//JLABEL
		this.lblMessageAccueil = new JLabel ("Bienvenue sur GSB Comptable :           ") ;
		Font titre = new Font("Arial", Font.PLAIN, 30);
		Font H3 = new Font("Arial", Font.PLAIN, 10);
		this.lblMessageAccueil.setFont(titre);
		this.lblMessageAccueil.setForeground(Color.white);
		
		
		this.lblLogin = new JLabel ("Votre Login:        ") ;
		this.lblLogin.setFont(H3);
		this.lblLogin.setForeground(Color.white);
		

		this.lblMdp = new JLabel ("Votre MDP: ") ;
		this.lblMdp.setFont(H3);
		this.lblMdp.setForeground(Color.white);

	//JTEXTFIELD
		this.jtfLogin = new JTextField ("") ;
		this.jtfLogin.setPreferredSize(new Dimension (150,30));
		this.jtfMdp = new JPasswordField ("") ;
		this.jtfMdp.setPreferredSize(new Dimension (150,30));
		
	//ACTION LISTENER	
		btnValider.addActionListener(new ActionCoVisiteur ());
		
	unPanel.setBackground(new Color(9,68,89));
	
	unPanel.add(this.lblMessageAccueil) ;
	
	
	unPanel.add(this.lblLogin) ;
	unPanel.add(this.jtfLogin) ;
	
	unPanel.add(this.lblMdp);
	unPanel.add(this.jtfMdp);
	unPanel.add(btnValider) ;
	this.getContentPane().add(unPanel) ;
	this.setVisible(true);

	}
	
	class ActionCoVisiteur  implements ActionListener {

		public void actionPerformed(ActionEvent evenement) {
			// TODO Auto-generated method stub
			if (evenement.getSource() == btnValider) {
				
				GSB_Modele unModele = new GSB_Modele () ;
				GSB_Md5 md5 = new GSB_Md5 () ;
				
				boolean rep = false ;
				String unLogin = jtfLogin.getText() ;
				String unMdp = jtfMdp.getText() ;
				
				String unMdpMd5 = md5.code(unMdp) ;
				System.out.println(unMdpMd5);
				
				
				 rep = unModele.connectionVisiteur(unLogin,unMdpMd5) ;
				 jtfLogin.setText("");
				 jtfMdp.setText("");
				 if (rep == false){
					System.out.println("pas connecter ");
					 setVisible(true);
				 }
				 else{
					 System.out.println("connecter");
					 setVisible(false);
					 GSB_FenetreAccueil uneFenetre = new GSB_FenetreAccueil() ;
					 dispose();
					
					
				 }//FIN ELSE REP
				 
			}//FIN SI EVENEMENT BTNVALIDER
		
		}//FIN DE CLASSE ACTION LISTENER
	}//FIN CONSTRUCTEUR
}

