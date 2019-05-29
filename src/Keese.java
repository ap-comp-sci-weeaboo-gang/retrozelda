import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Keese extends Character  {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private int clicks = 0;

	public Keese(int x, int y) {
		super(null, null, getImage(232,270,20,20), null, null, null, getImage(260,270,15,20),null,x, y, 50, 50);
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
		if (clicks%2 ==0)	
			g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		else 
			g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
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
			keyHit("right");
		}
		else if (p.getRect().getX() < this.getRect().getX()-5) {
			keyHit("left");
		}
		else if (p.getRect().getY() > this.getRect().getY()+5) {
			keyHit("down");
		}
		else if (p.getRect().getY() < this.getRect().getY()-5) {
			keyHit("up");
		}
	}
}
	