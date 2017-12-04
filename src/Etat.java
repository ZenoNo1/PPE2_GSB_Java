
public class Etat {
	
	//Attributs Privés
		private String id ;
		private String libelle ;
		
	//Constructeur
		public Etat(String unId, String unLibelle) {
			this.id = unId ;
			this.libelle = unLibelle ;
		}


		
		//Ascesseurs
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


		
		//To String
		public String toString () {
			String etat ="\nEtat [" ;
			if (this.id !=null){
				etat= etat +" "+this.id;
			}
			if (this.libelle != null){
				etat += " "+ this.libelle;
			}
			
			etat += "]" ;
			
			return etat ;
		}
		
}
