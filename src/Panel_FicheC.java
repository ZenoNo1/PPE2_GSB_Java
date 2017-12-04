import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class Panel_FicheC extends JPanel implements ActionListener{

	//Attribut Prive
	private JComboBox listeVisiteurFiche ;
	private JLabel lblMessageVF ;
	
	private JComboBox listeMoisFiche ;
	private JLabel lblMessageMF ;
	
	private  String idVisiteurSelec = null;
	
	private JButton btnValider ;
	private JLabel titreFrais ;
	private JTable tableauFrais ;
	private JTable tableauHors ;
	private JScrollPane scrollPane ;
	private JScrollPane scrollPaneH ;
	
	private JComboBox listeEtat ;
	private JLabel lblInfo ;
	
	public Panel_FicheC (){
		//Collection
		ArrayList <Comptable> lesVisiteursFiches = GSB_Modele.getLesVisiteursFiche() ;

		//JLABEL
		this.lblMessageVF = new JLabel ("Selectionner un Visiteur: ") ;
		this.lblInfo = new JLabel () ;
		this.lblInfo.setVisible(false);
		//JCOMBOBOX 
		this.listeVisiteurFiche = new JComboBox () ;
		for (Comptable elt : lesVisiteursFiches) {
			this.listeVisiteurFiche.addItem(elt.getNom());
		}
		
		this.listeMoisFiche = new JComboBox () ;
		this.listeMoisFiche.addItem("Les Mois du Visiteur");
		
		this.listeEtat  = new JComboBox() ;
		this.listeEtat.addItem("Etat Fiche");
		this.listeEtat.setVisible(false);
		//JBUTTON
		btnValider = new JButton ("Valider") ;
		
	

	
		
		

		//ACTION LISTENER
		
		 this.listeVisiteurFiche.addActionListener(new ActionVisiteurs ());
		 this.btnValider.addActionListener(this);
		
		//AJOUT DANS PANEL
		 
		this.add(this.lblMessageVF) ;
		this.add(this.listeVisiteurFiche) ;
		this.add(this.listeMoisFiche) ;
		this.add(this.btnValider) ;
		this.add(this.listeEtat) ;
		this.add(this.lblInfo) ;
	}
	
	class ActionVisiteurs implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == listeVisiteurFiche) {
				
				String nom  = (String) listeVisiteurFiche.getSelectedItem() ;
				System.out.println(nom);
				String id = GSB_Modele.recherVisiteur(nom) ;
				idVisiteurSelec = id ;
				//recupere id visiteurs selectionnner 
				//Clear la liste des mois
				
				listeMoisFiche.removeAllItems();
				
				//recupere les mois des fiches par rapport a id visiteur
				
				ArrayList <FicheFrais> lesFichesVisiteurs = GSB_Modele.getLesFichesFrais(id) ;
					Panel_FicheC c = new Panel_FicheC () ;
					
					//Suite au clear on re ajouter la phrase par defaut
					
					listeMoisFiche.addItem("Les Mois du Visiteur");
					for (FicheFrais elt : lesFichesVisiteurs) {
						listeMoisFiche.addItem(elt.getMois());
						
					}
					
					
					
			}
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		if (e.getSource() == btnValider) {
			String mois = (String) listeMoisFiche.getSelectedItem() ;
				if(mois == "Les Mois du Visiteur") {
					lblMessageVF.setText("Veuillez sélectionner un Mois");
				}
				else{
					String nom  = (String) listeVisiteurFiche.getSelectedItem() ;
					System.out.println(nom);
			      	String id = GSB_Modele.recherVisiteur(nom) ;
					
					//apres avoir recup les details des fiches en fonction
					//id visiteur et du mois
					//on fais un JTABLE
			      	
			      	ArrayList <LigneFraisHorsForfait> lesFraisHors = GSB_Modele.afficheDetailFicheH(mois, id);
					ArrayList <FraisForfait> lesFrais = GSB_Modele.afficheDetailFiche(mois, id);
					ArrayList <Etat> lesEtats = GSB_Modele.getLesEtats() ;
					int j  ;
					int z ;
					
					System.out.println(z = lesFraisHors.size());
					System.out.println( j = lesFrais.size());
					
					int numLigne = lesFrais.size() ;
					int numLigneH = lesFraisHors.size() ;
					
					Object data[][]= new Object[numLigne][10];
					int i = 0 ;
					for (FraisForfait elt : lesFrais){
						data[i][0] =  elt.getId() ;
						data[i][1]= elt.getLibelle();
						data[i][2]= elt.getMontant();
						i++ ;
					}//FIN DU FOREACH
					
				i = 0 ;
				Object data2[][]= new Object[numLigneH][5];
				for (LigneFraisHorsForfait elt2 : lesFraisHors){
					data2[i][0] =  elt2.getDate() ;
					data2[i][1]= elt2.getLibelle();
					data2[i][2]= elt2.getMontant();
					data2[i][3] = "Refuser" ;
					i++ ;
				}//FIN DU FOREACH
					
					
				String[] titre = {"Date","Libelle","Montant","Action"};
				String[] title = {"Id","Libelle","Montant"} ;
					
				this.tableauFrais = new JTable(data , title);
				this.tableauHors = new JTable(data2 , titre) ;
				tableauHors.getColumn("Action").setCellRenderer(new ButtonRenderer());
				tableauHors.getColumn("Action").setCellEditor(
				new ButtonEditor(new JCheckBox()));
				tableauHors.setDefaultEditor(LigneFraisHorsForfait.class, new RefuserCellEditor());
				tableauFrais.setGridColor(Color.black);
				tableauFrais.setRowHeight(50);
				tableauHors.setRowHeight(50);
					
				Color couleur = new Color(40,40,48);
					
				Font f = new Font ("Sherif", Font.BOLD, 18) ;
				titreFrais = new JLabel ("Tous les Frais Forfait :") ;
				this.titreFrais.setFont(f);
				this.add(titreFrais);
					
				scrollPaneH = new JScrollPane(tableauHors);
					
				scrollPane = new JScrollPane(tableauFrais);
				scrollPane.setPreferredSize(new Dimension(550,225));
				scrollPaneH.setPreferredSize(new Dimension(550,225));
				this.add(scrollPane);
					
				JLabel titreHFrais = new JLabel ("Elements Hors Forfaits :") ;
				titreHFrais.setFont(f);
				this.add(titreHFrais);
					
				this.add(scrollPaneH);
					
				this.updateUI();
				
			//Camille
				for (Etat elt : lesEtats) {
					listeEtat.addItem(elt.getLibelle()) ;
				}
				listeEtat.setVisible(true) ;
			//	listeEtat.addActionListener(new ActionEtatModif ());
				
				
				
			}//FIN DU ELSE 
				
		}//FIN DU PREMIER IF
			
	}//FIN DE LA CLASSE
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			}//FIN DU SI
			else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}//FIN DU ELSE
		setText((value == null) ? "" : value.toString());
		return this;
		}//FIN DE LA METHODE
	}//FIN DE LA CLASSE

			/**
			 * @version 1.0 11/09/98
			 */

	class ButtonEditor extends DefaultCellEditor {
		protected JButton btnButton;
		private String label;
		private boolean isPushed;
	
		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			btnButton = new JButton();
			btnButton.setOpaque(true);
			btnButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}//FIN PUBLIC VOID
			});//FIN ACTION LISTENER
		}//FIN CONSTRUCTEUR
	
		public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
			
			if (isSelected) {
				btnButton.setForeground(table.getSelectionForeground());
				btnButton.setBackground(table.getSelectionBackground());
			}//FIN DU SI
			else {
				btnButton.setForeground(table.getForeground());
				btnButton.setBackground(table.getBackground());
			}//FIN DU ELSE
			
			label = (value == null) ? "" : value.toString();
			btnButton.setText(label);
			isPushed = true;
			return btnButton;
		}//FIN DU PUBLIC
	
		public Object getCellEditorValue() {
		if (isPushed) {
		 
		}//FIN DU SI
		isPushed = false;
		return new String(label);
		}//FIN PUBLIC OBJECT
	
		public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
		}//FIN DU PUBLIC BOOLEAN
	
		protected void fireEditingStopped() {
		super.fireEditingStopped();
		}//FIN DU PROTECTED
	}//FIN DE LA CLASSE


	//Camille
	class ActionEtatModif implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nom = (String) listeEtat.getSelectedItem() ;
			
			if (nom == "Etat Fiche") {
				lblInfo.setText("Selectionnner un etat");
			}
			else{
				
			}
		}
		
	}
	
	}