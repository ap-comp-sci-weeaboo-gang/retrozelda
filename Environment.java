import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Environment {

    private int mapDecider;
    private BufferedImage im;
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
            if(mapDecider == 6 ) {
                im = ImageIO.read(new File("Envo7.png"));
            }
            if(mapDecider == 7) {
                im = ImageIO.read(new File("Envo7.png"));
            }
            if(mapDecider == 8) {
                im = ImageIO.read(new File("Envo8.png"));
            }
            if(mapDecider == 9) {
                im = ImageIO.read(new File("Envo9.png"));
            }
            if(mapDecider == 10) {
                im = ImageIO.read(new File("Envo10.png"));
            }
            if(mapDecider == 11) {
                im = ImageIO.read(new File("Envo11.png"));
            }
            if(mapDecider == 12) {
                im = ImageIO.read(new File("Envo12.png"));
            }
            if(mapDecider == 13) {
                im = ImageIO.read(new File("Envo13.png"));
            }
            if(mapDecider == 14) {
                im = ImageIO.read(new File("Envo14.png"));
            }
            if(mapDecider == 15) {
                im = ImageIO.read(new File("Envo15.png"));
            }
            if(mapDecider == 16) {
                im = ImageIO.read(new File("Envo16.png"));
            }
            if(mapDecider == 17) {
                im = ImageIO.read(new File("Envo17.png"));
            }
            if(mapDecider == 18) {
                im = ImageIO.read(new File("Envo18.png"));
            }
            if(mapDecider == 19) {
                im = ImageIO.read(new File("Envo19.png"));
            }
            if(mapDecider == 20) {
                im = ImageIO.read(new File("Envo20.png"));
            }
            if(mapDecider == 21) {
                im = ImageIO.read(new File("Envo21.png"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        return im;
    }


    private void mappy(Graphics g) {
        boundary(g);
        g.setColor(Color.BLUE);
        if(mapDecider == 0) {

            if((p.getRect().x > 158 && p.getRect().x < 215)  && (p.getRect().y > 40 && p.getRect().y < 87)) {

                mapDecider++;
                p.getRect().setLocation(377,490);
            }
            if((p.getRect().x > 730) && (p.getRect().y > 260 && p.getRect().y < 310)) {

                mapDecider+=2;
                p.getRect().setLocation(20,p.getRect().y);
            }
            if((p.getRect().x > 300 && p.getRect().x < 500) && p.getRect().y < 40) {
                mapDecider+=16;
                p.getRect().setLocation(p.getRect().x,510);
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
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 30) {
                mapDecider+=13;
                p.getRect().setLocation(p.getRect().x,500);
            }
        }
        if(mapDecider == 15) {
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 500) {
                mapDecider-=13;
                p.getRect().setLocation(p.getRect().x,30);
            }
            if(p.getRect().x < 30 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 16) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider--;
                p.getRect().setLocation(20,p.getRect().y);
            }
            if((p.getRect().x > 300 && p.getRect().x < 500) && p.getRect().y > 520) {
                mapDecider-=16;
                p.getRect().setLocation(p.getRect().x,50);
            }
            if(p.getRect().x < 30 && (p.getRect().y > 200 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 17) {
            if(p.getRect().x > 740  && (p.getRect().y > 200 && p.getRect().y < 400)) {
                mapDecider--;
                p.getRect().setLocation(30,p.getRect().y);
            }
            if(p.getRect().x < 30 && (p.getRect().y >20 && p.getRect().x < 520)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 18) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 520)) {
                mapDecider--;
                p.getRect().setLocation(30,p.getRect().y);
            }
            if(p.getRect().x < 30 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }

        }
        if(mapDecider == 19) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 520)) {
                mapDecider--;
                p.getRect().setLocation(30, p.getRect().y);
            }
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 40 ) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x, 510);
            }
        }
        if(mapDecider == 20) {
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 510) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,50);
            }
            if(p.getRect().x < 30 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 21) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect(). y < 550)) {
                mapDecider--;
                p.getRect().setLocation(30,p.getRect().y);
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
            if(p.getRect().x > 740 && (p.getRect().y > 30 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(20,p.getRect().y);
            }
            if((p.getRect().x > 300 && p.getRect().x < 710) && p.getRect().y < 30) {
                mapDecider+=3;
                p.getRect().setLocation(p.getRect().x,490);
            }
        }
        if(mapDecider == 6) {
            if( p.getRect().x < 20 && (p.getRect().y >30 && p.getRect().y < 400)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 30 && p.getRect().y < 400)) {
                mapDecider++;
                p.getRect().setLocation(30,p.getRect().y);
            }

        }
        if(mapDecider == 7) {
            if (p.getRect().x < 30 && (p.getRect().y > 30 && p.getRect().y < 400)) {
                mapDecider--;
                p.getRect().setLocation(740, p.getRect().y);
            }
//            if (p.getRect().x > 740 && (p.getRect().y > 30 && p.getRect().y < 400)) {
//                mapDecider+= 2;
//                p.getRect().setLocation(30, p.getRect().y);
//            }
        }
        if(mapDecider == 8) {
            if((p.getRect().x > 400 && p.getRect().x < 730) && p.getRect().y > 500) {
                mapDecider-=3;
                p.getRect().setLocation(p.getRect().x,50);
            }
            if((p.getRect().x > 3 && p.getRect().x < 797) && p.getRect().y < 30) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x, 500);
            }
        }
        if(mapDecider == 9) {
            if((p.getRect().x > 3 && p.getRect().x < 797) && p.getRect().y > 500) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,30);
            }
            if((p.getRect().x > 550 && p.getRect().x < 750) && p.getRect().y < 30) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x,500);
            }
        }
        if(mapDecider == 10) {
            if((p.getRect().x > 550 && p.getRect().x < 750) && p.getRect().y > 500) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,30);
            }
            if((p.getRect().x > 3 &&  p.getRect().x < 770) && p.getRect().y < 30) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x,500);
            }
        }
        if(mapDecider == 11) {
            if((p.getRect().x > 3 && p.getRect().x < 770) && p.getRect().y > 500) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,30);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider++;
                p.getRect().setLocation(25,p.getRect().y);
            }
        }
        if(mapDecider == 12) {
            if(p.getRect().x < 25 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider++;
                p.getRect().setLocation(25,p.getRect().y);
            }
            if((p.getRect().x > 130 && p.getRect().x < 200) && p.getRect().y < 20 ) {
                mapDecider+=2;
                p.getRect().setLocation(252, 520);
            }
        }
        if(mapDecider == 13) {
            if(p.getRect().x < 25 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }

        }
        if(mapDecider == 14) {
            if((p.getRect().x > 240 && p.getRect().x < 300) && p.getRect().y > 520) {
                mapDecider-=2;
                p.getRect().setLocation(154,20);
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
                    for (int j = playerLoc.x + 11; j < playerLoc.x + 35; j++) {
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

                for (int i = playerLoc.y+25 ; i < playerLoc.y+35; i++) {
                    for (int j = playerLoc.x +11; j < playerLoc.x + 35; j++) {
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
        // Only block green
        if(mapDecider == 0 || mapDecider == 8 || mapDecider == 9 || mapDecider == 15 || mapDecider == 16) {
            if (g > 80 && r + b < g) {
                onBoundary = true;
            }
        }
        // Block green and brown but not black

        // For where you meet old man
        if(mapDecider == 1 ) {

            if( (r> 1 && b> 1) && !(p.getRect().y > 500 && p.getRect().y < 599) && !(p.getRect().x > 330 && p.getRect().x < 443 ) ) {
                onBoundary = true;
            }
        }
        // Block any color other than almost white
        if(mapDecider == 2 || mapDecider == 3 || mapDecider == 4 || mapDecider == 5 || mapDecider == 6 || mapDecider == 7|| mapDecider == 10 || mapDecider == 11 || mapDecider == 13 || mapDecider == 17 || mapDecider == 19 || mapDecider == 20 || mapDecider == 21) {
            if(g < 100 || b < 100 || r < 100) {
                onBoundary = true;
            }
        }

        if(mapDecider == 12) {
            if(b < 100) {
                onBoundary = true;
            }
        }
        if(mapDecider == 18 )
            if(g < 100 || b < 100 || r < 100) {
                if (p.getRect().y < 243 || p.getRect().y > 300) {
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


