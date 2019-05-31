import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gohma extends Character  {
    private static BufferedImage spriteSheet;
    private int clicks = 0;
    private int count = 0;
    private int loop = 0;
    private int health = 3;
    private Image open;
    private Image openMove;
    private Projectile shot;
    private boolean eyeOpen = false;
    private boolean stunned = false;

    public Gohma(int x, int y) {
        super(null, null, getImage(175,88,56,22), null,
                null, null, getImage(175,118,56,22), null,x, y, 112, 44);
        open = getImage(120,88,56,22);
        openMove = getImage(120,118,56,22);
        shot = new Projectile((int)(this.getRect().getX())+56, (int)(this.getRect().getY())+22, 30, 30,"enemies.png", 330, 30, 15, 15);
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
        if (count < 30) {
            eyeOpen = false;
            if (clicks%2 ==0)
                g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            else
                g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            count++;
        }
        else if (count >= 30 && count < 60) {
            eyeOpen = true;
            if (clicks%2 ==0)
                g.drawImage(open,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            else
                g.drawImage(openMove,(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            count++;
        }
        else {
            if (clicks%2 ==0)
                g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            else
                g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
            count = 0;
        }
        shot.draw(g, this.getRect());
    }

    public void keyHit(String s) {
        if (s.equals("left")&& this.getRect().getX()-10 >= 1) {
            getRect().translate(-10, 0);
            clicks++;
        }
        else if (s.equals("right") && this.getRect().getX()+10 <= 799-(getRect().getWidth())) {
            this.getRect().translate(10, 0);
            clicks++;
        }
    }

    @Override
    public void movePattern(Player p) {
        if (stunned == false) {
            if (loop < 30) {
                this.keyHit("left");
                loop++;
            }
            else if (loop >= 30 && loop < 90) {
                this.keyHit("right");
                loop++;
            }
            else if (loop >= 90 && loop < 120) {
                this.keyHit("left");
                loop++;
            }
            else {
                loop = 0;
            }
        }
        shoot();
    }

    public void shoot() {
        if (shot.getVisible() == false) {
            shot.setLoc((int)(this.getRect().getX())+45,(int) (this.getRect().getY())+22);
            shot.move("down", getRect());
        }
        else if (shot.getVisible() == true) {
            shot.move("down", getRect());
        }
    }

    public void lowerHealth() {
        if (health > 0 && stunned == false && eyeOpen == true) {
            health--;
            stunned = true;
            System.out.println(health);
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

    public boolean getEyeOpen() {
        return this.eyeOpen;
    }

    public void closeEye() {
        eyeOpen = false;
    }

    public Projectile getShot() {
        return this.shot;
    }
}

