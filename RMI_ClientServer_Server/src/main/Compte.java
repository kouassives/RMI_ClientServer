package main;
/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 * Interface correspondant à un compte
 * les opération possible sont retrait , depot, getSolde
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compte extends Remote {

	/**
	 * Retire du solde un montant passé en parametre et
	 * retourne true dans le cas ou le retrait s'est effectué
	 * avec succès false dans le cas contraire
	 */
	public boolean retrait(double montant) throws RemoteException;
	
	/**
	 * depose sur le compte un montant passé en parametre et
	 * retourne true dans le cas ou le retrait s'est effectué
	 * avec succès false dans le cas contraire
	 */
	public boolean depot(double montant) throws RemoteException;

	/**
	 * @return le solde
	 */
	public double getSolde() throws RemoteException;
}
