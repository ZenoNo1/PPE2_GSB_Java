import java.awt.Container;
import java.awt.Image;

import javax.swing.JPanel;

public class AfficheImage extends JPanel {

	// D�claration de la propri�t� fond de type Image
			 private Image fond;
			 // Cr�ation du constructeur de la classe
			 AfficheImage(String s) {
			 // Permet de charger une image
			 fond = getToolkit().getImage(s);
			 }
}
