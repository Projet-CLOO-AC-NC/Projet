package bataillenavale.jeu;

import java.util.*;

public class Grille
{
	private List<Case> grille;
	
	public Grille()
	{
		this.grille = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				grille.add(new Case(j, i, false, false));
			}
		}
	}

	public List<Case> getGrille()
	{
		return grille;
	}
	
	public Case getCase(int coordX, int coordY)
	{
		return grille.get(coordX + coordY * 10);
	}
	
	public void setCase(Case position)
	{
		grille.set(position.getCoordX() + position.getCoordY() * 10, position);
	}
	
	public void setBateau(int coordX, int coordY, boolean bateau)
	{
		Case temp = this.getCase(coordX, coordY);
		temp.setBateau(bateau);
		this.setCase(temp);
	}
	
	public void setFullBateau(List<Case> position, boolean bateau)
	{
		for (Case c : position)
		{
			this.setBateau(c.getCoordX(), c.getCoordY(), bateau);
		}
	}
	
	public void setTir(int coordX, int coordY, boolean tir)
	{
		Case temp = this.getCase(coordX, coordY);
		temp.setTir(tir);
		this.setCase(temp);
	}
}
