
package core;

class PlayerH extends Player {
	public PlayerH(String name) {super(name);}
//methods
	//job specific
	public void askMove(Card pickedCard) {
		System.out.println(this.playingGridAdress.toString());
		System.out.print("\ncarte piochée :");
		pickedCard.display();
		System.out.println();
		
		boolean choice1done=false;
		boolean choice2done=false;
		boolean turnFinished=false;
		
		int choice=-1;
		do
		{
			if(choice1done)
			{
				do {
					System.out.println(this.playingGridAdress.toString());
					System.out.println("Que veux-tu faire :");
					System.out.println("2 - Déplacer une carte déjà sur le jeu");
					System.out.println("3 - Finir mon tour");
					choice = ShapUp.scanner.nextInt();
				}while(!(choice==2 || choice==3));
				if(choice==3) turnFinished=true;
			}
			
			if(!choice1done)
				do {
					System.out.println("Que veux-tu faire :");
					System.out.println("1 - Jouer la carte que tu as pioché");
					System.out.println("2 - Déplacer une carte déjà sur le jeu");
					choice = ShapUp.scanner.nextInt();
				}while(!(choice==1 || choice==2));
			
			if(choice==1 && !choice1done)
			{
				int x;
				int y;
				do {
					System.out.println("Où veux-tu la jouer ?");
					String choicePlace = ShapUp.scanner.next().trim();
					
					while (!choicePlace.matches("^[0-9],[0-9]$")) {
						System.out.println("Mauvaise saisie, où veux-tu la jouer ?");
						System.out.println("Exemple : 1,7");
						choicePlace = ShapUp.scanner.next().trim();
					}
					x = Integer.valueOf(choicePlace.split(",")[0]);
					y = Integer.valueOf(choicePlace.split(",")[1]);
				} while (!this.playingGridAdress.testSettingTile(x, y));
				
				this.playingGridAdress.setTile(x, y, pickedCard);
				choice1done=true;
			}
			
			if(choice==2 && !choice2done)
			{
				System.out.println(this.playingGridAdress.toString());
				int xSrc;
				int ySrc;
				int xDest;
				int yDest;
				do {
					System.out.println("\nQuelle carte veux-tu déplacer ?");
					String choiceMove = ShapUp.scanner.next().trim();
					
					while (!choiceMove.matches("^[0-9],[0-9]:[0-9],[0-9]$")) {
						System.out.println("Mauvaise saisie, quel carte veux-tu déplacer ?");
						System.out.println("Exemple : 1,3:(vers)6,7");
						choiceMove = ShapUp.scanner.next().trim();
					}//TODO truc bizarre avec les tests
					xSrc = Integer.valueOf(choiceMove.split(":")[0].split(",")[0]);
					ySrc = Integer.valueOf(choiceMove.split(":")[0].split(",")[1]);
					xDest = Integer.valueOf(choiceMove.split(":")[1].split(",")[0]);
					yDest = Integer.valueOf(choiceMove.split(":")[1].split(",")[1]);
				} while(!this.playingGridAdress.testSettingTile(xDest, yDest));//TODO appel fonc à changer
				this.playingGridAdress.moveTile(xSrc, ySrc, xDest, yDest);
				choice2done=true;
			}
			
		}while(!(choice1done && turnFinished));
		this.currentScore=this.playingGridAdress.calculateScore(victoryCard);
	}
}
