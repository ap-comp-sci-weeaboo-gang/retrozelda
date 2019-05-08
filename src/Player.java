import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Character {
    private static BufferedImage spriteSheet;
    String direction = "up";


    public Player() {
        super(getImage(60,0,15,15), getImage(90,30,15,15), getImage(0,0,15,15), getImage(30,0,15,15), 100, 100, 45);
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
        if (direction.equals("up"))
            g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
        else if (direction.equals("right"))
            g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
        else if (direction.equals("down"))
            g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
        else if (direction.equals("left"))
            g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
    }

    public void keyHit(String s) {
        if (s.equals("left")) {
            getRect().translate(-10, 0);
            direction = "left";
        }
        else if (s.equals("right")) {
            this.getRect().translate(10, 0);
            direction = "right";
        }
        else if (s.equals("up")) {
            this.getRect().translate(0, -10);
            direction = "up";
        }
        else if (s.equals("down")) {
            this.getRect().translate(0, 10);
            direction = "down";
        }
    }



}


