import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OldMan extends Character{
	private static BufferedImage spriteSheet;
	private boolean change = false;
	
	public OldMan() {
		super(null, null, getImage(30,0,20,25), null, null, null, null, null, 375, 200, 60, 75);
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("npc.png"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}
	
	public void draw(Graphics g) {
		g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getHeight()), null);
		
	}

}
