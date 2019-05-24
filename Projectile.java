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
	
	public Projectile(int x, int y, int w, int h, String s, int px, int py, int pw, int ph) {
		area = new Rectangle(x,y,w,h);
		image = getImage(px,py,pw,ph, s);
	}
	
	private static Image getImage(int x, int y, int w, int h, String s) {
		try {
			spriteSheet = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}
	
	public void draw(Graphics g, Rectangle rect) {
		if (visible == true) {
			g.drawImage(image,(int)(area.getX()),(int)(area.getY()),(int)(area.getWidth()),(int)(area.getHeight()), null);
		}
		else if (visible == false) {
			area.setLocation((int)(rect.getX())+20,(int) (rect.getY())+20);
		}
	}
	
	public void move(String s, Rectangle rect) {
		visible = true;
		if (s.equals("left")) {
			area.translate(-20, 0);
		}
		else if (s.equals("right")) {
			area.translate(20, 0);
		}
		else if (s.equals("up")) {
			area.translate(0, -20);
		}
		else if (s.equals("down")) {
			area.translate(0, 20);
		}
		if (area.getX()<0 || area.getX()>800 || area.getY()<0 || area.getY()>600) {
			visible = false;
		}
	}
	
	public boolean getVisible() {
		return this.visible;
	}
	
	public void setLoc(int x, int y) {
		area.setLocation(x, y);
	}
	
	public Rectangle getArea() {
		return this.area;
	}
}
