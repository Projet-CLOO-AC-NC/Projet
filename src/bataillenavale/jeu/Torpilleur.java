package bataillenavale.jeu;

public class Torpilleur extends Bateau
{
	public Torpilleur(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{
		super(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
	}

	@Override
	public int getTaille()
	{
		return 3;
	}
}