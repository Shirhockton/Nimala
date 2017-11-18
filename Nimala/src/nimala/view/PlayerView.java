package nimala.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import nimala.model.Player;

public class PlayerView extends JPanel{
	/**玩家*/
	private Player player;
	/** 玩家名称标签  */
	private JLabel nameV;
	/** 玩家id标签  */
	private JLabel idV;
	/** 当前面板是否显示边框  */
	private boolean active=false;
	
	public PlayerView(Player p) {
		this.player=p;
		this.setLayout(new GridLayout(2,1));
		this.setBorder(new LineBorder(new Color(0,0,0))); 
		this.setSize(20,20);
		this.setVisible(true);
		nameV=new JLabel(p.getName());
		idV=new JLabel(p.getPid()+"");
		active=false;
		this.add(nameV);
		this.add(idV);
	}
	public void setActive() {
	if(this.active) {
	    this.setBorder(new LineBorder(new Color(255,0,0))); 
	}
	else
		this.setBorder(new LineBorder(new Color(0,0,0))); 
		
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
