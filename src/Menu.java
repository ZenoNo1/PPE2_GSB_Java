import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
	
	//Attributs prives
	private JMenuBar menu ;
	private JMenuItem quitterItem ;
	private JMenu consulterMenu ;
	private JMenu gestionMenu ;
	private JMenuItem gererFicheItem ;
	private JMenuItem pdfItem ;
	private JMenuItem lesVisiteursItem ;
	
	public Menu () {
		
	}
	//Accesseure

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public JMenuItem getQuitterItem() {
		return quitterItem;
	}

	public void setQuitterItem(JMenuItem quitterItem) {
		this.quitterItem = quitterItem;
	}

	public JMenu getConsulterMenu() {
		return consulterMenu;
	}

	public void setConsulterMenu(JMenu consulterMenu) {
		this.consulterMenu = consulterMenu;
	}

	public JMenu getGestionMenu() {
		return gestionMenu;
	}

	public void setGestionMenu(JMenu gestionMenu) {
		this.gestionMenu = gestionMenu;
	}

	public JMenuItem getGererFicheItem() {
		return gererFicheItem;
	}

	public void setGererFicheItem(JMenuItem gererFicheItem) {
		this.gererFicheItem = gererFicheItem;
	}

	public JMenuItem getPdfItem() {
		return pdfItem;
	}

	public void setPdfItem(JMenuItem pdfItem) {
		this.pdfItem = pdfItem;
	}

	public JMenuItem getLesVisiteursItem() {
		return lesVisiteursItem;
	}

	public void setLesVisiteursItem(JMenuItem lesVisiteursItem) {
		this.lesVisiteursItem = lesVisiteursItem;
	}
	
	
	
}
