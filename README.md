/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
# RMI_ClientServer

LisezMoi.txt
*** Calendrier distant en JavaRMI

* Les fichiers

- Client.java : l'application cliente qui acc�de Compte distant.
- Serveur.java : l'application serveur qui cr�e et rend disponible un objet de type CompteDistant.
- Compte.java : l'interface du calendrier distant.
- CompteDistant.java : impl�mentation de l'interface.

* Compilation

1) Compilation de l'interface : javac Compte.java
2) Compilation de la classe CompteDistant : javac CompteDistant.java
3) Compilation des classes Client et Serveur :
  javac Client.java
  javac Serveur.java

* Ex�cution

Avec 2 terminaux/invites de commandes :

1) Dans le premier terminal : java Serveur
2) Dans le deuxi�me terminal : java Client
3) Dans le terminal du client entrez l'un des cl� des compte disponible dans le registre.
	Vous les retouverez dans Serveur.java  : compteSarlIndigoEX01 et compteSarlOxigenEX01.
4) TEST
	4-1) Pour les tests des principes du MultiThread, et de la Synchronisation
	** On lance plus de 1 client se connectant sur le m�me compte. Choisi par exemple le compte compteSarlIndigoEX01.
	 ::: On a fait endormir pendant 20s l'ex�cution de la m�thode depot(String) avec le code suivant que vous retrouverez dans l'implementation CompteDistant.java
	 	try {
			Thread.sleep(20000);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}

	4-2)Cas de Test
	** On lance un d�pot montant 5000 dans le terminal de l'un des clients
	** Le Solde est � 5000
	** Maglr� que le solde soit � 5000, lancons un retrait de 5200 dans le terminal de l'autre client

	4-3)Resultats de Test
	** Gr�ce au mot cl� synchronized d�clar� dans le prototype des m�thodes
	la m�thode depot(String) fait patienter toutes autres m�thodes voulant acceder � la variable solde
	Donc retrait(String) patient. Ensuite apr�s la fin d'ex�cution de dep�t le retrait peut etre effectu� 
5) Dans un autre terminal il est possible de lancer des clients voulant travailler sur un compte diff�rent
	**Ceux ci seront chacun transport� dans un nouveau thread o� ils pourront effectuer les op�rations Synchronis�es