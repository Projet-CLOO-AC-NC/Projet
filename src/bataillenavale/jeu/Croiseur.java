package bataillenavale.jeu;

public class Croiseur extends Bateau
{
	public Croiseur(Case proue, Case poupe)
	{
		super(proue, poupe);
	}

	@Override
	public int getTaille()
	{
		return 4;
	}
}
