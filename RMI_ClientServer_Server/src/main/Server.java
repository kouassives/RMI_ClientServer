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
			registry = LocateRegistry.createRegistry(1099);
			// Creation de l'objet distant
			
			// Enregistrement aupres du Registry
			try {
			    // Enregistrement de l'objet sur le Registry sous les  nom de monCompte
				registry.rebind("compteSarlIndigoEX01", new CompteDistant());
				registry.rebind("compteSarlOxigenEX01", new CompteDistant());
				
			    System.out.println("Les comptes sont disponible dans le registre");
			} catch(RemoteException e) {
			    System.err.println("Impossible de mettre a disposition le compte : " + e);
			    System.exit(-1);
			}
			
		} catch(RemoteException e) {
		    System.err.println("Erreur lors de la recuperation du registry : " + e);
		    System.exit(-1);
		}
		
	    
	}

}
