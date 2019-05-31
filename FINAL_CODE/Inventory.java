import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private int playerSelected=0;
    Rectangle bkground;
    private Player p;
    static List<BufferedImage> t = new ArrayList<>();
    private boolean invOn;

    public Inventory(Player d) {
        p = d;
    }

    public static void setImages() {

        try {
            BufferedImage image = ImageIO.read(new File(("inventory.jpg")));
            t.add( image);
            t.add( ImageIO.read(new File("blueInv.png")));
            t.add( ImageIO.read(new File("yellowInv.png")));
            t.add( ImageIO.read(new File("sword.png")));
            t.add( ImageIO.read(new File("bow.png")));
            t.add( ImageIO.read(new File("boomerang.png")));
            t.add( ImageIO.read(new File("potion.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g) {
        while (playerSelected>3) {
            playerSelected=playerSelected-3;
        }
        if (invOn == true) {
            g.drawImage(t.get(0), 0, 0, 800, 600, null);
            g.drawImage(t.get(1), 250, 50, 410, 100, null);
            g.drawImage(t.get(0), 255, 55, 400, 90, null);
            g.drawImage(t.get(3), 230, 50, 150, 130, null);
            g.drawImage(t.get(4), 340, 70, 100, 80, null);
            g.drawImage(t.get(5), 450, 55, 100, 100, null);
            g.drawImage(t.get(6), 550, 50, 100, 100, null);
            if(playerSelected==0) {
                g.drawImage(t.get(2),255, 55, 100, 90, null);
            }
            else if(playerSelected==1) {
                g.drawImage(t.get(2),355, 55, 100, 90, null);
            }
            else if(playerSelected==2) {
                g.drawImage(t.get(2),455, 55, 100, 90, null);
            }
            else if(playerSelected==3) {
                g.drawImage(t.get(2),555, 55, 100, 90, null);
            }
            g.setFont(new Font("TimesRoman", Font.BOLD, 35));
            g.setColor(Color.WHITE);
            g.drawString("PRESS SPACE TO USE THE ITEM",150,200);
        }

    }

    public boolean getInventoryCondition() {
        return invOn;
    }

    public void changeInvCondition() {
        invOn=!invOn;
    }
    public int getCurrentItem() {
        return playerSelected;
    }

    public void changeItem() {
        playerSelected++;
    }

    public void itemMoveRight() {
        playerSelected++;
        while(playerSelected>3) {
            playerSelected=0;
        }

    }

    public void itemMoveLeft() {
        playerSelected--;
        while(playerSelected<0) {
            playerSelected=3;
        }
    }
}
