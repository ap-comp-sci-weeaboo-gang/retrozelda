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
	private boolean collected = true;
	private boolean space = false;
	private boolean sword = false;
	private boolean bow = false;
	private boolean boomerang = false;
	private boolean potion = false;
	private String weapon;
	private Rectangle swordRect;
	private Image upAttack;
	private Image rightAttack;
	private Image downAttack;
	private Image leftAttack;
	private Projectile upArrow;
	private Projectile rightArrow;
	private Projectile downArrow;
	private Projectile leftArrow;
	private boolean initialSpace = false;
	private int health = 3;
	private Image hearts;
	private Boomerang boom;
	private String choice;
	private boolean invincible;
	private int rupee=10;
	private Image rupeeImg;
	boolean havePotion=false;
	//max=30

	public Player() {
		super(getImage(60,0,15,15), getImage(90,30,15,15), getImage(0,0,15,15), getImage(30,0,15,15), 
				getImage(60,30,15,15), getImage(90,0,15,15), getImage(0,30,15,15), getImage(30,30,15,15),100, 100, 50, 50);
		upSword = getImage(60,82,15,30);
		rightSword = getImage(82,90,30,15);
		downSword = getImage(0,82,15,30);
		leftSword = getImage(22,90,30,15);
		try {
			hearts=ImageIO.read(new File("heart.png"));
			rupeeImg=ImageIO.read(new File("rupees.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		swordRect = new Rectangle((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getX()+getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-getRect().getWidth()*0.06));
		upAttack = getImage(60,60,15,15);
		rightAttack = getImage(90,60,15,15);
		downAttack = getImage(0,60,15,15);
		leftAttack = getImage(30,60,15,15);
		upArrow = new Projectile((int)(getRect().getX())+20, (int)(getRect().getY())+20,16, 40, "link.png", 184, 193, 8, 20);
		rightArrow = new Projectile((int)(getRect().getX())+20, (int)(getRect().getY())+20,40, 16, "link.png", 209, 198, 20, 8);
		downArrow = new Projectile((int)(getRect().getX())+20, (int)(getRect().getY())+20,16, 40, "link.png", 124, 193, 8, 20);
		leftArrow = new Projectile((int)(getRect().getX())+20, (int)(getRect().getY())+20,40, 16, "link.png", 149, 198, 20, 8);
		try {
			hearts = ImageIO.read(new File("heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		boom = new Boomerang((int)(getRect().getX()), (int)(getRect().getY()), 40, 40);
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
		if (bow == true & initialSpace == true) {
			shoot();
		}
		if (boomerang == true & initialSpace == true) {
			toss();
		}
		if (direction.equals("up")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()-getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-(getRect().getWidth()*0.06)));
				g.drawImage(upSword,(int)(getRect().getX()),(int)(getRect().getY()-swordRect.getHeight()),(int)(getRect().getWidth()),(int)(getRect().getWidth())*2, null);
			}
			else if (bow == true && space == true) {
				g.drawImage(upAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (boomerang == true && space == true) {
				g.drawImage(upAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (clicks%2 ==0)
				g.drawImage(getUpMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("right")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.3), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				g.drawImage(rightSword,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
			}
			else if (bow == true && space == true) {
				g.drawImage(rightAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (boomerang == true && space == true) {
				g.drawImage(rightAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (clicks%2 ==0) 
				g.drawImage(getRightMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("down")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()+getRect().getWidth()*0.3), (int)(getRect().getY()+getRect().getWidth()), (int)(getRect().getWidth())/2, (int)(getRect().getWidth()-getRect().getWidth()*0.06));
				g.drawImage(downSword,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth())*2, null);
			}
			else if (bow == true && space == true) {
				g.drawImage(downAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (boomerang == true && space == true) {
				g.drawImage(downAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("left")) {
			if (space == true && sword == true) {
				swordRect.setBounds((int)(getRect().getX()-getRect().getWidth()), (int)(getRect().getY()+getRect().getWidth()*0.3), (int)(getRect().getWidth()-getRect().getWidth()*0.06), (int)(getRect().getWidth())/2);
				g.drawImage(leftSword,(int)(getRect().getX()-swordRect.getWidth()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
			}
			else if (bow == true && space == true) {
				g.drawImage(leftAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (boomerang == true && space == true) {
				g.drawImage(leftAttack,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			}
			else if (clicks%2 ==0)
				g.drawImage(getLeftMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		upArrow.draw(g, getRect());
		rightArrow.draw(g, getRect());
		downArrow.draw(g, getRect());
		leftArrow.draw(g, getRect());
		boom.draw(g, getRect());
		for (int currHealth = 0; currHealth < health; currHealth++) {
			g.drawImage(hearts, currHealth*25, 0, 50, 30, null);
		}
		g.drawImage(rupeeImg,0, 30, 50, 30, null);
		g.setFont(new Font("TimesRoman", Font.BOLD, 35));
		g.setColor(Color.WHITE);
		g.drawString("="+rupee,40,60);
	}
	
	private void toss() {
		if (boom.getVisible() == false) {
			boom.setLoc((int)(this.getRect().getX()),(int) (this.getRect().getY()));
			if (direction.equals("down")) {
				choice = "down";
				boom.move("choice", getRect());
			}
			else if (direction.equals("up")) {
				choice = "up";
				boom.move(choice, getRect());
			}
			else if (direction.equals("left")) {
				choice = "left";
				boom.move(choice, getRect());
			}
			else if (direction.equals("right")) {
				choice = "right";
				boom.move(choice, getRect());
			}
		}
		else if (boom.getVisible() == true) {
			boom.move(choice, getRect());
		}
		if (boom.getVisible() == false && boom.getBack() == true) {
			initialSpace = false;
			boom.setBack(false);
		}
		
	}

	public void addHearts() {
		if (health <30) {
			health++;
		}
	}
	
	public void getPotion() {
		havePotion=true;
	}
	
	public void subtractHearts() {
		if (health > 0 && invincible == false) {
			health--;
			invincible = true;
		}
	}
	
	public void addRupee() {
		rupee++;
	}

	public void minusRupee() {
		rupee--;
	}

	public int getRupee() {
		return rupee;
	}
	
	public void keyHit(String s) {
		if (s.equals("left") && this.getRect().getX()-5 >= 1) {
			getRect().translate(-15, 0);
			direction = "left";
			clicks++;
		}
		else if (s.equals("right") && this.getRect().getX()+5 <= 799-(getRect().getWidth())) {
			this.getRect().translate(15, 0);
			direction = "right";
			clicks++;
		}
		else if (s.equals("up") && this.getRect().getY()-5 >= 1) {
			this.getRect().translate(0, -15);
			direction = "up";
			clicks++;
		}
		else if (s.equals("down") && this.getRect().getY()+5 <= 599-getRect().getHeight()) {
			this.getRect().translate(0, 15);
			direction = "down";
			clicks++;
		}
		if (s.equals("space")) {
			space = true;
			if (upArrow.getVisible() == false && rightArrow.getVisible() == false && downArrow.getVisible() == false && leftArrow.getVisible() == false && (bow == true || boomerang == true)) {
				initialSpace = true;
			}
		}
		if (s.equals("space")) {
			space = true;
			if (upArrow.getVisible() == false && rightArrow.getVisible() == false && downArrow.getVisible() == false && leftArrow.getVisible() == false && (bow == true || boomerang == true)) {
				initialSpace = true;
			}
			if (potion == true && havePotion == true) {
				havePotion = false;
				addHearts();
				addHearts();
				addHearts();
			}
		}
	}
	
	public void shoot() {
		if (upArrow.getVisible() == false && rightArrow.getVisible() == false && downArrow.getVisible() == false && leftArrow.getVisible() == false && rupee > 0) {
			upArrow.setLoc((int)(this.getRect().getX())+20,(int) (this.getRect().getY())+20);
			rightArrow.setLoc((int)(this.getRect().getX())+20,(int) (this.getRect().getY())+20);
			downArrow.setLoc((int)(this.getRect().getX())+20,(int) (this.getRect().getY())+20);
			leftArrow.setLoc((int)(this.getRect().getX())+20,(int) (this.getRect().getY())+20);
			if (direction.equals("down")) {
				downArrow.move("down", getRect());
			}
			else if (direction.equals("up")) {
				upArrow.move("up", getRect());
			}
			else if (direction.equals("left")) {
				leftArrow.move("left", getRect());
			}
			else if (direction.equals("right")) {
				rightArrow.move("right", getRect());
			}
			minusRupee();
		}
		else if (upArrow.getVisible() == true) {
			upArrow.move("up", getRect());
		}
		else if (rightArrow.getVisible() == true) {
			rightArrow.move("right", getRect());
		}
		else if (downArrow.getVisible() == true) {
			downArrow.move("down", getRect());
		}
		else if (leftArrow.getVisible() == true) {
			leftArrow.move("left", getRect());
		}
		if (upArrow.getVisible() == false && rightArrow.getVisible() ==false && downArrow.getVisible() == false && leftArrow.getVisible() == false) {
			initialSpace = false;
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
	
	public void showSword() {
		sword = true;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public void setItem(int num) {
		if (num == 0) {
			sword = true;
			bow = false;
			boomerang = false;
			potion = false;
		}
		else if (num == 1) {
			bow = true;
			sword = false;
			boomerang = false;
			potion = false;
		}
		else if (num == 2) {
			boomerang = true;
			sword = false;
			bow = false;
			potion = false;
		}
		else if (num == 3) {
			boomerang = false;
			sword = false;
			bow = false;
			potion = true;
		}
		else if (num == 3) {
		}
	}
	
	public boolean getCollected() {
		return collected;
	}
	public void trueCollected() {
		collected = true;
	}
	public Boomerang getBoom() {
		return this.boom;
	}
	public Projectile getUpArrow() {
		return this.upArrow;
	}
	public Projectile getRightArrow() {
		return this.rightArrow;
	}
	public Projectile getDownArrow() {
		return this.downArrow;
	}
	public Projectile getLeftArrow() {
		return this.leftArrow;
	}
	public boolean getSword() {
		return sword;
	}
	public boolean getBow() {
		return bow;
	}
	public boolean getBoomerang() {
		return boomerang;
	}
	public boolean getInitialSpace() {
		return this.initialSpace;
	}
	public void setInvincible(boolean b) {
		this.invincible = b;
	}
	public boolean alive() {
		if (this.health == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
}