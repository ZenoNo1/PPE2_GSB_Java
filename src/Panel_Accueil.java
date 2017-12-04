import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panel_Accueil extends JFrame {
	//Attributs Privés
	private JLabel lblMessage ;
	private AfficheImage monImg ;
	private JPanel imgPanel ;
	
	// Constructeur
	public Panel_Accueil()  {
	
	 //Instanciation
		JLabel lblMessage = new JLabel("Bienvenue");
		lblMessage.setBackground(Color.orange);
		Font titre = new Font("Open Sans MS", Font.BOLD, 75);
		lblMessage.setFont(titre);
		lblMessage.setForeground(new Color(232,64,67));
	this.monImg = new AfficheImage("P://logo-gsb.png");
	this.monImg.setOpaque(false);
	this.monImg.setPreferredSize(new Dimension(500 , 500));
	this.imgPanel = new JPanel();
	this.imgPanel.setOpaque(false);
	this.setBackground(new Color(40,40,48));
	imgPanel.add(monImg) ;
	
	
	this.setLayout(new FlowLayout());
	
	 this.add(imgPanel) ;
	 this.add(lblMessage) ;
	 
	 

	}

	
	

}