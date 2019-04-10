
import java.util.Scanner;
import java.util.ArrayList;


public class TestAIVsAI{


	public static void main(String[] args){
		System.out.println("Constructing AI white Level 0 vs. black Level 1");
        AIPlayerForTest computer1 = new AIPlayerForTest(0);
        AIPlayerForTest computer2 = new AIPlayerForTest(1);

        Scanner keyboard = new Scanner(System.in);
        boolean validIterations = false;
        int numIterations = 0;
        while (!validIterations){
        	System.out.print("Enter number of iterations: ");
            numIterations = Integer.parseInt(keyboard.nextLine());
            if (numIterations > 0 && numIterations < 100){
                validIterations = true;
            }
            else {
            	System.out.print("Invalid Input. Number must be between ");
            	System.out.println("0 and 100 (exclusive).");
            	System.out.println("");
            }
        }


        System.out.println("");
        // this stores all the win condition strings
        ArrayList<String> gameConditions = new ArrayList<String>();
        String s;

        for (int i = 1; i < numIterations + 1; i++){
        	GameSet thePieces = new DefaultGameSet();
        	Board theBoard = new Board(thePieces);
        	GameDynamicsForTest theGame = new GameDynamicsForTest(computer1,
        	    computer2);
        	theGame.runMultiplayerAI(thePieces, theBoard, computer1,
        		computer2);
            s = theGame.winCondition(thePieces, theBoard);
            gameConditions.add(s);
            System.out.print("Finished game "+i+": ");
            System.out.println(s);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Record for AI white Level 0 vs. black Level 1");
        for (int i = 0; i < gameConditions.size(); i++){
        	System.out.println(gameConditions.get(i));
        }

	}

}
