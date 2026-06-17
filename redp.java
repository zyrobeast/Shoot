import java.awt.*;

public class redp {
    int x, y, n = 1;

    public redp(int n) {
        this.n = n;
    }

    public void ini() {
        x = (int) (Math.random() * 500);
        y = 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 30, 30);
    }

    public void move() {
        y += n;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }
}