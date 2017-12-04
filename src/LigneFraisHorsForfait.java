import java.util.Date;


public class LigneFraisHorsForfait {
	//Attributs Privés
		private int id ;
		private String idVisiteur ;
		private String libelle ;
		private Date date ;
		private float montant ;
		
	//Constructeur
		public LigneFraisHorsForfait(int unId, String unIdVisiteur, String unLibelle , Date uneDate, float unMontant) {
			this.id = unId ;
			this.idVisiteur = unIdVisiteur ;
			this.libelle = unLibelle ;
			this.date = uneDate ;
			this.montant = unMontant ;
		}
		public LigneFraisHorsForfait(String unLibelle , Date uneDate, float unMontant) {
			this.libelle = unLibelle ;
			this.date = uneDate ;
			this.montant = unMontant ;
		}

		
	//Ascesseurs
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getIdVisiteur() {
			return idVisiteur;
		}

		public void setIdVisiteur(String idVisiteur) {
			this.idVisiteur = idVisiteur;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public float getMontant() {
			return montant;
		}

		public void setMontant(float montant) {
			this.montant = montant;
		}




		
	//TO STRING
		@Override
		public String toString() {
			return "LigneFraisHorsForfait [id=" + id + ", idVisiteur="
					+ idVisiteur + ", libelle=" + libelle + ", date=" + date
					+ ", montant=" + montant + "]";
		}
}