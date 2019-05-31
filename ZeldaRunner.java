import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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

import javax.imageio.ImageIO;
import javax.sound.sampled.*;


public class ZeldaRunner {
	public static Player link = new Player();
	JPanel panel;
	ArrayList<ArrayList> enemies = new ArrayList<ArrayList>();
	ArrayList<Integer> itemX = new ArrayList<Integer>();
	ArrayList<Integer> itemY = new ArrayList<Integer>();
	ArrayList<String> drops = new ArrayList<String>();
	Timer timer;
	Timer attack;
	Timer enemy;
	Timer player;
	boolean moveable = true;
	// hope this works
	Environment envo = new Environment(link);
	Inventory inv=new Inventory(link);
	Dropables drop=new Dropables(link);
	boolean soundOn=false;
	boolean alive=true;
	int chance =0;
	static Clip audio;
	int t = 0;
	int ticks = 1;
	int time;
	int mapAt;
	int mapAt2
	int save;
	int save1;
	boolean enemyDeath=false;
	Clip audioAlive=get("overworld.wav");
	Clip audioDungeon=get("dungeon.wav");
	Clip audioGameOver=get("gameover.wav");
	Clip audioVictory=get("victory.wav");

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
		player = new Timer(200, new ActionListener() {		
			@Override		
			public void actionPerformed(ActionEvent arg0) {		
				if (moveable == false)		
					moveable = true;		
				panel.repaint();		
			}		
		});		
		player.start();
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

		enemies.get(11).add(new Goriya(124, 213));
		enemies.get(11).add(new Goriya(704, 239));
		enemies.get(11).add(new Goriya(400, 258));
		enemies.get(11).add(new Goriya(600, 440));

		enemies.get(12).add(new Tektite(264, 184, 1));
		enemies.get(12).add(new Tektite(510, 184, 2));
		enemies.get(12).add(new Keese(144, 309));
		enemies.get(12).add(new Keese(530, 440));
		enemies.get(12).add(new Octorok(700, 160, 0, 3));

		enemies.get(13).add(new Peahat(379, 298, 0));
		enemies.get(13).add(new Peahat(379, 298, 1));
		enemies.get(13).add(new Peahat(379, 298, 2));
		enemies.get(13).add(new Peahat(379, 298, 3));
		enemies.get(13).add(new Peahat(379, 298, 1));

		enemies.get(15).add(new Octorok(354,473, 0));
		enemies.get(15).add(new Octorok(508,113, 1));
		enemies.get(15).add(new Octorok(711,113, 0, 3));

		enemies.get(16).add(new Octorok(206, 117, 1));
		enemies.get(16).add(new Keese(494, 192));
		enemies.get(16).add(new Keese(505, 402));
		enemies.get(16).add(new Octorok(658, 475, 0));

		enemies.get(17).add(new Octorok(355, 462, 0));
		enemies.get(17).add(new Octorok(100, 125, 1));
		enemies.get(17).add(new Tektite(620, 169, 0));
		enemies.get(17).add(new Tektite(452, 448, 3));

		enemies.get(18).add(new Moblin(282, 293));
		enemies.get(18).add(new Keese(404, 159));
		enemies.get(18).add(new Keese(145, 446));
		enemies.get(18).add(new Octorok(554, 466, 0));

		enemies.get(19).add(new Moblin(578, 146));
		enemies.get(19).add(new Peahat(307, 293, 0));
		enemies.get(19).add(new Peahat(307, 293, 2));
		enemies.get(19).add(new Peahat(307, 293, 3));

		enemies.get(20).add(new Octorok(210, 466, 1, 3));
		enemies.get(20).add(new Keese(377, 174));
		enemies.get(20).add(new Keese(616, 307));

		enemies.get(21).add(new Moblin(447, 207));
		enemies.get(21).add(new Goriya(216, 256));
		enemies.get(21).add(new Goriya(406, 456));
		enemies.get(21).add(new Moblin(643, 430));

		enemies.get(22).add(new Octorok(560, 470, 0));
		enemies.get(22).add(new Octorok(105, 132, 1));
		enemies.get(22).add(new Peahat(407, 319, 2));
		enemies.get(22).add(new Peahat(407, 319, 1));

