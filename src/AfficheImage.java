import java.awt.Container;
import java.awt.Image;

import javax.swing.JPanel;

public class AfficheImage extends JPanel {

	// Déclaration de la propriété fond de type Image
			 private Image fond;
			 // Création du constructeur de la classe
			 AfficheImage(String s) {
			 // Permet de charger une image
			 fond = getToolkit().getImage(s);
			 }
}
