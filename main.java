import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class main extends Applet implements Runnable, MouseListener {
    bluep b1 = new bluep(1);
    bluep b2 = new bluep(2);
    bluep b3 = new bluep(3);
    redp r1 = new redp(3);
    redp r2 = new redp(4);
    redp r3 = new redp(1);
    redp r4 = new redp(4);
    redp r5 = new redp(5);
    time ti = new time();
    health he = new health();
    Thread th;
    int time = 6000, a = 0, t = 0, h = 0, b = 0;
    int health = 100, score = 0;
    boolean gm, fl;
    Cursor c = new Cursor(Cursor.CROSSHAIR_CURSOR);
    int mx = 0, my = 0;
    Font f = new Font("Sans Serif", Font.BOLD, 20);
    private Graphics db;
    private Image i;

    public void init() {
        setSize(500, 615);
        setBackground(Color.black);
        setCursor(c);
        addMouseListener(this);
        setFocusable(true);
        th = new Thread(this);
        setFont(f);
    }

    public void start() {
        th.start();
    }

    public void run() {
        while (true) {
            setSize(500, 615);
            if (t == 1)
                ti.move();
            if (h == 1)
                he.move();
            b1.move();
            b2.move();
            b3.move();
            r1.move();
            r2.move();
            r3.move();
            r4.move();
            r5.move();
            if (((r1.getx() < mx) && (r1.getx() + 30 > mx) && (r1.gety() < my) && (r1.gety() + 30 > my)) || ((r5.getx() < mx) && (r5.getx() + 30 > mx) && (r5.gety() < my) && (r5.gety() + 30 > my)) || ((r2.getx() < mx) && (r2.getx() + 30 > mx) && (r2.gety() < my) && (r2.gety() + 30 > my)) || ((r4.getx() < mx) && (r4.getx() + 30 > mx) && (r4.gety() < my) && (r4.gety() + 30 > my)) || ((r3.getx() < mx) && (r3.getx() + 30 > mx) && (r3.gety() < my) && (r3.gety() + 30 > my)))
                health--;
            if (((b1.getx() < mx) && (b1.getx() + 30 > mx) && (b1.gety() < my) && (b1.gety() + 30 > my)) || ((b2.getx() < mx) && (b2.getx() + 30 > mx) && (b2.gety() < my) && (b2.gety() + 30 > my)) || ((b3.getx() < mx) && (b3.getx() + 30 > mx) && (b3.gety() < my) && (b3.gety() + 30 > my)))
                score += 10;
            if (((b1.getx() < mx) && (b1.getx() + 30 > mx) && (b1.gety() < my) && (b1.gety() + 30 > my)) || (b1.gety() > 480))
                b1.ini();
            if (((b2.getx() < mx) && (b2.getx() + 30 > mx) && (b2.gety() < my) && (b2.gety() + 30 > my)) || (b2.gety() > 480))
                b2.ini();
            if (((b3.getx() < mx) && (b3.getx() + 30 > mx) && (b3.gety() < my) && (b3.gety() + 30 > my)) || (b3.gety() > 480))
                b3.ini();
            if (((r1.getx() < mx) && (r1.getx() + 30 > mx) && (r1.gety() < my) && (r1.gety() + 30 > my)) || (r1.gety() > 480))
                r1.ini();
            if (((r2.getx() < mx) && (r2.getx() + 30 > mx) && (r2.gety() < my) && (r2.gety() + 30 > my)) || (r2.gety() > 480))
                r2.ini();
            if (((r3.getx() < mx) && (r3.getx() + 30 > mx) && (r3.gety() < my) && (r3.gety() + 30 > my)) || (r3.gety() > 480))
                r3.ini();
            if (((r4.getx() < mx) && (r4.getx() + 30 > mx) && (r4.gety() < my) && (r4.gety() + 30 > my)) || (r4.gety() > 480))
                r4.ini();
            if (((r5.getx() < mx) && (r5.getx() + 30 > mx) && (r5.gety() < my) && (r5.gety() + 30 > my)) || (r5.gety() > 480))
                r5.ini();
            if ((ti.getx() < mx) && (ti.getx() + 30 > mx) && (ti.gety() < my) && (ti.gety() + 30 > my))
                time += 15;
            if ((he.getx() < mx) && (he.getx() + 30 > mx) && (he.gety() < my) && (he.gety() + 30 > my))
                health += 1;
            if (((ti.getx() < mx) && (ti.getx() + 30 > mx) && (ti.gety() < my) && (ti.gety() + 30 > my)) || (ti.gety() == 480)) {
                ti.ini();
                t = 0;
                score += 10;
            }
            if (((he.getx() < mx) && (he.getx() + 30 > mx) && (he.gety() < my) && (he.gety() + 30 > my)) || (he.gety() == 480)) {
                he.ini();
                h = 0;
                score += 10;
            }
            if ((a % 100 == 0) && (a > 0)) {
                time -= 1;
                b += 1;
                a = 0;
            }
            a++;
            if ((b % 30 == 0) && (b != 0)) {
                b += 1;
                b1.n++;
                b2.n++;
                b3.n++;
            }

            repaint();
            if ((score % 250 == 0) && (score > 0))
                t = 1;
            if ((score % 190 == 0) && (score > 0))
                h = 1;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            if (health == 0) {
                gm = true;
                break;
            }
            if (time == 0) {
                gm = true;
                break;
            }
        }
        repaint();
    }

    public void paint(Graphics g) {
        r1.draw(g);
        r2.draw(g);
        r3.draw(g);
        r4.draw(g);
        r5.draw(g);
        b1.draw(g);
        b2.draw(g);
        b3.draw(g);
        g.setColor(Color.white);
        g.fillRect(0, 480, 500, 150);
        if (t == 1)
            ti.draw(g);
        if (h == 1)
            he.draw(g);
        g.setColor(Color.black);
        g.drawString("TIME LEFT   " + time, 0, 500);
        g.drawString("HEALTH   " + health, 0, 530);
        g.drawString("YOUR SCORE IS " + score, 0, 560);
        g.drawString("HEALTH", 335, 510);
        g.drawString("TIME", 335, 545);
        g.drawString("TOUCH-ME-NOT", 335, 575);
        g.drawString("POINT", 335, 610);
        if (gm == true) {
            g.setColor(Color.red);
            g.drawString("GAME OVER", 250, 250);
        }
        g.setColor(Color.green);
        g.fillOval(300, 487, 30, 30);
        g.setColor(Color.red);
        g.drawString("H", 305, 492);
        g.setColor(Color.green);
        g.fillOval(300, 523, 30, 30);
        g.setColor(Color.red);
        g.drawString("T", 305, 528);
        g.setColor(Color.red);
        g.fillOval(300, 552, 30, 30);
        g.setColor(Color.blue);
        g.fillOval(300, 582, 30, 30);
    }

    public void update(Graphics g) {
        if (i == null) {
            i = createImage(this.getSize().width, this.getSize().height);
            db = i.getGraphics();
        }
        db.setColor(getBackground());
        db.fillRect(0, 0, this.getSize().width, this.getSize().height);
        db.setColor(getForeground());
        paint(db);
        g.drawImage(i, 0, 0, this);
    }

    public void mouseExited(MouseEvent a) {
    }

    public void mouseEntered(MouseEvent a) {
    }

    public void mouseReleased(MouseEvent a) {
        mx = 0;
        my = 0;
    }

    public void mousePressed(MouseEvent a) {
        mx = a.getX();
        my = a.getY();
    }

    public void mouseClicked(MouseEvent a) {
    }
}
