import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Environment {

    private int mapDecider = 35;
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
            if(mapDecider == 22) {
                im = ImageIO.read(new File("Envo22.png"));
            }
            if(mapDecider == 23) {
                im = ImageIO.read(new File("Envo23.png"));
            }
            if(mapDecider == 24) {
                im = ImageIO.read(new File("Envo24.png"));
            }
            if(mapDecider == 25) {
                im = ImageIO.read(new File("Envo25.png"));
            }
            if(mapDecider == 26) {
                im = ImageIO.read(new File("Envo26.png"));
            }
            if(mapDecider == 27) {
                im = ImageIO.read(new File("Envo27.png"));
            }
            if(mapDecider == 28) {
                im = ImageIO.read(new File("Envo28.png"));
            }
            if(mapDecider == 29) {
                im = ImageIO.read(new File("Envo29.png"));
            }
            if(mapDecider == 30) {
                im = ImageIO.read(new File("Envo30.png"));
            }
            if(mapDecider == 31) {
                im = ImageIO.read(new File("Envo31.png"));
            }
            if(mapDecider == 32) {
                im = ImageIO.read(new File("Envo32.png"));
            }
            if(mapDecider == 33) {
                im = ImageIO.read(new File("Envo33.png"));
            }
            if(mapDecider == 34) {
                im = ImageIO.read(new File("Envo34.png"));
            }
            if(mapDecider == 35) {
                im = ImageIO.read(new File("Envo35.png"));
            }
            if(mapDecider == 36) {
                im = ImageIO.read(new File("Envo36.png"));
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
            if(p.getRect().x > 720) {

                mapDecider+=2;
                p.getRect().setLocation(30,p.getRect().y);
            }
            if((p.getRect().x > 300 && p.getRect().x < 500) && p.getRect().y < 40) {
                mapDecider+=16;
                p.getRect().setLocation(p.getRect().x,510);
            }
            if(p.getRect().x < 30) {
                mapDecider+=30;
                p.getRect().setLocation(720,p.getRect().y);
            }
        }
        if(mapDecider == 30) {
            if(p.getRect(). x > 720) {
                mapDecider-=30;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if(p.getRect().y < 40) {
                mapDecider-=13;
                p.getRect().setLocation(p.getRect().x,510);
            }
            if(p.getRect().x < 40) {
                mapDecider++;
                p.getRect().setLocation(720,p.getRect().y);
            }
        }
        if(mapDecider == 31) {
            if (p.getRect().x > 720) {
                mapDecider--;
                p.getRect().setLocation(40,p.getRect().y);
            }
        }
        if(mapDecider == 1) {

            if ((p.getRect().x > 336 && p.getRect().x < 470) && (p.getRect().y > 510)) {

                mapDecider--;
                p.getRect().setLocation(179, 115);
            }
        }

        if (mapDecider == 2) {
           // System.out.println("x= " + p.getRect().x + " y= " + p.getRect().y);
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
            if((p.getRect().x > 30 && p.getRect().x < 780) && p.getRect().y > 500) {
                mapDecider-=13;
                p.getRect().setLocation(p.getRect().x,30);
            }
            else if(p.getRect().x < 40) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
            else if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 40) {
                mapDecider+=12;
                p.getRect().setLocation(p.getRect().x,500);
            }
            else if(p.getRect().x > 745) {
                mapDecider+=14;
                p.getRect().setLocation(40,p.getRect().y);
            }
        }
        if(mapDecider == 29) {
            if(p.getRect().x > 745) {
                mapDecider-=5;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if(p.getRect().x < 30) {
                mapDecider-=14;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().y < 40) {
                mapDecider-=3;
                p.getRect().setLocation(p.getRect().x,510);
            }
        }
        if(mapDecider == 16) {
           // System.out.println("its here");
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 580)) {
               // System.out.println("got there");
                mapDecider--;
                p.getRect().setLocation(40,p.getRect().y);
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
            if(p.getRect().x < 30 && (p.getRect().y >20 && p.getRect().y < 520)) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().y > 520) {
                mapDecider+=13;
                p.getRect().setLocation(p.getRect().x,40);
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
            if(p.getRect().x < 30 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider+=3;
                p.getRect().setLocation(730,p.getRect().y);
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
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 525)  {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x,40);
            }
        }
        if(mapDecider == 22) {
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 40) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,525);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider-=3;
                p.getRect().setLocation(30,p.getRect().y);
            }
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 525) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x,40);
            }
        }
        if(mapDecider == 23) {
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 40) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,525);
            }
            if(p.getRect().x > 740) {
                mapDecider+=5;
                p.getRect().setLocation(40,p.getRect().y);
            }
        }
        if(mapDecider == 28) {
            g.drawRect(400,250,40,70);
            if(p.getRect().x < 40) {
                mapDecider-=5;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if((p.getRect().x > 380 & p.getRect().x < 440) && (p.getRect().y > 250 && p.getRect().y < 290)) {
                mapDecider+=7;
                p.getRect().setLocation(380,480);
            }
        }
        if(mapDecider == 35) {
            if(p.getRect().y > 480 && (p.getRect().x > 366 && p.getRect().x < 444 )) {
                mapDecider-=7;
                p.getRect().setLocation(400,290);
            }

            if(p.getRect().x < 90 && (p.getRect().y > 265 && p.getRect().y <315) ) {
                mapDecider++;
                p.getRect().setLocation(662,293);
            }
        }
        if(mapDecider == 36) {

            if(p.getRect().x > 677 && (p.getRect().y > 270 && p.getRect().y < 345)) {
                mapDecider--;
                p.getRect().setLocation(99,293);
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

            if((p.getRect().x > 300 && p.getRect().x < 710) && p.getRect().y < 30) {
                mapDecider+=3;
                p.getRect().setLocation(p.getRect().x,490);
            }
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
            if(p.getRect().x < 40 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider+=16;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 24) {
            if(p.getRect().x > 740 && (p.getRect(). y > 20 && p.getRect().y < 580)) {
                mapDecider-=16;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y < 40) {
                mapDecider++;
                p.getRect().setLocation(p.getRect().x,525);
            }
            if(p.getRect().x < 40) {
                mapDecider+=5;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 25) {
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 525) {
                mapDecider--;
                p.getRect().setLocation(p.getRect().x,40);
            }
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider-=16;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if(p.getRect().x < 40 && (p.getRect().y >20 && p.getRect().y < 580 )) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
        }
        if(mapDecider == 26) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 780)) {
                mapDecider--;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if(p.getRect().x < 40 && (p.getRect().y >20 && p.getRect().y < 580 )) {
                mapDecider++;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().y > 510) {
                mapDecider+=3;
                p.getRect().setLocation(p.getRect().x,40);
            }
        }
        if(mapDecider == 27) {
            if(p.getRect().x > 740 && (p.getRect().y > 20 && p.getRect().y < 780)) {
                mapDecider--;
                p.getRect().setLocation(40,p.getRect().y);
            }
            if((p.getRect().x > 20 && p.getRect().x < 780) && p.getRect().y > 525) {
                mapDecider-=12;
                p.getRect().setLocation(p.getRect().x,40);
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
            if(p.getRect().x < 40 && (p.getRect().y > 20 && p.getRect().y < 580)) {
                mapDecider+=16;
                p.getRect().setLocation(740,p.getRect().y);
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
        }
        if(mapDecider == 13) {
            if(p.getRect().x < 25 && (p.getRect().y > 20 && p.getRect().y < 550)) {
                mapDecider--;
                p.getRect().setLocation(740,p.getRect().y);
            }
            if(p.getRect().y < 290 && (p.getRect().x > 275 && p.getRect().x < 340)) {
                mapDecider+=19;
               // System.out.println("here");
                p.getRect().setLocation(378,480);
            }

        }
        if(mapDecider == 32) {
            if(p.getRect().y > 480 && (p.getRect().x > 366 && p.getRect().x < 444 )) {
                mapDecider-=19;
                p.getRect().setLocation(310,290);
            }
            if(p.getRect().x < 90 && (p.getRect().y > 265 && p.getRect().y <315) ) {
                mapDecider++;
                p.getRect().setLocation(662,293);
            }
            if((p.getRect().x > 340 && p.getRect().x < 420) && p.getRect().y < 90) {
                mapDecider+=2;
                p.getRect().setLocation(p.getRect().x,500);
            }
        }
        if(mapDecider == 33) {
            if(p.getRect().x > 677 && (p.getRect().y > 270 && p.getRect().y < 345)) {
                mapDecider--;
                p.getRect().setLocation(99,293);
            }
        }
        if(mapDecider == 34) {
            if((p.getRect().x > 340 && p.getRect().x < 420) && p.getRect().y > 500) {
                mapDecider-=2;
                p.getRect().setLocation(p.getRect().x,90);
            }
        }
    }
    private void boundary(Graphics g) {

        g.setColor(Color.BLUE);
        //System.out.println(r.getPixelColor(p.getRect().x,p.getRect().y));
        //System.out.println("(" + p.getRect().x + " , " + p.getRect().y + ")");
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
        if(mapDecider == 0 || mapDecider == 8 || mapDecider == 9 || mapDecider == 16) {
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
        if(mapDecider == 2 || mapDecider == 3 || mapDecider == 4 || mapDecider == 5 || mapDecider == 15 || mapDecider == 6 || mapDecider == 7|| mapDecider == 10 || mapDecider == 11 || mapDecider == 13 || mapDecider == 17 || mapDecider == 19 || mapDecider == 20 || mapDecider == 21 || mapDecider == 22 || mapDecider == 23 || mapDecider == 24 || mapDecider == 25 || mapDecider == 26 || mapDecider == 27 || mapDecider == 29 || mapDecider == 30 || mapDecider == 31 || mapDecider == 28) {
            if(g < 100 || b < 100 || r < 100) {
                onBoundary = true;
            }
        }
        if(mapDecider == 32) {
            if (b > 100) {
                onBoundary = true;
            }
            if (!p.getRect().intersects(110, 110, 545, 383)) {
                onBoundary = true;
            }
        }
        if(mapDecider == 33) {

            if (!p.getRect().intersects(130, 130, 545, 362)) {
                if (!p.getRect().intersects(672, 233, 20, 100)) {
                    onBoundary = true;
                }
            }
        }
        if(mapDecider == 34) {
            if (!p.getRect().intersects(130, 130, 545, 382)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(202,227,46,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(202,345,46,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(550,345,46,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(550,227,46,50)) {
                onBoundary = true;
            }

        }
        if(mapDecider == 35) {
            if (!p.getRect().intersects(110, 130, 545, 382)) {
                onBoundary = true;
            }
            if ((r > 120 && r < 170)) {
                onBoundary = true;
            }
        }
        if(mapDecider == 36) {
            if (!p.getRect().intersects(130, 130, 565, 382)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(199,173,50,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(199,398,50,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(551,173,50,50)) {
                onBoundary = true;
            }
            if(p.getRect().intersects(551,398,50,50)) {
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
    public int getMapDecider() {
        return this.mapDecider;
    }



}


