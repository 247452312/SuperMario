package model;

import core.Demo;
import model_factory.BackgroundFactory;

public class Background extends model {
    private static Demo backgroundDemo = BackgroundFactory.getTheFirstBackground(0);

    public Background(Demo demo) {
        super(demo);
    }

    public static Demo getBackgroundDemo() {
        return backgroundDemo;
    }

}
