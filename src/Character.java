import java.awt.*;

public abstract class Character {
    //private Image upMoveImg;
    //private Image rightMoveImg;
    //private Image downMoveImg;
    //private Image leftMoveImg;
    private Image upImg;
    private Image rightImg;
    private Image downImg;
    private Image leftImg;
    private Rectangle rect;
    private Robot robot;
    private int totalhp;
    private int currenthp=3;
    private int rupees;
    private int [] linksitems;
    private boolean bow = false;
    private boolean bluecandle = false;
    private boolean redcandle = false;
    private boolean boomerang = false;
    private boolean magicalboomerang = false;
    private boolean silverarrows = false;
    private boolean whistle = false;
    private boolean food = false;
    private boolean lifePotion= false;
    private boolean secondlifePotion= false;
    private boolean magicalRod= false;
    private boolean bookofmagic= false;
    private boolean bomb= false;

    public Character (Image up, Image right, Image down, Image left, int x, int y, int w, int hp, int money) {
        upImg = up;
        rightImg = right;
        downImg = down;
        leftImg = left;
        rect = new Rectangle(x,y,w,w);

    }

    public Image getUpImg() {
        return upImg;
    }

    public Image getLeftImg() {
        return leftImg;
    }

    public Image getDownImg() {
        return downImg;
    }

    public Image getRightImg() {
        return rightImg;
    }

    public Rectangle getRect() {
        return rect;
    }
    public Robot getRobot() {
        return robot;
    }
}

