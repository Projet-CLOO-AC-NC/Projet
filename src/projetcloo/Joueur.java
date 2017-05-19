package projetcloo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public Grille getGrilleEnnemi()
	{
		return grilleEnnemi;
	}
	
	public Bateau getCV1()
	{
		return CV1;
	}
	
	public Bateau getCA1()
	{
		return CA1;
	}
	
	public Bateau getCA2()
	{
		return CA2;
	}
	
	public Bateau getDD1()
	{
		return DD1;
	}
	
	public Bateau getDD2()
	{
		return DD2;
	}
	
	public int getNbCVJoueur()
	{
		return nbCVJoueur;
	}
	
	public int getNbCAJoueur()
	{
		return nbCAJoueur;
	}
	
	public int getNbDDJoueur()
	{
		return nbDDJoueur;
	}
	
	public int getNbCVEnnemi()
	{
		return nbCVEnnemi;
	}
	
	public int getNbCAEnnemi()
	{
		return nbCAEnnemi;
	}
	
	public int getNbDDEnnemi()
	{
		return nbDDEnnemi;
	}
	
	public void setGrilleJoueur(Grille grilleJoueur)
	{
		this.grilleJoueur = grilleJoueur;
	}
	
	public void setGrilleEnnemi(Grille grilleEnnemi)
	{
		this.grilleEnnemi = grilleEnnemi;
	}
	
	public void setCV1(Bateau CV1)
	{
		this.CV1 = CV1;
	}
	
	public void setCA1(Bateau CA1)
	{
		this.CA1 = CA1;
	}
	
	public void setCA2(Bateau CA2)
	{
		this.CA2 = CA2;
	}
	
	public void setDD1(Bateau DD1)
	{
		this.DD1 = DD1;
	}
	
	public void setDD2(Bateau DD2)
	{
		this.DD2 = DD2;
	}
	
	public void setNbCVJoueur(int nbCVJoueur)
	{
		this.nbCVJoueur = nbCVJoueur;
	}
	
	public void setNbCAJoueur(int nbCAJoueur)
	{
		this.nbCAJoueur = nbCAJoueur;
	}
	
	public void setNbDDJoueur(int nbDDJoueur)
	{
		this.nbDDJoueur = nbDDJoueur;
	}
	
	public void setNbCVEnnemi(int nbCVEnnemi)
	{
		this.nbCVEnnemi = nbCVEnnemi;
	}
	
	public void setNbCAEnnemi(int nbCAEnnemi)
	{
		this.nbCAEnnemi = nbCAEnnemi;
	}
	
	public void setNbDDEnnemi(int nbDDEnnemi)
	{
		this.nbDDEnnemi = nbDDEnnemi;
	}
	
	public int tourJoueur()
	{
		String tir = null;
		
		int coordX = 0;
		int coordY = 0;
		Case position;
		
		System.out.println("À vous de jouer!");
		grilleEnnemi.print();
		
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
									if (tir.equalsIgnoreCase("Porte-Avion") && nbCVEnnemi < 1)
									{
										nbCVEnnemi ++;
										break;
									}
									else if (tir.equalsIgnoreCase("Croiseur") && nbCAEnnemi < 2)
									{
										nbCAEnnemi ++;
										break;
									}
									else if (tir.equalsIgnoreCase("Torpilleur") && nbDDEnnemi < 2)
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
								else // On rejoue
								{
									return this.tourJoueur();
								}
							}
							else // On rejoue
							{
								return this.tourJoueur();
							}
						}
					}
					while (true);
				}
				else // À l'ennemi de jouer
				{
					return this.tourEnnemi();
				}
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
		grilleJoueur.print();
		
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
						grilleJoueur.setTir(position, true);
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
						grilleJoueur.setTir(position, true);
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
		
		if (CV1.isTouche(position))
		{
			System.out.println("Touché");
			if (CV1.isCoule())
			{
				System.out.println("Porte-Avion coulé");
				nbCVJoueur ++;
				if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
				{
					return 0; // Défaite
				}
			}
			return this.tourEnnemi(); // L'ennemi rejoue
		}
		else if (CA1.isTouche(position))
		{
			System.out.println("Touché");
			if (CA1.isCoule())
			{
				System.out.println("Croiseur coulé");
				nbCAJoueur ++;
				if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
				{
					return 0; // Défaite
				}
			}
			return this.tourEnnemi(); // L'ennemi rejoue
		}
		else if (CA2.isTouche(position))
		{
			System.out.println("Touché");
			if (CA2.isCoule())
			{
				System.out.println("Croiseur coulé");
				nbCAJoueur ++;
				if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
				{
					return 0; // Défaite
				}
			}
			return this.tourEnnemi(); // L'ennemi rejoue
		}
		else if (DD1.isTouche(position))
		{
			System.out.println("Touché");
			if (DD1.isCoule())
			{
				System.out.println("Torpilleur coulé");
				nbCAJoueur ++;
				if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
				{
					return 0; // Défaite
				}
			}
			return this.tourEnnemi(); // L'ennemi rejoue
		}
		else if (DD2.isTouche(position))
		{
			System.out.println("Touché");
			if (DD2.isCoule())
			{
				System.out.println("Torpilleur coulé");
				nbCAJoueur ++;
				if (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5)
				{
					return 0; // Défaite
				}
			}
			return this.tourEnnemi(); // L'ennemi rejoue
		}
		else
		{
			System.out.println("Coup dans l'eau");
			return this.tourJoueur(); // Au joueur de jouer
		}
	}
}
