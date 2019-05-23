import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.io.*;
import java.util.ArrayList;

import javax.sound.sampled.*;


public class ZeldaRunner {
	public static Player link = new Player();
	JPanel panel;
	ArrayList<ArrayList> enemies = new ArrayList<ArrayList>();
	Timer timer;
	Timer attack;
	Timer enemy;
	// hope this works
    Environment envo = new Environment(link);
    Inventory inv=new Inventory(link);
	boolean soundOn=false;
	boolean alive=true;
	static Clip audio;
	int t = 0;
	int ticks = 1;
	int time;
	Clip audioAlive=get("overworld.wav");
	Clip audioDungeon=get("dungeon.wav");
	Clip audioGameOver=get("gameover.wav");
	
	public static void main(String[] args) {
		new ZeldaRunner().start();
	}

	private void start() {
		buildList();
		JFrame frame = new JFrame("Runner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawAll(g);
			}
		};
		panel.setPreferredSize(new Dimension(800,600));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(150, 0);
		frame.setSize(800, 600);
		mapKeyStrokesToActions(panel);
		Inventory.setImages();
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				panel.repaint();
			}
		});
		timer.start();
		
		attack = new Timer(300, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attack();
				panel.repaint();
			}
		});
		enemy = new Timer(200, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enemyMove();
				panel.repaint();
			}
		});
		enemy.start();
	}

	//@SuppressWarnings("unchecked")
	private void buildList() {
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.add(new ArrayList<Character>());
		enemies.get(1).add(new OldMan());
		
		enemies.get(2).add(new Octorok(354,473, 0));
		enemies.get(2).add(new Octorok(409,113, 1));
		enemies.get(2).add(new Octorok(711,113, 0, 3));
		
		enemies.get(3).add(new Tektite(460,300,1));
		enemies.get(3).add(new Tektite(409,237,0));
		enemies.get(3).add(new Tektite(507,238,2));
		enemies.get(3).add(new Tektite(400,339,3));
		enemies.get(3).add(new Tektite(507,352,1));
		
		enemies.get(4).add(new Tektite(205,324,0));
		enemies.get(4).add(new Tektite(591,309,2));
		enemies.get(4).add(new Peahat(387,296,1));
		enemies.get(4).add(new Peahat(387,296,2));
		enemies.get(4).add(new Peahat(387,296,3));
		
		enemies.get(5).add(new Keese(600,186));
		enemies.get(5).add(new Keese(379,227));
		enemies.get(5).add(new Keese(528,400));
		
		enemies.get(6).add(new Keese(400,200));
		enemies.get(6).add(new Keese(300,400));
		enemies.get(6).add(new Peahat(630,220,2));
		enemies.get(6).add(new Peahat(630,220,3));
		
		enemies.get(8).add(new Moblin(300,300));
		enemies.get(8).add(new Moblin(500,120));
		enemies.get(8).add(new Octorok(450,145, 1));
		enemies.get(8).add(new Octorok(240,460, 0));
		
		enemies.get(9).add(new Moblin(300,300));
		enemies.get(9).add(new Moblin(500,120));
		enemies.get(9).add(new Octorok(450,145, 1));
		enemies.get(9).add(new Octorok(240,460, 0));
		
		enemies.get(10).add(new Peahat(400, 300, 0));
		enemies.get(10).add(new Peahat(400, 300, 1));
		enemies.get(10).add(new Peahat(400, 300, 2));
		enemies.get(10).add(new Peahat(400, 300, 3));
		enemies.get(10).add(new Peahat(400, 300, 1));
		enemies.get(10).add(new Peahat(400, 300, 2));
		
		enemies.get(11).add(new Peahat(400, 300, 0));
		enemies.get(11).add(new Peahat(400, 300, 1));
		enemies.get(11).add(new Peahat(400, 300, 2));
		enemies.get(11).add(new Peahat(400, 300, 3));
		enemies.get(11).add(new Peahat(400, 300, 1));
		enemies.get(11).add(new Peahat(400, 300, 2));
		
		enemies.get(12).add(new Tektite(264, 184, 1));
		enemies.get(12).add(new Tektite(510, 184, 2));
		enemies.get(12).add(new Keese(144, 309));
		enemies.get(12).add(new Keese(530, 440));
		enemies.get(12).add(new Octorok(700, 160, 0, 3));
		
	}

	protected void enemyMove() {
		if (inv.getInventoryCondition()==false) {
			time++;
			for (int i = 0; i < enemies.get(envo.getMapDecider()).size(); i ++) {
				((Character) enemies.get(envo.getMapDecider()).get(i)).movePattern(link);
			}
		}
	}

	protected void attack() {
		ticks++;
		attackCheck();
		link.falseSpace();
		attack.restart();
		
	}

	protected void updateGame() {
		if (audioAlive.isRunning()==true||audioDungeon.isRunning()==true||audioGameOver.isRunning()==true) {
			soundOn=true;
		}else {
			soundOn=false;
		}
		if (soundOn==false&&alive==true) {
			audioAlive.loop(Clip.LOOP_CONTINUOUSLY);
		}
		if (soundOn==false&&alive==false) {
			audioGameOver.start();
		}
		if (alive==false) {
			if (audioAlive.isRunning()==true) {
				audioAlive.stop();	
			}
			audioGameOver.start();
		}
		t++;
		}

	private void mapKeyStrokesToActions(JPanel panel) {
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();
		
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");

			}

			
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("A"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("D"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("S"),"down");
		panel.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
        
        panel.getInputMap().put(KeyStroke.getKeyStroke("J"), "space");
        panel.getActionMap().put("space", new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                hit("space");
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("K"), "inv");
		panel.getActionMap().put("inv", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (link.getCollected() == true) {
					inv.changeInvCondition();
					link.setItem(inv.getCurrentItem());
				}

			}
		});
	}
	public  void hit(String s) {
		if (inv.getInventoryCondition()==true&&s.equals("right")) {
			inv.itemMoveRight();
		}
		if (inv.getInventoryCondition()==true&&s.equals("left")) {
			inv.itemMoveLeft();
		}
		if (inv.getInventoryCondition()==false) {
			link.keyHit(s);
			if (s.equals("space")) {
				attack.start();
			}//if inv is on change playerselected
			panel.repaint();
		}
	}
	
	private void attackCheck() {
		for(int i = 0; i < enemies.get(envo.getMapDecider()).size(); i++) {
			if (link.getSwordRect().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect()) && link.getSpace() == true) {
				if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
					if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
							&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))) {
						((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
						enemies.get(envo.getMapDecider()).remove(i);
					}
				}
			}
		}
	}

	protected void drawAll(Graphics g) {
		envo.draw(g);
		link.draw(g);
		if (envo.getMapDecider() == 1) {
			((OldMan) enemies.get(1).get(0)).checkSword(link);
		}
		System.out.println(envo.getMapDecider());
		for (int i = 0; i < enemies.get(envo.getMapDecider()).size(); i ++) {
			((Character) enemies.get(envo.getMapDecider()).get(i)).draw(g);
		}
		if (link.getCollected() == true) {
			inv.draw(g);
		}
	}
	public static Clip get(String filename){
		Clip audios = null;
		try
	    {
	        audios = AudioSystem.getClip();
	        audios.open(AudioSystem.getAudioInputStream(new File(filename)));
	        return audios;
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
		return audios;
	}
	/*public boolean checkWav(String filename){
		try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        if(clip.isActive()==true) {
		    	return true;
	        	}
	        	return false;   	
		   // }
	   // }
	    //catch (Exception exc)
	    {
	        //exc.printStackTrace(System.out);
	    }
	    
	}*/

}
