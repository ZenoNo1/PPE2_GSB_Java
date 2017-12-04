public class LigneFraisForfait {
	//Attributs Privés
		private String idVisiteur ;
		private String mois ;
		private FraisForfait idFraisForfait ;
		private int quantite ;
		
	//Constructeur
		public LigneFraisForfait(String unId, String unMois, FraisForfait unForfait, int uneQte) {
			this.idVisiteur = unId ;
			this.mois = unMois ;
			this.idFraisForfait = unForfait ;
			this.quantite = uneQte ;
		}

		
	//Ascesseurs

		public String getIdVisiteur() {
			return idVisiteur;
		}

		public void setIdVisiteur(String idVisiteur) {
			this.idVisiteur = idVisiteur;
		}

		public String getMois() {
			return mois;
		}

		public void setMois(String mois) {
			this.mois = mois;
		}

		public FraisForfait getIdFraisForfait() {
			return idFraisForfait;
		}

		public void setIdFraisForfait(FraisForfait idFraisForfait) {
			this.idFraisForfait = idFraisForfait;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}



		
	//To String
		public String toString() {
			String ligneFraisForfait = "\nLigneFraisForfait [";
			
			if (this.idVisiteur !=null){
				ligneFraisForfait= ligneFraisForfait +" "+this.idVisiteur;
			}
			if (this.mois != null){
				ligneFraisForfait += " "+ this.mois;
			}
			if (this.idFraisForfait !=null){
				ligneFraisForfait +="/n" + this.idFraisForfait;
			}
			if (this.quantite != 0){
				ligneFraisForfait += "/n"+this.quantite;
			}
			
			return ligneFraisForfait ;
			
		}
}