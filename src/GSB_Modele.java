import java.sql.*;
import java.util.ArrayList;
import java.time.* ;

public class GSB_Modele {

	//Attriburs Prives 
	private static Connection connexion;
	private static Statement statementP;
	private static ResultSet rs;
	
	
	//Methode pour la connection
	
	public static int connexion(){
		int rep = 0 ;
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsbmvc", "root", "");
			statementP = connexion.createStatement(); 
			System.out.println("Connexion Réussi");
			rep = 1
			;
		}
		catch  (ClassNotFoundException e) {
			System.out.println("driveur non chargé");
		}
		catch (SQLException e){
		}
		
		return rep ;
	}//FIN CONNECTION
	
	public static boolean connectionVisiteur (String unLogin, String unMdp) {
		boolean rep = false ;
		int numREp = 0  ;
		String sql ="SELECT * FROM visiteur WHERE login = '"+unLogin+"'AND mdp = '"+unMdp+"'";
		System.out.println(sql);
		int compt;
		String id , nom, prenom ;
		try {	
			rs = statementP.executeQuery(sql);
			
			while (rs.next()) {
				id = rs.getString(1);
				nom = rs.getString(2) ;
				prenom = rs.getString(3) ;
				compt = rs.getInt(10) ;
				if (compt == 1) {
					rep = true ;
				}
				else{
					rep = false ;
				}
			}
			
			rs.close() ;
			
				
		}
		catch (SQLException e){
			System.out.println(e);
		}
		
		
		return rep ;
	}
	
	public static ArrayList <Comptable> getLesVisiteurs () {
		ArrayList <Comptable> lesVisiteurs = new ArrayList <Comptable>();
		String unNumero ,  unNom ,  unPrenom ,  unLogin ,  unMdp,  uneAdr,  unCode ,  uneVille, dateEmbauch;
		int unComptable ;
		
		Comptable unComp ;
		
	    String sql = ("SELECT id, nom, prenom,login,dateEmbauche FROM VISITEUR" );
		try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				unNumero = rs.getString(1);
				unNom = rs.getString(2);
				unPrenom = rs.getString(3);
				unLogin = rs.getString(4) ;
				dateEmbauch = rs.getString(5) ;
				//Convertir string en localdate 
				LocalDate localDateEmbauche = LocalDate.parse(dateEmbauch) ;
				
				unComp = new Comptable (unNumero,unNom,unPrenom,unLogin,localDateEmbauche);
				
				lesVisiteurs.add(unComp);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		return lesVisiteurs ;
	}
	
	public static ArrayList <Comptable> getLesVisiteursFiche () {
		ArrayList <Comptable> lesVisiteursFiche = new ArrayList <Comptable>();
		String  unNom ,  unPrenom ;
		
		
		Comptable unComp ;
		
	    String sql = ("SELECT DISTINCT(idVisiteur), nom, prenom FROM FICHEFRAIS, VISITEUR WHERE FICHEFRAIS.idVisiteur = VISITEUR.id AND FICHEFRAIS.idVisiteur IS NOT NULL" );
		try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				unNom = rs.getString(2);
				unPrenom = rs.getString(3);
				
				unComp = new Comptable (unNom,unPrenom);
				
				lesVisiteursFiche.add(unComp);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		return lesVisiteursFiche ;
	}
	
	public static ArrayList <FicheFrais> getLesFichesFrais (String idVisiteur) {
		ArrayList <FicheFrais> lesFiches = new ArrayList <FicheFrais>();
		String  id ,  mois ;
		
		
		FicheFrais uneFiche ;
		
	    String sql = ("select fichefrais.mois as mois from  fichefrais where fichefrais.idvisiteur ='"+idVisiteur+"' order by fichefrais.mois desc " );
		System.out.println(sql);
	    String moisF ;
	    try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				
				moisF = rs.getString(1);
				
				uneFiche = new FicheFrais (moisF);
				System.out.println(moisF);
				lesFiches.add(uneFiche);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		return lesFiches ;
	}
	
	public static String recherVisiteur (String unNom) {
		String idV = null;
		String sql = ("SELECT id FROM visiteur WHERE nom='"+unNom+"'") ;
		
		System.out.println(sql) ;
		Comptable  unCompt = null ;
		  try{
				
				rs = statementP.executeQuery(sql);
				while (rs.next()) {
				String	id = rs.getString(1) ;
				idV = id ;	
					//unCompt = new Comptable (idV) ;
				}
					rs.close() ;
					
			}
			catch(SQLException e){
				System.out.println("problème sql" + e);
			}
		
		return idV;
	}
	
	public static ArrayList <FraisForfait> afficheDetailFiche (String mois, String idV) {
		
		String sql = ("select fraisforfait.id as idfrais, fraisforfait.libelle as libelle,lignefraisforfait.quantite as quantite from lignefraisforfait inner join fraisforfait on fraisforfait.id = lignefraisforfait.idfraisforfait where lignefraisforfait.idvisiteur ='"+idV+"' and lignefraisforfait.mois='"+mois+"' order by lignefraisforfait.idfraisforfait") ;
		System.out.println(sql);
		
		ArrayList <FraisForfait> lesFrais = new ArrayList <FraisForfait>();
		String  idFF ,  libelleFF ;
		float montantFF ;
		
		FraisForfait unFrais ;
	    
	    try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				
				idFF = rs.getString(1);
				libelleFF = rs.getString(2) ;
				montantFF = rs.getFloat(3) ;
				
				unFrais = new FraisForfait (idFF,libelleFF,montantFF  );
				
				lesFrais.add(unFrais);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		
		
		return lesFrais ;
	}
	public static ArrayList <LigneFraisHorsForfait> afficheDetailFicheH (String mois, String idV) {
		
		String sql = "select date,libelle,montant from lignefraishorsforfait where idVisiteur ='"+idV+"' and mois =" +mois  ;
		System.out.println(sql);
		
		ArrayList <LigneFraisHorsForfait> lesFraisHors = new ArrayList <LigneFraisHorsForfait>();
		Date dateFH ;
		String  libelleFH ;
		float montantFH ;
		
		LigneFraisHorsForfait unFrais ;
	    
	    try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				
				dateFH = rs.getDate(1);
				libelleFH = rs.getString(2) ;
				montantFH = rs.getFloat(3) ;
				
				unFrais = new LigneFraisHorsForfait (libelleFH,dateFH,montantFH );
				
				lesFraisHors.add(unFrais);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		
		
		return lesFraisHors ;
	}
