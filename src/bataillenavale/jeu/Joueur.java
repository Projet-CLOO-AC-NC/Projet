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
		this.grilleJoueur = new Grille();
		this.grilleEnnemi = new Grille();
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
	
	public int getCVJoueur()
	{
		return nbCVJoueur;
	}
	
	public int getCAJoueur()
	{
		return nbCAJoueur;
	}
	
	public int getDDJoueur()
	{
		return nbDDJoueur;
	}
	
	public int getCVEnnemi()
	{
		return nbCVEnnemi;
	}
	
	public int getCAEnnemi()
	{
		return nbCAEnnemi;
	}
	
	public int getDDEnnemi()
	{
		return nbDDEnnemi;
	}
	
	public boolean isBateau(int coordX, int coordY)
	{
		return grilleJoueur.getCase(coordX, coordY).isBateau();
	}
	
	public boolean isBateau(List<Case> position)
	{
		for (Case c : position)
		{
			if (grilleJoueur.getCase(c.getCoordX(), c.getCoordY()).isBateau())
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean setCV1(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{	
		List<Case> positionBateau;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 4) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 4))
		{
			CV1 = new PorteAvion(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
			positionBateau = CV1.getPosition();
			
			if (isBateau(positionBateau))
			{
				return false;
			}
			
			nbCVJoueur --;
			grilleJoueur.setFullBateau(positionBateau, true);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void destroyCV1()
	{
		List<Case> positionBateau = CV1.getPosition();
		nbCVJoueur ++;
		grilleJoueur.setFullBateau(positionBateau, false);
	}
	
	public boolean setCA1(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{	
		List<Case> positionBateau;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 3) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 3))
		{
			CA1 = new Croiseur(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
			positionBateau = CA1.getPosition();
			
			if (isBateau(positionBateau))
			{
				return false;
			}
			
			nbCAJoueur --;
			grilleJoueur.setFullBateau(positionBateau, true);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void destroyCA1()
	{
		List<Case> positionBateau = CA1.getPosition();
		nbCAJoueur ++;
		grilleJoueur.setFullBateau(positionBateau, false);
	}
	
	public boolean setCA2(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{	
		List<Case> positionBateau;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 3) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 3))
		{
			CA2 = new Croiseur(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
			positionBateau = CA2.getPosition();
			
			if (isBateau(positionBateau))
			{
				return false;
			}
			
			nbCAJoueur --;
			grilleJoueur.setFullBateau(positionBateau, true);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void destroyCA2()
	{
		List<Case> positionBateau = CA2.getPosition();
		nbCAJoueur ++;
		grilleJoueur.setFullBateau(positionBateau, false);
	}
	
	public boolean setDD1(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{	
		List<Case> positionBateau;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 2) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 2))
		{
			DD1 = new Torpilleur(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
			positionBateau = DD1.getPosition();
			
			if (isBateau(positionBateau))
			{
				return false;
			}
			
			nbDDJoueur --;
			grilleJoueur.setFullBateau(positionBateau, true);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void destroyDD1()
	{
		List<Case> positionBateau = DD1.getPosition();
		nbDDJoueur ++;
		grilleJoueur.setFullBateau(positionBateau, false);
	}
	
	public boolean setDD2(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{	
		List<Case> positionBateau;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 2) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 2))
		{
			DD2 = new Torpilleur(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
			positionBateau = DD2.getPosition();
			
			if (isBateau(positionBateau))
			{
				return false;
			}
			
			nbDDJoueur --;
			grilleJoueur.setFullBateau(positionBateau, true);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void destroyDD2()
	{
		List<Case> positionBateau = DD2.getPosition();
		nbDDJoueur ++;
		grilleJoueur.setFullBateau(positionBateau, false);
	}
	
	public boolean isTir(int coordX, int coordY)
	{
		return grilleEnnemi.getCase(coordX, coordY).isTir();
	}
	
	public void setCoupDansEau(int coordX, int coordY)
	{
		grilleEnnemi.setTir(coordX, coordY, true);
	}
	
	public void setTouche(int coordX, int coordY)
	{
		grilleEnnemi.setBateau(coordX, coordY, true);
		grilleEnnemi.setTir(coordX, coordY, true);
	}
	
	public boolean setCVCoule(int coordX, int coordY)
	{
		this.setTouche(coordX, coordY);
		nbCVEnnemi ++;
		return isFinish();
	}
	
	public boolean setCACoule(int coordX, int coordY)
	{
		this.setTouche(coordX, coordY);
		nbCAEnnemi ++;
		return isFinish();
	}
	
	public boolean setDDCoule(int coordX, int coordY)
	{
		this.setTouche(coordX, coordY);
		nbDDEnnemi ++;
		return isFinish();
	}
	
	public int setTir(int coordX, int coordY)
	{
		int issue = 0;
		grilleJoueur.setTir(coordX, coordY, true);
		
		if (CV1.isTouche(coordX, coordY) && CV1.isCoule())
		{
			nbCVJoueur ++;
			issue = 50;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if (CA1.isTouche(coordX, coordY) && (CA1.isCoule()) || (CA2.isTouche(coordX, coordY) && CA2.isCoule()))
		{
			nbCAJoueur ++;
			issue = 40;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if ((DD1.isTouche(coordX, coordY) && DD1.isCoule()) || (DD2.isTouche(coordX, coordY) && DD2.isCoule()))
		{
			nbDDJoueur ++;
			issue = 30;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if (CV1.isTouche(coordX, coordY) || CA1.isTouche(coordX, coordY) || CA2.isTouche(coordX, coordY) || DD1.isTouche(coordX, coordY) || DD2.isTouche(coordX, coordY))
		{
			issue ++;
		}
		
		return issue; // 0: coup dans l'eau, 1: touché, 30: torpilleur coulé, 31: torpilleur coulé + fin, 40: croiseur coulé, 41: croiseur coulé + fin, 50: porte-avion coulé, 51: porte-avion coulé + fin
	}
	
	public boolean isFinish()
	{
		return (nbCVEnnemi + nbCAEnnemi + nbDDEnnemi == 5) || (nbCVJoueur + nbCAJoueur + nbDDJoueur == 5);
	}
}