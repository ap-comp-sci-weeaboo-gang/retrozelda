import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OldMan extends Character{
    private static BufferedImage spriteSheet;
    private boolean change = false;
    private Rectangle swordRect;
    private Image swordImg;
    private boolean showSword = true;
    private Image fire;

    public OldMan() {
        super(null, null, getImage(30,0,20,25, "npc.png"), null, null, null, null, null, 375, 200, 60, 75);
        swordImg = getImage(60,188,20,30,"link.png");
        swordRect = new Rectangle(385, 275, 40, 60);
        fire = getImage(300,0,20,20, "enemies.png");
    }

    private static Image getImage(int x, int y, int w, int h, String s) {
        try {
            spriteSheet = ImageIO.read(new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
    }

    public void draw(Graphics g) {
        g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
        g.drawImage(fire,185,(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
        g.drawImage(fire,585,(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
        g.setFont(new Font("TimesRoman", Font.BOLD, 35));
        g.setColor(Color.WHITE);
        if (showSword == true) {
            g.drawImage(swordImg,(int) swordRect.getX(),(int) swordRect.getY(), (int)swordRect.getWidth(), (int)swordRect.getHeight(), null);
            g.drawString("IT'S DANGEROUS TO GO", 195, 150);
            g.drawString("ALONE! TAKE THIS.", 225, 185);
        }
        else {
            g.drawString("K IS FOR INVENTORY AND J IS TO USE OBJECT. GOOD LUCK MY FRIEND!", 195, 150);
        }
    }

    public Rectangle getSwordRect() {
        return this.swordRect;
    }

    public void checkSword(Player link) {
        if(getSwordRect().intersects(link.getRect())) {
            link.trueCollected();
            this.showSword = false;
        }
    }

}
