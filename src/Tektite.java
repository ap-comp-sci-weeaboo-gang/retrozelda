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
	int t;
	int startX; 
	int startY; 
	int clicks;

	public Tektite(int x, int y, int start) {
		super(null, null, getImage(240,180,20,20), null, null, null, getImage(240,210,20,20), null,x, y, 50, 50);
		t = start;
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
		else {
			if (clicks %2 == 0) 
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
	}
	
	public void keyHit(int x, int y) {
		if ((this.getRect().getX()+x >= 1 && this.getRect().getX()+x <= 799-getRect().getWidth()) && 
				(this.getRect().getY()+y >= 1 && this.getRect().getY()+y <= 599  -getRect().getHeight())) {
			this.getRect().translate(x, y);
		}
		else if (this.getRect().getX()+x >= 1 && this.getRect().getX()+x <= 799-getRect().getWidth()) {
			this.getRect().translate(x, 0);
		}
		else if (this.getRect().getY()+y >= 1 && this.getRect().getY()+y <= 599  -getRect().getHeight()) {
			this.getRect().translate(0, y);
		}
		else {
			moving = false;
		}
	}
	
	@Override
	public void movePattern(Player p) {
		if (moving == false) { 
			if (clicks > 5) {
				startX = (int) this.getRect().getX();
				startY = (int) this.getRect().getY();
				goalX = (int)(Math.random()*150);
				goalY = (int)(Math.random()*100);
				if (t == 0) {
				}
				else if (t == 1) {
					goalX = goalX * -1;
					goalY = goalY* -1;
				}
				else if (t == 2) {
					goalY = goalY* -1;
				}
				else if (t == 3) {
					goalX = goalX * -1;
				}
				moving = true;
			}
			clicks++;
		}
		else if (moving == true) {
			if (t == 0) {
				if (this.getRect().getX() >= startX+goalX || this.getRect().getY() >= startY +goalY) {	
					moving = false;
					t++;
					//System.out.println("stopped");
				}
				else {
					keyHit(goalX/6+1, goalY/4+1);
				}
			}
			else if (t == 1) {
				if (this.getRect().getX() <= startX+goalX || this.getRect().getY() <= startY +goalY) {	
					moving = false;
					t++;
					//System.out.println("stopped");
				}
				else {
					keyHit(goalX/6+1, goalY/4+1);
				}
			}
			else if (t == 2) {
				if (this.getRect().getX() >= startX+goalX || this.getRect().getY() <= startY +goalY) {	
					moving = false;
					t++;
					//System.out.println("stopped");
				}
				else {
					keyHit(goalX/6+1, goalY/4+1);
				}
			}
			else if (t == 3) {
				if (this.getRect().getX() <= startX+goalX || this.getRect().getY() >= startY +goalY) {	
					moving = false;
					t++;
					//System.out.println("stopped");
				}
				else {
					keyHit(goalX/6+1, goalY/4+1);
				}
			}
			clicks = 0;
		}
		if (t > 3) {
			t = 0;
		}
	}
	
	public boolean getMoving() {
		return this.moving;
	}
}