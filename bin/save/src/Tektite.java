import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Tektite extends Character {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private boolean moving = false;
	private int goalX, goalY;
	double g = 9.8;
	double angle;
	double v;
	int t = 0;

	public Tektite() {
		super(null, null, getImage(240,180,20,20), null, null, null, getImage(240,210,20,20), null,600, 300, 50, 50);
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("enemies.png"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}

	@Override
	public void draw(Graphics g) {
		if (moving == true)	
			g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		else 	
			g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
	}
	
	public void keyHit(int x, int y) {
		//angle = Math.abs(Math.atan2(this.getRect().getY(), this.getRect().getX()));
		//v = (Math.sqrt((this.getRect().getY()*this.getRect().getY())+(this.getRect().getX()*this.getRect().getX())))/10;
		//this.getRect().setLocation((int)(v*Math.cos(angle)*t+this.getRect().getX()),
		//		(int)(g/2*(t*t)-Math.sin(angle)*v*t+this.getRect().getY()));
		if ((this.getRect().getX()+x > 0 && this.getRect().getX()+x < 1100-getRect().getWidth()) && 
				(this.getRect().getY()+y > 0 && this.getRect().getY()+y < 600-getRect().getHeight())) {
			//this.getRect().setLocation(x, y);
			this.getRect().translate(x, y);
		}
	}
	
	@Override
	public void movePattern(Player p) {
		if (moving == false) { 
			t=0;
			int choice1 = (int)(Math.random()*2);
			int choice2 = (int)(Math.random()*2);
			goalX = (int) ((Math.random()*200));
			goalY = (int)(Math.random()*150);
			if (choice1 == 0)
				goalX = (int) (this.getRect().getX() - goalX);
			if (choice2 == 0)
				goalY = (int) (this.getRect().getY() - goalY);
			moving = true;
		}
		if (moving == true) {
			if ((this.getRect().getX() == goalX+(goalX/15) || this.getRect().getX() == goalX-(goalX/15))
					&& (this.getRect().getY() == goalY+(goalY/10) || this.getRect().getY() == goalY-(goalX/10))) {	
				moving = false;
			}
			else {
				keyHit(goalX/15, goalY/10);
				t++;
			}
		}
	}
	
}