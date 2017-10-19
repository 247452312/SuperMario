package util;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.applet.AudioClip;
import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PlaySound {
    public AudioStream audioStream;
    public File file;

    public PlaySound(String filename) {
        try {
            setAudioClip(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAudioClip(String filename) throws IOException {
        file = new File("src/main/static/sound/" + filename);
        FileInputStream fis = new FileInputStream(file);
        audioStream = new AudioStream(fis);
    }


    public void play() {
        AudioPlayer.player.start(audioStream);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            FileInputStream fis = new FileInputStream(file);
            audioStream = new AudioStream(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playNoStop() {
        AudioPlayer.player.start(audioStream);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            audioStream = new AudioStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        AudioPlayer.player.stop(audioStream);
    }


}