/*public static Statement maj(String libelle , String id , Date mois ) {
	try {
		String sql = "update lignefraishorsforfait SET libelle=CONCAT(libelle, ' :  '"+libelle+"') WHERE idVisiteur='"+id+"' AND mois="+mois ;
		st.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return st ;*/
	
	public static ArrayList<Etat> getLesEtats() {
		
		String sql = "select * FROM etat";
		System.out.println(sql);
		
		ArrayList <Etat> lesEtats = new ArrayList <Etat>();
		String  idE, libelleE ;
		Etat unEtat ;
	    
	    try{
			
			rs = statementP.executeQuery(sql);
			while (rs.next()) {
				
				idE = rs.getString(1);
				libelleE= rs.getString(2) ;
			
				unEtat = new Etat (idE,libelleE );
				
				lesEtats.add(unEtat);
				
				}
				rs.close() ;
				
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		
		
		return lesEtats ;
	}
	
	//Camille
	public static boolean majEtatFiche (String idV, String mois, String etat){
		boolean rep = false ;
		String sql = "update ficheFrais set idEtat = '"+etat+"', dateModif = now() where fichefrais.idvisiteur ='"+idV+"' and fichefrais.mois = '"+mois+"";
		System.out.println(sql);
		
		try {
		statementP.executeUpdate(sql);
		rep= true ;
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
		
		return rep ;
	}	
	
	


	
}