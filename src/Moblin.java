import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Moblin extends Character  {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private int clicks = 0;
	private Projectile shot;
	private boolean able = true;
	private String choice;
	private int count = 0;

	public Moblin(int x, int y) {
		super(getImage(60,120,20,20), getImage(90,120,20,20), getImage(0,120,20,20), getImage(30,120,20,20), 
				getImage(60,150,20,20), getImage(90,150,20,20), getImage(0,150,20,20), getImage(30,150,20,20),x, y, 50, 50);
		shot = new Projectile((int)(getRect().getX()), (int)(getRect().getY()), 30, 30, "enemies.png", 90, 300, 15, 15);
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
		if (direction.equals("up")) {
			if (clicks%2 ==0)	
				g.drawImage(getUpMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("right")) {
			if (clicks%2 ==0)
				g.drawImage(getRightMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("down")) {
			if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("left")) {
			if (clicks%2 ==0)
				g.drawImage(getLeftMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		shot.draw(g, getRect());
	}
	
	public void keyHit(String s) {
		if (s.equals("left")) {
			getRect().translate(-10, 0);
			direction = "left";
			clicks++;
		}
		else if (s.equals("right")) {
			this.getRect().translate(10, 0);
			direction = "right";
			clicks++;
		}
		else if (s.equals("up")) {
			this.getRect().translate(0, -10);
			direction = "up";
			clicks++;
		}
		else if (s.equals("down")) {
			this.getRect().translate(0, 10);
			direction = "down";
			clicks++;
		}
	}
	
	@Override 
	public void movePattern(Player p) {
		if (p.getRect().getX() > this.getRect().getX()+5) {
			if (count%2 == 0)
				keyHit("right");
		}
		else if (p.getRect().getX() < this.getRect().getX()-5) {
			if (count%2 == 0)
				keyHit("left");
		}
		else if (p.getRect().getY() > this.getRect().getY()+5) {
			if (count%2 == 0)
				keyHit("down");
		}
		else if (p.getRect().getY() < this.getRect().getY()-5) {
			if (count%2 == 0)
				keyHit("up");
		}
		count++;
		shoot(p);
	}
	
	public void shoot(Player p) {
		if (shot.getVisible() == false) {
			shot.setLoc((int)(this.getRect().getX()),(int) (this.getRect().getY()));
			if (Math.abs((p.getRect().getX()-this.getRect().getX())) <15 && direction.equals("down")) {
				choice = "down";
				shot.move(choice, getRect());
			}
			else if (Math.abs((p.getRect().getX()-this.getRect().getX())) <15 && direction.equals("up")) {
				choice = "up";
				shot.move(choice, getRect());
			}
			else if (Math.abs((p.getRect().getY()-this.getRect().getY())) <15 && direction.equals("left")) {
				choice = "left";
				shot.move(choice, getRect());
			}
			else if (Math.abs((p.getRect().getY()-this.getRect().getY())) <15 && direction.equals("right")) {
				choice = "right";
				shot.move(choice, getRect());
			}
		}
		else if (shot.getVisible() == true) {
			shot.move(choice, getRect());
		}
		
	}
	
	public Projectile getShot() {
		return this.shot;
	}
}
	