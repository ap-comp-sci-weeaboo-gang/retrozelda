import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boomerang {
	Rectangle area;
	Image image;
	boolean visible = false;
	private int moves;
	private boolean back;
	
	public Boomerang(int x, int y, int w, int h) {
		area = new Rectangle(x,y,w,h);
		image = getImage();
	}
	
	private Image getImage() {
		Image img = null;
		try {
			img = ImageIO.read(new File("boomerang.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
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
			if (moves > 200 && moves < 400) {
				area.translate(20, 0);
			}
			else if (moves >= 400) {
				moves = 0;
				visible = false;
				back = true;
			}
			else 
				area.translate(-20, 0);
		}
		else if (s.equals("right")) {
			if (moves > 200 && moves < 400) {
				area.translate(-20, 0);
			}
			else if (moves >= 400) {
				moves = 0;
				visible = false;
				back = true;
			}
			else 
				area.translate(20, 0);
		}
		else if (s.equals("up")) {
			if (moves > 200 && moves < 400) {
				area.translate(0, 20);
			}
			else if (moves >= 400) {
				moves = 0;
				visible = false;
				back = true;
			}
			else
				area.translate(0, -20);
		}
		else if (s.equals("down")) {
			if (moves > 200 && moves < 400) {
				area.translate(0, -20);
			}
			else if (moves >= 400) {
				moves = 0;
				visible = false;
				back = true;
			}
			else 
				area.translate(0, 20);
		}
		moves+= 20;
		System.out.println(moves);
		if (area.getX()<0 || area.getX()>800 || area.getY()<0 || area.getY()>600) {
			visible = false;
		}
	}
	
	public boolean getBack() {
		return this.back;
	}
	
	public void setBack(boolean b) {
		back = b;
	}

	public boolean getVisible() {
		return this.visible;
	}
	
	public void setLoc(int x, int y) {
		area.setLocation(x, y);
	}
}