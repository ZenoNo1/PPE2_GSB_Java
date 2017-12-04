import java.time.LocalDate;


public class FraisForfait {

	//Attributs Prives
	private String id;
	private String libelle ;
	private float montant ;
	
	
	//Constructeurs
	public FraisForfait (String id, String libelle, float montant  ){
		this.id = id ;
		this.libelle = libelle ;
		this.montant = montant ;
		
	}
	
	public FraisForfait (String id) {
		
		this.id = id ;
	}
	
	public FraisForfait () {
		
	}
	
	//Accesseurs

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	//Methodes
	public String toString () {
		String uneFiche ="FraisForfait [ " ;
		if (this.id !=null){
			uneFiche= uneFiche +" "+this.id;
		}
		if (this.libelle != null){
			uneFiche += " "+ this.libelle;
		}
		if (this.montant !=0){
			uneFiche +="/n" + this.montant;
		}
		
		
		uneFiche += "]" ;
		return uneFiche ;
	}

	
}
