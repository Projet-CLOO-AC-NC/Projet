package game;


import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import javax.swing.*;

public class Fenetre extends JFrame implements ActionListener{

  // déclarations des Panels
    // panel de droite
    private JPanel droite = new JPanel();
      // panel du joueur
      private JPanel casejoueur = new JPanel();
      // panel de l'adversaire
			private JPanel caseadv = new JPanel();
    // panel de gauche
		private JPanel gauche = new JPanel();
      // panel de display de message
      private JPanel gauchehaut = new JPanel();
      // panel de gauche en bas
        // placement des bateaux
        private JPanel beforeStart = new JPanel();
        // jeu
        private JPanel afterStart = new JPanel();

   // Déclarations des boutons pour les Panels
    //pour le joueur et l'adversaire
    private JButton[][] boutonJoueur = new JButton[11][11];
    private JButton[][] boutonAdv = new JButton[11][11];
    // bouton nécessaire pour les Panels
    private JButton startButton =  new JButton("Start");
    private JButton validerButton = new JButton("Valider");
    private JButton[] bateaux = new JButton[5]; //il y a 5 bateaux

  // Déclarations des radioButtons utilisés dans le panel afterStart
    private JRadioButton[] radioButtons = new JRadioButton[5];

  // entier pour gérer les cliques sur les bateaux
  private int[] etatBateaux = new int[5]; // pour vérifier s'ils ont été attribués, ou non


