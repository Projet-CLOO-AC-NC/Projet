package projetcloo;

import java.util.*;

public class Grille
{
	private List<Case> grille;
	private int taille;
	
	public Grille(int taille)
	{
		this.taille = taille;
		this.grille = new ArrayList<>();
		for (int i = 0; i < taille; i++)
		{
			for (int j = 0; j < taille; j++)
			{
				grille.add(new Case(j, i, false, false));
			}
		}
	}

	public List<Case> getGrille()
	{
		return grille;
	}
	
	public int getTaille()
	{
		return taille;
	}
	
	public void setBateau(List<Case> position, boolean bateau)
	{
		for (Case c : position)
		{
			int index = c.getCoordX() + c.getCoordY() * 10;
			Case temp = grille.get(index);
			temp.setBateau(bateau);
			grille.set(index, temp);
		}
	}
	
	public void setTir(Case position, boolean tir)
	{
		int index = position.getCoordX() + position.getCoordY() * 10;
		Case temp = grille.get(index);
		temp.setTir(tir);
		grille.set(index, temp);
	}
	
	public void print()
	{
		int i = 1;
		int j = 0;
		System.out.println("----------------------");
		System.out.println("   A B C D E F G H I J");
		System.out.print(" " + i + " ");
		for (Case c : grille)
		{
			c.print();
			j++;
			if (j == taille)
			{
				System.out.println("");
				j = 0;
				i++;
				if (i < taille)
				{
					System.out.print(" " + i + " ");
				}
				else if (i == taille)
				{
					System.out.print(i + " ");
				}
			}
		}
		System.out.println("----------------------");
	}
	
	public void printTest()
	{
		for (Case c : grille)
		{
			c.printTest();
		}
	}
}
