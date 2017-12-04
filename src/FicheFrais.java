import java.time.LocalDate;


public class FicheFrais {

	//Attributs Prives
	private String idFicheFrais;
	private Comptable idVisiteur ;
	private String mois ;
	private int nbJustificatifs;
	private float montantValide ;
	private LocalDate dateModif ;
	private String idEtat ;
	
	//Constructeurs
	public FicheFrais (String idFicheFrais, Comptable idVisiteur, String unMois, int nbJusti, float montantValide,LocalDate uneDate, String idEtat  ){
		this.idFicheFrais = idFicheFrais ;
		this.idVisiteur = idVisiteur ;
		this.mois = unMois ;
		this.nbJustificatifs = nbJusti ;
		this.montantValide = montantValide ; 
		this.dateModif = uneDate ;
		this.idEtat = idEtat ;
	}
	
	public FicheFrais (String unMois) {
		
		this.mois = unMois ;
	}
	
	public FicheFrais () {
		
	}
	
	//Accesseurs
	public String getIdFicheFrais() {
		return idFicheFrais;
	}

	public void setIdFicheFrais(String idFicheFrais) {
		this.idFicheFrais = idFicheFrais;
	}

	public Comptable getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(Comptable idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getNbJustificatifs() {
		return nbJustificatifs;
	}

	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}
	
	
	public float getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(float montantValide) {
		this.montantValide = montantValide;
	}

	public LocalDate getDateModif() {
		return dateModif;
	}

	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}
	
	//Methodes
	public String toString () {
		String uneFiche ="Fiche [ " ;
		if (this.idFicheFrais !=null){
			uneFiche= uneFiche +" "+this.idFicheFrais;
		}
		if (this.idVisiteur != null){
			uneFiche += " "+ this.idVisiteur;
		}
		if (this.mois !=null){
			uneFiche +="/n" + this.mois;
		}
		if (this.nbJustificatifs != 0){
			uneFiche += "/n"+this.nbJustificatifs;
		}
		if (this.montantValide != 0){
			uneFiche += "/n"+this.montantValide;
		}
		if (this.dateModif != null){
			uneFiche += "/n"+this.dateModif;
		}
		if (this.idEtat != null){
			uneFiche += "/n"+this.idEtat;
		}
		
		uneFiche += "]" ;
		return uneFiche ;
	}
}
