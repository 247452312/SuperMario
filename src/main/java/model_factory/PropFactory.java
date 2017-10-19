package model_factory;

import _static.Resources;
import core.Demo;
import util.Direction;

import java.io.IOException;

/**
 * 道具
 */
public class PropFactory {

    //红蘑菇
    public static Demo getMushroomRed() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(9));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    //绿蘑菇
    public static Demo getMushroomGreen() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(9));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    //星星1
    public static Demo getStar1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(3));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    //星星2
    public static Demo getStar2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(3));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    //星星3
    public static Demo getStar3() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(3));
        demo.setDirection(new Direction(32, 0, 16, 16));
        return demo;
    }

    //星星4
    public static Demo getStar4() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(3));
        demo.setDirection(new Direction(48, 0, 16, 16));
        return demo;
    }
}

