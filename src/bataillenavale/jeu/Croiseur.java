package bataillenavale.jeu;

public class Croiseur extends Bateau
{
	public Croiseur(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{
		super(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
	}

	@Override
	public int getTaille()
	{
		return 4;
	}
}
