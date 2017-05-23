package bataillenavale.jeu;

import java.util.*;

public class Joueur
{
	private Grille grilleJoueur;
	private Grille grilleEnnemi;
	
	private Bateau CV1;
	private Bateau CA1;
	private Bateau CA2;
	private Bateau DD1;
	private Bateau DD2;
	
	private int nbCVJoueur;
	private int nbCAJoueur;
	private int nbDDJoueur;
	
	private int nbCVEnnemi;
	private int nbCAEnnemi;
	private int nbDDEnnemi;
	
	public Joueur()
	{
		this.grilleJoueur = new Grille(10);
		this.grilleEnnemi = new Grille(10);
		this.nbCVJoueur = 1;
		this.nbCAJoueur = 2;
		this.nbDDJoueur = 2;
		this.nbCVEnnemi = 0;
		this.nbCAEnnemi = 0;
		this.nbDDEnnemi = 0;
	}

	public Grille getGrilleJoueur()
	{
		return grilleJoueur;
	}
	
	public void initialisation()
	{
		String nomBateau = null;
		String proue = null;
		String poupe = null;
		
		int tailleBateau = 0;
		int coordProueX = 0;
		int coordProueY = 0;
		int coordPoupeX = 0;
		int coordPoupeY = 0;
		int index = 0;
		
		Case caseProue;
		Case casePoupe;
		Case caseTemp;
		List<Case> positionBateau;
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		do // Placement des bateaux
		{
			do // Selection du bateau
			{
				System.out.print("Entrez un type de bateau : ");
				nomBateau = reader.nextLine();
				if (nomBateau.equalsIgnoreCase("CV") && nbCVJoueur != 0)
				{
					tailleBateau = 5;
					nbCVJoueur --;
					break;
				}
				else if (nomBateau.equalsIgnoreCase("CA") && nbCAJoueur != 0)
				{
					tailleBateau = 4;
					nbCAJoueur --;
					break;
				}
				else if (nomBateau.equalsIgnoreCase("DD") && nbDDJoueur != 0)
				{
					tailleBateau = 3;
					nbDDJoueur --;
					break;
				}
				else
				{
					System.out.println("Entrée incorrecte");
				}
			}
			while (true);
			
			do // Selection de la proue
			{
				System.out.print("Entrez la case de proue ([A..J][1..10]): ");
				proue = reader.nextLine();
				if (proue.length() < 2)
				{
					System.out.println("Entrée incorrecte");
				}
				else
				{
					coordProueX = Character.getNumericValue(proue.charAt(0));
					coordProueY = Character.getNumericValue(proue.charAt(1));
					if (coordProueX < 20 && coordProueX >= 10 && Character.isDigit(proue.charAt(1)) && proue.length() == 2)
					{
						coordProueX -= 10;
						coordProueY -= 1;
						break;
					}
					else if (coordProueX < 20 && coordProueX >= 10 && Character.isDigit(proue.charAt(1)) && coordProueY == 1 &&
							Character.isDigit(proue.charAt(2)) && Character.getNumericValue(proue.charAt(2)) == 0 && proue.length() == 3)
					{
						coordProueX -= 10;
						coordProueY = 9;
						break;
					}
					else
					{
						System.out.println("Entrée incorrecte");
					}
				}
			}
			while (true);
			
			do // Selection de la poupe
			{
				System.out.print("Entrez la case de poupe ([A..J][1..10]): ");
				poupe = reader.nextLine();
				if (poupe.length() < 2)
				{
					System.out.println("Entrée incorrecte");
				}
				else
				{
					coordPoupeX = Character.getNumericValue(poupe.charAt(0));
					coordPoupeY = Character.getNumericValue(poupe.charAt(1));
					if (coordPoupeX < 20 && coordPoupeX >= 10 && Character.isDigit(poupe.charAt(1)) && poupe.length() == 2)
					{
						coordPoupeX -= 10;
						coordPoupeY -= 1;
						if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == tailleBateau - 1) ||
							(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == tailleBateau - 1))
						{
							break;
						}
						else
						{
							System.out.println("Entrée incorrecte");
						}
					}
					else if (coordPoupeX < 20 && coordPoupeX >= 10 && Character.isDigit(poupe.charAt(1)) && coordPoupeY == 1 &&
							Character.isDigit(poupe.charAt(2)) && Character.getNumericValue(poupe.charAt(2)) == 0 && poupe.length() == 3)
					{
						coordPoupeX -= 10;
						coordPoupeY = 9;
						if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == tailleBateau - 1) ||
							(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == tailleBateau - 1))
						{
							break;
						}
						else
						{
							System.out.println("Entrée incorrecte");
						}
					}
					else
					{
						System.out.println("Entrée incorrecte");
					}
				}
			}
			while (true);
			
			caseProue = new Case(coordProueX, coordProueY, true, false);
			casePoupe = new Case(coordPoupeX, coordPoupeY, true, false);
			
			if (tailleBateau == 5)
			{
				CV1 = new PorteAvion(caseProue, casePoupe);
				positionBateau = CV1.getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = grilleJoueur.getGrille().get(index);
					if (caseTemp.isBateau())
					{
						nbCVJoueur ++;
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (nbCVJoueur == 0)
				{
					grilleJoueur.setBateau(positionBateau, true);
				}
			}
			else if (tailleBateau == 4 && nbCAJoueur == 1)
			{
				CA1 = new Croiseur(caseProue, casePoupe);
				positionBateau = CA1.getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = grilleJoueur.getGrille().get(index);
					if (caseTemp.isBateau())
					{
						nbCAJoueur ++;
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (nbCAJoueur == 1)
				{
					grilleJoueur.setBateau(positionBateau, true);
				}
			}
			else if (tailleBateau == 4 && nbCAJoueur == 0)
			{
				CA2 = new Croiseur(caseProue, casePoupe);
				positionBateau = CA2.getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = grilleJoueur.getGrille().get(index);
					if (caseTemp.isBateau())
					{
						nbCAJoueur ++;
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (nbCAJoueur == 0)
				{
					grilleJoueur.setBateau(positionBateau, true);
				}
			}
			else if (tailleBateau == 3 && nbDDJoueur == 1)
			{
				DD1 = new Torpilleur(caseProue, casePoupe);
				positionBateau = DD1.getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = grilleJoueur.getGrille().get(index);
					if (caseTemp.isBateau())
					{
						nbDDJoueur ++;
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (nbDDJoueur == 1)
				{
					grilleJoueur.setBateau(positionBateau, true);
				}
			}
			else if (tailleBateau == 3 && nbDDJoueur == 0)
			{
				DD2 = new Torpilleur(caseProue, casePoupe);
				positionBateau = DD2.getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = grilleJoueur.getGrille().get(index);
					if (caseTemp.isBateau())
					{
						nbDDJoueur ++;
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (nbDDJoueur == 0)
				{
					grilleJoueur.setBateau(positionBateau, true);
				}
			}
		}
		while (nbCVJoueur + nbCAJoueur + nbDDJoueur > 0);
	}
	
	public int tourJoueur()
	{
		String tir = null;
		
		int coordX = 0;
		int coordY = 0;
		Case position;
		
		System.out.println("À vous de jouer!");
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		do // Selection de la case
		{
			System.out.print("Entrez une case ([A..J][1..10]): ");
			tir = reader.nextLine();
			if (tir.length() < 2)
			{
				System.out.println("Entrée incorrecte");
			}
			else
			{
				coordX = Character.getNumericValue(tir.charAt(0));
				coordY = Character.getNumericValue(tir.charAt(1));
				if (coordX < 20 && coordX >= 10 && Character.isDigit(tir.charAt(1)) && tir.length() == 2)
				{
					coordX -= 10;
					coordY -= 1;
					position = grilleEnnemi.getGrille().get(coordX + coordY * 10);
					if (position.isTir())
					{
						System.out.println("Entrée incorrecte");
					}
					else
					{
						grilleEnnemi.setTir(position, true);
						break;
					}
				}
				else if (coordX < 20 && coordX >= 10 && Character.isDigit(tir.charAt(1)) && coordY == 1 &&
						Character.isDigit(tir.charAt(2)) && Character.getNumericValue(tir.charAt(2)) == 0 && tir.length() == 3)
				{
					coordX -= 10;
					coordY = 9;
					position = grilleEnnemi.getGrille().get(coordX + coordY * 10);
					if (position.isTir())
					{
						System.out.println("Entrée incorrecte");
					}
					else
					{
						grilleEnnemi.setTir(position, true);
						break;
					}
				}
				else
				{
					System.out.println("Entrée incorrecte");
				}
			}
		}
		while (true);
		
		do
		{
			System.out.print("Touché ? ");
			tir = reader.nextLine();
			if (tir.length() < 1)
			{
				System.out.println("Entrée incorrecte");
			}
			else
			{
				if (tir.equalsIgnoreCase("T"))
				{
					List<Case> bateau = new ArrayList<>();
					bateau.add(position);
					grilleEnnemi.setBateau(bateau, true);
					
					do
					{
						System.out.print("Coulé ? ");
						tir = reader.nextLine();
						if (tir.length() < 1)
						{
							System.out.println("Entrée incorrecte");
						}
						else
						{
							if (tir.equalsIgnoreCase("C"))
							{
								do
								{
									System.out.print("Quel bateau ? ");
									tir = reader.nextLine();
									if (tir.equalsIgnoreCase("CV") && nbCVEnnemi < 1)
									{
										nbCVEnnemi ++;
										break;
									}
									else if (tir.equalsIgnoreCase("CA") && nbCAEnnemi < 2)
									{
										nbCAEnnemi ++;
										break;
									}
									else if (tir.equalsIgnoreCase("DD") && nbDDEnnemi < 2)
									{
										nbDDEnnemi ++;
										break;
									}
									else
									{
										System.out.println("Entrée incorrecte");
									}
								}
								while (true);
								
								if (nbCVEnnemi + nbCAEnnemi + nbDDEnnemi == 5) // Victoire
								{
									return 1;
								}
							}
							return this.tourJoueur(); // On rejoue
						}
					}
					while (true);
				}
				return this.tourEnnemi(); // À l'ennemi de jouer
			}
		}
		while (true);
	}
	
	public int tourEnnemi()
	{
		String tir = null;
		
		int coordX = 0;
		int coordY = 0;
		Case position;
		
		System.out.println("C'est à l'ennemi de jouer!");
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		do // Selection de la case
		{
			System.out.print("Entrez une case ([A..J][1..10]): ");
			tir = reader.nextLine();
			if (tir.length() < 2)
			{
				System.out.println("Entrée incorrecte");
			}
			else
			{
				coordX = Character.getNumericValue(tir.charAt(0));
				coordY = Character.getNumericValue(tir.charAt(1));
				if (coordX < 20 && coordX >= 10 && Character.isDigit(tir.charAt(1)) && tir.length() == 2)
				{
					coordX -= 10;
					coordY -= 1;
					position = grilleJoueur.getGrille().get(coordX + coordY * 10);
					if (position.isTir())
					{
						System.out.println("Entrée incorrecte");
					}
					else
					{
						break;
					}
				}
				else if (coordX < 20 && coordX >= 10 && Character.isDigit(tir.charAt(1)) && coordY == 1 &&
						Character.isDigit(tir.charAt(2)) && Character.getNumericValue(tir.charAt(2)) == 0 && tir.length() == 3)
				{
					coordX -= 10;
					coordY = 9;
					position = grilleJoueur.getGrille().get(coordX + coordY * 10);
					if (position.isTir())
					{
						System.out.println("Entrée incorrecte");
					}
					else
					{
						break;
					}
				}
				else
				{
					System.out.println("Entrée incorrecte");
				}
			}
		}
		while (true);
		
		grilleJoueur.setTir(position, true);
		
		if (CV1.isTouche(position) || CA1.isTouche(position) || CA2.isTouche(position) || DD1.isTouche(position) || DD2.isTouche(position))
		{
			System.out.println("Touché");
			
			if (CV1.isCoule() && CV1.isTouche(position))
			{
				System.out.println("Porte-Avion coulé");
				nbCVJoueur ++;
			}
			else if ((CA1.isCoule() && CA1.isTouche(position)) || (CA2.isCoule() && CA2.isTouche(position)))
			{
				System.out.println("Croiseur coulé");
				nbCAJoueur ++;
			}
			else if ((DD1.isCoule() && DD1.isTouche(position)) || (DD2.isCoule() && DD2.isTouche(position)))
			{
				System.out.println("Torpilleur coulé");
				nbDDJoueur ++;
			}
			
			if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
			{
				return 0; // Défaite
			}
			else
			{
				return this.tourEnnemi(); // L'ennemi rejoue
			}
		}
		else
		{
			System.out.println("Coup dans l'eau");
			return this.tourJoueur(); // Au joueur de jouer
		}
	}
}