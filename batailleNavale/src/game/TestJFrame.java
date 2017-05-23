package game;

import javax.swing.*;


public class TestJFrame {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				System.out.println("Démarrage du système");
				//On crée une nouvelle instance de notre JDialog
				Fenetre fenetre = new Fenetre();
				fenetre.setVisible(true);//On la rend visible
			}
		});
	}
}
