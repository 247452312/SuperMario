package core;

import _static.Resources;
import sun.rmi.server.InactiveGroupException;
import util.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Demo {

    //位置
    public Direction direction;

    //大图片
    public Image image;


    public Direction getDirection() {
        return direction;
    }

    public Image getImage() {
        return image;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public void setImage(Image image) {
        this.image = image;
    }

    public Image getPic() {
        BufferedImage bi = (BufferedImage) image;
        return bi.getSubimage(direction.getX(), direction.getY(), direction.getW(), direction.getH());
    }


    public Image getPic(Direction direction) {
        this.direction = direction;
        return getPic();
    }

    public void setX(int x) {
        direction.setX(x);
    }

    public void setY(int y) {
        direction.setY(y);
    }

    public Demo change() {
        setImage(Resources.flipImage((BufferedImage) image));
        direction.setX(((BufferedImage) image).getWidth() - direction.getW() - direction.getX());
        return this;
    }
}
