package core;

import _static.Resources;
import model.Mario;
import model.Monster;
import model.Obstrcle;
import ui.MyFrame;
import util.AllDemo;

/**
 * 碰撞检测
 */
public class Impact extends Thread {
    AllDemo allDemo;
    Mario mario;
    MyFrame myFrame;

    public Impact(AllDemo allDemo, MyFrame myFrame) {
        this.allDemo = allDemo;
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
            for (Monster monster : allDemo.getMonsters()) {
                mario.rectangleToMonster(monster, myFrame);
            }
            int mark = 0;
            boolean b = false;
            //下降的碰撞检测
            for (Obstrcle obstrcle : allDemo.getObstrcles()) {
                mark = mario.rectangleToObstrcle(obstrcle);
                if (mark != 0) {
                    b = true;
                }
            }
            if (b == false) {
                mario.ySpeed += Resources.ACCELERATION_OF_GRAVITY;
                try {
                    sleep(1000 / Resources.FRAME_NUMBER);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
