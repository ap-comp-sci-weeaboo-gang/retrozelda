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

    public Character (Image up, Image right, Image down, Image left, int x, int y, int w) {
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

