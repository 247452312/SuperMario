package ui;

import core.*;
import model.*;
import util.AllDemo;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyFrame extends JFrame implements KeyListener {


    public AllDemo allDemo = new AllDemo();
    public Sound sound = new Sound(Sound.BGM);
    public Impact impact;
    public XThread xThread;
    //w-0,a-1,s-2,d-3
    public boolean[] key = {false, false, false, false};

    {
        xThread = new XThread(allDemo, key, this);
        impact = new Impact(allDemo, this);
    }

    public MyFrame() throws IOException {
        addDemo();
        setDefaultCloseOperation(3);
        addKeyListener(this);
        setSize(800, 250);
        setLocation(300, 150);
        setResizable(false);
        setLayout(null);
        runThread();
        setVisible(true);

    }

    private void runThread() {
        sound.start();
        impact.start();
        xThread.start();
    }

    private void addDemo() {
        for (Obstrcle obstrcle : allDemo.getObstrcles()) {
            add(obstrcle);
        }
        add(allDemo.getMario());
        for (Monster monster : allDemo.getMonsters()) {
            add(monster);
        }
        for (Prop prop : allDemo.getProps()) {
            add(prop);
        }
    }

    public static void main(String[] args) throws IOException {
        new MyFrame();
    }

    public void stopMove() {
        xThread.stopThread();
        impact.stopThread();
        sound.stopSound();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'k') {
            allDemo.getMario().jump();
        }
        if (e.getKeyChar() == 'j') {
            allDemo.getMario().biu(this);
        }
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            key[0] = true;
        }
        if (e.getKeyChar() == 'a') {
            key[1] = true;
        }
        if (e.getKeyChar() == 's') {
            key[2] = true;
        }
        if (e.getKeyChar() == 'd') {
            key[3] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            key[0] = false;
        }
        if (e.getKeyChar() == 'a') {
            key[1] = false;
        }
        if (e.getKeyChar() == 's') {
            key[2] = false;
        }
        if (e.getKeyChar() == 'd') {
            key[3] = false;
        }
    }
}
