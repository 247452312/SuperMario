package model_factory;

import _static.Resources;
import core.Demo;
import util.Direction;

import java.awt.*;
import java.io.IOException;

public class MarioFactory {

    /**
     * 小人站立
     *
     * @return 小人站立image
     */
    public static Demo getSmallMarioStay() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    /**
     * 小人跑步1
     *
     * @return 小人跑步image
     */
    public static Demo getSmallMarioRun1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    /**
     * 小人跑步2
     *
     * @return 小人跑步image
     */
    public static Demo getSmallMarioRun2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(32, 0, 16, 16));
        return demo;
    }

    /**
     * 小人跑步3
     *
     * @return 小人跑步image
     */
    public static Demo getSmallMarioRun3() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(48, 0, 16, 16));
        return demo;
    }

    /**
     * 小人刹车
     *
     * @return 小人刹车image
     */
    public static Demo getSmallMarioBreak() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(64, 0, 16, 16));
        return demo;
    }

    /**
     * 小人跳
     *
     * @return 小人跳image
     */
    public static Demo getSmallMarioJump() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(80, 0, 16, 16));
        return demo;
    }

    /**
     * 小人死
     *
     * @return 小人死image
     */
    public static Demo getSmallMarioDead() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(2));
        demo.setDirection(new Direction(96, 0, 16, 16));
        return demo;
    }


    /**
     * 大人站立
     *
     * @return 大人站立image
     */
    public static Demo getBigMarioStay() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(0, 0, 16, 32));
        return demo;
    }

    /**
     * 大人跑步1
     *
     * @return 大人跑步image
     */
    public static Demo getBigMarioRun1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(16, 0, 16, 32));
        return demo;
    }

    /**
     * 大人跑步2
     *
     * @return 大人跑步image
     */
    public static Demo getBigMarioRun2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(32, 0, 16, 32));
        return demo;
    }

    /**
     * 大人跑步3
     *
     * @return 大人跑步image
     */
    public static Demo getBigMarioRun3() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(48, 0, 16, 32));
        return demo;
    }

    /**
     * 大人刹车
     *
     * @return 大人刹车image
     */
    public static Demo getBigMarioBreak() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(64, 0, 16, 32));
        return demo;
    }

    /**
     * 大人跳
     *
     * @return 大人跳image
     */
    public static Demo getBigMarioJump() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(80, 0, 16, 32));
        return demo;
    }

    /**
     * 大人蹲
     *
     * @return 大人死image
     */
    public static Demo getBigMarioDead() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(1));
        demo.setDirection(new Direction(96, 16, 16, 16));
        return demo;
    }

    /**
     * 子弹
     */
    public static Demo getBiu() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(12));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }


}
