package nimala.model;

public class Game {
	public static final int PLAYERS_NUMBER = 3;
	public static int current_pid=1;
	
	private Board board;
	private Board board_face;
	private Boat[] boats;
	private int[][] positions;
	private Player[] players=new Player[PLAYERS_NUMBER];
	
	public Game()
	{
		players[0]=new Player("甲",1);
		players[1]=new Player("乙",2);
		players[2]=new Player("丙",3);
		this.positions=new int[3][2];
		this.positions[0]=new int[] {3,30};
		this.positions[1]=new int[] {8,30};
		this.positions[2]=new int[] {13,30};
		this.board=new Board();
		this.board_face=this.board;
		this.boats=new Boat[3]; 
		boats[0]=new Boat(this.positions[0],1);
		boats[1]=new Boat(this.positions[1],2);
		boats[2]=new Boat(this.positions[2],3);
		this.PutBoat(boats[0]);
		this.PutBoat(boats[1]);
		this.PutBoat(boats[2]);
	}
	
	
	
	public int fight(int id1,int id2)
	{
		return id1;
	}
	
	
	public Board getBoard_face() {
		return board_face;
	}
	public void setBoard_face(Board board_face) {
		this.board_face = board_face;
	}
	public void PutBoat(Boat b)
	{
		this.board.SetBoardBlock(b.getPosition()[0], b.getPosition()[1], b.getId());
	}
	public void MoveBoat(int id,int[] position) {
		for(int i=1; i<Board.WIDTH+1; i++){
			for(int j=1; j<Board.LONG+1; j++){
				if(10==this.board.GetBoardBlock(i, j))
				{
					this.board.SetBoardBlock(i, j, 0);
				}
			}
		}
		this.board.SetBoardBlock(this.boats[id-1].getPosition()[0],this.boats[id-1].getPosition()[1], 0);
		this.boats[id-1].setPosition(position);
		PutBoat(this.boats[id-1]);
	}
	public Boat[] getBoats() {
		return boats;
	}
	public void setBoats(Boat[] boats) {
		this.boats = boats;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public void SetAvailiableBlock(int current_id,int dice) {
		for(int j=-dice;j<dice+1;j++)
		{
			if(j<=0)
			{
				for(int i=-dice-j;i<=dice+j;i++)
				{
					if(0==this.board.GetBoardBlock(this.boats[current_id-1].getPosition()[0]+i,
							this.boats[current_id-1].getPosition()[1]+j))
					{
						this.board.SetBoardBlock(this.boats[current_id-1].getPosition()[0]+i, 
								this.boats[current_id-1].getPosition()[1]+j,10);
					}

				}
			}
			else {
				for(int i=-dice+j;i<=dice-j;i++)
				{
					if(0==this.board.GetBoardBlock(this.boats[current_id-1].getPosition()[0]+i,
							this.boats[current_id-1].getPosition()[1]+j))
					{
						this.board.SetBoardBlock(this.boats[current_id-1].getPosition()[0]+i, 
								this.boats[current_id-1].getPosition()[1]+j,10);
					}

				}
			}
		}
		this.board.SetBoardBlock(this.boats[current_id-1].getPosition()[0], 
				this.boats[current_id-1].getPosition()[1],this.boats[current_id-1].getId());
	}
}
