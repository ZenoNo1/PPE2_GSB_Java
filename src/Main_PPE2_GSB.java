import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.ArrayList; //Importer Bibliothèque Collection de Liste
//Projet Java


public class Main_PPE2_GSB{

	public static Scanner clavier;
	public static String chemin ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clavier = new Scanner(System.in);
		
			GSB_Modele.connexion();
			//GSB_FenetrePrincipale maFenetre = new GSB_FenetrePrincipale();
			GSB_FenetreConnectionVisiteur unPanel = new GSB_FenetreConnectionVisiteur();
			/*
			Document unDoc = new Document () ;
			chemin = "P:/Workspace/PPE2_GSB_Java/Source PDF/test.pdf" ;
			
			try {
				PdfWriter.getInstance(unDoc,  new FileOutputStream(chemin)) ;
				
				//Ajout de contenu
				unDoc.open();
				unDoc.add(new Paragraph ("Test PDF")) ;
			}
			catch (DocumentException doc) {
				doc.printStackTrace();
			}
			catch (IOException io) {
				io.printStackTrace();
			}
			
			unDoc.close();
		*/
	}
	
}
	