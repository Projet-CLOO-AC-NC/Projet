package bataillenavale.jeu;

public class PorteAvion extends Bateau
{
	public PorteAvion(int coordProueX, int coordProueY, int coordPoupeX, int coordPoupeY)
	{
		super(coordProueX, coordProueY, coordPoupeX, coordPoupeY);
	}

	@Override
	public int getTaille()
	{
		return 5;
	}
}
