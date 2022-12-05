import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    // khung game
    private final int B_WIDTH = 1100;
    private final int B_HEIGHT = 600;
    // tốc độ nhân vật
    private final int DOT_SIZE = 4;
    // tốc độ quái
    private final int DELAY = 30;
    // vị trí nv
    private int x, y;
    // biến đếm run
    private int x1, y1;
    private int x2 = 0;
    // vị trí mũi tên menu
    private int ymn = 180;
    // vị trí quái
    private int monster_x[] = new int[5];
    private int monster_y[] = new int[5];
    // level bắt đầu
    private int lvl = 2;
    // đếm tgian dùng skill
    private int at1 = 0;
    private int at2 = 0;
    // đếm chạy
    private int r = 0;
    // máu người
    private int h = 6;
    // hồi máu
    private int heal = 0;
    // điểm
    private int score = 0;
    // đếm quái di chuyển
    private int t = 0;
    // đếm quái tấn công
    private int u[] = new int[5];
    // đếm quái chết
    private int p[] = new int[5];
    // máu quái
    private int hmt[] = new int[5];
    // biến mở đầu || kết thúc game
    private boolean inGame = true;
    // menu
    private boolean menu = true;
    private boolean start = false;
    private boolean level = false;
    private boolean character = false;
    // bản đồ bắt đầu
    private boolean bando1 = true;
    private boolean bando2 = false;
    private boolean bando3 = false;
    // di chuyển
    private boolean up = true;
    private boolean down = true;
    private boolean right1 = true;
    private boolean left1 = true;
    // di chuyển quái
    private boolean upmt[] = new boolean[5];
    private boolean downmt[] = new boolean[5];
    private boolean rightmt[] = new boolean[5];
    private boolean leftmt[] = new boolean[5];
    // tấn công
    private boolean attack1 = false;
    private boolean attack2 = false;
    private boolean at = false;
    // quái tấn công
    private boolean mtat1 = false;
    // nhân vật
    private boolean meliodas = true;
    private boolean escanor = false;
    private boolean diana = false;
    // nhân vật chạy
    private boolean run = false;
    private boolean left = true;
    private boolean right = false;
    // quái chạy
    private boolean mtrun[] = new boolean[5];
    // quái di chuyển
    private boolean left2 = true;
    private boolean right2 = false;
    // biến tgian
    private Timer timer;
    // ảnh menu
    private Image map;
    private Image mouse;
    // ảnh map
    private Image map1;
    private Image map2;
    // ảnh nv đứng im
    private Image main;
    // ảnh nv chết
    private Image main0;
    // ảnh nv chạy
    private Image mainr;
    private Image mainr1;
    private Image mainr2;
    // ảnh skill 1
    private Image main11;
    private Image main12;
    private Image main13;
    // ảnh skill 2
    private Image main21;
    private Image main22;
    private Image main23;
    // ảnh máu
    private Image h1;
    private Image h2;
    private Image h3;
    private Image h4;
    private Image h5;
    private Image h6;
    // ảnh quái vật 1
    private Image monster;
    private Image monstera;
    private Image monsterb;
    private Image monsterc;
    // ảnh quái vật 2
    private Image monster1;
    private Image monster1a;
    private Image monster1b;
    private Image monster1c;
    // ảnh quái vật 1 tấn công
    private Image monsterat;
    private Image monsterata;
    private Image monsteratb;
    private Image monsteratc;
    private Image monsteratd;
    private Image monsterate;
    private Image monsteratf;
    private Image monsteratg;
    // ảnh quái vật 2 tấn công
    private Image monster1at;
    private Image monster1ata;
    private Image monster1atb;
    private Image monster1atc;
    private Image monster1atd;
    private Image monster1ate;
    private Image monster1atf;
    private Image monster1atg;
    // ảnh quái vật 1 chết
    private Image monsterdie;
    private Image monsterdiea;
    private Image monsterdieb;
    private Image monsterdiec;
    // ảnh quái vật 2 chết
    private Image monster1die;
    private Image monster1diea;
    private Image monster1dieb;
    private Image monster1diec;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        loadcharacter();
        loadmonster();
        loadheal();
        initGame();
    }

    private void loadImages() {

        // menu
        ImageIcon map0 = new ImageIcon("menu/map.png");
        map = map0.getImage();

        ImageIcon mouse1 = new ImageIcon("menu/mouse.png");
        mouse = mouse1.getImage();

        // load map
        ImageIcon map4 = new ImageIcon("map/map1.jpg");
        map1 = map4.getImage();

        ImageIcon map5 = new ImageIcon("map/map2.jpg");
        map2 = map5.getImage();
    }

    private void loadmonster() {
        if (left2) {
            // load quái
            ImageIcon qv = new ImageIcon("monster/monster.png");
            monster = qv.getImage();
            ImageIcon qva = new ImageIcon("monster/monstera.png");
            monstera = qva.getImage();
            ImageIcon qvb = new ImageIcon("monster/monsterb.png");
            monsterb = qvb.getImage();
            ImageIcon qvc = new ImageIcon("monster/monsterc.png");
            monsterc = qvc.getImage();
            // load quái2
            ImageIcon qv1 = new ImageIcon("monster/monster1.png");
            monster1 = qv1.getImage();
            ImageIcon qv1a = new ImageIcon("monster/monster1a.png");
            monster1a = qv1a.getImage();
            ImageIcon qv1b = new ImageIcon("monster/monster1b.png");
            monster1b = qv1b.getImage();
            ImageIcon qv1c = new ImageIcon("monster/monster1c.png");
            monster1c = qv1c.getImage();
            // load quái 1 chết
            ImageIcon qvdie = new ImageIcon("monster/monsterdie.png");
            monsterdie = qvdie.getImage();
            ImageIcon qvdiea = new ImageIcon("monster/monsterdiea.png");
            monsterdiea = qvdiea.getImage();
            ImageIcon qvdieb = new ImageIcon("monster/monsterdieb.png");
            monsterdieb = qvdieb.getImage();
            ImageIcon qvdiec = new ImageIcon("monster/monsterdiec.png");
            monsterdiec = qvdiec.getImage();
            // load quái2 chết
            ImageIcon qv1die = new ImageIcon("monster/monsterdie1.png");
            monster1die = qv1die.getImage();
            ImageIcon qv1diea = new ImageIcon("monster/monsterdie1a.png");
            monster1diea = qv1diea.getImage();
            ImageIcon qv1dieb = new ImageIcon("monster/monsterdie1b.png");
            monster1dieb = qv1dieb.getImage();
            ImageIcon qv1diec = new ImageIcon("monster/monsterdie1c.png");
            monster1diec = qv1diec.getImage();
        }
        if (right2) {
            // load quái
            ImageIcon qv = new ImageIcon("monster/monster-.png");
            monster = qv.getImage();
            ImageIcon qva = new ImageIcon("monster/monster-a.png");
            monstera = qva.getImage();
            ImageIcon qvb = new ImageIcon("monster/monster-b.png");
            monsterb = qvb.getImage();
            ImageIcon qvc = new ImageIcon("monster/monster-c.png");
            monsterc = qvc.getImage();
            // load quái2
            ImageIcon qv1 = new ImageIcon("monster/monster-1.png");
            monster1 = qv1.getImage();
            ImageIcon qv1a = new ImageIcon("monster/monster-1a.png");
            monster1a = qv1a.getImage();
            ImageIcon qv1b = new ImageIcon("monster/monster-1b.png");
            monster1b = qv1b.getImage();
            ImageIcon qv1c = new ImageIcon("monster/monster-1c.png");
            monster1c = qv1c.getImage();
            // load quái1 chết
            ImageIcon qvdie = new ImageIcon("monster/monsterdie-.png");
            monsterdie = qvdie.getImage();
            ImageIcon qvdiea = new ImageIcon("monster/monsterdie-a.png");
            monsterdiea = qvdiea.getImage();
            ImageIcon qvdieb = new ImageIcon("monster/monsterdie-b.png");
            monsterdieb = qvdieb.getImage();
            ImageIcon qvdiec = new ImageIcon("monster/monsterdie-c.png");
            monsterdiec = qvdiec.getImage();
            // load quái2 chết
            ImageIcon qv1die = new ImageIcon("monster/monsterdie-1.png");
            monster1die = qv1die.getImage();
            ImageIcon qv1diea = new ImageIcon("monster/monsterdie-1a.png");
            monster1diea = qv1diea.getImage();
            ImageIcon qv1dieb = new ImageIcon("monster/monsterdie-1b.png");
            monster1dieb = qv1dieb.getImage();
            ImageIcon qv1diec = new ImageIcon("monster/monsterdie-1c.png");
            monster1diec = qv1diec.getImage();
        }
        // load quái tấn công
        if (left2) {
            // load quái 1
            ImageIcon qvat1 = new ImageIcon("monster/monsterattack.png");
            monsterat = qvat1.getImage();
            ImageIcon qvat1a = new ImageIcon("monster/monsterattacka.png");
            monsterata = qvat1a.getImage();
            ImageIcon qvat1b = new ImageIcon("monster/monsterattackb.png");
            monsteratb = qvat1b.getImage();
            ImageIcon qvat1c = new ImageIcon("monster/monsterattackc.png");
            monsteratc = qvat1c.getImage();
            ImageIcon qvat1d = new ImageIcon("monster/monsterattackd.png");
            monsteratd = qvat1d.getImage();
            ImageIcon qvat1e = new ImageIcon("monster/monsterattacke.png");
            monsterate = qvat1e.getImage();
            ImageIcon qvat1f = new ImageIcon("monster/monsterattack1.png");
            monsteratf = qvat1f.getImage();
            ImageIcon qvat1g = new ImageIcon("monster/monsterattack1a.png");
            monsteratg = qvat1g.getImage();
            // load quái 2
            ImageIcon qvat2 = new ImageIcon("monster/monsterattack2.png");
            monster1at = qvat2.getImage();
            ImageIcon qvat2a = new ImageIcon("monster/monsterattack2a.png");
            monster1ata = qvat2a.getImage();
            ImageIcon qvat2b = new ImageIcon("monster/monsterattack2b.png");
            monster1atb = qvat2b.getImage();
            ImageIcon qvat2c = new ImageIcon("monster/monsterattack2c.png");
            monster1atc = qvat2c.getImage();
            ImageIcon qvat2d = new ImageIcon("monster/monsterattack2d.png");
            monster1atd = qvat2d.getImage();
            ImageIcon qvat2e = new ImageIcon("monster/monsterattack3.png");
            monster1ate = qvat2e.getImage();
            ImageIcon qvat2f = new ImageIcon("monster/monsterattack3a.png");
            monster1atf = qvat2f.getImage();
            ImageIcon qvat2g = new ImageIcon("monster/monsterattack3b.png");
            monster1atg = qvat2g.getImage();
        }
        if (right2) {
            // load quái 1
            ImageIcon qvat1 = new ImageIcon("monster/monsterattack-.png");
            monsterat = qvat1.getImage();
            ImageIcon qvat1a = new ImageIcon("monster/monsterattack-a.png");
            monsterata = qvat1a.getImage();
            ImageIcon qvat1b = new ImageIcon("monster/monsterattack-b.png");
            monsteratb = qvat1b.getImage();
            ImageIcon qvat1c = new ImageIcon("monster/monsterattack-c.png");
            monsteratc = qvat1c.getImage();
            ImageIcon qvat1d = new ImageIcon("monster/monsterattack-d.png");
            monsteratd = qvat1d.getImage();
            ImageIcon qvat1e = new ImageIcon("monster/monsterattack-e.png");
            monsterate = qvat1e.getImage();
            ImageIcon qvat1f = new ImageIcon("monster/monsterattack-1.png");
            monsteratf = qvat1f.getImage();
            ImageIcon qvat1g = new ImageIcon("monster/monsterattack-1a.png");
            monsteratg = qvat1g.getImage();
            // load quái 2
            ImageIcon qvat2 = new ImageIcon("monster/monsterattack-2.png");
            monster1at = qvat2.getImage();
            ImageIcon qvat2a = new ImageIcon("monster/monsterattack-2a.png");
            monster1ata = qvat2a.getImage();
            ImageIcon qvat2b = new ImageIcon("monster/monsterattack-2b.png");
            monster1atb = qvat2b.getImage();
            ImageIcon qvat2c = new ImageIcon("monster/monsterattack-2c.png");
            monster1atc = qvat2c.getImage();
            ImageIcon qvat2d = new ImageIcon("monster/monsterattack-2d.png");
            monster1atd = qvat2d.getImage();
            ImageIcon qvat2e = new ImageIcon("monster/monsterattack-3.png");
            monster1ate = qvat2e.getImage();
            ImageIcon qvat2f = new ImageIcon("monster/monsterattack-3a.png");
            monster1atf = qvat2f.getImage();
            ImageIcon qvat2g = new ImageIcon("monster/monsterattack-3b.png");
            monster1atg = qvat2g.getImage();
        }
    }

    private void loadheal() {
        ImageIcon heal1 = new ImageIcon("health bar/heal1-6.png");
        h1 = heal1.getImage();
        ImageIcon heal2 = new ImageIcon("health bar/heal2-6.png");
        h2 = heal2.getImage();
        ImageIcon heal3 = new ImageIcon("health bar/heal3-6.png");
        h3 = heal3.getImage();
        ImageIcon heal4 = new ImageIcon("health bar/heal4-6.png");
        h4 = heal4.getImage();
        ImageIcon heal5 = new ImageIcon("health bar/heal5-6.png");
        h5 = heal5.getImage();
        ImageIcon heal6 = new ImageIcon("health bar/heal6-6.png");
        h6 = heal6.getImage();
    }

    private void loadcharacter() {
        // meliodas
        if (meliodas) {
            // load nhân vật
            if (right) {
                ImageIcon main1 = new ImageIcon("attack/attack1.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character3a.png");
                main0 = main0a.getImage();
            }
            if (left) {
                ImageIcon main1 = new ImageIcon("attack/attack-1.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character-3a.png");
                main0 = main0a.getImage();
            }
            // load tấn công
            if (right) {
                ImageIcon at1a = new ImageIcon("attack/attack1.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack1a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack1b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack2.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack2a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack2b.png");
                main23 = at2c.getImage();
            }
            if (left) {
                ImageIcon at1a = new ImageIcon("attack/attack-1.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack-1a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack-1b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack-2.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack-2a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack-2b.png");
                main23 = at2c.getImage();
            }
            // chạy
            if (right) {
                ImageIcon mainra = new ImageIcon("run/run.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run1a.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run1b.png");
                mainr2 = mainrc.getImage();
            }
            if (left) {
                ImageIcon mainra = new ImageIcon("run/run-.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run-1a.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run-1b.png");
                mainr2 = mainrc.getImage();
            }
        }
        // escanor
        if (escanor) {
            // load nhân vật
            if (right) {
                ImageIcon main1 = new ImageIcon("attack/attack3.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character1a.png");
                main0 = main0a.getImage();
            }
            if (left) {
                ImageIcon main1 = new ImageIcon("attack/attack-3.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character-1a.png");
                main0 = main0a.getImage();
            }
            // load tấn công
            if (right) {
                ImageIcon at1a = new ImageIcon("attack/attack3.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack3a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack3b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack4.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack4a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack4b.png");
                main23 = at2c.getImage();
            }
            if (left) {
                ImageIcon at1a = new ImageIcon("attack/attack-3.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack-3a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack-3b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack-4.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack-4a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack-4b.png");
                main23 = at2c.getImage();
            }
            // chạy
            if (right) {
                ImageIcon mainra = new ImageIcon("run/run2a.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run2b.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run2c.png");
                mainr2 = mainrc.getImage();
            }
            if (left) {
                ImageIcon mainra = new ImageIcon("run/run-2a.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run-2b.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run-2c.png");
                mainr2 = mainrc.getImage();
            }
        }
        // diana
        if (diana) {
            // load nhân vật
            if (right) {
                ImageIcon main1 = new ImageIcon("attack/attack6.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character2a.png");
                main0 = main0a.getImage();
            }
            if (left) {
                ImageIcon main1 = new ImageIcon("attack/attack-6.png");
                main = main1.getImage();

                ImageIcon main0a = new ImageIcon("character/character-2a.png");
                main0 = main0a.getImage();
            }
            // load tấn công
            if (right) {
                ImageIcon at1a = new ImageIcon("attack/attack5.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack5a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack5b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack6.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack6a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack6b.png");
                main23 = at2c.getImage();
            }
            if (left) {
                ImageIcon at1a = new ImageIcon("attack/attack-5.png");
                main11 = at1a.getImage();

                ImageIcon at1b = new ImageIcon("attack/attack-5a.png");
                main12 = at1b.getImage();

                ImageIcon at1c = new ImageIcon("attack/attack-5b.png");
                main13 = at1c.getImage();

                ImageIcon at2a = new ImageIcon("attack/attack-6.png");
                main21 = at2a.getImage();

                ImageIcon at2b = new ImageIcon("attack/attack-6a.png");
                main22 = at2b.getImage();

                ImageIcon at2c = new ImageIcon("attack/attack-6b.png");
                main23 = at2c.getImage();
            }
            // chạy
            if (right) {
                ImageIcon mainra = new ImageIcon("run/run3a.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run3b.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run3c.png");
                mainr2 = mainrc.getImage();

            }
            if (left) {
                ImageIcon mainra = new ImageIcon("run/run-3a.png");
                mainr = mainra.getImage();

                ImageIcon mainrb = new ImageIcon("run/run-3b.png");
                mainr1 = mainrb.getImage();

                ImageIcon mainrc = new ImageIcon("run/run-3c.png");
                mainr2 = mainrc.getImage();
            }
        }
    }

    private void initGame() {
        if (inGame) {
            timer = new Timer(DELAY, this);
            timer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    // thanh máu
    private void heal(Graphics g) {
        if (h == 1) {
            g.drawImage(h1, x, y - 7, this);
        }
        if (h == 2) {
            g.drawImage(h2, x, y - 7, this);
        }
        if (h == 3) {
            g.drawImage(h3, x, y - 7, this);
        }
        if (h == 4) {
            g.drawImage(h4, x, y - 7, this);
        }
        if (h == 5) {
            g.drawImage(h5, x, y - 7, this);
        }
        if (h == 6) {
            g.drawImage(h6, x, y - 7, this);
        }
        if (!run && !attack1 && !attack2 && h < 6) {
            heal = heal + 1;
            if (heal >= 3000 / DELAY) {
                h += 1;
                heal = 0;
            }
        } else {
            heal = 0;
        }
        for (int i = 0; i < 5; i++) {
            if (left2) {
                if (hmt[i] == 1) {
                    g.drawImage(h1, monster_x[i] + 10, monster_y[i] - 7, this);
                }
                if (hmt[i] == 2) {
                    g.drawImage(h2, monster_x[i] + 10, monster_y[i] - 7, this);
                }
                if (hmt[i] == 3) {
                    g.drawImage(h3, monster_x[i] + 10, monster_y[i] - 7, this);
                }
                if (hmt[i] == 4) {
                    g.drawImage(h4, monster_x[i] + 10, monster_y[i] - 7, this);
                }
                if (hmt[i] == 5) {
                    g.drawImage(h5, monster_x[i] + 10, monster_y[i] - 7, this);
                }
                if (hmt[i] == 6) {
                    g.drawImage(h6, monster_x[i] + 10, monster_y[i] - 7, this);
                }
            } else {
                if (hmt[i] == 1) {
                    g.drawImage(h1, monster_x[i], monster_y[i] - 7, this);
                }
                if (hmt[i] == 2) {
                    g.drawImage(h2, monster_x[i], monster_y[i] - 7, this);
                }
                if (hmt[i] == 3) {
                    g.drawImage(h3, monster_x[i], monster_y[i] - 7, this);
                }
                if (hmt[i] == 4) {
                    g.drawImage(h4, monster_x[i], monster_y[i] - 7, this);
                }
                if (hmt[i] == 5) {
                    g.drawImage(h5, monster_x[i], monster_y[i] - 7, this);
                }
                if (hmt[i] == 6) {
                    g.drawImage(h6, monster_x[i], monster_y[i] - 7, this);
                }
            }
        }
    }

    // tấn công meliodas
    private void attackcrt1(Graphics g) {
        if (attack1) {
            at1 += 2;
            if (right) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main12, x - 10 * 3 / 2, y, this);
                }
            }
            if (left) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main12, x, y, this);
                }
            }
            if (at1 > 15) {
                if (at1 >= 20) {
                    at = true;
                }
                if (at1 >= 30) {
                    at1 = 0;
                    at = false;
                    attack1 = false;
                }
                g.drawImage(main13, x - 12 * 3 / 2, y - 20 * 3 / 2, this);
            }
        } else if (attack2) {
            at2 += 2;
            if (right) {
                if (at2 >= 0 && at2 < 16) {
                    g.drawImage(main21, x - 15 * 3 / 2, y - 30 * 3 / 2, this);
                }
                if (at2 > 15) {
                    if (at2 >= 20) {
                        at = true;
                    }
                    if (at2 >= 30) {
                        at2 = 0;
                        attack2 = false;
                        at = false;
                    }
                    g.drawImage(main23, x - 10 * 3 / 2, y - 30 * 3 / 2, this);
                }
            }
            if (left) {
                if (at2 >= 0 && at2 < 16) {
                    g.drawImage(main21, x - 5 * 3 / 2, y - 30 * 3 / 2, this);
                }
                if (at2 > 15) {
                    if (at2 >= 20) {
                        at = true;
                    }
                    if (at2 >= 30) {
                        at2 = 0;
                        at = false;
                        attack2 = false;
                    }
                    g.drawImage(main23, x - 25 * 3 / 2, y - 30 * 3 / 2, this);
                }
            }
        }
    }

    // tấn công escanor
    private void attackcrt2(Graphics g) {
        if (attack1 || attack2) {
            at1 += 2;
            if (right) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main12, x - 10 * 3 / 2, y + 1 * 3 / 2, this);
                }
                if (at1 > 15) {
                    if (at1 >= 20) {
                        at = true;
                    }
                    if (at1 >= 30) {
                        at = false;
                        at1 = 0;
                        attack1 = false;
                        attack2 = false;
                    }
                    g.drawImage(main13, x - 10 * 3 / 2, y - 20 * 3 / 2, this);
                }
            }
            if (left) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main12, x - 10 * 3 / 2, y + 1 * 3 / 2, this);
                }
                if (at1 > 15) {
                    if (at1 >= 20) {
                        at = true;
                    }
                    if (at1 >= 30) {
                        at1 = 0;
                        at = false;
                        attack1 = false;
                        attack2 = false;
                    }
                    g.drawImage(main13, x - 20 * 3 / 2, y - 20 * 3 / 2, this);
                }
            }
        }
    }

    // tấn công diane
    private void attackcrt3(Graphics g) {
        if (attack1) {
            at1 += 2;
            if (right) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main11, x - 10 * 3 / 2, y - 4 * 3 / 2, this);
                }
                if (at1 > 15) {
                    if (at1 >= 20) {
                        at = true;
                    }
                    if (at1 >= 30) {
                        at1 = 0;
                        at = false;
                        attack1 = false;
                    }
                    g.drawImage(main13, x + 1 * 3 / 2, y - 11 * 3 / 2, this);
                }
            }
            if (left) {
                if (at1 >= 0 && at1 < 16) {
                    g.drawImage(main11, x - 2 * 3 / 2, y - 4 * 3 / 2, this);
                }
                if (at1 > 15) {
                    if (at1 >= 20) {
                        at = true;
                    }
                    if (at1 >= 30) {
                        at1 = 0;
                        at = false;
                        attack1 = false;
                    }
                    g.drawImage(main13, x - 19 * 3 / 2, y - 11 * 3 / 2, this);
                }
            }

        } else if (attack2) {
            at2 += 2;
            if (right) {
                if (at2 >= 0 && at2 < 16) {
                    g.drawImage(main22, x - 5 * 3 / 2, y - 4 * 3 / 2, this);
                }
                if (at2 > 15) {
                    if (at2 >= 20) {
                        at = true;
                    }
                    if (at2 >= 30) {
                        at2 = 0;
                        at = false;
                        attack2 = false;
                    }
                    g.drawImage(main23, x - 1 * 3 / 2, y - 8 * 3 / 2, this);
                }
            }
            if (left) {
                if (at2 >= 0 && at2 < 16) {
                    g.drawImage(main22, x - 5 * 3 / 2, y - 4 * 3 / 2, this);
                }
                if (at2 > 15) {
                    if (at2 >= 20) {
                        at = true;
                    }
                    if (at2 >= 30) {
                        at2 = 0;
                        at = false;
                        attack2 = false;
                    }
                    g.drawImage(main23, x - 13 * 3 / 2, y - 8 * 3 / 2, this);
                }
            }
        }
    }

    // đứng im
    private void crtnotrun(Graphics g) {
        if (meliodas) {
            if (!run) {
                g.drawImage(main, x, y, this);
            }
        }
        if (escanor) {
            if (!run) {
                g.drawImage(main, x - 4 * 3 / 2, y - 4 * 3 / 2, this);
            }
        }
        if (diana) {
            if (!run) {
                g.drawImage(main, x, y, this);
            }
        }
    }

    private void Characterrun(Graphics g) {
        if (meliodas) {
            if (r >= 0 && r < 10) {
                g.drawImage(mainr, x, y, this);
            }
            if (r > 9 && r < 20) {
                g.drawImage(mainr1, x, y, this);
            }
            if (r > 19) {
                if (r > 30) {
                    r = 0;
                }
                g.drawImage(mainr2, x, y, this);
            }
        }
        if (escanor) {
            if (r >= 0 && r < 10) {
                g.drawImage(mainr, x, y - 2 * 3 / 2, this);
            }
            if (r > 9 && r < 20) {
                g.drawImage(mainr1, x, y - 2 * 3 / 2, this);
            }
            if (r > 19) {
                if (r > 30) {
                    r = 0;
                }
                g.drawImage(mainr2, x, y - 2 * 3 / 2, this);
            }
        }
        if (diana) {
            if (r >= 0 && r < 10) {
                g.drawImage(mainr, x, y - 2 * 3 / 2, this);
            }
            if (r > 9 && r < 20) {
                g.drawImage(mainr1, x, y - 2 * 3 / 2, this);
            }
            if (r > 19) {
                if (r > 30) {
                    r = 0;
                }
                g.drawImage(mainr2, x, y - 2 * 3 / 2, this);
            }
        }
    }

    private void doDrawing(Graphics g) {

        if (inGame) {
            if (level) {
                g.drawImage(map, 0, 0, this);
                g.drawImage(mouse, 475, ymn, this);
                level(g);
            }
            if (character) {
                g.drawImage(map, 0, 0, this);
                g.drawImage(mouse, 475, ymn, this);
                Character(g);
            }
            if (menu) {
                g.drawImage(map, 0, 0, this);
                g.drawImage(mouse, 475, ymn, this);
                menu(g);
            }
            if (start) {
                // bản đồ
                if (bando1) {
                    g.drawImage(map1, 0, 0, this);
                }
                if (bando2) {
                    g.drawImage(map2, 0, 0, this);
                    if (bando3) {
                        win(g);
                    }
                }
                // người chạy
                if (run) {
                    x1 = x;
                    y1 = y;
                    r += 2;
                    Characterrun(g);
                }
                // thanh máu
                heal(g);
                // quái vật
                moveMonster(g);
                // người đứng im
                if (!attack1 && !attack2) {
                    crtnotrun(g);
                }
                // quái tấn công
                monsterattack(g);
                // nhân vật
                if (meliodas) {
                    attackcrt1(g);
                }
                if (escanor) {
                    attackcrt2(g);
                }
                if (diana) {
                    attackcrt3(g);
                }
                if (x == x1 && y == y1) {
                    x2 += 1;
                    if (x2 > 20) {
                        x2 = 0;
                        run = false;
                    }
                }
                // diem
                diem(g);
            }
            Toolkit.getDefaultToolkit().sync();

        } else {
            // chết
            if (bando1) {
                g.drawImage(map1, 0, 0, this);
            }
            if (bando2) {
                g.drawImage(map2, 0, 0, this);
            }
            if (right) {
                g.drawImage(main0, x - 5 * 3 / 2, y + 10 * 3 / 2, this);
            }
            if (left) {
                g.drawImage(main0, x - 15 * 3 / 2, y + 10 * 3 / 2, this);
            }
            gameOver(g);

        }
    }

    // hiện chữ menu
    private void menu(Graphics g) {
        String st = "Start";
        String lv = "Level";
        String crt = "Character";
        String ex = "Exit";
        Font small = new Font("Forte", Font.ROMAN_BASELINE, 20);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(st, 500, 200);
        g.drawString(lv, 500, 250);
        g.drawString(crt, 500, 300);
        g.drawString(ex, 500, 350);
    }

    // hiện điểm
    private void diem(Graphics g) {
        String st = "Score: " + score;
        Font small = new Font("Forte", Font.ROMAN_BASELINE, 20);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(st, 8, 16);
    }

    // hiện chữ trong level
    private void level(Graphics g) {
        // dễ
        String ez = "Easy";
        Font big = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (lvl == 2) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(big);
        g.drawString(ez, 500, 210);
        // khó
        String hard = "Hard";
        Font small = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (lvl == 4) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(small);
        g.drawString(hard, 500, 260);
        // địa ngục
        String evil = "Hell";
        Font evil1 = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (lvl == 10) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(evil1);
        g.drawString(evil, 500, 310);
    }

    // hiện chữ trong crt
    private void Character(Graphics g) {
        // meliodas
        String me = "Meliodas";
        Font meli = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (meliodas) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(meli);
        g.drawString(me, 500, 210);
        // nv2
        String nv2a = "Escanor";
        Font nv2b = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (escanor) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(nv2b);
        g.drawString(nv2a, 500, 260);
        // nv3
        String nv3a = "Diane";
        Font nv3b = new Font("Forte", Font.ROMAN_BASELINE, 20);
        if (diana) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.white);
        }
        g.setFont(nv3b);
        g.drawString(nv3a, 500, 310);
    }

    // hiện chữ lúc thua
    private void gameOver(Graphics g) {

        String msg = "Bạn đã chết :D";
        String s = "Điểm của bạn là: " + score;
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT / 2 + 50);
    }

    private void win(Graphics g) {

        String msg = "Bạn đã qua ải";
        String s = "Điểm của bạn là: " + score;
        String m = "Ấn ESC để ra ngoài tăng độ khó :D";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(s, (B_WIDTH - metr.stringWidth(s)) / 2, B_HEIGHT / 2 + 50);
        g.drawString(m, (B_WIDTH - metr.stringWidth(m)) / 2, B_HEIGHT / 2 + 100);
    }

    // check vị trí quái
    private void checkMonster() {
        for (int i = 0; i < 5; i++) {
            if (bando1) {
                if ((monster_y[i] - 18 == 232
                        && ((92 <= monster_x[i] && monster_x[i] <= 152)
                                || (168 <= monster_x[i] && monster_x[i] <= 424)))
                        || (monster_y[i] - 18 == 152 && ((108 <= monster_x[i] && monster_x[i] <= 208)
                                || (472 <= monster_x[i] && monster_x[i] <= 516)
                                || (612 <= monster_x[i] && monster_x[i] <= 800)))
                        || (monster_y[i] - 18 == -8 && 560 <= monster_x[i] && monster_x[i] <= 572)
                        || (monster_y[i] - 18 == 112 && ((516 <= monster_x[i] && monster_x[i] <= 560)
                                || (572 <= monster_x[i] && monster_x[i] <= 612)))
                        || (monster_y[i] - 18 == 196 && 424 <= monster_x[i] && monster_x[i] <= 469)
                        || (monster_y[i] - 18 == 276 && 756 <= monster_x[i] && monster_x[i] <= 980)
                        || (monster_y[i] - 18 == 312 && 480 <= monster_x[i] && monster_x[i] <= 649)
                        || (monster_y[i] - y + 29 <= 20 && monster_y[i] - y + 29 > 0)) {
                    upmt[i] = false;
                } else {
                    upmt[i] = true;
                }
                if ((monster_y[i] - 18 == 180 && 480 <= monster_x[i] && monster_x[i] <= 652)
                        || (monster_y[i] - 18 == 184 && ((108 <= monster_x[i] && monster_x[i] <= 152)
                                || (168 <= monster_x[i] && monster_x[i] <= 208)
                                || (668 <= monster_x[i] && monster_x[i] <= 740)
                                || (756 <= monster_x[i] && monster_x[i] <= 800)))
                        || (monster_y[i] - 18 == 300 && ((92 <= monster_x[i] && monster_x[i] <= 469)
                                || (740 <= monster_x[i] && monster_x[i] <= 980)))
                        || (monster_y[i] - 18 == 340 && ((472 <= monster_x[i] && monster_x[i] <= 560)
                                || (572 <= monster_x[i] && monster_x[i] <= 660)))
                        || (y + 29 - monster_y[i] <= 8 && y + 29 - monster_y[i] > 0)) {
                    downmt[i] = false;
                } else {
                    downmt[i] = true;
                }
                if ((monster_x[i] + 10 == 168 && 188 <= monster_y[i] - 18 && monster_y[i] - 18 <= 228)
                        || (monster_x[i] + 10 == 208 && 152 <= monster_y[i] - 18 && monster_y[i] - 18 <= 184)
                        || (monster_x[i] + 10 == 480 && 188 <= monster_y[i] - 18 && monster_y[i] - 18 <= 304)
                        || (monster_x[i] + 10 == 572 && ((-8 <= monster_y[i] - 18 && monster_y[i] - 18 <= 112)
                                || (340 <= monster_y[i] - 18 && monster_y[i] - 18 <= 552)))
                        || (monster_x[i] + 10 == 612 && 112 <= monster_y[i] - 18 && monster_y[i] - 18 <= 156)
                        || (monster_x[i] + 10 == 660 && 184 <= monster_y[i] - 18 && monster_y[i] - 18 <= 340)
                        || (monster_x[i] + 10 == 756 && 184 <= monster_y[i] - 18 && monster_y[i] - 18 <= 276)
                        || (monster_x[i] + 10 == 800 && 152 <= monster_y[i] - 18 && monster_y[i] - 18 <= 184)
                        || (monster_x[i] + 10 == 980 && 276 <= monster_y[i] - 18 && monster_y[i] - 18 <= 300)
                        || (x - monster_x[i] <= 40 && x - monster_x[i] > 0)) {
                    rightmt[i] = false;
                } else {
                    rightmt[i] = true;
                }
                if ((monster_x[i] == 92 && 232 <= monster_y[i] - 18 && monster_y[i] - 18 <= 300)
                        || (monster_x[i] == 108 && 152 <= monster_y[i] - 18 && monster_y[i] - 18 <= 184)
                        || (monster_x[i] == 152 && 188 <= monster_y[i] - 18 && monster_y[i] - 18 <= 228)
                        || (monster_x[i] == 424 && 188 <= monster_y[i] - 18 && monster_y[i] - 18 <= 232)
                        || (monster_x[i] == 472 && ((152 <= monster_y[i] - 18 && monster_y[i] - 18 <= 184)
                                || (300 <= monster_y[i] - 18 && monster_y[i] - 18 <= 340)))
                        || (monster_x[i] == 516 && 112 <= monster_y[i] - 18 && monster_y[i] - 18 <= 152)
                        || (monster_x[i] == 560 && ((-8 <= monster_y[i] - 18 && monster_y[i] - 18 <= 112)
                                || (340 <= monster_y[i] - 18 && monster_y[i] - 18 <= 552)))
                        || (monster_x[i] == 652 && 180 <= monster_y[i] - 18 && monster_y[i] - 18 <= 304)
                        || (monster_x[i] == 740 && 184 <= monster_y[i] - 18 && monster_y[i] - 18 <= 300)
                        || (monster_x[i] - x <= 32 && monster_x[i] - x > 0)) {
                    leftmt[i] = false;
                } else {
                    leftmt[i] = true;
                }
            }
            if (bando2) {
                if ((monster_x[i] == 168 && 188 <= monster_y[i] - 18 && monster_y[i] - 18 <= 232)
                        || (monster_x[i] == 136 && 180 <= monster_y[i] - 18 && monster_y[i] - 18 <= 188)
                        || (monster_x[i] == 108 && ((144 <= monster_y[i] - 18 && monster_y[i] - 18 <= 180)
                                || (348 <= monster_y[i] - 18 && monster_y[i] - 18 <= 468)))
                        || (monster_x[i] == 192 && 56 <= monster_y[i] - 18 && monster_y[i] - 18 <= 140)
                        || (monster_x[i] == 880 && 56 <= monster_y[i] - 18 && monster_y[i] - 18 <= 468)
                        || (monster_x[i] == 716 && 164 <= monster_y[i] - 18 && monster_y[i] - 18 <= 192)
                        || (monster_x[i] == 800 && 200 <= monster_y[i] - 18 && monster_y[i] - 18 <= 224)
                        || (monster_x[i] == 828 && 228 <= monster_y[i] - 18 && monster_y[i] - 18 <= 252)
                        || (monster_x[i] == 552 && 168 <= monster_y[i] - 18 && monster_y[i] - 18 <= 252)) {
                    leftmt[i] = false;
                } else {
                    leftmt[i] = true;
                }
                if ((monster_x[i] + 10 == 960 && ((56 <= monster_y[i] - 18 && monster_y[i] - 18 <= 228)
                        || (292 <= monster_y[i] - 18 && monster_y[i] - 18 <= 468)))
                        || (monster_x[i] + 10 == 272 && 244 <= monster_y[i] - 18 && monster_y[i] - 18 <= 468)
                        || (monster_x[i] + 10 == 328 && 224 <= monster_y[i] - 18 && monster_y[i] - 18 <= 240)
                        || (monster_x[i] + 10 == 380 && 196 <= monster_y[i] - 18 && monster_y[i] - 18 <= 220)
                        || (monster_x[i] + 10 == 436 && 168 <= monster_y[i] - 18 && monster_y[i] - 18 <= 192)
                        || (monster_x[i] + 10 == 552 && 212 <= monster_y[i] - 18 && monster_y[i] - 18 <= 252)
                        || (monster_x[i] + 10 == 628 && 168 <= monster_y[i] - 18 && monster_y[i] - 18 <= 208)) {
                    rightmt[i] = false;
                } else {
                    rightmt[i] = true;
                }
                if ((monster_y[i] - 18 == 56 && 192 <= monster_x[i] && monster_x[i] <= 960)
                        || (monster_y[i] - 18 == 232 && ((964 <= monster_x[i] && monster_x[i] <= 1100)
                                || (0 <= monster_x[i] && monster_x[i] <= 160)))
                        || (monster_y[i] - 18 == 144 && 108 <= monster_x[i] && monster_x[i] <= 188)) {
                    upmt[i] = false;
                } else {
                    upmt[i] = true;
                }
                if ((monster_y[i] - 18 == 468 && ((880 <= monster_x[i] && monster_x[i] <= 960)
                        || (108 <= monster_x[i] && monster_x[i] <= 272)))
                        || (monster_y[i] - 18 == 192 && 716 <= monster_x[i] && monster_x[i] <= 796)
                        || (monster_y[i] - 18 == 224 && 800 <= monster_x[i] && monster_x[i] <= 820)
                        || (monster_y[i] - 18 == 176 && 108 <= monster_x[i] && monster_x[i] <= 132)
                        || (monster_y[i] - 18 == 188 && 136 <= monster_x[i] && monster_x[i] <= 160)
                        || (monster_y[i] - 18 == 344 && 0 <= monster_x[i] && monster_x[i] <= 108)
                        || (monster_y[i] - 18 == 240 && 276 <= monster_x[i] && monster_x[i] <= 328)
                        || (monster_y[i] - 18 == 220 && 332 <= monster_x[i] & monster_x[i] <= 380)
                        || (monster_y[i] - 18 == 192 && 384 <= monster_x[i] && monster_x[i] <= 436)
                        || (monster_y[i] - 18 == 164 && 440 <= monster_x[i] && monster_x[i] <= 548)
                        || (monster_y[i] - 18 == 208 && 556 <= monster_x[i] && monster_x[i] <= 628)
                        || (monster_y[i] - 18 == 164 && 636 <= monster_x[i] && monster_x[i] <= 712)
                        || (monster_y[i] - 18 == 252 && monster_x[i] == 552)
                        || (monster_y[i] - 18 == 252 && 828 <= monster_x[i] && monster_x[i] <= 836)
                        || (monster_y[i] - 18 == 288 && 964 <= monster_x[i] && monster_x[i] <= 1100)) {
                    downmt[i] = false;
                } else {
                    downmt[i] = true;
                }
            }
            if (monster_x[i] - x <= 32 && monster_x[i] - x >= 0 && monster_y[i] - y == 20
                    || (monster_x[i] - x >= -40 && monster_x[i] - x <= 0 && monster_y[i] - y == 20)) {
                mtrun[i] = false;
            } else {
                mtrun[i] = true;
            }
        }
    }

    // quái tấn công
    private void monsterattack(Graphics g) {
        for (int i = 0; i < 5; i++) {
            if (!mtrun[i] && !mtat1 && hmt[i] > 0) {
                u[i] += 2;
                if (u[i] > 2000 / DELAY) {
                    mtat1 = true;
                    u[i] = 0;
                }
            }
            if (!mtrun[i] && mtat1 && hmt[i] > 0) {
                u[i] += 2;
                if (i % 2 == 0) {
                    if (left2) {
                        // tấn công quái 1
                        if (u[i] >= 0 && u[i] < 16) {
                            g.drawImage(monsterata, monster_x[i] - 2, monster_y[i] - 4, this);
                        }
                        if (u[i] > 15 && u[i] < 31) {
                            g.drawImage(monsteratb, monster_x[i] - 28, monster_y[i] - 4, this);
                            g.drawImage(monsteratf, x - 8, y - 4, this);
                            if (u[i] == 22) {
                                if (lvl == 2) {
                                    h -= 1;
                                }
                                if (lvl == 4) {
                                    h -= 2;
                                }
                                if (lvl == 10) {
                                    h -= 3;
                                }
                            }
                        }
                        if (u[i] > 30 && u[i] < 46) {
                            g.drawImage(monsteratc, monster_x[i] - 26, monster_y[i] - 2, this);
                            g.drawImage(monsteratg, x - 8, y - 4, this);

                        }
                        if (u[i] > 45) {
                            if (u[i] >= 60) {
                                u[i] = 0;
                                mtat1 = false;
                            }
                            g.drawImage(monsterate, monster_x[i] - 30, monster_y[i] - 2, this);
                        }
                    } else {
                        // tấn công quái 1
                        if (u[i] >= 0 && u[i] < 16) {
                            g.drawImage(monsterata, monster_x[i] - 2, monster_y[i] - 4, this);
                        }
                        if (u[i] > 15 && u[i] < 31) {
                            g.drawImage(monsteratb, monster_x[i] + 18, monster_y[i] - 4, this);
                            g.drawImage(monsteratf, x - 8, y - 4, this);
                            if (u[i] == 22) {
                                if (lvl == 2) {
                                    h -= 1;
                                }
                                if (lvl == 4) {
                                    h -= 2;
                                }
                                if (lvl == 10) {
                                    h -= 3;
                                }
                            }
                        }
                        if (u[i] > 30 && u[i] < 46) {
                            g.drawImage(monsteratc, monster_x[i] - 10, monster_y[i] - 2, this);
                            g.drawImage(monsteratg, x - 8, y - 4, this);
                        }
                        if (u[i] > 45) {
                            if (u[i] >= 60) {
                                u[i] = 0;
                                mtat1 = false;
                            }
                            g.drawImage(monsterate, monster_x[i], monster_y[i] - 2, this);
                        }
                    }
                } else {
                    // tấn công quái 2
                    if (left2) {
                        if (u[i] >= 0 && u[i] < 16) {
                            g.drawImage(monster1at, monster_x[i] - 18, monster_y[i] - 14, this);
                        }
                        if (u[i] > 15 && u[i] < 31) {
                            g.drawImage(monster1atb, monster_x[i] - 10, monster_y[i] - 14, this);
                            if (u[i] == 22) {
                                if (lvl == 2) {
                                    h -= 1;
                                }
                                if (lvl == 4) {
                                    h -= 2;
                                }
                                if (lvl == 10) {
                                    h -= 3;
                                }
                            }
                        }
                        if (u[i] > 30 && u[i] < 46) {
                            g.drawImage(monster1atc, monster_x[i] - 18, monster_y[i] - 14, this);
                            g.drawImage(monster1ate, x - 8, y - 4, this);
                        }
                        if (u[i] > 45) {
                            if (u[i] >= 60) {
                                u[i] = 0;
                                mtat1 = false;
                            }
                            g.drawImage(monster1atd, monster_x[i] - 18, monster_y[i] - 14, this);
                            g.drawImage(monster1atf, x - 8, y + 4, this);
                        }

                    } else {
                        if (u[i] >= 0 && u[i] < 16) {
                            g.drawImage(monster1at, monster_x[i], monster_y[i] - 14, this);
                        }
                        if (u[i] > 15 && u[i] < 31) {
                            g.drawImage(monster1atb, monster_x[i], monster_y[i] - 14, this);
                            if (u[i] == 22) {
                                if (lvl == 2) {
                                    h -= 1;
                                }
                                if (lvl == 4) {
                                    h -= 2;
                                }
                                if (lvl == 10) {
                                    h -= 3;
                                }
                            }
                        }
                        if (u[i] > 30 && u[i] < 46) {
                            g.drawImage(monster1atc, monster_x[i], monster_y[i] - 14, this);
                            g.drawImage(monster1ate, x - 8, y - 4, this);
                        }
                        if (u[i] > 45) {
                            if (u[i] >= 60) {
                                u[i] = 0;
                                mtat1 = false;
                            }
                            g.drawImage(monster1atd, monster_x[i], monster_y[i] - 14, this);
                            g.drawImage(monster1atf, x - 8, y + 4, this);
                        }
                    }
                }
            } else {
                if (hmt[i] > 0) {
                    if (i % 2 == 0) {
                        g.drawImage(monster, monster_x[i], monster_y[i], this);
                    } else {
                        g.drawImage(monster1, monster_x[i], monster_y[i], this);
                    }
                } else {
                    p[i] += 2;
                    if (i % 2 == 0) {
                        if (p[i] >= 0 && p[i] < 10) {
                            if (p[i] == 2) {
                                score += 10;
                            }
                            g.drawImage(monsterdie, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 10 && p[i] < 20) {
                            g.drawImage(monsterdiea, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 20 && p[i] < 30) {
                            g.drawImage(monsterdieb, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 30) {

                            g.drawImage(monsterdiec, monster_x[i], monster_y[i], this);
                        }
                    } else {
                        if (p[i] >= 0 && p[i] < 10) {
                            if (p[i] == 2) {
                                score += 20;
                            }
                            g.drawImage(monster1die, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 10 && p[i] < 20) {
                            g.drawImage(monster1diea, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 20 && p[i] < 30) {
                            g.drawImage(monster1dieb, monster_x[i], monster_y[i], this);
                        }
                        if (p[i] >= 30) {
                            g.drawImage(monster1diec, monster_x[i], monster_y[i], this);
                        }
                    }
                }
            }
            if (at && !mtrun[i] && hmt[i] > 0) {
                p[i] += 2;
                if (p[i] == 10) {
                    at = false;
                    p[i] = 0;
                }
                if (p[i] == 0) {
                    if (lvl == 2) {
                        hmt[i] -= 3;
                    }
                    if (lvl == 4) {
                        hmt[i] -= 2;
                    }
                    if (lvl == 10) {
                        hmt[i] -= 1;
                    }
                }
                if (i % 2 == 0) {
                    g.drawImage(monsterdie, monster_x[i], monster_y[i], this);
                } else {
                    g.drawImage(monster1die, monster_x[i], monster_y[i], this);
                }

            }
        }
    }

    // di chuyển quái
    private void moveMonster(Graphics g) {
        t += 10;
        if (t % (10 / lvl) == 0) {
            if (mtrun[0] && hmt[0] > 0) {
                if (y + 20 < monster_y[0] && upmt[0]) {
                    monster_y[0] -= 1;
                }
                if (y + 20 > monster_y[0] && downmt[0]) {
                    monster_y[0] += 1;
                }
                if (x + 12 < monster_x[0] && leftmt[0]) {
                    monster_x[0] -= 1;
                    left2 = true;
                    right2 = false;
                    loadmonster();
                }
                if (x + 12 > monster_x[0] && rightmt[0]) {
                    monster_x[0] += 1;
                    left2 = false;
                    right2 = true;
                    loadmonster();
                }
            }
            for (int i = 1; i < 5; i++) {
                if (mtrun[i] && hmt[i] > 0 && (hmt[i - 1] == 0)) {
                    if (y + 20 < monster_y[i] && upmt[i]) {
                        monster_y[i] -= 1;
                    }
                    if (y + 20 > monster_y[i] && downmt[i]) {
                        monster_y[i] += 1;
                    }
                    if (x + 12 < monster_x[i] && leftmt[i]) {
                        monster_x[i] -= 1;
                        left2 = true;
                        right2 = false;
                        loadmonster();
                    }
                    if (x + 12 > monster_x[i] && rightmt[i]) {
                        monster_x[i] += 1;
                        left2 = false;
                        right2 = true;
                        loadmonster();
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (mtrun[i] && hmt[i] > 0) {
                if (i % 2 == 0) {
                    if (t >= 0 && t < 10) {
                        g.drawImage(monstera, monster_x[i], monster_y[i], this);
                    }
                    if (t > 9 && t < 20) {
                        g.drawImage(monsterb, monster_x[i], monster_y[i], this);
                    }
                    if (t > 19) {
                        if (t > 30) {
                            t = 0;
                        }
                        g.drawImage(monsterc, monster_x[i], monster_y[i], this);
                    }
                } else {
                    if (t >= 0 && t < 10) {
                        g.drawImage(monster1a, monster_x[i], monster_y[i], this);
                    }
                    if (t > 9 && t < 20) {
                        g.drawImage(monster1b, monster_x[i], monster_y[i], this);
                    }
                    if (t > 19) {
                        if (t > 30) {
                            t = 0;
                        }
                        g.drawImage(monster1c, monster_x[i], monster_y[i], this);
                    }
                }
            }
        }
    }

    // check vị trí nhân vật
    private void checkCollision() {
        if (bando1) {
            if ((x == 92 && 232 <= y && y <= 300) || (x == 108 && 152 <= y && y <= 184)
                    || (x == 152 && 188 <= y && y <= 228) || (x == 424 && 188 <= y && y <= 232)
                    || (x == 472 && ((152 <= y && y <= 184) || (300 <= y && y <= 340)))
                    || (x == 516 && 112 <= y && y <= 152)
                    || (x == 560 && ((-8 <= y && y <= 112) || (340 <= y && y <= 552)))
                    || (x == 652 && 180 <= y && y <= 304) || (x == 740 && 184 <= y && y <= 300)) {
                left1 = false;
            } else {
                left1 = true;
            }
            if ((x == 168 && 188 <= y && y <= 228) || (x == 208 && 152 <= y && y <= 184)
                    || (x == 480 && 188 <= y && y <= 304)
                    || (x == 572 && ((-8 <= y && y <= 112) || (340 <= y && y <= 552)))
                    || (x == 612 && 112 <= y && y <= 156) || (x == 660 && 184 <= y && y <= 340)
                    || (x == 756 && 184 <= y && y <= 276) || (x == 800 && 152 <= y && y <= 184)
                    || (x == 980 && 276 <= y && y <= 300)) {
                right1 = false;
            } else {
                right1 = true;
            }
            if ((y == 232 && ((92 <= x && x <= 152) || (168 <= x && x <= 424)))
                    || (y == 152 && ((108 <= x && x <= 208) || (472 <= x && x <= 516) || (612 <= x && x <= 800)))
                    || (y == -8 && 560 <= x && x <= 572)
                    || (y == 112 && ((516 <= x && x <= 560) || (572 <= x && x <= 612)))
                    || (y == 196 && 424 <= x && x <= 472) || (y == 276 && 756 <= x && x <= 980)
                    || (y == 308 && 480 <= x && x <= 652)) {
                up = false;
            } else {
                up = true;
            }
            if ((y == 180 && 480 <= x && x <= 652)
                    || (y == 184 && ((108 <= x && x <= 152) || (168 <= x && x <= 208) || (668 <= x && x <= 740)
                            || (756 <= x && x <= 800)))
                    || (y == 300 && ((92 <= x && x <= 472) || (740 <= x && x <= 980)))
                    || (y == 340 && ((472 <= x && x <= 560) || (572 <= x && x <= 660)))) {
                down = false;
            } else {
                down = true;
            }
        }
        if (bando2) {
            if ((x == 168 && 188 <= y && y <= 232) || (x == 136 && 180 <= y && y <= 188)
                    || (x == 108 && ((144 <= y && y <= 180) || (348 <= y && y <= 468)))
                    || (x == 192 && 56 <= y && y <= 140)
                    || (x == 880 && 56 <= y && y <= 468) || (x == 716 && 164 <= y && y <= 192)
                    || (x == 800 && 200 <= y && y <= 224) || (x == 828 && 228 <= y && y <= 252)
                    || (x == 552 && 168 <= y && y <= 252)) {
                left1 = false;
            } else {
                left1 = true;
            }
            if ((x == 960 && ((56 <= y && y <= 228) || (292 <= y && y <= 468))) || (x == 272 && 244 <= y && y <= 468)
                    || (x == 328 && 224 <= y && y <= 240) || (x == 380 && 196 <= y && y <= 220)
                    || (x == 436 && 168 <= y && y <= 192) || (x == 552 && 212 <= y && y <= 252)
                    || (x == 628 && 168 <= y && y <= 208)) {
                right1 = false;
            } else {
                right1 = true;
            }
            if ((y == 56 && 192 <= x && x <= 960) || (y == 232 && ((964 <= x && x <= 1100) || (0 <= x && x <= 160)))
                    || (y == 144 && 108 <= x && x <= 188)) {
                up = false;
            } else {
                up = true;
            }
            if ((y == 468 && ((880 <= x && x <= 960) || (108 <= x && x <= 272))) || (y == 192 && 716 <= x && x <= 796)
                    || (y == 224 && 800 <= x && x <= 820) || (y == 176 && 108 <= x && x <= 132)
                    || (y == 188 && 136 <= x && x <= 160) || (y == 344 && 0 <= x && x <= 108)
                    || (y == 240 && 276 <= x && x <= 328) || (y == 220 && 332 <= x & x <= 380)
                    || (y == 192 && 384 <= x && x <= 436) || (y == 164 && 440 <= x && x <= 548)
                    || (y == 208 && 556 <= x && x <= 628) || (y == 164 && 636 <= x && x <= 712)
                    || (y == 252 && x == 552) || (y == 252 && 828 <= x && x <= 836)
                    || (y == 288 && 964 <= x && x <= 1100)) {
                down = false;
            } else {
                down = true;
            }
        }
        if (h == 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    // đặt quái
    private void locateMonster() {
        if (inGame) {
            for (int z = 0; z < 5; z++) {
                p[z] = 0;
                hmt[z] = 6;
            }
            if (bando1) {
                monster_x[0] = 432;
                monster_y[0] = 248;
                monster_x[1] = 560;
                monster_y[1] = 144;
                monster_x[2] = 560;
                monster_y[2] = 344;
                monster_x[3] = 752;
                monster_y[3] = 192;
                monster_x[4] = 832;
                monster_y[4] = 316;
            }
            if (bando2) {
                monster_x[0] = 232;
                monster_y[0] = 204;
                monster_x[1] = 428;
                monster_y[1] = 136;
                monster_x[2] = 592;
                monster_y[2] = 208;
                monster_x[3] = 792;
                monster_y[3] = 136;
                monster_x[4] = 1012;
                monster_y[4] = 272;
            }
        }
    }

    // vòng lặp điều kiện
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkMonster();
            checkCollision();
        }

        repaint();
    }

    // các nút thao tác
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            // trong bắt đầu
            if (level) {
                // di chuyển mũi tên
                if (key == KeyEvent.VK_UP && ymn > 200) {
                    ymn -= 50;
                }
                if (key == KeyEvent.VK_DOWN && ymn < 250) {
                    ymn += 50;
                }
                // các nút thao tác
                if (key == KeyEvent.VK_LEFT) {
                    menu = true;
                    level = false;
                    ymn = 180;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 190) {
                    lvl = 2;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 240) {
                    lvl = 4;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 290) {
                    lvl = 10;
                }
            }
            // trong nhân vật
            if (character) {
                // di chuyển mũi tên
                if (key == KeyEvent.VK_UP && ymn > 200) {
                    ymn -= 50;
                }
                if (key == KeyEvent.VK_DOWN && ymn < 250) {
                    ymn += 50;
                }
                // các nút thao tác
                if (key == KeyEvent.VK_LEFT) {
                    menu = true;
                    character = false;
                    ymn = 180;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 190) {
                    meliodas = true;
                    escanor = false;
                    diana = false;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 240) {
                    meliodas = false;
                    escanor = true;
                    diana = false;
                }
                if (key == KeyEvent.VK_ENTER && ymn == 290) {
                    meliodas = false;
                    escanor = false;
                    diana = true;
                }
            }
            // trong menu
            if (menu) {
                // di chuyển mũi tên
                if (key == KeyEvent.VK_UP && ymn > 200) {
                    ymn -= 50;
                }
                if (key == KeyEvent.VK_DOWN && ymn < 300) {
                    ymn += 50;
                }
                // các nút thao tác
                if (key == KeyEvent.VK_RIGHT && ymn == 180) {
                    menu = false;
                    start = true;
                    score = 0;
                    bando1 = true;
                    bando2 = false;
                    bando3 = false;
                    x = 156;
                    y = 156;
                    h = 6;
                    locateMonster();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                    initGame();
                }
                if (key == KeyEvent.VK_RIGHT && ymn == 230) {
                    menu = false;
                    level = true;
                    ymn = 190;
                }
                if (key == KeyEvent.VK_RIGHT && ymn == 280) {
                    menu = false;
                    character = true;
                    ymn = 190;
                }
                if (key == KeyEvent.VK_RIGHT && ymn == 330) {
                    System.exit(0);
                }
            }
            // vào game
            if (start && menu == false) {
                // lấy vị trí
                if (key == KeyEvent.VK_P) {
                    System.out.println(x);
                    System.out.println(y);
                }
                // tấn công
                if (key == KeyEvent.VK_T) {
                    attack1 = true;
                }
                if (key == KeyEvent.VK_R) {
                    attack2 = true;
                }
                // thoát game
                if (key == KeyEvent.VK_E) {
                    System.exit(0);
                }
                // chết
                if (key == KeyEvent.VK_U) {
                    inGame = false;
                }
                // hồi sinh
                if (key == KeyEvent.VK_I) {
                    inGame = true;
                    x = 156;
                    y = 156;
                    h = 6;
                    score = 0;
                    locateMonster();
                    initGame();
                }
                // ra ngoài menu
                if (key == KeyEvent.VK_ESCAPE) {
                    menu = true;
                    start = false;
                    bando3 = false;
                }
                // di chuyển giữa các map
                if (key == KeyEvent.VK_DOWN && y == 544 && 560 <= x && x <= 572 && bando1) {
                    bando1 = false;
                    bando2 = true;
                    x = 0;
                    y = 292;
                    locateMonster();
                }

                if (key == KeyEvent.VK_LEFT && x == 0 && 244 <= y && y <= 344 && bando2) {
                    bando1 = true;
                    bando2 = false;
                    x = 568;
                    y = 544;
                    locateMonster();
                }
                if (key == KeyEvent.VK_RIGHT && x == 1068 && 232 <= y && y <= 288 && bando2) {
                    bando3 = true;
                }
                // di chuyển nhân vật
                else if (key == KeyEvent.VK_LEFT) {
                    if (left1) {
                        x -= DOT_SIZE;
                    }
                    run = true;
                    left = true;
                    right = false;
                    loadcharacter();
                }

                else if (key == KeyEvent.VK_RIGHT) {
                    if (right1) {
                        x += DOT_SIZE;
                    }
                    run = true;
                    left = false;
                    right = true;
                    loadcharacter();
                }

                else if (key == KeyEvent.VK_UP) {
                    if (up) {
                        y -= DOT_SIZE;
                    }
                    run = true;
                }

                else if (key == KeyEvent.VK_DOWN) {
                    if (down) {
                        y += DOT_SIZE;
                    }
                    run = true;
                }
            }
        }
    }
}