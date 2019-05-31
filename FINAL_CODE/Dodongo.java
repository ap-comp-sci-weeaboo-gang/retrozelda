import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dodongo extends Character  {
    private static BufferedImage spriteSheet;
    private String direction = "down";
    private int clicks = 0;
    private boolean able = true;
    private String choice;
    private int count = 0;
    private Image stunUp;
    private Image stunRight;
    private Image stunDown;
    private Image stunLeft;
    private boolean stunned = false;
    private int facing;
    private int moves;
    private boolean moving = false;
    private int health = 3;


    public Dodongo(int x, int y) {
        super(getImage(60,90,20,20), getImage(83,90,35,20), getImage(0,90,20,20), getImage(23,90,35,20),
                getImage(60,120,20,20), getImage(83,120,35,20), getImage(0,120,20,20), getImage(23,120,35,20),x, y, 50, 50);
        stunUp = getImage(60,150,20,20);
        stunRight = getImage(83,150,35,20);
        stunDown = getImage(0,150,20,20);
        stunLeft = getImage(23,150,35,20);
    }

    private static Image getImage(int x, int y, int w, int h) {
        try {
            spriteSheet = ImageIO.read(new File("bosses.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public void draw(Graphics g) {
        if (direction.equals("up")) {
            if (stunned == true)
                g.drawImage(stunUp,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
            else if (clicks%2 ==0)
                g.drawImage(getUpMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
            else
                g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
        }
        else if (direction.equals("right")) {
            if (stunned == true)
                g.drawImage(stunRight,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
            else if (clicks%2 ==0)
                g.drawImage(getRightMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
            else
                g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
        }
        else if (direction.equals("down")) {
            if (stunned == true)
                g.drawImage(stunDown,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
            else if (clicks%2 ==0)
                g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
            else
                g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
        }
        else if (direction.equals("left")) {
            if (stunned == true)
                g.drawImage(stunLeft,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
            else if (clicks%2 ==0)
                g.drawImage(getLeftMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
            else
                g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth())*2,(int)(getRect().getWidth()), null);
        }
    }

    public void keyHit(String s) {
        if (s.equals("left")&& this.getRect().getX()-10 >= 100) {
            getRect().translate(-10, 0);
            direction = "left";
            clicks++;
        }
        else if (s.equals("right") && this.getRect().getX()+10 <= 700-(getRect().getWidth()*2)) {
            this.getRect().translate(10, 0);
            direction = "right";
            clicks++;
        }
        else if (s.equals("up") && this.getRect().getY()-10 >= 110) {
            this.getRect().translate(0, -10);
            direction = "up";
            clicks++;
        }
        else if (s.equals("down") && this.getRect().getY()+10 <= 520-getRect().getHeight()) {
            this.getRect().translate(0, 10);
            direction = "down";
            clicks++;
        }
        else {
            moving = false;
        }
    }

    @Override
    public void movePattern(Player p) {
        if (moving == false) {
            count = 0;
            facing = (int)(Math.random()*4);
            moves = (int)((Math.random())*10)+10;
            //System.out.println(moves);
            moving = true;
        }
        if (moving == true) {
            if (p.getRect().getX() >= this.getRect().getX()-5 && p.getRect().getX() <= this.getRect().getX()+5
                    && p.getRect().getY() < this.getRect().getY()) {
                keyHit("up");
                keyHit("up");
            }
            else if (p.getRect().getX() >= this.getRect().getX()-5 && p.getRect().getX() <= this.getRect().getX()+5
                    && p.getRect().getY() > this.getRect().getY()) {
                keyHit("down");
                keyHit("down");
            }
            else if (p.getRect().getY() >= this.getRect().getY()-5 && p.getRect().getY() <= this.getRect().getY()+5
                    && p.getRect().getX() > this.getRect().getX()) {
                keyHit("right");
                keyHit("right");
            }
            else if (p.getRect().getY() >= this.getRect().getY()-5 && p.getRect().getY() <= this.getRect().getY()+5
                    && p.getRect().getX() < this.getRect().getX()) {
                keyHit("left");
                keyHit("left");
            }
            else if (facing == 0) {
                if (count < moves) {
                    keyHit("up");
                }
                else {
                    moving = false;
                }
            }
            else if (facing == 1) {
                if (count < moves) {
                    keyHit("right");
                }
                else {
                    moving = false;
                }
            }
            else if (facing == 2) {
                if (count < moves) {
                    keyHit("down");
                }
                else {
                    moving = false;
                }
            }
            else if (facing == 3) {
                if (count < moves) {
                    keyHit("left");
                }
                else {
                    moving = false;
                }
            }
            count++;
        }
    }

    public void lowerHealth() {
        if (health > 0 && stunned == false) {
            health--;
            stunned = true;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public void setStunned(boolean b) {
        stunned = b;
    }

    public boolean getStunned() {
        return this.stunned;
    }

    public boolean alive() {
        if (health == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
	