package Logic;

public abstract class Player{

	private String name;

	/**
	 * constructor that sets the player name
	 * @param name
	 */
	public Player(String name) {
		setName(name);
	}

	/**
	 * copy constructor
	 * @param aPlayer
	 */
	public Player(Player aPlayer){
        setName(aPlayer.getName());
	}

	/**
	 * gets the players name
	 * @return
	 */
	public String getName(){
		String copyName = name;
		return copyName;
	}

	/**
	 * sets the players name
	 * @param aName
	 */
	public void setName(String aName){
		this.name = aName;
	}

}
