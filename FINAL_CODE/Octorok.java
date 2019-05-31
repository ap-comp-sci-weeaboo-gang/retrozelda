import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Octorok extends Character  {
    private static BufferedImage spriteSheet;
    private String direction = "down";
    private int clicks = 0;
    private Projectile shot;
    private boolean able = true;
    private String choice;
    private int count = 0;
    private int moveChoice;
    private int loop;

    public Octorok(int x, int y, int c) {
        super(getImage(60,0,20,20), getImage(90,0,20,20), getImage(0,0,20,20), getImage(30,0,20,20),
                getImage(60,30,20,20), getImage(90,30,20,20), getImage(0,30,20,20), getImage(30,30,20,20),x, y, 50, 50);
        moveChoice = c;
        shot = new Projectile((int)(getRect().getX()), (int)(getRect().getY()), 30, 30, "enemies.png", 330, 0, 15, 15);
    }

    public Octorok(int x, int y, int c, int l) {
        super(getImage(60,0,20,20), getImage(90,0,20,20), getImage(0,0,20,20), getImage(30,0,20,20),
                getImage(60,30,20,20), getImage(90,30,20,20), getImage(0,30,20,20), getImage(30,30,20,20),x, y, 50, 50);
        shot = new Projectile((int)(getRect().getX()), (int)(getRect().getY()), 30, 30, "enemies.png", 330, 0, 15, 15);
        moveChoice = c;
        loop = l;

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
        if (moveChoice == 0) {
            if (loop < 3) {
                if (count < 12) {
                    keyHit("up");
                    count++;
                }
                else {
                    direction = "left";
                    shoot(p);
                    if (shot.getVisible() == false) {
                        count = 0;
                        loop++;
                    }
                }
            }
            else if (loop >= 3 && loop < 6) {
                if (count < 12) {
                    keyHit("down");
                    count++;
                }
                else {
                    direction = "left";
                    shoot(p);
                    if (shot.getVisible() == false) {
                        count = 0;
                        loop++;
                    }
                }
            }
            else if (loop == 6) {
                loop = 0;
            }
        }
        else if (moveChoice == 1) {
            if (loop < 3) {
                if (count < 12) {
                    keyHit("down");
                    count++;
                }
                else {
                    direction = "right";
                    shoot(p);
                    if (shot.getVisible() == false) {
                        count = 0;
                        loop++;
                    }
                }
            }
            else if (loop >= 3 && loop < 6) {
                if (count < 12) {
                    keyHit("up");
                    count++;
                }
                else {
                    direction = "right";
                    shoot(p);
                    if (shot.getVisible() == false) {
                        count = 0;
                        loop++;
                    }
                }
            }
            else if (loop == 6) {
                loop = 0;
            }
        }
    }

    public void shoot(Player p) {
        if (shot.getVisible() == false) {
            shot.setLoc((int)(this.getRect().getX()),(int) (this.getRect().getY()));
            if (direction.equals("down")) {
                choice = "down";
                shot.move(choice, getRect());
            }
            else if (direction.equals("up")) {
                choice = "up";
                shot.move(choice, getRect());
            }
            else if (direction.equals("left")) {
                choice = "left";
                shot.move(choice, getRect());
            }
            else if (direction.equals("right")) {
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


