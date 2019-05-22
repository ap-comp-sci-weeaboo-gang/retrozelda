import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile {
	Rectangle area;
	Image image;
	static BufferedImage spriteSheet;
	boolean visible = false;
	
	public Projectile(int x, int y, int w, int h, String s) {
		area = new Rectangle(x,y,w,h);
		if (s.equals("moblin")) {
			image = getImage(90,300,15,15);
		}
		else {
			image = getImage(330,0,15,15);
		}
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("enemies.png"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}
	
	public void draw(Graphics g, Rectangle rect) {
		if (visible == true) {
			g.drawImage(image,(int)(area.getX()),(int)(area.getY()),(int)(area.getWidth()),(int)(area.getWidth()), null);
		}
		else if (visible == false) {
			area.setLocation((int)(rect.getX()),(int) (rect.getY()));
		}
	}
	
	public void move(String s, Rectangle rect) {
		visible = true;
		if (s.equals("left")) {
			//if(area.getX()>0) {
				area.translate(-20, 0);
			//}
		}
		else if (s.equals("right")) {
			//if(area.getX()<1137) {
				area.translate(20, 0);
			//}
		}
		else if (s.equals("up")) {
			//if(area.getY()>0) {
				area.translate(0, -20);
			//}
		}
		else if (s.equals("down")) {
			//if(area.getY()<622) {
				area.translate(0, 20);
			//}
		}
		if (area.getX()<0 || area.getX()>1137 || area.getY()<0 || area.getY()>622) {
			visible = false;
		}
	}
	
	public boolean getVisible() {
		return this.visible;
	}
	
	public void setLoc(int x, int y) {
		area.setLocation(x, y);
	}
}
