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
        System.out.println("Welcome to the Apocalypse Game!");
        System.out.println("Players will set their username");
        System.out.println("then they will take turns selecting moves to make");
        System.out.println("getting your pawn to the other side of the board will turn it into a knight");
        System.out.println("but the first player to lose all of their pawn loses!");
        System.out.println("be careful unlike normal chess both players moves will execute at the same time!");
        System.out.println("okay its time to play good luck have fun!");
        newGame.runGame();


    }

}

