package model;

import core.Demo;

import javax.swing.*;

public class model extends JLabel {
    //偏移
    public int x = 0;
    public int y = 0;

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Demo demo;

    public void setOffset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public model(Demo demo) {
        super();
        setDemo(demo);
        setIcon(new ImageIcon(demo.getPic()));
    }

    public void setMyBound() {
        setBounds(x, y, demo.getPic().getWidth(null), demo.getPic().getHeight(null));
    }



}
