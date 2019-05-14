/**
 * @author KOUASSI Yves Anselme Magloire
 * @version 13/01/2018
 */
# RMI_ClientServer

LisezMoi.txt
*** Comptes distant en JavaRMI

* Les fichiers

- Client.java : l'application cliente qui accède Compte distant.
- Serveur.java : l'application serveur qui crée et rend disponible un objet de type CompteDistant.
- Compte.java : l'interface du calendrier distant.
- CompteDistant.java : implémentation de l'interface.

* Compilation

1) Compilation de l'interface : javac Compte.java
2) Compilation de la classe CompteDistant : javac CompteDistant.java
3) Compilation des classes Client et Serveur :
  javac Client.java
  javac Serveur.java

* Exécution

Avec 2 terminaux/invites de commandes :

1) Dans le premier terminal : java Serveur
2) Dans le deuxième terminal : java Client
3) Dans le terminal du client entrez l'un des clé des compte disponible dans le registre.
	Vous les retouverez dans Serveur.java  : compteSarlIndigoEX01 et compteSarlOxigenEX01.
4) TEST
	4-1) Pour les tests des principes du MultiThread, et de la Synchronisation
	** On lance plus de 1 client se connectant sur le même compte. Choisi par exemple le compte compteSarlIndigoEX01.
	 ::: On a fait endormir pendant 20s l'exécution de la méthode depot(String) avec le code suivant que vous retrouverez dans l'implementation CompteDistant.java
	 	try {
			Thread.sleep(20000);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}

	4-2)Cas de Test
	** On lance un dépot montant 5000 dans le terminal de l'un des clients
	** Le Solde est à 5000
	** Maglré que le solde soit à 5000, lancons un retrait de 5200 dans le terminal de l'autre client

	4-3)Resultats de Test
	** Grâce au mot clé synchronized déclaré dans le prototype des méthodes
	la méthode depot(String) fait patienter toutes autres méthodes voulant acceder à la variable solde
	Donc retrait(String) patient. Ensuite après la fin d'exécution de depôt le retrait peut etre effectué 
5) Dans un autre terminal il est possible de lancer des clients voulant travailler sur un compte différent
	**Ceux ci seront chacun transporté dans un nouveau thread où ils pourront effectuer les opérations Synchronisées
