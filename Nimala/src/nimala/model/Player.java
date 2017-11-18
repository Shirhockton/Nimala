package nimala.model;

public class Player {

	private String name;
	private int pid;
	
	public Player(String name,int pid) {
		this.name=name;
		this.pid=pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	
}