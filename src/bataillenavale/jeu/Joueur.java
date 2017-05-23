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
	
	public boolean setCV1(Case proue, Case poupe)
	{
		int coordProueX = proue.getCoordX();
		int coordProueY = proue.getCoordY();
		int coordPoupeX = poupe.getCoordX();
		int coordPoupeY = poupe.getCoordY();
		
		List<Case> positionBateau;
		Case caseTemp;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 4) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 4))
			{
				CV1 = new PorteAvion(proue, poupe);
				positionBateau = CV1.getPosition();
				for (Case c : positionBateau)
				{
					caseTemp = grilleJoueur.getCase(c.getCoordX(), c.getCoordY());
					if (caseTemp.isBateau())
					{
						return false;
					}
				}
				nbCVJoueur --;
				grilleJoueur.setBateau(positionBateau, true);
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
		grilleJoueur.setBateau(positionBateau, false);
	}
	
	public boolean setCA1(Case proue, Case poupe)
	{
		int coordProueX = proue.getCoordX();
		int coordProueY = proue.getCoordY();
		int coordPoupeX = poupe.getCoordX();
		int coordPoupeY = poupe.getCoordY();
		
		List<Case> positionBateau;
		Case caseTemp;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 3) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 3))
			{
				CA1 = new Croiseur(proue, poupe);
				positionBateau = CA1.getPosition();
				for (Case c : positionBateau)
				{
					caseTemp = grilleJoueur.getCase(c.getCoordX(), c.getCoordY());
					if (caseTemp.isBateau())
					{
						return false;
					}
				}
				nbCAJoueur --;
				grilleJoueur.setBateau(positionBateau, true);
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
		grilleJoueur.setBateau(positionBateau, false);
	}
	
	public boolean setCA2(Case proue, Case poupe)
	{
		int coordProueX = proue.getCoordX();
		int coordProueY = proue.getCoordY();
		int coordPoupeX = poupe.getCoordX();
		int coordPoupeY = poupe.getCoordY();
		
		List<Case> positionBateau;
		Case caseTemp;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 3) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 3))
			{
				CA2 = new Croiseur(proue, poupe);
				positionBateau = CA2.getPosition();
				for (Case c : positionBateau)
				{
					caseTemp = grilleJoueur.getCase(c.getCoordX(), c.getCoordY());
					if (caseTemp.isBateau())
					{
						return false;
					}
				}
				nbCAJoueur --;
				grilleJoueur.setBateau(positionBateau, true);
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
		grilleJoueur.setBateau(positionBateau, false);
	}
	
	public boolean setDD1(Case proue, Case poupe)
	{
		int coordProueX = proue.getCoordX();
		int coordProueY = proue.getCoordY();
		int coordPoupeX = poupe.getCoordX();
		int coordPoupeY = poupe.getCoordY();
		
		List<Case> positionBateau;
		Case caseTemp;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 2) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 2))
			{
				DD1 = new Croiseur(proue, poupe);
				positionBateau = DD1.getPosition();
				for (Case c : positionBateau)
				{
					caseTemp = grilleJoueur.getCase(c.getCoordX(), c.getCoordY());
					if (caseTemp.isBateau())
					{
						return false;
					}
				}
				nbDDJoueur --;
				grilleJoueur.setBateau(positionBateau, true);
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
		grilleJoueur.setBateau(positionBateau, false);
	}
	
	public boolean setDD2(Case proue, Case poupe)
	{
		int coordProueX = proue.getCoordX();
		int coordProueY = proue.getCoordY();
		int coordPoupeX = poupe.getCoordX();
		int coordPoupeY = poupe.getCoordY();
		
		List<Case> positionBateau;
		Case caseTemp;
		
		if ((coordProueX == coordPoupeX && Math.abs(coordProueY - coordPoupeY) == 2) ||
			(coordProueY == coordPoupeY && Math.abs(coordProueX - coordPoupeX) == 2))
			{
				DD2 = new Croiseur(proue, poupe);
				positionBateau = DD2.getPosition();
				for (Case c : positionBateau)
				{
					caseTemp = grilleJoueur.getCase(c.getCoordX(), c.getCoordY());
					if (caseTemp.isBateau())
					{
						return false;
					}
				}
				nbDDJoueur --;
				grilleJoueur.setBateau(positionBateau, true);
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
		grilleJoueur.setBateau(positionBateau, false);
	}
	
	public void setCoupDansEau(Case position)
	{
		grilleEnnemi.setTir(position, true);
	}
	
	public void setTouche(Case position)
	{
		List<Case> bateau = new ArrayList<>();
		bateau.add(position);
		grilleEnnemi.setBateau(bateau, true);
		grilleEnnemi.setTir(position, true);
	}
	
	public boolean setCVCoule(Case position)
	{
		this.setTouche(position);
		nbCVEnnemi ++;
		return isFinish();
	}
	
	public boolean setCACoule(Case position)
	{
		this.setTouche(position);
		nbCAEnnemi ++;
		return isFinish();
	}
	
	public boolean setDDCoule(Case position)
	{
		this.setTouche(position);
		nbDDEnnemi ++;
		return isFinish();
	}
	
	public int setTir(Case position)
	{
		int issue = 0;
		grilleJoueur.setTir(position, true);
		if (CV1.isCoule() && CV1.isTouche(position))
		{
			nbCVJoueur ++;
			issue = 50;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if ((CA1.isCoule() && CA1.isTouche(position)) || (CA2.isCoule() && CA2.isTouche(position)))
		{
			nbCAJoueur ++;
			issue = 40;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if ((DD1.isCoule() && DD1.isTouche(position)) || (DD2.isCoule() && DD2.isTouche(position)))
		{
			nbDDJoueur ++;
			issue = 30;
			if (isFinish())
			{
				issue ++;
			}
		}
		else if (CV1.isTouche(position) || CA1.isTouche(position) || CA2.isTouche(position) || DD1.isTouche(position) || DD2.isTouche(position))
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