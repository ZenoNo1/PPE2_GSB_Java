import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import com.itextpdf.* ;

public class Panel_VisiteurC extends JPanel{
	private JTable tableau;
	JScrollPane scrollPane;
	private Font font ;
	
		
		
		public Panel_VisiteurC() {
			ArrayList <Comptable> lesVisiteurs = GSB_Modele.getLesVisiteurs() ;
			this.setLayout(new FlowLayout());
			int i = 0 ;
			Object[][]data = new Object[lesVisiteurs.size()][5]; {
				for (Comptable cmpt : lesVisiteurs){
					data[i][0] = cmpt.getId();
					data[i][1] = cmpt.getNom();
					data[i][2] = cmpt.getPrenom();
					data[i][3] = cmpt.getLogin();
					data[i][4] = cmpt.getDateEmbauche();
					i++;
					}
			};
					
					String [] title = {"Id" , "Nom" , "Prenom" , "Login" , "Date D'Embauche" };
				
					this.tableau = new JTable(data,title);
					
					this.tableau.getTableHeader().setFont(new Font("Open Sans MS", Font.BOLD, 15));
					this.tableau.setPreferredScrollableViewportSize(new Dimension(530, 400));
					this.tableau.setRowHeight(20);
					this.tableau.setBackground(Color.white);
					
					this.scrollPane = new JScrollPane(this.tableau);
					this.add(scrollPane);
		
		}
}