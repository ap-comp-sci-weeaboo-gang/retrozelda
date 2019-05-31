import java.awt.*;

public abstract class Character {
    private Image upMoveImg;
    private Image rightMoveImg;
    private Image downMoveImg;
    private Image leftMoveImg;
    private Image upImg;
    private Image rightImg;
    private Image downImg;
    private Image leftImg;
    private Rectangle rect;
    private Robot robot;
    private boolean dead = true;

    public Character (Image up, Image right, Image down, Image left,
                      Image moveU, Image moveR, Image moveD, Image moveL, int x, int y, int w, int h) {
        upImg = up;
        rightImg = right;
        downImg = down;
        leftImg = left;
        upMoveImg = moveU;
        rightMoveImg = moveR;
        downMoveImg = moveD;
        leftMoveImg = moveL;

        rect = new Rectangle(x,y,w,h);
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

    public Image getUpMoveImg() {
        return upMoveImg;
    }

    public Image getLeftMoveImg() {
        return leftMoveImg;
    }

    public Image getDownMoveImg() {
        return downMoveImg;
    }

    public Image getRightMoveImg() {
        return rightMoveImg;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setDead(boolean set) {
        dead = set;
    }

    public boolean getDead() {
        return dead;
    }
    public void movePattern(Player p) {
    }
    public void draw(Graphics g) {
    }

    //rock dungeon: tektite, leever, octorok
    //forest: moblin, octorok, peahat
    //enemies: darknut, leever, like-like, moblin, octorok, pols voice, tektite,
    //maybe: peahat, lynel, vire, wizrobe, zol,
}