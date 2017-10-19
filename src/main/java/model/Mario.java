package model;

import _static.Resources;
import core.Demo;
import core.Sound;
import model_factory.MarioFactory;
import model_factory.MonsterFactory;
import ui.MyFrame;
import util.AllDemo;
import util.PlaySound;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mario extends model {

    //行走速度
    public static final int SPEED = 1;

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    //垂直速度
    public int ySpeed = 0;

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    //横向速度
    public int xSpeed = 0;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    //方向 0为正 1为反
    private int direction;


    public Mario(Demo demo) {
        super(demo);
    }

    //检测与障碍的碰撞
    public int rectangleToObstrcle(Obstrcle obstrcle) {
        //malio的
        int x = getX();
        int y = getY();
        int w = getDemo().getDirection().getW();
        int h = getDemo().getDirection().getH();

        //障碍的
        int x1 = obstrcle.getX();
        int y1 = obstrcle.getY();
        int w1 = obstrcle.getDemo().getDirection().getW();
        int h1 = obstrcle.getDemo().getDirection().getH();
        if (x >= x1 - w && x <= x1 + w1 && y >= y1 - h && y <= y1 + h1) {
            //从上面碰
            if (y < y1 && ySpeed >= 0) {
                ySpeed = 0;
                setY(y1 - h);
                return 1;
            }
            //从左面碰撞
            if (x < x1 - 1 && xSpeed > 0) {
                setX(x1 - w);
                xSpeed = 0;
                return 2;
            }
            //从右面碰
            if (x > x1 + 1 && xSpeed < 0) {
                setX(x1 + w1);
                xSpeed = 0;
                return 4;
            }
            //从下面碰
            if (y > y1 && ySpeed < 0) {
                ySpeed = 0;
                setY(y1 + h1 + 1);
                return 3;
            }
        }
        return 0;
    }

    public void jump() {
        if (ySpeed == 0) {
            Resources.playSounds.get(4).playNoStop();
            ySpeed = Resources.JUMP_SPEED;
            y = y - 1;
        }

    }

    public void goRight() {
        if (xSpeed < Resources.SPEED) {
            setxSpeed(xSpeed + Resources.RUN_ACCELERATION_OF_GRAVITY);
        }
    }

    public void goLeft() {
        if (xSpeed > -Resources.SPEED) {
            setxSpeed(xSpeed - Resources.RUN_ACCELERATION_OF_GRAVITY);
        }
    }

    public void biu(final MyFrame myFrame) {
        Demo biuDemo = MarioFactory.getBiu();
        final Biu biu = new Biu(biuDemo);
        biu.setX(x);
        biu.setY(y);
        biu.setDir(direction);
        myFrame.add(biu);
        biu.setMyBound();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (biu.getDir() == 0) {
                        biu.setX(biu.getX() + Resources.BIU_SPEED);
                    } else {
                        biu.setX(biu.getX() - Resources.BIU_SPEED);
                    }
                    biu.setMyBound();
                    if (Math.abs(biu.getX() - x) > 600) {
                        myFrame.remove(biu);
                        break;
                    }
                    try {
                        sleep(1000 / Resources.FRAME_NUMBER);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    public void rectangleToMonster(Monster monster, MyFrame myFrame) {
        //malio的
        int x = getX();
        int y = getY();
        int w = getDemo().getDirection().getW();
        int h = getDemo().getDirection().getH();

        //怪物的
        int x1 = monster.getX();
        int y1 = monster.getY();
        int w1 = monster.getDemo().getDirection().getW();
        int h1 = monster.getDemo().getDirection().getH();
        if (x >= x1 - w && x <= x1 + w1 && y >= y1 - h && y <= y1 + h1) {
            //从上面碰
            if (y < y1 && ySpeed >= 0) {
                ySpeed = -6;
                setY(y1 - h);
                monster.setY(-20);
                monster.setX(-20);
                myFrame.remove(monster);
                myFrame.repaint();
                new PlaySound(Sound.SMALLJUMP_S).playNoStop();
            } else {
                dead(myFrame);
            }
        }
    }

    public void dead(MyFrame myFrame) {
        myFrame.stopMove();
        Demo demo = MarioFactory.getSmallMarioDead();
        setDemo(demo);
        setIcon(new ImageIcon(demo.getPic()));
        new PlaySound(Sound.DEAD_S).playNoStop();
        setMyBound();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new PlaySound(Sound.DEADBGM_S).playNoStop();
        for (int i = 10; ; i--) {
            setY(getY() - i);
            setMyBound();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == -40) {
                break;
            }
        }
    }
}
