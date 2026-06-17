import java.awt.*;

class bluep {
    public int x = (int) (Math.random() * 500), y, n;

    public bluep(int n) {
        this.n = n;
    }

    public void ini() {
        x = (int) (Math.random() * 500);
        y = 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
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