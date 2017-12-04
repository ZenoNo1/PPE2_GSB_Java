import java.io.Serializable;
import java.time.LocalDate;


public class Comptable  {
	
	//Attributs Privés
		private String id ;
		private String nom ;
		private String prenom ;
		private String login ;
		private String password ;
		private String adresse ;
		private String cp ;
		private String ville ;
		private LocalDate dateEmbauche ;
		private int comptable ;
		
	//Constructeurs
		public Comptable(String unNumero , String unNom , String unPrenom , String unLogin , String unMdp, String uneAdr, String unCode , String uneVille, LocalDate uneDate, int unComptable) {
			this.id = unNumero ;
			this.nom = unNom ;
			this.prenom = unPrenom ;
			this.login = unLogin ;
			this.password = unMdp ;
			this.adresse = uneAdr ;
			this.cp = unCode ;
			this.ville = uneVille ;
			this.dateEmbauche = uneDate ;
			this.comptable = unComptable ;
			
		}
		
		public Comptable(String unNumero , String unNom , String unPrenom , String unLogin , LocalDate uneDate) {
			this.id = unNumero ;
			this.nom = unNom ;
			this.prenom = unPrenom ;
			this.login = unLogin ;
			this.dateEmbauche = uneDate ;
			
		}
		
		public Comptable (String unNom, String unPrenom) {
			this.nom = unNom ;
			this.prenom = unPrenom ;
		}
		
		public Comptable () {
			
		}
		
		public Comptable (String id) {
			this.id = id ;
		}
	 //Méthodes Publiques

		public int getComptable() {
			return this.comptable;
		}

		public void setComptable(int comptable) {
			this.comptable = comptable;
		}

		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNom() {
			return this.nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return this.prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getLogin() {
			return this.login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAdresse() {
			return this.adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getCp() {
			return this.cp;
		}

		public void setCp(String cp) {
			this.cp = cp;
		}

		public String getVille() {
			return this.ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public LocalDate getDateEmbauche() {
			return this.dateEmbauche;
		}

		public void setDateEmbauche(LocalDate dateEmbauche) {
			this.dateEmbauche = dateEmbauche;
		}

		/*
		public String toString() {
			return "Comptable [id=" + id + ", nom=" + nom + ", prenom="
					+ prenom + ", login=" + login + ", password=" + password
					+ ", adresse=" + adresse + ", cp=" + cp + ", ville="
					+ ville + ", dateEmbauche=" + dateEmbauche + ", comptable="
					+ comptable + "]";
		}
		*/
		
		public String toString () {
			String visiteur ="\nComptable [" ;
			if (this.id !=null){
				visiteur= visiteur +" "+this.id;
			}
			if (this.nom != null){
				visiteur += " "+ this.nom;
			}
			if (this.prenom !=null){
				visiteur +="/n" + this.prenom;
			}
			if (this.login != null){
				visiteur += "/n"+this.login;
			}
			if (this.password != null){
				visiteur += "/n"+this.password;
			}
			if (this.adresse != null){
				visiteur += "/n"+this.adresse;
			}
			if (this.cp != null){
				visiteur += "/n"+this.cp;
			}
			if (this.ville != null){
				visiteur += "/n"+this.ville;
			}
			if (this.dateEmbauche != null){
				visiteur += "/n"+this.dateEmbauche;
			}
			if (this.comptable != 0){
				visiteur += "/n"+this.comptable;
			}
			visiteur += "]" ;
			
			return visiteur ;
		}
		
}