		enemies.get(23).add(new Peahat(511, 298, 2));
		enemies.get(23).add(new Peahat(511, 298, 1));
		enemies.get(23).add(new Peahat(511, 298, 0));
		enemies.get(23).add(new Peahat(511, 298, 3));
		enemies.get(23).add(new Peahat(511, 298, 2));

		enemies.get(24).add(new Keese(95, 355));
		enemies.get(24).add(new Keese(450, 137));
		enemies.get(24).add(new Moblin(490, 306));

		enemies.get(25).add(new Keese(230, 274));
		enemies.get(25).add(new Keese(211, 459));
		enemies.get(25).add(new Goriya(430, 190));

		enemies.get(26).add(new Keese(390, 452));
		enemies.get(26).add(new Keese(507, 298));
		enemies.get(26).add(new Moblin(197, 286));

		enemies.get(27).add(new Octorok(354,473, 0));
		enemies.get(27).add(new Octorok(508,113, 1));
		enemies.get(27).add(new Octorok(253,128, 0));

		enemies.get(28).add(new Tektite(256, 292, 1));
		enemies.get(28).add(new Tektite(558, 292, 2));
		enemies.get(28).add(new Keese(410, 130));
		enemies.get(28).add(new Keese(410, 460));

		enemies.get(29).add(new Octorok(198, 130, 1));
		enemies.get(29).add(new Keese(609, 371));
		enemies.get(29).add(new Keese(350, 253));

		enemies.get(30).add(new Octorok(349, 148, 1));
		enemies.get(30).add(new Octorok(460, 514, 0));
		enemies.get(30).add(new Tektite(168, 203, 0));
		enemies.get(30).add(new Tektite(225, 474, 3));

		enemies.get(31).add(new Octorok(453, 133, 0, 3));
		enemies.get(31).add(new Octorok(553, 133, 1));
		enemies.get(31).add(new Keese(159, 207));
		enemies.get(31).add(new Keese(173, 407));

		enemies.get(32).add(new Octorok(97, 470, 1, 3));
		enemies.get(32).add(new Octorok(660, 470, 0));
		
		enemies.get(33).add(new Goriya(150, 170));
		enemies.get(33).add(new Goriya(200, 400));
		enemies.get(33).add(new Goriya(450, 400));
		enemies.get(33).add(new Goriya(500, 170));
		
		enemies.get(34).add(new Dodongo(200, 170));
		
		enemies.get(35).add(new Octorok(100, 117, 1));
		enemies.get(35).add(new Octorok(657, 117, 0, 3));
		
