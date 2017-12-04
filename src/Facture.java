
public class Facture {

	//Attributs Prives
	private String numFacture ;
	private String libelleFacture ;
	private int qteFacture ;
	private float montantFacture ;
	private Comptable idVisiteur ;
	
	//Constructeur
	public Facture () {
		
	}
	
	public Facture(String num){
		this.numFacture = num ;
	}
	
	public Facture (String num, String libelle, int qte, float montant, Comptable idV)  {
		this.numFacture = num ;
		this.libelleFacture = libelle ;
		this.qteFacture = qte ;
		this.montantFacture = montant ;
		this.idVisiteur = idV ;
	}

	//accesseur 
	public String getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	public String getLibelleFacture() {
		return libelleFacture;
	}

	public void setLibelleFacture(String libelleFacture) {
		this.libelleFacture = libelleFacture;
	}

	public int getQteFacture() {
		return qteFacture;
	}

	public void setQteFacture(int qteFacture) {
		this.qteFacture = qteFacture;
	}

	public float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Comptable getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(Comptable idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	
	//methode
	
	public String toString () {
		String facture ="\nFacture [" ;
		if (this.numFacture !=null){
			facture= facture +" "+this.numFacture ;
		}
		if (this.libelleFacture != null){
			facture += " "+ this.libelleFacture ;
		}
		if (this.qteFacture !=0){
			facture +="/n" + this.qteFacture ;
		}
		if (this.montantFacture != 0){
			facture += "/n"+this.montantFacture ;
		}
		if (this.idVisiteur != null){
			facture += "/n"+this.idVisiteur ;
		}
	
		facture += "]" ;
		
		return facture ;
	}
	
	
}
