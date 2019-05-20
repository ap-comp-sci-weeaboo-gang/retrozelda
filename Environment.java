import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Environmenttwo {

    private int mapDecider;
    private BufferedImage im;
    // I have to remember that I may not be able to start from the first map
    private Player p;
    private  Robot r;
    private Color[][] colors;


    public Environmenttwo(Player d) {
        p = d;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        p.getRect().setLocation(350,420);
        colors = new Color[getImage().getWidth()][getImage().getHeight()];


    } // I might need to switch this code once I get a Player



    private  BufferedImage getImage() {

        try {
            if(mapDecider == 0) {
                im = ImageIO.read(new File("Envo1new.png"));
            }
            if(mapDecider == 1) {
                im = ImageIO.read(new File("Envo2.png"));
            }
            if(mapDecider == 2) {
                im = ImageIO.read(new File("Envo3.png"));
            }
            if(mapDecider == 3) {
                im = ImageIO.read(new File("Envo4.png"));
            }
            if(mapDecider == 4) {
                im = ImageIO.read(new File("Envo5.png"));
            }
            if(mapDecider == 5) {
                im = ImageIO.read(new File("Envo6.png"));
            }
            if(mapDecider == 6) {
                im = ImageIO.read(new File("Envo2.png"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        return im;
    }


    private void mappy(Graphics g) {
        boundary(g);
        if(mapDecider == 0) {

            if((p.getRect().x > 158 && p.getRect().x < 215)  && (p.getRect().y > 40 && p.getRect().y < 87)) {

                mapDecider++;
                p.getRect().setLocation(377,490);
            }
            if((p.getRect().x > 730) && (p.getRect().y > 260 && p.getRect().y < 310)) {

                mapDecider+=2;
                p.getRect().setLocation(20,p.getRect().y);
            }
        }
        if(mapDecider == 1) {

            if ((p.getRect().x > 336 && p.getRect().x < 470) && (p.getRect().y > 510)) {

                mapDecider--;
                p.getRect().setLocation(179, 115);
            }
        }
        if (mapDecider == 2) {
            if((p.getRect().x < 20) && (p.getRect().y > 262 && p.getRect().y <  310 )) {
                mapDecider-=2;
                p.getRect().setLocation(720,p.getRect().y);
            }
            if(p.getRect().x > 745 && (p.getRect().y > 120 && p.getRect().y < 490)) {
                mapDecider++;
                p.getRect().setLocation(20,p.getRect().y);
            }
        }
        if(mapDecider == 3) {
            if(p.getRect().x < 20 && (p.getRect().y > 139 && p.getRect().y < 490)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }


            if(p.getRect().x > 740 && (p.getRect().y > 200 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(20,p.getRect().y);
            }
        }
        if(mapDecider == 4) {
            if(p.getRect(). x < 20 && (p.getRect().y > 200 && p.getRect(). y < 400 )) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 200 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(20,p.getRect().y);
            }
        }
        if(mapDecider == 5) {
            if( p.getRect().x < 20 && (p.getRect().y >200 && p.getRect().y < 400)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 200 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(20,p.getRect().y);
            }
        }
        if(mapDecider == 6) {
            if( p.getRect().x < 20 && (p.getRect().y >200 && p.getRect().y < 400)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
    }
    private void boundary(Graphics g) {

        g.setColor(Color.BLUE);
        System.out.println(r.getPixelColor(p.getRect().x,p.getRect().y));
        int red = 0, green = 0, blue = 0;
        int skip = 10;

        int diam = 5;
        BufferedImage im = getImage();
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

            if( (r> 1 && b> 1) && !(p.getRect().y > 500 && p.getRect().y < 599) && !(p.getRect().x > 330 && p.getRect().x < 443 ) ) {
                onBoundary = true;
            }
        }
        if(mapDecider == 2 || mapDecider == 3 || mapDecider == 4 || mapDecider == 5 || mapDecider == 6) {
            if(g < 100 || b < 100 || r < 100) {
                onBoundary = true;
            }
        }
        return onBoundary;
    }


    public void draw(Graphics g) {

        // width 800, height 600

        mappy(g);
        g.drawImage(getImage(), 0, 0, 800, 600, null);


        //boundary(g);
        // loadArray();
    }



}


