package main;
/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
// Non utilisé encore

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ThreadRMI extends Thread {
	public ThreadRMI(String nom) {
		super(nom);
	}
	
	public void run() {
		try{
			
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
			} catch(RemoteException e) {
			    System.err.println("Impossible de mettre a disposition le compte : " + e);
			    System.exit(-1);
			} catch(MalformedURLException e) {
			    System.err.println("Probleme avec l'URL : " + e);
			    System.exit(-1);
			}

			System.out.println("Votre Compte est disponible sur le serveur");
			
		}catch(Exception e){
			
		}
	}
}