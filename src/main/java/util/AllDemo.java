package util;

import core.Demo;
import model.*;
import model_factory.BackgroundFactory;
import model_factory.MarioFactory;
import model_factory.MonsterFactory;
import model_factory.ObstrcleFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AllDemo {
    private Mario mario = new Mario(MarioFactory.getSmallMarioStay());

    //怪物
    private List<Monster> monsters = new ArrayList<Monster>();
    //障碍
    private List<Obstrcle> obstrcles = new ArrayList<Obstrcle>();
    //道具
    private List<Prop> props = new ArrayList<Prop>();

    private void setBounds() {
        mario.setMyBound();
        for (Monster monster : monsters) {
            monster.setMyBound();
        }
        for (Obstrcle obstrcle : obstrcles) {
            obstrcle.setMyBound();
        }
        for (Prop prop : props) {
            prop.setMyBound();
        }
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Obstrcle> getObstrcles() {
        return obstrcles;
    }

    public void setObstrcles(List<Obstrcle> obstrcles) {
        this.obstrcles = obstrcles;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }

    public List<List<Integer>> getMap() {
        return map;
    }

    public void setMap(List<List<Integer>> map) {
        this.map = map;
    }

    private void setOffset() {
        //i行j列
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                int mark = map.get(i).get(j);
                switch (mark) {
                    case 1:
                        Obstrcle obstrcle = new Obstrcle(ObstrcleFactory.getBrick());
                        obstrcle.setOffset(j * 16, i * 16);
                        obstrcles.add(obstrcle);
                        break;
                    case 2:
                        Obstrcle obstrcle1 = new Obstrcle(ObstrcleFactory.getCoinBrick());
                        obstrcle1.setOffset(j * 16, i * 16);
                        obstrcles.add(obstrcle1);
                        break;
                    case 3:
                        Obstrcle obstrcle2 = new Obstrcle(ObstrcleFactory.getPiping1());
                        obstrcle2.setOffset(j * 16, i * 16);
                        obstrcles.add(obstrcle2);
                        break;
                    case 4:
                        Obstrcle obstrcle3 = new Obstrcle(ObstrcleFactory.getPiping2());
                        obstrcle3.setOffset(j * 16, i * 16);
                        obstrcles.add(obstrcle3);
                        break;
                    case 5:
                        Obstrcle obstrcle4 = new Obstrcle(ObstrcleFactory.getWall1());
                        obstrcle4.setOffset(j * 16, i * 16);
                        obstrcles.add(obstrcle4);
                        break;
                    case 6:
                        mario.setOffset(j * 16, i * 16);
                        break;
                    case 7:
                        Monster monster = new Enemy1(MonsterFactory.getMonster1Run1());
                        monster.setOffset(j * 16, i * 16);
                        monsters.add(monster);
                        break;
                }
            }
        }
    }

    private List<List<Integer>> map = new ArrayList<List<Integer>>();

    public AllDemo() {
        readMap();
        setOffset();
        setBounds();
    }


    private void readMap() {
        FileInputStream f = null;
        try {
            f = new FileInputStream("src/main/static/maps/FirstMap.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[][] b = new char[14][];
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String s = null;
        int i = 0;
        try {
            while ((s = br.readLine()) != null) {
                char[] bs = s.toCharArray();
                b[i] = bs;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (i = 0; i < b.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < b[i].length; j++) {
                temp.add(b[i][j] - 48);
            }
            map.add(temp);
        }
    }

    public int getCharAt(int x, int y) {
        return map.get(y).get(x);
    }


    public Mario getMario() {
        return mario;
    }


}
