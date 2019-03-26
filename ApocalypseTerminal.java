
public class ApocalypseTerminal{

	public static void main(String args[]){
		System.out.println(""); System.out.println("");
        System.out.println("WELCOME TO TERMINAL BASED APOCALYPSE");
        System.out.println(""); System.out.println("");

        // FILL IN // option to print rules to the terminal

        // Instantiate single or multi-player mode
        System.out.print("Single or Multi-Player? (S/M):  S");
        System.out.println("");

        // if single player, choose difficulty
        System.out.println("Choose difficulty; (0,1):  0");

        // instantiate players
        System.out.println("Player 1 enter name:  Peasant");
        System.out.println("");
        System.out.println("");


        /** GAME SECTION **/

        // create all the objects for the game
        GameSet gameSet = new DefaultGameSet();
        Board gameBoard = new Board(gameSet);
        GameDynamics game = new GameDynamics();

        gameBoard.printBoard();
        System.out.println("");

	}

}
