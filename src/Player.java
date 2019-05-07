import javax.imageio.ImageIO;
import javax.swing.Timer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player extends Character {
	private static BufferedImage spriteSheet;
	String direction = "up";
	private int clicks = 0;
	private Image upSword;
	private Image rightSword;
	private Image downSword;
	private Image leftSword;
	private boolean space = false;
	private boolean sword = true;
	private Rectangle swordRect;

	public Player() {
		super(getImage(60,0,15,15), getImage(90,30,15,15), getImage(0,0,15,15), getImage(30,0,15,15), 
				getImage(60,30,15,15), getImage(90,0,15,15), getImage(0,30,15,15), getImage(30,30,15,15),100, 100, 50, 50);
		upSword = getImage(60,82,15,30);
		rightSword = getImage(82,90,30,15);
		downSword = getImage(0,82,15,30);
		leftSword = getImage(22,90,30,15);
		swordRect = new Rectangle((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getX()+getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-getRect().getWidth()*0.06));
		
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("link.png"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}

	public void draw(Graphics g) {
		if (direction.equals("up")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()-getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-(getRect().getWidth()*0.06)));
				//g.drawRect((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()-getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-(getRect().getWidth()*0.06)));
				g.drawImage(upSword,(int)(getRect().getX()),(int)(getRect().getY()-swordRect.getHeight()),(int)(getRect().getWidth()),(int)(getRect().getWidth())*2, null);
			}
			else if (clicks%2 ==0)
				g.drawImage(getUpMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("right")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.3), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				//g.drawRect((int)(getRect().getX()+getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.2), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				g.drawImage(rightSword,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
			}
			else if (clicks%2 ==0) 
				g.drawImage(getRightMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("down")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()+getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-getRect().getWidth()*0.06));
				//g.drawRect((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()+getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-getRect().getWidth()*0.06));
				g.drawImage(downSword,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth())*2, null);
			
				}
			else if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("left")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()-getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.3), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				//g.drawRect((int)(getRect().getX()-getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.2), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				g.drawImage(leftSword,(int)(getRect().getX()-swordRect.getWidth()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
				}
			else if (clicks%2 ==0)
				g.drawImage(getLeftMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
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
		else if (s.equals("space")) {
			space = true;
		}
	}
	
	public void falseSpace() {
		space = false;
	}
	
	public boolean getSpace() {
		return this.space;
	}
	
	public Rectangle getSwordRect() {
		return this.swordRect;
	}
}