package bataillenavale.jeu;

import java.util.*;

public abstract class Bateau
{
	private List<Case> position;
	
	public Bateau(Case proue, Case poupe)
	{
		int taille = getTaille();
		int start = 0;
		List<Case> position = new ArrayList<>();
		
		if (proue.getCoordX() == poupe.getCoordX())
		{
			start = Math.min(proue.getCoordY(), poupe.getCoordY());
			for (int i = start; i < (taille + start); i++)
			{
				position.add(new Case(proue.getCoordX(), i, true, false));
			}
		}
		else
		{
			start = Math.min(proue.getCoordX(), poupe.getCoordX());
			for (int i = start; i < (taille + start); i++)
			{
				position.add(new Case(i, proue.getCoordY(), true, false));
			}
		}
		
		this.position = position;
	}
	
	public List<Case> getPosition()
	{
		return position;
	}
	
	public boolean isTouche(Case tir)
	{
		int coordX = tir.getCoordX();
		int coordY = tir.getCoordY();
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
