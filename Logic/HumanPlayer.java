package Logic;

public class HumanPlayer extends Player{
    /**
     * new human player
     */
    public HumanPlayer(){
    	super("A Human");
    }

    /**
     * creates a new human player with a unique
     * @param aName
     */
	public HumanPlayer(String aName){
        super(aName);
	}
}
