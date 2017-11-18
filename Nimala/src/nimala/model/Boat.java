package nimala.model;

public class Boat {

	private int[] position;
	private int id;
	
	public Boat(int[] position,int id) {
		this.position=position;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
}
