package nimala.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import nimala.model.Board;
import nimala.model.Game;


public class BoardView extends JPanel{
	public static final int SIZE = 20;
		private Board board;
		private Board board_face;
		
		public BoardView(Board b){
			this.board = b;
			this.board_face=b;
			this.setPreferredSize(new Dimension(SIZE*board.getWidth(),SIZE*board.getLong()));
			
		}
		
		@Override
		public void paint(Graphics g){
			super.paint(g);
		    Graphics2D g2 = (Graphics2D) g;
			this.makeLines(g2);
			this.makeBoats(g2);
			this.board_face=this.board;
		}
		
		public void makeLines(Graphics2D g){
			// TODO
			g.setFont(new Font("SansSerif", Font.PLAIN, 120));
			for(int i=0;i<board.getLong();i++)
			{
				g.drawLine(0, i*SIZE+SIZE,SIZE*board.getWidth() , i*SIZE+SIZE);
			}
			for(int i=0;i<board.getWidth();i++)
			{
				g.drawLine(i*SIZE+SIZE,0 ,i*SIZE+SIZE ,SIZE*board.getLong());
			}
			g.drawLine(0,0 ,SIZE*board.getWidth() ,0);
			g.drawLine(0,SIZE*board.getLong()-1 ,SIZE*board.getWidth() ,SIZE*board.getLong()-1);
			g.drawLine(0,0 ,0 ,SIZE*board.getLong());
			g.drawLine(SIZE*board.getWidth()-1,0 ,SIZE*board.getWidth()-1 ,SIZE*board.getLong());
		}
		public void makeBoats(Graphics2D g){
			// TODO
			g.setFont(new Font("SansSerif", Font.PLAIN, 18));
			for(int i=1; i<this.board.LONG+1; i++) {
				for(int j=1;j<this.board.WIDTH+1;j++) {
					if(1==this.board.GetBoardBlock(j, i)) {
						g.setColor(Color.black);
						g.drawString("O", j*SIZE-SIZE*8/9, i*SIZE-SIZE*1/9);
					}
					if(2==this.board.GetBoardBlock(j, i)) {
						g.setColor(Color.black);
						g.drawString("a", j*SIZE-SIZE*8/9, i*SIZE-SIZE*1/9);
					}
					if(3==this.board.GetBoardBlock(j, i)) {
						g.setColor(Color.black);
						g.drawString("b", j*SIZE-SIZE*8/9, i*SIZE-SIZE*1/9);
					}
					if(99==this.board.GetBoardBlock(j, i)) {
						g.setColor(Color.black);
						g.drawString("■", j*SIZE-SIZE*8/9, i*SIZE-SIZE*1/9);
					}
					if(10==this.board.GetBoardBlock(j, i)) {
						g.setColor(Color.blue);
						g.drawString("□", j*SIZE-SIZE*8/9, i*SIZE-SIZE*1/9);
					}
				}
			}
			
		}


		
		public Board getBoard() {
			return board;
		}

		public void setBoard(Board board) {
			this.board = board;
		}
		
public static void main(String[] args) {
			GameView g=new GameView("尼玛拉",new Game());

			//System.out.println(b.toString());
			
		}
	}


