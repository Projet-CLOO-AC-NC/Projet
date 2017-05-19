package projetcloo;

public class Torpilleur extends Bateau
{
	public Torpilleur(Case proue, Case poupe)
	{
		super(proue, poupe);
	}

	@Override
	public int getTaille()
	{
		return 3;
	}

}
