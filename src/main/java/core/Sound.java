package core;

import javax.annotation.Resource;
import javax.swing.*;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeSet;

import _static.Resources;
import util.*;

public class Sound extends Thread {


    //地上
    public static final String BGM_S = "BGM.wav";
    //死亡
    public static final String DEAD_S = "死亡.wav";
    //子弹
    public static final String BULLET_S = "子弹.wav";
    //吃到蘑菇
    public static final String EAT_S = "吃到蘑菇.wav";
    //大跳跃
    public static final String BIGJUMP_S = "大跳跃.wav";
    //小跳跃
    public static final String SMALLJUMP_S = "小跳跃.wav";
    //死亡音乐
    public static final String DEADBGM_S = "死亡音乐.wav";
    //硬币
    public static final String COIN_S = "硬币.wav";
    //碎砖
    public static final String BROKEN_S = "碎砖.wav";
    //踩
    public static final String TREAD_S = "踩踏.wav";
    //顶转无效
    public static final String INVALID_S = "顶砖无效.wav";

    //地上
    public static final int BGM = 1;
    //死亡
    public static final int DEAD = 2;
    //子弹
    public static final int BULLET = 3;
    //吃到蘑菇
    public static final int EAT = 4;
    //大跳跃
    public static final int BIGJUMP = 5;
    //小跳跃
    public static final int SMALLJUMP = 6;
    //死亡音乐
    public static final int DEADBGM = 7;
    //硬币
    public static final int COIN = 8;
    //碎砖
    public static final int BROKEN = 9;
    //踩
    public static final int TREAD = 10;
    //顶转无效
    public static final int INVALID = 11;

    //正在播放的音乐
    private int mark = 1;
    //音乐播放
    private PlaySound playSound;

    public Sound(int type) {
        mark = type;
        playSound = Resources.playSounds.get(type - 1);
    }

    private boolean isRun = true;

    /**
     * 循环播放一个音乐
     */
    @Override
    public void run() {
        while (isRun) {
            playSound.play();
            lastSound();
        }
    }


    //转到下一个音乐
    private void lastSound() {
        if (mark == 2) {
            rightSound(7);
        } else if (mark == 1) {
            return;
        } else {
            rightSound(1);
        }
    }

    //确定音乐
    private void rightSound(int mark) {
        this.mark = mark;
        playSound = Resources.playSounds.get(mark - 1);
    }

    public void stopSound() {
        isRun = false;
        playSound.stop();
        playSound = null;
    }


    //暂停音乐
    public void waitSound() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //继续音乐
    public void continueSound() {
        this.notify();
    }

    //切换音乐
    public void switchSound(int mark) {
        Thread t = new Thread(this);
        t.interrupt();
        rightSound(mark);
        t.start();
    }


}

