import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Environment {

    private int mapDecider;
    // I have to remember that I may not be able to start from the first map
    private Player p;
    private  Robot r;


    public Environment(Player d) {
        p = d;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        p.getRect().setLocation(350,420);

    } // I might need to switch this code once I get a Player

    private static List<BufferedImage> getImage() {
        List<BufferedImage> t = new ArrayList<>();
        try {
            // Add rest of needed images here

            t.add( ImageIO.read(new File("Envo1.png")));
            t.add( ImageIO.read(new File("Envo2.png")));
            t.add( ImageIO.read(new File("Envo3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return t;
    }


    private void mappy() {
        if(mapDecider == 0) {
            boundary();
            if((p.getRect().x > 158 && p.getRect().x < 215)  && (p.getRect().y > 40 && p.getRect().y < 87)) {
                mapDecider++;
                p.getRect().setLocation(380,470);
            }
            if((p.getRect().x > 740) && (p.getRect().y > 260 && p.getRect().y < 310)) {
                mapDecider+=2;
                p.getRect().setLocation(50,292);
            }
            }
            if(mapDecider == 1) {
                if ((p.getRect().x > 336 && p.getRect().x < 470) && (p.getRect().y > 510)) {
                    mapDecider--;
                    p.getRect().setLocation(186, 115);
                }
            }
            if (mapDecider == 2) {
                if((p.getRect().x == 20) && (p.getRect().y > 262 && p.getRect().y <  310 )) {
                    mapDecider-=2;
                    p.getRect().setLocation(720,280);

                }
            }

    }


    private void boundary() {

        System.out.println(r.getPixelColor(p.getRect().x,p.getRect().y));
        Color point = r.getPixelColor(p.getRect().x,p.getRect().y);


        if (mapDecider == 0) {
            if (p.direction.equals("NORTH")) {
                if (point.equals(new Color(42, 42, 38)) || point.equals(new Color(0, 94, 0))) {
                    p.getRect().setLocation(400, 300);
                }

//        if(p.getRobot().getPixelColor(20,20) == p.getRobot().getPixelColor(30,30)) {
//            p.getRect().setLocation(400,300);
//        }
            }
        }
    }


    public void draw(Graphics g) {

        // width 800, height 600

            mappy();

            g.drawImage(getImage().get(mapDecider), 0, 0, 800, 600, null);



        // soon replace with mapDecider
    }



}


