package nimala.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import nimala.model.Game;
import nimala.view.BoardView;
import nimala.view.GameView;

public class GameController implements MouseListener {

private GameView gv;
	
	public GameController(GameView gv){
		this.gv = gv;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX()/BoardView.SIZE+1;
		int y=e.getY()/BoardView.SIZE+1;
		//System.out.println("("+x+","+y+")");
		if(10==gv.getGame().getBoard().GetBoardBlock(x, y))
		{
			gv.getGame().MoveBoat(Game.current_pid,new int[] {x,y});
		}
		else if(1==gv.getGame().getBoard().GetBoardBlock(x, y))
		{
			if(1!=gv.getGame().current_pid)
			{
				gv.getGame().fight(gv.getGame().current_pid, 1);
			}
		}
		else if(2==gv.getGame().getBoard().GetBoardBlock(x, y))
		{
			if(2!=gv.getGame().current_pid)
			{
				gv.getGame().fight(gv.getGame().current_pid, 2);
			}
		}
		else if(3==gv.getGame().getBoard().GetBoardBlock(x, y))
		{
			if(3!=gv.getGame().current_pid)
			{
				gv.getGame().fight(gv.getGame().current_pid, 3);
			}
		}
		gv.getBv().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
