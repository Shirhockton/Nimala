package nimala.model;

public class Board {
	//关于board的说明：
	//每格不同的数字表示不同的状态
	//0——空，1——一号玩家的船只，2——2号玩家的船只，3——3号玩家的船只，99——暗礁，100——无人岛，101——boss
	public final static int WIDTH = 15;
	public final static int LONG=30;
		public int getWidth() {
		return WIDTH;
	}
	public int getLong() {
		return LONG;
	}
		private int[][] blocks;
		private int size;
 
		public Board() {
			this.blocks = new int[WIDTH][];
			for(int i=0; i<WIDTH; i++){
				this.blocks[i] = new int[LONG];
			}
			
			for(int i=0; i<WIDTH; i++){
				for(int j=0; j<LONG; j++){
					this.blocks[i][j] = 0;
				}
			}
			for(int i=0;i<WIDTH;i++) {
				for(int j=0;j<7;j++)
				{
					this.blocks[i][j]=99;
					this.blocks[7][j]=0;
				}
			}
		}
		public int GetBoardBlock(int x,int y) {
			if((x>0)&&(x<16)&&(y>0)&&(y<31))
			{
				return this.blocks[x-1][y-1];
			}
			else {
				return 0;
			}
		}
		public void SetBoardBlock(int x,int y,int z)
		{
			if((x>0)&&(x<16)&&(y>0)&&(y<31))
			this.blocks[x-1][y-1]=z;
		}
		public String toString(){
			String s = "---\n|";
			for(int i=0;i<WIDTH;i++){
				for(int j=0;j<LONG;j++){
					s += this.blocks[i][j]+"|";
				}
				s += "\n";
			}
			s += "---";
			return s;
		}
	
}
