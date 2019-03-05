import java.util.Scanner;


public class Main {

    private Player white = new Player(PlayerTeam.White);
    private Player black = new Player(PlayerTeam.Black);
    private Board board = new Board();

    public void runGame(){

        //Set up Players
        System.out.print("Player 1 enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        white.setPlayerName(keyboard.nextLine());

        System.out.print("Player 2 enter your name: ");
        black.setPlayerName(keyboard.nextLine());

        System.out.println("White Player " + white.playerName + " vs " + "Black Player " + black.playerName);
        // Initialize Board
        board.printCurrentBoard();
        board.moveWithUserInput(board);




    }




    public static void main(String[] args){
        Main newGame = new Main();
        newGame.runGame();


    }

}

