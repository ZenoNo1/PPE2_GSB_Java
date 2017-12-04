import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDF_FicheVisiteur {

	private static String chemin ;
	
	public static boolean creerPDF(/*String idVisiteur, String leMois, String idFraisForfait, int QTE, String libelleFraisHF, float montantFraisHF*/) {
	boolean rep = false ;
		Document unDoc = new Document () ;
		chemin = "P:/Workspace/PPE2_GSB_Java/Source PDF/test.pdf" ;
		
		try {
			PdfWriter.getInstance(unDoc,  new FileOutputStream(chemin)) ;
			
			//Ajout de contenu
			unDoc.open();
			
			//FONT
			Font fTitreH1 = new Font(FontFamily.TIMES_ROMAN, 50, Font.BOLD);
			Font fTitreH2 = new Font(FontFamily.TIMES_ROMAN, 30, Font.UNDERLINE);
			
			//PHRASE
			Phrase facture = new Phrase ("N° Facture : ---  ") ;
			Phrase dteF = new Phrase ("Fait le : ") ;
			//PARAGRAPH
			Paragraph titre = new Paragraph ("~ Facture ~", fTitreH1) ; 
			Paragraph escp = new Paragraph (" ") ; 

			Paragraph ligneP = new Paragraph ("_____________________________________________________________________________") ;
			Paragraph numFacture = new Paragraph () ;
			
			//POSITION
			titre.setAlignment(Element.ALIGN_CENTER);
			
			//AJOUT
			unDoc.add(titre);
			unDoc.add(escp);
			unDoc.add((tabVisiteur() ));
			unDoc.add(ligneP);
			unDoc.add(escp);
			numFacture.add(facture);
			numFacture.add(dteF);
			unDoc.add(numFacture);
			unDoc.add(escp);
			unDoc.add(escp);
			unDoc.add((detailFiche())) ;
			
			rep = true ;
		}
		catch (DocumentException doc) {
			doc.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
		
		unDoc.close();
		return rep ;
	}
	
	 public static PdfPTable tabVisiteur(){
		 
		 float[] columnWidths = {2, 3, 3};
	        PdfPTable table = new PdfPTable(columnWidths);
	        table.setWidthPercentage(50);
	        table.getDefaultCell().setUseAscender(true);
	        table.getDefaultCell().setUseDescender(true);
	        Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
	        PdfPCell cell = new PdfPCell(new Phrase("Visiteur", f));
	        cell.setBackgroundColor(GrayColor.GRAYBLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setColspan(3);
	        table.addCell(cell);
	        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
	        for (int i = 0; i <= 1; i++) {
	            table.addCell("idVisiteur : ");
	            table.addCell("NomVisiteur : ");
	            table.addCell("PrenomVisiteur: ");
	        }
	        table.setHeaderRows(3);
	        table.setFooterRows(1);
	        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
	        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	        
	            table.addCell("999");
	            table.addCell("Loan");
	            table.addCell("Loan");
	        table.setHorizontalAlignment(10);
	       
	     
	      return table;  
	  }
	 
	 public static PdfPTable detailFiche () {
		 float[] columnWidths = {5, 5, 5};
	     PdfPTable table = new PdfPTable(columnWidths);
	     
	     table.setWidthPercentage(50);
	        table.getDefaultCell().setUseAscender(true);
	        table.getDefaultCell().setUseDescender(true);
	        Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(GrayColor.GRAYBLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setColspan(3);
	        table.addCell(cell);
	        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
	        for (int i = 0; i <2; i++) {
	            table.addCell("Designation");
	            table.addCell("Quantité");
	            table.addCell("Montant ");
	        }
	        table.setHeaderRows(3);
	        table.setFooterRows(1);
	        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
	        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	        for (int i = 0; i <3; i++) {
	            table.addCell("999");
	            table.addCell("Loan");
	            table.addCell("Loan");
	        }
	        table.setHorizontalAlignment(10);
	     
	     
		 return table ;
	 }

}
