import javax.swing.* ; //Importe pour les Fenetres en Java 

import java.awt.* ; //IMporte pour creer l'interface
import java.awt.event.*;
import java.util.ArrayList;

public class GSB_FenetreAccueil extends JFrame  {

	//Attributs Prives 
	private JLabel lblMessageAccueil ;
	private GSB_FenetreConnectionVisiteur panelConnection ;
	//Attibuts Prives JMenuBar
	private JMenuBar menu ;
	private JMenuItem quitterItem ;
	private JMenu consulterMenu ;
	private JMenu gestionMenu ;
	private JMenuItem gererFicheItem ;
	private JMenuItem pdfItem ;
	private JLabel lblLogin ;
	private JLabel lblMdp ;
	private JPanel unPanel ;
	private JTextField jtfLogin ;
	private JTextField jtfMdp ;
	private JButton btnValider ;
	private JMenuItem lesVisiteursItem ;
	
		
	public GSB_FenetreAccueil ()  {
		
		this.setTitle("PPE 2: Accueil ") ;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400) ;
		this.setResizable (true) ;
		
		//JMENUBAR
		this.menu = new JMenuBar();
		this.unPanel = new JPanel();
		this.consulterMenu = new JMenu("Consulter");
		this.gestionMenu = new JMenu("Gestion") ;
		this.quitterItem = new JMenuItem("Quitter");
		this.gererFicheItem = new JMenuItem("Gérer les Fiches");
		this.pdfItem = new JMenuItem("Fichier PDF") ;
		this.lesVisiteursItem = new JMenuItem("Les Visiteurs");
		

		
		//ACTION LISTENER
		this.quitterItem.addActionListener(new ActionQuitter());
		this.gererFicheItem.addActionListener(new ActionConsulFiche());
		this.lesVisiteursItem.addActionListener(new ActionVisiteurs());
		this.pdfItem.addActionListener(new ActionConsulPDF ());
		
		
		//JPANEL
		
		//JLABEL
		this.lblMessageAccueil = new JLabel ("Bienvenue sur GSB Comptable") ;
		
		
		//Ajoute les item dans le menuConsultation
		this.gestionMenu.add(gererFicheItem);
		this.gestionMenu.add(pdfItem);
		this.consulterMenu.add(lesVisiteursItem);
		this.menu.add(consulterMenu);
		this.menu.add(gestionMenu);
		this.menu.add(quitterItem);
		
		this.setJMenuBar(menu);

		this.getContentPane().add(unPanel) ;
		this.setVisible(true) ;
	}

	
	class ActionQuitter implements ActionListener {
		public void actionPerformed(ActionEvent evenement ) {
			System.exit(0) ;
		}
	}
	
	class ActionConsulFiche implements ActionListener {
		public void actionPerformed(ActionEvent evenement ) {
			Panel_FicheC panelGererFiche = new Panel_FicheC() ;
			setContentPane(panelGererFiche) ;
			getContentPane().revalidate();
		}
	}
	
	class ActionVisiteurs implements ActionListener {
		public void actionPerformed(ActionEvent evenement ) {
			Panel_VisiteurC panelVisiteur = new Panel_VisiteurC() ;
			setContentPane(panelVisiteur) ;
			getContentPane().revalidate();
		}
	}
	
	class ActionConsulPDF implements ActionListener {
		public void actionPerformed(ActionEvent evenement ) {
			PDF_FicheVisiteur unPDF = new PDF_FicheVisiteur () ;
			//setContentPane(panelVisiteur) ;
			//getContentPane().revalidate();
			boolean rep = false ;
			rep = unPDF.creerPDF();
			if (rep == false ){
				System.out.println("PDF NON CREER");
			}
			else{
				System.out.println("PDF CREER ");
			}
		}
	}
	
	

}

