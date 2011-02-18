package lgm.fr;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Traitement {
	static Connection connexion = null;

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER OK ! ");

			String url = "jdbc:mysql://localhost:3306/cde_semitag";
			String user = "root";
			String passwd = "";
			connexion = (Connection) DriverManager.getConnection(url, user,
					passwd);

			System.out.println("Connection : OK !");
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public class Caracteristique_Condor_Log {
	
		File monLog;
		int tailleEvt=95;
		int renv=0;
		String Log_Path="";
		String Log_Nom="";
		long Log_taille=0;
		int nbEvt=0;
		String typeEqu="";
		String numEqu="";
		String dateFichier="";
		
	public Caracteristique_Condor_Log(String chemin, int tailleEvt) {
		this.tailleEvt = tailleEvt;
		this.monLog = new File(chemin);
		this.Log_Path = monLog.getAbsolutePath();
		this.Log_Nom = monLog.getName();
		this.Log_taille =  monLog.length();
		this.nbEvt = calculeNbEvt();
	}
		
		public int calculeNbEvt(){
			int renv=0;
			if(Log_taille==0){
				renv = 0;
			}else{
				if(Math.IEEEremainder(Log_taille, tailleEvt)==0 ){
					renv = (int)Log_taille/tailleEvt;
		        }else{
		        	renv = -1;
		        }
			}
			return renv;
		}
		
		public boolean tailleFichierCorrect(){
			if(this.nbEvt>0)
				return true;
			else 
				return false;
		}
		
		public boolean NomFichierCorrect(){
			/****** A IMPLEMENTER ******/
			return true;
		}
		
		public void AfficheDonneeFichier(){
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("-- NOM FICHIER : "+ this.Log_Nom);
			System.out.println("-- CHEMIN : '" + this.Log_Path + "'");
			System.out.println("-- Taille : " + this.Log_taille + " octets");
			System.out.println("-- Nb evt : " + this.nbEvt);
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
		public File getFile(){return this.monLog;}
		public String getNomLog(){return this.Log_Nom;}
		public String getPathLog(){return this.Log_Path;}
		public long getTailleLog(){return this.Log_taille;}
		public int getTailleEvt(){return this.tailleEvt;}
		public int getNbEvt(){return this.nbEvt;}
		public String getTypeEqu(){return this.typeEqu;}
		public String getNumEqu(){return this.numEqu;}
		public String getDateFichier(){return this.dateFichier;}
	}
}


