package model;

import core.Demo;
import model_factory.MonsterFactory;

import javax.swing.*;

public class Enemy1 extends Monster {

    public Enemy1(Demo demo) {
        super(demo);
        move.start();
    }

    boolean isLive = true;
    private int dir = 0;
    private int pic = 1;

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Thread move = new Thread() {

        @Override
        public void run() {
            while (true) {
                x -= 1;
                if (pic == 1) {
                    pic = 0;
                    setDemo(MonsterFactory.getMonster1Run2());
                    setIcon(new ImageIcon(getDemo().getPic()));
                }
                if (pic == 0) {
                    pic = 1;
                    setDemo(MonsterFactory.getMonster1Run1());
                    setIcon(new ImageIcon(getDemo().getPic()));
                }
                if (pic == 2) {
                    setDemo(MonsterFactory.getMonster1Dead());
                    setIcon(new ImageIcon(getDemo().getPic()));
                }

                setMyBound();
                try {
                    sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isLive == false) break;
            }
        }
    };

    public void dead() {
        isLive = false;
        pic = 2;
    }
}
