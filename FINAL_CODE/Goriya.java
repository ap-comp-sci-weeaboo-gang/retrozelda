import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goriya extends Character  {
    private static BufferedImage spriteSheet;
    private String direction = "down";
    private int clicks = 0;
    private Boomerang boom;
    private String choice;
    private int count = 0;
    private boolean moving;
    private int facing;
    private int moves;

    public Goriya(int x, int y) {
        super(getImage(60,60,20,20), getImage(90,60,20,20), getImage(0,60,20,20), getImage(30,60,20,20),
                getImage(60,90,20,20), getImage(90,90,20,20), getImage(0,90,20,20), getImage(30,90,20,20),x, y, 50, 50);
        boom = new Boomerang((int)(getRect().getX()), (int)(getRect().getY()), 40, 40);
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
        boom.draw(g, getRect());
    }

    public void keyHit(String s) {
        if (s.equals("left")&& this.getRect().getX()-10 >= 110) {
            getRect().translate(-10, 0);
            direction = "left";
            clicks++;
        }
        else if (s.equals("right") && this.getRect().getX()+10 <= 799-(getRect().getWidth()*2)) {
            this.getRect().translate(10, 0);
            direction = "right";
            clicks++;
        }
        else if (s.equals("up") && this.getRect().getY()-10 >= 112) {
            this.getRect().translate(0, -10);
            direction = "up";
            clicks++;
        }
        else if (s.equals("down") && this.getRect().getY()+10 <= 599-getRect().getHeight()) {
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
            System.out.println(moves);
            moving = true;
        }
        if (moving == true) {
            if (facing == 0) {
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
            toss();
        }
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
            boom.setBack(false);
        }

    }

    public Boomerang getBoom() {
        return this.boom;
    }
}


