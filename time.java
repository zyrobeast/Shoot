import java.awt.*;

class time {
    int x = (int) (Math.random() * 500), y = 0, n = 2;

    public time() {
    }

    public void ini() {
        x = (int) (Math.random() * 500);
        y = 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.red);
        g.drawString("T", x + 5, y + 5);
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
