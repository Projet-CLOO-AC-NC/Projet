package bataillenavale.jeu;

import java.util.*;

public class BatailleNavaleMain
{

	public BatailleNavaleMain()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	
	//-------------Main--------------------

	public static void main(String[] args)
	{	
		Joueur joueur = new Joueur();
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		joueur.initialisation();
		
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
