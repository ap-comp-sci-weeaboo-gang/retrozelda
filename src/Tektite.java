import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tektite extends Character {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private int clicks = 0;

	public Tektite() {
		super(null, null, getImage(240,180,20,20), null, null, null, getImage(240,210,20,20), null,100, 300, 50, 50);
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
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("right")) {
			if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("down")) {
			if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("left")) {
			if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
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
	public void movePattern(int i) {
		if (i>=0 && i < 8)
			keyHit("down");
		else if (i >= 8 && i <15)
			keyHit("right");
		else if (i >= 15 && i <22)
			keyHit("up");
		else if (i >=22 && i< 28)
			keyHit("left");
	}
	
}