package main;

/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

		/**
	     * Methode principale.
	     * @param args inutilise
	     */
	public static void main(String[] args) {
		/*
		System.out.println("Mise en place du Security Manager ...");
		if (System.getSecurityManager() == null) {
		System.setSecurityManager(new RMISecurityManager());
		}
		*/
		
		// Creation du RMI registry
		try {
		    LocateRegistry.createRegistry(1099);
		} catch(RemoteException e) {
		    System.err.println("Erreur lors de la recuperation du registry : " + e);
		    System.exit(-1);
		}
		
		
		// Creation de l'objet distant
		Compte compte = null;
		try {
		    compte = new CompteDistant();
		} catch(RemoteException e) {
		    System.err.println("Erreur lors de la creation de l'objet : " + e);
		    System.exit(-1);
		}

		// Enregistrement aupres du Registry
		try {
		    // Enregistrement de l'objet sur le Registry
		    Naming.rebind("monCompte", compte);
		    System.out.println("Le compte est disponible dans le registre");
		} catch(RemoteException e) {
		    System.err.println("Impossible de mettre a disposition le compte : " + e);
		    System.exit(-1);
		} catch(MalformedURLException e) {
		    System.err.println("Probleme avec l'URL : " + e);
		    System.exit(-1);
		}
	    
	}

}
