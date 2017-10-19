package core;

import _static.Resources;
import model.Mario;
import model_factory.MarioFactory;
import ui.MyFrame;
import util.AllDemo;
import util.PlaySound;

import javax.swing.*;

/**
 * 改变位置
 */
public class XThread extends Thread {
    private AllDemo allDemo;
    private Mario mario;
    private int i = 0;
    private boolean[] key;
    private MyFrame myFrame;

    public XThread(AllDemo allDemo, boolean[] key, MyFrame myFrame) {
        this.allDemo = allDemo;
        this.key = key;
        this.mario = allDemo.getMario();
        this.myFrame = myFrame;
    }

    public void stopThread() {
        isRun = false;
    }

    private boolean isRun = true;

    @Override
    public void run() {
        while (isRun) {
            mario.x += mario.xSpeed;
            mario.y += mario.ySpeed;
            if (mario.y > 250) {
                mario.dead(myFrame);
            }
            if (mario.xSpeed > 0)
                mario.xSpeed -= Resources.FRICTION_FORCE;
            if (mario.xSpeed < 0)
                mario.xSpeed += Resources.FRICTION_FORCE;

            Demo demo = null;
            if (mario.ySpeed == 0) {//没有跳
                if (mario.xSpeed != 0) {
                    if (i == 0) demo = MarioFactory.getSmallMarioRun1();
                    if (i == 1) demo = MarioFactory.getSmallMarioRun2();
                    if (i == 2) demo = MarioFactory.getSmallMarioRun3();
                    i++;
                    if (i > 2) i = 0;
                } else {//原地
                    demo = MarioFactory.getSmallMarioStay();
                }
            } else {//跳跃中
                demo = MarioFactory.getSmallMarioJump();
            }
            if (mario.getDirection() == 1) demo = demo.change();
            mario.setDemo(demo);
            mario.setIcon(new ImageIcon(demo.getPic()));
//            System.out.println("mario.xSpeed:" + mario.xSpeed + "--------mario.ySpeed:" + mario.ySpeed + "----dir:" + mario.getDirection());


            if (key[1] == true) {
                mario.setDirection(1);
                if (mario.xSpeed > -Resources.SPEED)
                    mario.xSpeed -= Resources.RUN_ACCELERATION_OF_GRAVITY;
            }
            if (key[3] == true) {
                mario.setDirection(0);
                if (mario.xSpeed < Resources.SPEED)
                    mario.xSpeed += Resources.RUN_ACCELERATION_OF_GRAVITY;
            }
            mario.setMyBound();
            try {
                sleep(1000 / Resources.FRAME_NUMBER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