		enemies.get(36).add(new Gohma(370, 246));
	}

	protected void enemyMove() {
		if (inv.getInventoryCondition()==false) {
			time++;
			if (time - save == 3) {
				link.setInvincible(false);
			}
			for (int i = 0; i < enemies.get(envo.getMapDecider()).size(); i ++) {
				((Character) enemies.get(envo.getMapDecider()).get(i)).movePattern(link);
				if (((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().intersects(link.getRect()) 
						||  (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class) &&
								((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying() == false 
								&& ((Peahat) enemies.get(envo.getMapDecider()).get(i)).getRect().intersects(link.getRect()))
						|| (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Tektite.class) &&
								((Tektite) enemies.get(envo.getMapDecider()).get(i)).getMoving() == false
								&& ((Tektite) enemies.get(envo.getMapDecider()).get(i)).getRect().intersects(link.getRect())) 
						|| (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Octorok.class) &&
								((Octorok) enemies.get(envo.getMapDecider()).get(i)).getShot().getArea().intersects(link.getRect()))
						|| (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Moblin.class) &&
								((Moblin) enemies.get(envo.getMapDecider()).get(i)).getShot().getArea().intersects(link.getRect()))
						|| (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Goriya.class) &&
								((Goriya) enemies.get(envo.getMapDecider()).get(i)).getBoom().getArea().intersects(link.getRect()))
						|| (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Gohma.class) &&
							((Gohma) enemies.get(envo.getMapDecider()).get(i)).getShot().getArea().intersects(link.getRect()))) {
					link.subtractHearts();
					save = time;
				}
			}
		}

	}

	protected void attack() {
		ticks++;
		if (ticks - save1 >= 4) {
			if (!enemies.get(34).isEmpty())
				((Dodongo) enemies.get(34).get(0)).setStunned(false);
			if (!enemies.get(36).isEmpty()) 
				((Gohma) enemies.get(36).get(0)).setStunned(false);
		}
		attackCheck();
		link.falseSpace();
		attack.restart();
		link.setInvincible(false);

	}

	protected void updateGame() {
          mapAt2 = envo.getMapDecider();
        if (mapAt != mapAt2) {
            for (int c = 0; c < itemX.size(); c++) {
                if (itemX != null) {
                    itemX.remove(c);
                }
            }
            for (int c = 0; c < itemY.size(); c++) {
                if (itemY != null) {
                    itemY.remove(c);
                }
            }
            for (int c = 0; c < drops.size(); c++) {
                if (drops != null) {
                    drops.remove(c);
                }
            }
        }
        mapAt = envo.getMapDecider();
        for (int r = 0; r < drops.size(); r++) {
            //System.out.println(link.getRupee());
            if (drops.get(r).equals("potion") && link.getRect().intersects(new Rectangle(itemX.get(r), itemY.get(r), 25, 15))) {
                drops.remove(r);
                itemX.remove(r);
                itemY.remove(r);
                link.getPotion();
                r--;
            } else if (drops.get(r).equals("hearts") && link.getRect().intersects(new Rectangle(itemX.get(r), itemY.get(r), 25, 15))) {
                drops.remove(r);
                itemX.remove(r);
                itemY.remove(r);
                link.addHearts();
                r--;
            } else if (drops.get(r).equals("rupees") && link.getRect().intersects(new Rectangle(itemX.get(r), itemY.get(r), 35, 25))) {
                drops.remove(r);
                itemX.remove(r);
                itemY.remove(r);
                link.addRupee();
                r--;
            }
        }
        if (audioAlive.isRunning() == true || audioDungeon.isRunning() == true || audioGameOver.isRunning() == true) {
            soundOn = true;
        } else {
            soundOn = false;
        }
        if ((alive == true) && (envo.getMapDecider() == 32 || envo.getMapDecider() == 33 || envo.getMapDecider() == 34 || envo.getMapDecider() == 35 || envo.getMapDecider() == 36)) {
            if (audioAlive.isRunning() == true) {
                audioAlive.stop();
        }
        audioDungeon.loop(Clip.LOOP_CONTINUOUSLY);
    }

        if ((alive==true)&&(envo.getMapDecider()!=32&&envo.getMapDecider()!=33&&envo.getMapDecider()!=34&&envo.getMapDecider()!=35&&envo.getMapDecider()!=36)) {
        if(audioDungeon.isRunning()==true){
            audioDungeon.stop();
        }
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


		inMap.put(KeyStroke.getKeyStroke("W"), "up");
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
			if (moveable == true) {	
				moveable = false;		
				link.keyHit(s);		
			}
			if (s.equals("space")) {
				attack.start();
			}//if inv is on change playerselected
			panel.repaint();
		}
	}


	private void attackCheck() {
		for(int i = 0; i < enemies.get(envo.getMapDecider()).size(); i++) {
			if (link.getSword() == true && link.getSwordRect().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect()) && link.getSpace() == true) {
				if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
					if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
							&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))
							&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
						((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
						enemyDeath=true;
						chance =(int)(Math.random()*20);
						if (chance<=2) {
							drops.add("potion");
						}
						else if (chance>2&&chance<=5) {
							drops.add("hearts");
						}else {
							drops.add("rupees");
						}
						itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
						itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
						enemies.get(envo.getMapDecider()).remove(i);
					}
				}
			}
			else if (link.getBow() == true && link.getInitialSpace() == true) {
				if (link.getUpArrow().getVisible() == true && link.getUpArrow().getArea().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect())) {
					if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
						if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
								&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying())) 
								&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
							((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
							enemyDeath=true;
							chance =(int)(Math.random()*20);
							if (chance<=2) {
								drops.add("potion");
							}
							else if (chance>2&&chance<=5) {
								drops.add("hearts");
							}else {
								drops.add("rupees");
							}
							itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
							itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
							enemies.get(envo.getMapDecider()).remove(i);
						}
						else if (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Gohma.class) 
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getEyeOpen() == true
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getStunned() == false){
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).lowerHealth();
								save1 = ticks;
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).setStunned(true);
								if (((Gohma) enemies.get(envo.getMapDecider()).get(i)).getHealth() == 0){
									((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
									enemyDeath=true;
									chance =(int)(Math.random()*20);
									if (chance<=2) {
										drops.add("potion");
									}
									else if (chance>2&&chance<=5) {
										drops.add("hearts");
									}else {
										drops.add("rupees");
									}
									itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
									itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
									enemies.get(envo.getMapDecider()).remove(i);
								}
							}
						}
					}
				}
				else if (link.getRightArrow().getVisible() == true && link.getRightArrow().getArea().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect())) {
					if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
						if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
								&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))
								&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
							((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
							enemyDeath=true;
							chance =(int)(Math.random()*20);
							if (chance<=2) {
								drops.add("potion");
							}
							else if (chance>2&&chance<=5) {
								drops.add("hearts");
							}else if(chance>5&&chance<=10){
								drops.add("rupees");
							}
							itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
							itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
							enemies.get(envo.getMapDecider()).remove(i);
						}
						else if (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Gohma.class) 
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getEyeOpen() == true
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getStunned() == false){
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).lowerHealth();
								save1 = ticks;
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).setStunned(true);
							if (((Gohma) enemies.get(envo.getMapDecider()).get(i)).getHealth() == 0){
								((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
								enemyDeath=true;
								chance =(int)(Math.random()*20);
								if (chance<=2) {
									drops.add("potion");
								}
								else if (chance>2&&chance<=5) {
									drops.add("hearts");
								}else {
									drops.add("rupees");
								}
								itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
								itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
								enemies.get(envo.getMapDecider()).remove(i);
							}
						}
					}
				}
				else if (link.getDownArrow().getVisible() == true && link.getDownArrow().getArea().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect())) {
					if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
						if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
								&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))
								&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
							((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
							enemyDeath=true;
							chance =(int)(Math.random()*20);
							if (chance<=2) {
								drops.add("potion");
							}
							else if (chance>2&&chance<=5) {
								drops.add("hearts");
							}else {
								drops.add("rupees");
							}
							itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
							itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
							enemies.get(envo.getMapDecider()).remove(i);
						}
						else if (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Gohma.class) 
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getEyeOpen() == true
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getStunned() == false){
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).lowerHealth();
								save1 = ticks;
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).setStunned(true);
							if (((Gohma) enemies.get(envo.getMapDecider()).get(i)).getHealth() == 0){
								((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
								enemyDeath=true;
								chance =(int)(Math.random()*20);
								if (chance<=2) {
									drops.add("potion");
								}
								else if (chance>2&&chance<=5) {
									drops.add("hearts");
								}else {
									drops.add("rupees");
								}
								itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
								itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
								enemies.get(envo.getMapDecider()).remove(i);
							}
						}
					}
				}
				else if (link.getLeftArrow().getVisible() == true && link.getLeftArrow().getArea().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect())) {
					if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
						if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
								&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))
								&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
							((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
							enemyDeath=true;
							chance =(int)(Math.random()*20);
							if (chance<=2) {
								drops.add("potion");
							}
							else if (chance>2&&chance<=5) {
								drops.add("hearts");
							}else {
								drops.add("rupees");
							}
							itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
							itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
							enemies.get(envo.getMapDecider()).remove(i);
						}
						else if (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Gohma.class) 
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getEyeOpen() == true
								&& ((Gohma) enemies.get(envo.getMapDecider()).get(i)).getStunned() == false){
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).lowerHealth();
								save1 = ticks;
								((Gohma) enemies.get(envo.getMapDecider()).get(i)).setStunned(true);
							if (((Gohma) enemies.get(envo.getMapDecider()).get(i)).getHealth() == 0){
								((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
								enemyDeath=true;
								chance =(int)(Math.random()*20);
								if (chance<=2) {
									drops.add("potion");
								}
								else if (chance>2&&chance<=5) {
									drops.add("hearts");
								}else {
									drops.add("rupees");
								}
								itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
								itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
								enemies.get(envo.getMapDecider()).remove(i);
							}
						}
					}
				}
			else if (link.getBoomerang() == true && link.getBoom().getVisible() == true 
					&& link.getBoom().getArea().intersects(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect())) {
				if (!enemies.get(envo.getMapDecider()).get(i).getClass().equals(OldMan.class)) {
					if (!(enemies.get(envo.getMapDecider()).get(i).getClass().equals(Peahat.class)
							&& (((Peahat) enemies.get(envo.getMapDecider()).get(i)).getFlying()))
							&& envo.getMapDecider() != 34 && envo.getMapDecider() != 36) {
						((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
						enemyDeath=true;
						chance =(int)(Math.random()*20);
						if (chance<=2) {
							drops.add("potion");
						}
						else if (chance>2&&chance<=5) {
							drops.add("hearts");
						}else {
							drops.add("rupees");
						}
						itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
						itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
						enemies.get(envo.getMapDecider()).remove(i);
					}
					else if (enemies.get(envo.getMapDecider()).get(i).getClass().equals(Dodongo.class) 
							&& ((Dodongo) enemies.get(envo.getMapDecider()).get(i)).getStunned() == false){
							((Dodongo) enemies.get(envo.getMapDecider()).get(i)).lowerHealth();
							save1 = ticks;
							((Dodongo) enemies.get(envo.getMapDecider()).get(i)).setStunned(true);
						if (((Dodongo) enemies.get(envo.getMapDecider()).get(i)).getHealth() == 0){
							((Character) enemies.get(envo.getMapDecider()).get(i)).setDead(false);
							enemyDeath=true;
							chance =(int)(Math.random()*20);
							if (chance<=2) {
								drops.add("potion");
							}
							else if (chance>2&&chance<=5) {
								drops.add("hearts");
							}else {
								drops.add("rupees");
							}
							itemX.add((int)(((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getX()));
							itemY.add((int)((Character) enemies.get(envo.getMapDecider()).get(i)).getRect().getY());
							enemies.get(envo.getMapDecider()).remove(i);
						}
					}
				}
			}
		}
	}

	protected void drawAll(Graphics g) {
		if (link.alive() == false) {
			Image img = null;
			try {
				img = ImageIO.read(new File(("inventory.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			alive = false;
			g.drawImage(img, 0, 0, 800, 600, null);
			g.setFont(new Font("TimesRoman", Font.BOLD, 35));
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 300, 150);	
		}
		//34 is main boss, 36 is mini boss
		if (enemies.get(34).isEmpty() == true && enemies.get(36).isEmpty() == true) {
			Image img = null;
			try {
				img = ImageIO.read(new File(("inventory.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, 800, 600, null);
			g.setFont(new Font("TimesRoman", Font.BOLD, 35));
			g.setColor(Color.WHITE);
			g.drawString("VICTORY! YOU HAVE WON THE GAME", 100, 150);
		}
		else {
			envo.draw(g);
			link.draw(g);
			if (envo.getMapDecider() == 1) {
				((OldMan) enemies.get(1).get(0)).checkSword(link);
			}
			//System.out.println(envo.getMapDecider());
			for (int i = 0; i < enemies.get(envo.getMapDecider()).size(); i ++) {
				((Character) enemies.get(envo.getMapDecider()).get(i)).draw(g);
			}
			if (link.getCollected() == true) {
				inv.draw(g);
			}
			for (int r=0;r<drops.size();r++) {
				if (drops.get(r).equals("potion")) {
					drop.drawPotion(g,itemX.get(r), itemY.get(r));
				}
				else if (drops.get(r).equals("hearts")) {
					drop.drawHearts(g,itemX.get(r), itemY.get(r));
				}else {
					drop.drawRupees(g,itemX.get(r), itemY.get(r));
				}
			}
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
