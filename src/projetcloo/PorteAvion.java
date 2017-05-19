package projetcloo;

public class PorteAvion extends Bateau
{
	public PorteAvion(Case proue, Case poupe)
	{
		super(proue, poupe);
	}

	@Override
	public int getTaille()
	{
		return 5;
	}
}