  public Fenetre(){
  super();
  // initialisation des values et on met dans les panels

  // initialisation du Panel général
  this.setTitle("Bataille Navale");
  setLocationRelativeTo(null);
  setResizable(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(new Dimension(1000,600));

  // initialisation du Panel casejoueur
  casejoueur.setPreferredSize(new Dimension(900,300));
  casejoueur.setLayout(new GridLayout(11,11));

  // initialisation du Panel caseadv
  caseadv.setPreferredSize(new Dimension(900,300));
  caseadv.setLayout(new GridLayout(11,11));

  // initialisation du panel de droite
  droite.setPreferredSize(new Dimension(1000,600));
  droite.setLayout(new GridLayout(2,1));
  droite.add(caseadv);
  droite.add(casejoueur);


  // initialisation du Panel beforeStart
  beforeStart.setPreferredSize(new Dimension(300,600));;
  beforeStart.setLayout(new GridLayout(6,1));

  // initialisation du Panel afterStart
  afterStart.setLayout(new GridLayout(6,1));

  // initialisation du Panel de gauche en haut
  gauchehaut.setPreferredSize(new Dimension(300,150));

  // initialisation du Panel de gauche
  gauche.setPreferredSize(new Dimension(300,300));
  gauche.setLayout(new GridLayout(2,1));
  gauche.add(gauchehaut);
  //gauche.add(afterStart);
  gauche.add(beforeStart);

  // tout mettre en visible, dans le panel principal
  this.setLayout(new GridLayout(1,2));
  this.add(gauche, BorderLayout.EAST);
  this.add(droite, BorderLayout.WEST);
  this.setVisible(true);
  this.setBackground(Color.BLACK);


  // Initialisation des boutons
  // boutons pour joueur et l'adversaire
  for (int i=0 ; i<11 ; i++) {
   for (int j=0 ; j<11 ; j++ ) {
	   boutonJoueur[i][j] = new JButton("");
	   boutonAdv[i][j] = new JButton("");

      if (i == 0 && j == 0) { //première case avec rien
        boutonJoueur[i][j].setText("");
        boutonJoueur[i][j].setEnabled(false);
        boutonJoueur[i][j].setBackground(Color.BLACK);
        boutonAdv[i][j].setText("");
        boutonAdv[i][j].setEnabled(false);
        boutonAdv[i][j].setBackground(Color.BLACK);
      }
      else if(i == 0){
        boutonJoueur[i][j].setText("A");
        boutonJoueur[i][j].setEnabled(false);
        boutonJoueur[i][j].setBackground(Color.BLACK);
        boutonAdv[i][j].setText("A");
        boutonAdv[i][j].setEnabled(false);
        boutonAdv[i][j].setBackground(Color.BLACK);
      }
      else if(j == 0){
    	boutonJoueur[i][j].setText("1");
        boutonJoueur[i][j].setEnabled(false);
        boutonJoueur[i][j].setBackground(Color.BLACK);
        boutonAdv[i][j].setText("1");
        boutonAdv[i][j].setEnabled(false);
        boutonAdv[i][j].setBackground(Color.BLACK);

      } else{
    	  boutonJoueur[i][j].setText("");
          boutonJoueur[i][j].addActionListener(this);
          boutonAdv[i][j].setText("");
          boutonAdv[i][j].addActionListener(this);
          // de base, on désactive les boutons des cases adverses
          boutonAdv[i][j].setEnabled(false);;
      }

  		casejoueur.add(boutonJoueur[i][j]);
  		caseadv.add(boutonAdv[i][j]);
    }

  }

  // boutons pour le panel beforeStart
  bateaux[0] = new JButton("Porte-Avion");
  bateaux[1] = new JButton("Croiseur");
  bateaux[2] = new JButton("Croiseur");
  bateaux[3] = new JButton("Torpilleur");
  bateaux[4] = new JButton("Torpilleur");

  for(int i=0; i<5; i++){
	  bateaux[i].addActionListener(this);
	  beforeStart.add(bateaux[i]);
  }
  startButton.addActionListener(this);
  startButton.setBackground(Color.GREEN);
  beforeStart.add(startButton);

  //radio boutons pour le afterStart
  radioButtons[0] = new JRadioButton("Coup dans l'eau");
  radioButtons[1] = new JRadioButton("Touché");
  radioButtons[2] = new JRadioButton("Porte-Avion coulé");
  radioButtons[3] = new JRadioButton("Torpilleur coulé");
  radioButtons[4] = new JRadioButton("Croiseur coulé");
  // cas de départ
  radioButtons[0].setSelected(true);
  radioButtons[1].setSelected(false);
  radioButtons[2].setEnabled(false);
  radioButtons[3].setEnabled(false);
  radioButtons[4].setEnabled(false);

  

  for(int i=0; i<5;i++){
	  radioButtons[i].addActionListener(this);
	  afterStart.add(radioButtons[i]);
  }
  validerButton.addActionListener(this);
  validerButton.setBackground(Color.GREEN);
  afterStart.add(validerButton);

  System.out.println("Fin initialisation");

  }

  public void actionPerformed(ActionEvent e){
  Object source = e.getSource();

  if(source == startButton){

    // TODO: ne pas oublier de check que les 5 bateaux ont été placés
    gauche.remove(beforeStart);
    gauche.add(afterStart, BorderLayout.SOUTH);
    gauche.invalidate();
    gauche.validate();
    // On active les boutons pour le joueur adversaire
	  for(int i=1; i<11;i++){
		  for(int j=1; j<11;j++){
			  boutonAdv[i][j].setEnabled(true);
		  }
		 }
  }// on règle les radioButtons
  else if(source == radioButtons[1]){

   if(radioButtons[1].isSelected()){
     radioButtons[0].setSelected(false);
     radioButtons[2].setEnabled(true);
     radioButtons[3].setEnabled(true);
     radioButtons[4].setEnabled(true);
     gauche.invalidate();
     gauche.validate();
   } else {
     radioButtons[0].setSelected(true);
     radioButtons[2].setSelected(false);
     radioButtons[3].setSelected(false);
     radioButtons[4].setSelected(false);
     radioButtons[2].setEnabled(false);
     radioButtons[3].setEnabled(false);
     radioButtons[4].setEnabled(false);
     gauche.invalidate();
     gauche.validate();
   }
  }
  else if(source == radioButtons[0]){
   if(radioButtons[0].isSelected()){
     radioButtons[1].setSelected(false);
     radioButtons[2].setSelected(false);
     radioButtons[3].setSelected(false);
     radioButtons[4].setSelected(false);
     radioButtons[2].setEnabled(false);
     radioButtons[3].setEnabled(false);
     radioButtons[4].setEnabled(false);
     gauche.invalidate();
     gauche.validate();

   }else{
     radioButtons[1].setSelected(true);
     radioButtons[2].setEnabled(true);
     radioButtons[3].setEnabled(true);
     radioButtons[4].setEnabled(true);
     gauche.invalidate();
     gauche.validate();
   }
  }
  else if(source == radioButtons[2]){

   if(radioButtons[2].isSelected()){
     radioButtons[3].setSelected(false);
     radioButtons[4].setSelected(false);
     radioButtons[1].setSelected(true);
     //
     radioButtons[0].setSelected(false);
   }
  }
  else if(source == radioButtons[3]){
   if(radioButtons[3].isSelected()){
     radioButtons[2].setSelected(false);
     radioButtons[4].setSelected(false);
     radioButtons[1].setSelected(true);
     //
     radioButtons[0].setSelected(false);
   }
  }
  else if(source == radioButtons[4]){
     if(radioButtons[4].isSelected()){
       radioButtons[2].setSelected(false);
       radioButtons[3].setSelected(false);
       radioButtons[1].setSelected(true);
       //
       radioButtons[0].setSelected(false);

     }
   }
  else if(source == validerButton){
	  //TODO: implémenter le bouton validation
	  // avec une case sélectionné
	  // tout les cas
	  if(radioButtons[0].isSelected()){
		  // TODO: coup dans l'eau
	  } else if(radioButtons[1].isSelected() && radioButtons[2].isSelected()) {
		  //TODO: touché + porte avion coulé
		  
	  } else if(radioButtons[1].isSelected() && radioButtons[3].isSelected()) {
		  //TODO: touché + torpilleur coulé
		  
	  } else if(radioButtons[1].isSelected() && radioButtons[2].isSelected()) {
		  //TODO: touché + croiseur coulé
		  
	  } else if(radioButtons[1].isSelected()) {
		  //TODO: touché
		  
	  } else {
		  // TODO: cas problématique: aucune sol
	  }

  }
  else {
	//TODO: pour les bateaux
	  // pour chaque bateau, on veut construire celui du joueur

	  //TODO:
	  // boutons beforeStart: sert à placer les bateaux
	  // boutons afterStart: sert à tirer, ou regarder les tirs
	  // boutons adversaire/joueur
	  
	  //beforeStart: choix des bateaux
	  for(int i=0; i<5;i++){
		  if(source == bateaux[i]){

			  if(etatBateaux[i] == 0){
				  System.out.println("bateau" + i +" selectionne");
				  // on vient de sélectionner le bateau
				  // on vérifie qu'aucun autre bateau n'est sélectionné
				  int autrebateauxselectionné = 0;
				  for(int j=0; j<5;j++){
					  if(i !=j && etatBateaux[j] == 1){
						  autrebateauxselectionné = 1;  
					  }
				  }

				  if(autrebateauxselectionné !=1){

					  // si aucun d'autre bateau n'est sélectionné, on le sélectionne
					  etatBateaux[i] = 1;// on le sélectionne
					  bateaux[i].setBackground(Color.WHITE);
					     gauche.invalidate();
					     gauche.validate();
					  
				  }
			  } else if(etatBateaux[i] == 1){
				  // on vient de déselectionner le bateau
				  bateaux[i].setBackground(null);
				  etatBateaux[i] = 0;
				  
			  } else if(etatBateaux[i] == 2){
				  // deja réglé
				 
				  // faire le cas ou étatsBateaux[i] = 2
				  // quand il vaut 2, dans lautre, il faudra le mettre en noir et le disable
				  
			  } else{
				  // ou on a fini de le selectionné et on fait de la merde
			  }
		  }
	  }
	  
	  for(int i=1; i<11;i++){
		  for(int j=1; j<11;j++){
			  if(source == boutonJoueur[i][j]){
				  //TODO: un bouton a été cliqué
				  // nécessaire variable start pour savoir si on est avec le panel before ou after
				  
			  } else if(source == boutonAdv[i][j]){
				  //TODO: un bouton a été cliqué
				  // nécessaire variable start pour savoir si on est avec le panel before ou after
				  
			  }
		  }
	  }
	  
  }
	  

  


  }

}

// TODO: faire en sorte que si le joueur doit jouer, de grisé les cases adversaires
