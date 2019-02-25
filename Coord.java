public class Coord{

	private int x;
	private int y;

	public Coord(){

		this.x = 0;
		this.y = 0;

	}

	public Coord(int initialX, int initialY){
		this.x = initialX;
		this.y = initialY;

	}

	public void setX(int x){
		this.x = x;
        
	}


	public int getX(){
		int copyX = this.x;
        return copyX;
	}

	public void setY(int y){
		this.y = y;

	}


	public int getY(){
		int copyY = this.y;
        return copyY;
	}


}

