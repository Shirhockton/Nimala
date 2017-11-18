package nimala.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nimala.controller.GameController;
import nimala.model.Game;

public class GameView extends JFrame{
	private Game game;
	private BoardView bv;
	private DiceView dv;
	private JPanel mv;
	public GameView(String name, Game g)
	{
		super(name);
		this.game = g;
		
		// 设置窗体属性
		this.setSize(new Dimension(300, 300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(400, 60);
		
		this.mv=new JPanel();
		this.dv=new DiceView(this);
		this.bv = new BoardView(this.game.getBoard());
		this.bv.addMouseListener(new GameController(this));
		this.mv.add(bv,BorderLayout.CENTER);
		this.mv.add(this.dv,BorderLayout.EAST);
		this.setContentPane(this.mv);
		
		this.pack();
		this.setVisible(true);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public BoardView getBv() {
		return bv;
	}
	public void setBv(BoardView bv) {
		this.bv = bv;
	}
}
