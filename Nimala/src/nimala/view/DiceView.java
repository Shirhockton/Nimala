package nimala.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nimala.model.Game;
import nimala.model.Player;

public class DiceView extends JPanel{
	private PlayerView[] playersView=new PlayerView[Game.PLAYERS_NUMBER];

	private JButton btn_dice=new JButton("Dice");
	private JLabel dic_number_label=new JLabel("0");
	
	
	private int dic_number;
	private Random rand=new Random();
	private Game game;
	public DiceView(GameView gv) {
		this.game=gv.getGame();
		this.setLayout(new BorderLayout());
		this.setSize(400, 300);
		
		
		JPanel northPanel=new JPanel();
		JPanel centerPanel=new JPanel();
		for(int i=0;i<playersView.length;i++) {
			playersView[i]=new PlayerView(game.getPlayers()[i]);
			northPanel.add(playersView[i]);
		}
		centerPanel.add(btn_dice);
		centerPanel.add(dic_number_label);
		this.add(northPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
		btn_dice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dic_number=rand.nextInt(6)+1;
				dic_number_label.setText(dic_number+"");
				switch(Game.current_pid) {
				case 1:
					playersView[0].setActive(true);
					playersView[1].setActive(false);
					playersView[2].setActive(false);
					Game.current_pid++;
					break;
			    case 2:
					for(int i=0;i<Game.PLAYERS_NUMBER;i++) {
						if(Game.current_pid==i+1) {
							playersView[i].setActive(true);
						}
						else playersView[i].setActive(false);
					}
					Game.current_pid++;
					break;
				case 3:
					for(int i=0;i<Game.PLAYERS_NUMBER;i++) {
						if(Game.current_pid==i+1) {
							playersView[i].setActive(true);
						}
						else playersView[i].setActive(false);
					}
					Game.current_pid=1;
					break;
				}
				for(int i=0;i<Game.PLAYERS_NUMBER;i++) {
					playersView[i].setActive();
				}
				game.SetAvailiableBlock(game.current_pid, dic_number);
				gv.repaint();
			}
			
		});
	}
	
//	public static void main(String[] args) {
//		DiceView d=new DiceView();
//		JFrame f=new JFrame();
//		f.setSize(400, 300);
//		Container c=f.getContentPane();
//		c.add(d);
//		f.setVisible(true);
//
//	}

}