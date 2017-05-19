package projetcloo;

import java.util.*;

public class BatailleNavale
{

	public BatailleNavale()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	
	//-------------Main--------------------

	public static void main(String[] args)
	{	
		Joueur joueur = new Joueur();
		joueur.getGrilleJoueur().print();
		
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
		
		Grille grilleTemp;
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		do // Placement des bateaux
		{
			do // Selection du bateau
			{
				System.out.print("Entrez un type de bateau : ");
				nomBateau = reader.nextLine();
				if (nomBateau.equalsIgnoreCase("Porte-Avion") && joueur.getNbCVJoueur() != 0)
				{
					tailleBateau = 5;
					joueur.setNbCVJoueur(joueur.getNbCVJoueur() - 1);
					break;
				}
				else if (nomBateau.equalsIgnoreCase("Croiseur") && joueur.getNbCAJoueur() != 0)
				{
					tailleBateau = 4;
					joueur.setNbCAJoueur(joueur.getNbCAJoueur() - 1);
					break;
				}
				else if (nomBateau.equalsIgnoreCase("Torpilleur") && joueur.getNbDDJoueur() != 0)
				{
					tailleBateau = 3;
					joueur.setNbDDJoueur(joueur.getNbDDJoueur() - 1);
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
				joueur.setCV1(new PorteAvion(caseProue, casePoupe));
				positionBateau = joueur.getCV1().getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = joueur.getGrilleJoueur().getGrille().get(index);
					if (caseTemp.isBateau())
					{
						joueur.setNbCVJoueur(joueur.getNbCVJoueur() + 1);
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (joueur.getNbCVJoueur() == 0)
				{
					grilleTemp = joueur.getGrilleJoueur();
					grilleTemp.setBateau(positionBateau, true);
					joueur.setGrilleJoueur(grilleTemp);
				}
			}
			else if (tailleBateau == 4 && joueur.getNbCAJoueur() == 1)
			{
				joueur.setCA1(new Croiseur(caseProue, casePoupe));
				positionBateau = joueur.getCA1().getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = joueur.getGrilleJoueur().getGrille().get(index);
					if (caseTemp.isBateau())
					{
						joueur.setNbCAJoueur(joueur.getNbCAJoueur() + 1);
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (joueur.getNbCAJoueur() == 1)
				{
					grilleTemp = joueur.getGrilleJoueur();
					grilleTemp.setBateau(positionBateau, true);
					joueur.setGrilleJoueur(grilleTemp);
				}
			}
			else if (tailleBateau == 4 && joueur.getNbCAJoueur() == 0)
			{
				joueur.setCA2(new Croiseur(caseProue, casePoupe));
				positionBateau = joueur.getCA2().getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = joueur.getGrilleJoueur().getGrille().get(index);
					if (caseTemp.isBateau())
					{
						joueur.setNbCAJoueur(joueur.getNbCAJoueur() + 1);
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (joueur.getNbCAJoueur() == 1)
				{
					grilleTemp = joueur.getGrilleJoueur();
					grilleTemp.setBateau(positionBateau, true);
					joueur.setGrilleJoueur(grilleTemp);
				}
			}
			else if (tailleBateau == 3 && joueur.getNbDDJoueur() == 1)
			{
				joueur.setDD1(new Torpilleur(caseProue, casePoupe));
				positionBateau = joueur.getDD1().getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = joueur.getGrilleJoueur().getGrille().get(index);
					if (caseTemp.isBateau())
					{
						joueur.setNbDDJoueur(joueur.getNbDDJoueur() + 1);
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (joueur.getNbDDJoueur() == 1)
				{
					grilleTemp = joueur.getGrilleJoueur();
					grilleTemp.setBateau(positionBateau, true);
					joueur.setGrilleJoueur(grilleTemp);
				}
			}
			else if (tailleBateau == 3 && joueur.getNbDDJoueur() == 0)
			{
				joueur.setDD2(new Torpilleur(caseProue, casePoupe));
				positionBateau = joueur.getDD2().getPosition();
				for (Case c : positionBateau)
				{
					index = c.getCoordX() + c.getCoordY() * 10;
					caseTemp = joueur.getGrilleJoueur().getGrille().get(index);
					if (caseTemp.isBateau())
					{
						joueur.setNbDDJoueur(joueur.getNbDDJoueur() + 1);
						System.out.println("Entrée incorrecte");
						break;
					}
				}
				if (joueur.getNbDDJoueur() == 0)
				{
					grilleTemp = joueur.getGrilleJoueur();
					grilleTemp.setBateau(positionBateau, true);
					joueur.setGrilleJoueur(grilleTemp);
				}
			}
			
			joueur.getGrilleJoueur().print();
		}
		while (joueur.getNbCVJoueur() + joueur.getNbCAJoueur() + joueur.getNbDDJoueur() > 0);
		
		System.out.println("Placement terminé. Début de la partie.");
		
		int noJoueur = 0;
		int issue = 0;
		
		System.out.print("Vous êtes le joueur 1 ou 2 ? ");
		noJoueur = reader.nextInt();
		
		if (noJoueur == 1)
		{
			issue = joueur.tourJoueur();
		}
		else
		{
			issue = joueur.tourEnnemi();
		}
		
		if (issue == 1)
		{
			System.out.println("Vous avez gagné!");
		}
		else
		{
			System.out.println("Vous avez perdu!");
		}
		
		System.out.println("Fin de la partie");
	}
}
