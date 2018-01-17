package main;

/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(10000);
			// Creation de l'objet distant
			
			Compte skeleton = null;
			try {
				skeleton = new CompteDistant();
				
				// Enregistrement aupres du Registry
				try {
				    // Enregistrement de l'objet sur le Registry sous le monCompte
					registry.rebind("monCompte", skeleton);
				    System.out.println("Le compte est disponible dans le registre");
				} catch(RemoteException e) {
				    System.err.println("Impossible de mettre a disposition le compte : " + e);
				    System.exit(-1);
				}
				
			} catch(RemoteException e) {
			    System.err.println("Erreur lors de la creation de l'objet : " + e);
			    System.exit(-1);
			}
		} catch(RemoteException e) {
		    System.err.println("Erreur lors de la recuperation du registry : " + e);
		    System.exit(-1);
		}
		
	    
	}

}
