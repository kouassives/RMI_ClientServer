package main;
/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	private static Compte stub = null;
	private static Registry registry =null;
	/**
     * Methode principale.
     * @param args inutilise
     */
    public static void main(String[] args) {
    	Scanner sc = null;
    // Reference du registe
    try {
		registry = LocateRegistry.getRegistry(1099);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.exit(-1);
	}
		
    boolean rechercherCompte = true;
    System.out.println("La clé du compte: ");
    while(rechercherCompte) {
    	sc  = new Scanner(System.in);
    	String cle = sc.nextLine();
    	rechercherCompte = rechercherCompte(cle);
    }
    // Utilisation du compte
		gesiton(stub);
	sc.close();
    }

    public static void gesiton(Compte stub) {
    	try {
    		Scanner sc = new Scanner(System.in);
    	    System.out.print("Le solde du compte est : " + stub.getSolde()+"\n");
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
    		    	if(stub.depot(montant))
    		    		System.out.print("Le nouveau solde du compte est : " + stub.getSolde()+"\n");
    		    }
    		    else if(choix.equals("2"))
    		    	{
    			    	System.out.println("Entrez le montant");
    			    	montant=Double.valueOf(sc.nextLine());
    			    	if(stub.retrait(montant))
    			    		System.out.print("Le nouveau solde du compte est : " + stub.getSolde()+"\n");
    			    	else
    			    		System.out.print("Retrait impossible le montant "
    			    				+ "sur le solde est inssufisant pour effectuer ce retrait\n");
    		    	}
    		    else if (choix.equals("0x23"))
    		    	continuer =false;
    		    		
    		}
    		sc.close();
    		
    	} catch(RemoteException e) {
    	    System.err.println("Erreur lors de l'acces aux methodes : " + e);
    	    System.exit(-1);
    	}
    }
    
    public static boolean rechercherCompte(String cle) {
    	// Récupération du calendrier distant
    	
    	try {
    		stub = (Compte)registry.lookup(cle);
    		return false;
		    } catch(RemoteException e) {
			    //System.err.println("Pas possible d'acceder à l'objet distant : " + e);
		    	System.err.println("Aucun compte ne correspond à cette clé");
			} catch(NotBoundException e) {
			    //System.err.println("Pas possible d'acceder à l'objet distant : " + e);
				System.err.println("Aucun compte ne correspond à cette clé");
			}
    	System.out.println("Ressayez: ");
    	return true;
    }
}
