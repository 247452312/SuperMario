package util;

import ui.MyFrame;

public class RepaintThread extends Thread {
    private MyFrame my;
    @Override
    public void run() {
        my.repaint();
    }

}
