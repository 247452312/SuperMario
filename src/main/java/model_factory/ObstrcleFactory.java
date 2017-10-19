package model_factory;

import _static.Resources;
import core.Demo;
import util.Direction;

import java.io.IOException;

/**
 * 障碍
 */
public class ObstrcleFactory {


    //碎砖
    public static Demo getLittleBrick() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(6));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    //砖
    public static Demo getBrick() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(6));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    //金币砖
    public static Demo getCoinBrick() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(11));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    //金币砖黑1
    public static Demo getCoinBrickBlack1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(11));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    //金币砖黑2
    public static Demo getCoinBrickBlack2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(11));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    //金币砖黑3
    public static Demo getCoinBrickBlack3() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(11));
        demo.setDirection(new Direction(32, 0, 16, 16));
        return demo;
    }

    //金币砖空
    public static Demo getCoinBrickNull() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(11));
        demo.setDirection(new Direction(48, 0, 16, 16));
        return demo;
    }

    //墙1
    public static Demo getWall1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(7));
        demo.setDirection(new Direction(0, 16, 16, 16));
        return demo;
    }

    //墙2
    public static Demo getWall2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(7));
        demo.setDirection(new Direction(16, 16, 16, 16));
        return demo;
    }

    //管道上
    public static Demo getPiping1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(7));
        demo.setDirection(new Direction(32, 0, 16, 32));
        return demo;
    }

    //管道下
    public static Demo getPiping2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(7));
        demo.setDirection(new Direction(32, 16, 16, 32));
        return demo;
    }


}
