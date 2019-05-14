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
    private Color[][] colors;


    public Environment(Player d) {
        p = d;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        p.getRect().setLocation(350,420);
        colors = new Color[getImage().get(mapDecider).getWidth()][getImage().get(mapDecider).getHeight()];


    } // I might need to switch this code once I get a Player



    private  List<BufferedImage> getImage() {
        List<BufferedImage> t = new ArrayList<>();

        try {
            BufferedImage image = ImageIO.read(new File(("Envo1new.png")));
            // Add rest of needed images here
          //  int widthSize = Toolkit.getDefaultToolkit().getScreenSize().width/2;
            //int heightSize = Toolkit.getDefaultToolkit().getScreenSize().height/2;

            t.add( image);
          //  t.add(r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getImage("C:/Downloads/Envo1.png").getWidth(null),Toolkit.getDefaultToolkit().getImage("C:/Downloads/Envo1.png").getHeight(null))));
            // I need to use screen Caputre somehow
            t.add( ImageIO.read(new File("Envo2.png")));
            t.add( ImageIO.read(new File("Envo3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }



        return t;
    }


    private void mappy(Graphics g) {
        boundary(g);
        if(mapDecider == 0) {

            if((p.getRect().x > 158 && p.getRect().x < 215)  && (p.getRect().y > 40 && p.getRect().y < 87)) {

                mapDecider++;
                p.getRect().setLocation(380,490);
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

    private void boundary(Graphics g) {

        g.setColor(Color.BLUE);
        System.out.println(r.getPixelColor(p.getRect().x,p.getRect().y));
        int red = 0, green = 0, blue = 0;
        int skip = 10;

        int diam = 5;
        BufferedImage im = getImage().get(mapDecider);
        Point playerLoc = p.getRect().getLocation();
        for (int x = 0; x < im.getWidth()-20; x++) {
            for (int y = 0; y < im.getHeight()-20; y++) {
                colors[x][y] = new Color(im.getRGB(x, y));


            }
        }
        boolean onGreen = false;
        if(p.direction.equals("up" )  ) {
            if( playerLoc.x > diam && playerLoc.y > skip) {
                for (int i = playerLoc.y+skip*2 ; i < playerLoc.y+skip*3; i++) {
                    for (int j = playerLoc.x + 7; j < playerLoc.x + 35; j++) {
                        red = colors[j][i].getRed();
                        green = colors[j][i].getGreen();
                        blue = colors[j][i].getBlue();
                        g.drawRect(j,i,diam,skip);

                        if (whichColor(red,green,blue,g)) {
                            onGreen = true;
                            break;

                        }
                    }
                }
                if (onGreen) {
                    p.getRect().translate(0, 10);
                    System.out.println("You are on Green");
                }
            }
        }
        if(p.direction.equals("right" )  ) {


            if( playerLoc.x < 800-50  && playerLoc.y > skip*3) {

                for (int i = playerLoc.y+skip*2 ; i < playerLoc.y+skip*3; i++) {
                    for (int j = playerLoc.x+15; j < playerLoc.x +diam+28; j++) {
                        red = colors[j][i].getRed();
                        green = colors[j][i].getGreen();
                        blue = colors[j][i].getBlue();
                        g.drawRect(j,i,diam,skip);

                        if (whichColor(red,green,blue,g)) {
                            onGreen = true;
                            break;

                        }
                    }
                }
                if (onGreen) {
                    p.getRect().translate(-10, 0);

                    System.out.println("You are on Green");
                }
            }
        }

        if(p.direction.equals("down" )  ) {


            if( playerLoc.x > diam && playerLoc.y > skip) {

                for (int i = playerLoc.y+30 ; i < playerLoc.y+40; i++) {
                    for (int j = playerLoc.x +7; j < playerLoc.x + 35; j++) {
                        red = colors[j][i].getRed();
                        green = colors[j][i].getGreen();
                        blue = colors[j][i].getBlue();
                        g.drawRect(j,i,diam,skip);
                        if (whichColor(red,green,blue,g)) {

                            onGreen = true;
                            break;

                        }
                    }
                }
                if (onGreen) {
                    p.getRect().translate(0, -10);
                    System.out.println("You are on Green");
                }
            }
        }
        if(p.direction.equals("left" ) ) {


            if( playerLoc.x > diam && playerLoc.y > skip) {
                System.out.println("left");
                for (int i = playerLoc.y+skip*2 ; i < playerLoc.y+skip*3; i++) {
                    for (int j = playerLoc.x+6; j < playerLoc.x + 20; j++) {
                        red = colors[j][i].getRed();
                        green = colors[j][i].getGreen();
                        blue = colors[j][i].getBlue();
                        g.drawRect(j,i,diam,skip);
                        if (whichColor(red,green,blue,g)) {

                            onGreen = true;
                            break;

                        }
                    }
                }
                if (onGreen) {
                    p.getRect().translate(10, 0);
                    System.out.println("You are on Green");
                }
            }
        }

    }


    private boolean whichColor( int r, int g, int b, Graphics gt) {
        boolean onBoundary = false;
        if(mapDecider == 0 ) {
            if (g > 80 && r + b < g) {
                onBoundary = true;
            }
        }
        if(mapDecider == 1 ) {

            if( (r!= 1 && b!= 1) && !(p.getRect().y > 500 && p.getRect().y < 599) && !(p.getRect().x > 330 && p.getRect().x < 443 ) ) {
                onBoundary = true;
            }
        }
        if(mapDecider == 2) {
            if(g < 100 && b < 100 && r < 100) {
                onBoundary = true;
            }
        }
        return onBoundary;
    }


    public void draw(Graphics g) {

        // width 800, height 600
        mappy(g);
            g.drawImage(getImage().get(mapDecider), 0, 0, 800, 600, null);


            //boundary(g);
           // loadArray();
    }



}

