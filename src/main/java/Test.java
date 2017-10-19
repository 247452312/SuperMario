import core.Sound;

public class Test {
    public static void main(String[] args) {
        new Thread(new Sound(Sound.DEAD)).start();
    }
}
