package model_factory;

import _static.Resources;
import core.Demo;
import util.Direction;

import java.io.IOException;

/**
 * 怪物工厂
 */
public class MonsterFactory {
    /**
     * 蘑菇走1
     *
     * @return
     */
    public static Demo getMonster1Run1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(4));
        demo.setDirection(new Direction(0, 0, 16, 16));
        return demo;
    }

    /**
     * 蘑菇走2
     *
     * @return
     */
    public static Demo getMonster1Run2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(4));
        demo.setDirection(new Direction(16, 0, 16, 16));
        return demo;
    }

    /**
     * 蘑菇死
     *
     * @return
     */
    public static Demo getMonster1Dead() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(4));
        demo.setDirection(new Direction(32, 0, 16, 16));
        return demo;
    }


    /**
     * 鸭子走1
     *
     * @return
     */
    public static Demo getMonster2Run1() {
        Demo demo = new Demo();

        demo.setImage(Resources.images.get(5));
        demo.setDirection(new Direction(0, 0, 16, 24));
        return demo;
    }

    /**
     * 鸭子走2
     *
     * @return
     */
    public static Demo getMonster2Run2() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(5));
        demo.setDirection(new Direction(16, 0, 16, 24));
        return demo;
    }

    /**
     * 鸭子死1
     *
     * @return
     */
    public static Demo getMonster2Dead() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(5));
        demo.setDirection(new Direction(64, 0, 16, 24));
        return demo;
    }

    /**
     * 鸭子要活
     *
     * @return
     */
    public static Demo getMonster2Dead1() {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(5));
        demo.setDirection(new Direction(80, 0, 16, 24));
        return demo;
    }
}
