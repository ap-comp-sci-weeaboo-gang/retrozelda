import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dropables {
	private Image hearts;
	private Image potion;
	private Image rupeeImg;
	private Player p;
	private Rectangle rect;
	public Dropables(Player d) {
		p = d;
		try {
			hearts=ImageIO.read(new File("heart.png"));
			rupeeImg=ImageIO.read(new File("rupees.png"));
			potion=ImageIO.read(new File("potion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Rectangle getRect() {
		return rect;
	}
	public void drawPotion(Graphics g, int x, int y) {
		g.drawImage(potion,x,y,25,25,null);
	}
	public void drawHearts(Graphics g, int x, int y) {
		g.drawImage(hearts,x,y,25,15,null);
	}
	public void drawRupees(Graphics g, int x, int y) {
		g.drawImage(rupeeImg,x,y,35,25,null);
	}
}
