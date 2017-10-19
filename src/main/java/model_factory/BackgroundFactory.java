package model_factory;

import _static.Resources;
import core.Demo;
import util.Direction;

import java.awt.*;
import java.io.IOException;

public class BackgroundFactory {

    public static Demo getTheFirstBackground(int y) {
        Demo demo = new Demo();
        demo.setImage(Resources.images.get(0));
        demo.setDirection(new Direction(0, y, 600, 224));
        return demo;
    }
}
