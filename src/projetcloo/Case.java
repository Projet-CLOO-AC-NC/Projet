package projetcloo;

public class Case
{

	private int coordX;
	private int coordY;
	private boolean bateau;
	private boolean tir;
	
	public Case(int coordX, int coordY, boolean bateau, boolean tir)
	{
		this.coordX = coordX;
		this.coordY = coordY;
		this.bateau = bateau;
		this.tir = tir;
	}
	
	public int getCoordX()
	{
		return coordX;
	}
	
	public int getCoordY()
	{
		return coordY;
	}
	
	public boolean isBateau()
	{
		return bateau;
	}
	
	public boolean isTir()
	{
		return tir;
	}
	
	public void setBateau(boolean bateau)
	{
		this.bateau = bateau;
	}
	
	public void setTir(boolean tir)
	{
		this.tir = tir;
	}
	
	public void print()
	{
		if (bateau && tir)
		{
			System.out.print("X ");
		}
		else if (bateau && !tir)
		{
			System.out.print("+ ");
		}
		else if (!bateau && tir)
		{
			System.out.print("0 ");
		}
		else
		{
			System.out.print("O ");
		}
	}
	
	public void printTest()
	{
		System.out.println("X: " + coordX + " Y: " + coordY + " B: " + bateau + " T: " + tir);
	}
}
