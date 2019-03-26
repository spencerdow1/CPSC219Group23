
public abstract class Player{

	private String name;

	public Player(String name) {
		setName(name);
	}

	public Player(Player aPlayer){
        setName(aPlayer.getName());
	}

	public String getName(){
		String copyName = name;
		return copyName;
	}

	public void setName(String aName){
		name = aName;
	}

}
