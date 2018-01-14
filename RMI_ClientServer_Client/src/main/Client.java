package main;
/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	/**
     * Methode principale.
     * @param args inutilise
     */
    public static void main(String[] args) {
	Compte compte = null;

	// Récupération du calendrier distant
	try {
	    compte = (Compte)Naming.lookup("rmi://localhost/monCompte");
	} catch(RemoteException e) {
	    System.err.println("Pas possible d'acceder à l'objet distant : " + e);
	    System.exit(-1);
	} catch(NotBoundException e) {
	    System.err.println("Pas possible d'acceder à l'objet distant : " + e);
	    System.exit(-1);
	} catch(MalformedURLException e) {
	    System.err.println("Probleme avec l'URL : " + e);
	    System.exit(-1);
	}

	// Utilisation du compte
	try {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Le solde du compte est : " + compte.getSolde()+"\n");
		boolean continuer =true;
		String choix="";
		double montant;
		while(continuer) {
			
		    System.out.println("   1-Depot");
		    System.out.println("   2-Retrait");
		    System.out.println("0x23-Sortir");
		    choix = String.valueOf(sc.nextLine());
		    if(choix.equals("1")) {
		    	System.out.println("Entrez le montant");
		    	montant = Integer.valueOf(sc.nextLine());
		    	if(compte.depot(montant))
		    		System.out.print("Le nouveau solde du compte est : " + compte.getSolde()+"\n");
		    }
		    else if(choix.equals("2"))
		    	{
			    	System.out.println("Entrez le montant");
			    	montant=Integer.valueOf(sc.nextLine());
			    	if(compte.retrait(montant))
			    		System.out.print("Le nouveau solde du compte est : " + compte.getSolde()+"\n");
			    	else
			    		System.out.print("Retrait impossible le montant "
			    				+ "sur le solde est inssufisant pour effectuer ce retrait\n");
		    	}
		    else if (choix.equals("0x23"))
		    	continuer =false;
		    		
		}
		
	} catch(RemoteException e) {
	    System.err.println("Erreur lors de l'acces aux methodes : " + e);
	    System.exit(-1);
	}
    }

}
