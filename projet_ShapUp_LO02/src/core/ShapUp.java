package core;

import java.util.Scanner;
/**
 * Starts the Shape Up game. Provides a clean exit to the user.
 */
public class ShapUp {
	public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
    	char playing;
    	
    	System.out.println("Bienvenue dans le jeu Shap'Up !");
		
    	do {
    		System.out.println("Lancer une partie ? y/n");
    		playing = scanner.next().charAt(0);
    		
    		if(playing=='y') {
				GameMaster currentGame = new GameMaster();
				GameController gameController = new GameController(currentGame, currentGame.graphical);
				currentGame.instantiatePlayers(gameController);
    			currentGame.play();
    			currentGame=null;
    		}
    	}while(playing!='n');
    	
    	scanner.close();
    }
}
