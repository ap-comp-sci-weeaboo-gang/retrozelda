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
		enemies.get(1).add(new OldMan());
		enemies.get(2).add(new Octorok(710,425));
		enemies.get(2).add(new Octorok(710,350));
		enemies.get(2).add(new Octorok(710,275));
		enemies.get(2).add(new Octorok(710,200));
		
	}

	protected void enemyMove() {
		time++;
		for (int i = 0; i < enemies.get(envo.mapDecider()).size(); i ++) {
			((Character) enemies.get(envo.mapDecider()).get(i)).movePattern(link);
		}
		
	}

	protected void attack() {
		ticks++;
		//if (ticks % 100 != 0) {
		attackCheck();
		link.falseSpace();
		attack.restart();
		//}
		
	}

	protected void updateGame() {
		//System.out.println(t);
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
		
		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");

			}

			
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		panel.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
        
        panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
        panel.getActionMap().put("space", new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                hit("space");
            }
        });
	}
	public  void hit(String s) {
		link.keyHit(s);
		if (s.equals("space")) {
			attack.start();
		}
		panel.repaint();
	}
	
	private void attackCheck() {
		for(int i = 0; i < enemies.get(envo.mapDecider()).size(); i++) {
			if (link.getSwordRect().intersects(((Character) enemies.get(envo.mapDecider()).get(i)).getRect()) && link.getSpace() == true) {
				((Character) enemies.get(envo.mapDecider()).get(i)).setDead(false);
				enemies.get(envo.mapDecider()).remove(i);
			}
		}
	}

	protected void drawAll(Graphics g) {
		envo.draw(g);
		link.draw(g);
		for (int i = 0; i < enemies.get(envo.mapDecider()).size(); i ++) {
			((Character) enemies.get(envo.mapDecider()).get(i)).draw(g);
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
