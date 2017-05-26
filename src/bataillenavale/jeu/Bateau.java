package bataillenavale.jeu;

import java.util.*;

public abstract class Bateau
{
	private List<Case> position;
	
	public Bateau(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{
		int taille = getTaille();
		int start = 0;
		List<Case> position = new ArrayList<>();
		
		if (coordProueX == coordPoupeX)
		{
			start = Math.min(coordProueY, coordPoupeY);
			for (int i = start; i < (taille + start); i++)
			{
				position.add(new Case(coordProueX, i, true, false));
			}
		}
		else
		{
			start = Math.min(coordProueX, coordPoupeX);
			for (int i = start; i < (taille + start); i++)
			{
				position.add(new Case(i, coordProueY, true, false));
			}
		}
		
		this.position = position;
	}
	
	public List<Case> getPosition()
	{
		return position;
	}
	
	public boolean isTouche(int coordX, int coordY)
	{
		for (Case c: position)
		{
			if (c.getCoordX() == coordX && c.getCoordY() == coordY && !c.isTir())
			{
				c.setTir(true);
				return true;
			}
		}
		return false;
	}
	
	public boolean isCoule()
	{
		for (Case c: position)
		{
			if (!c.isTir())
			{
				return false;
			}
		}
		return true;
	}
	
	public abstract int getTaille();
}
