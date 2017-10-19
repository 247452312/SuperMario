package _static;

import core.Sound;
import util.PlaySound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 静态资源类
 * e.g.图片,
 */
public class Resources {
    //重力加速度
    public static final int ACCELERATION_OF_GRAVITY = 1;
    //行走速度
    public static final int SPEED = 4;
    //行走加速度
    public static final int RUN_ACCELERATION_OF_GRAVITY = 2;

    //摩擦力
    public static final int FRICTION_FORCE = 1;
    //跳跃初始值
    public static final int JUMP_SPEED = -15;
    //帧数
    public static final int FRAME_NUMBER = 50;
    //子弹速度
    public static final int BIU_SPEED = 15;

    public static List<PlaySound> playSounds = new ArrayList<PlaySound>();
    public static List<Image> images = new ArrayList<Image>();

    static {
        playSounds.add(new PlaySound(Sound.BGM_S));
        playSounds.add(new PlaySound(Sound.DEAD_S));
        playSounds.add(new PlaySound(Sound.BULLET_S));
        playSounds.add(new PlaySound(Sound.EAT_S));
        playSounds.add(new PlaySound(Sound.BIGJUMP_S));
        playSounds.add(new PlaySound(Sound.SMALLJUMP_S));
        playSounds.add(new PlaySound(Sound.DEADBGM_S));
        playSounds.add(new PlaySound(Sound.COIN_S));
        playSounds.add(new PlaySound(Sound.BROKEN_S));
        playSounds.add(new PlaySound(Sound.TREAD_S));
        playSounds.add(new PlaySound(Sound.INVALID_S));


        images.add(getImage("src/main/static/background/20592.png"));
        images.add(getImage("src/main/static/picture/大人.png"));
        images.add(getImage("src/main/static/picture/小人.png"));
        images.add(getImage("src/main/static/picture/星星.png"));
        images.add(getImage("src/main/static/picture/杂兵01.png"));
        images.add(getImage("src/main/static/picture/杂兵02.png"));
        images.add(getImage("src/main/static/picture/碎砖.png"));
        images.add(getImage("src/main/static/picture/第一关贴图.png"));
        images.add(getImage("src/main/static/picture/花.png"));
        images.add(getImage("src/main/static/picture/蘑菇.png"));
        images.add(getImage("src/main/static/picture/金币.png"));
        images.add(getImage("src/main/static/picture/金币砖.png"));
        images.add(getImage("src/main/static/picture/子弹.png"));
    }

    public static Image getImage(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(fileName));
            return ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage flipImage(final BufferedImage bufferedimage) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, bufferedimage
                .getColorModel().getTransparency())).createGraphics())
                .drawImage(bufferedimage, 0, 0, w, h, w, 0, 0, h, null);
        graphics2d.dispose();
        return img;
//        AffineTransform transform = new AffineTransform(-1, 0, 0, 1, bufferedimage.getWidth() - 1, 0);
//        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
//        return op.filter(bufferedimage, null);
    }

}
