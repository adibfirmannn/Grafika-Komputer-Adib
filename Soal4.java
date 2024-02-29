import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class Soal4 extends Frame {

    private static final int WINDOW_SIZE = 600;
    private static final int SUN_RADIUS = 30;
    private static final int PLANET_RADIUS = 10;
    private static final int ORBIT_RADIUS = 200;
    private static final int FRAMES = 100;

    public Soal4() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double orbitRotationAngle = 2 * Math.PI / FRAMES;
        double planetRotationAngle = 365 * 2 * Math.PI / FRAMES;

        for (int i = 0; i <= FRAMES; i++) {
            double orbitX = ORBIT_RADIUS * Math.cos(orbitRotationAngle * i);
            double orbitY = ORBIT_RADIUS * Math.sin(orbitRotationAngle * i);

            clearWindow(g2d);

            drawSun(g2d);

            drawOrbitPath(g2d);

            drawAndRotatePlanet(g2d, orbitX, orbitY, planetRotationAngle * i);

            sustain(50);
        }
    }

    private void drawSun(Graphics2D g2d) {
        g2d.setPaint(Color.yellow);
        g2d.fill(new Ellipse2D.Double(WINDOW_SIZE / 2 - SUN_RADIUS, WINDOW_SIZE / 2 - SUN_RADIUS,
                2 * SUN_RADIUS, 2 * SUN_RADIUS));
    }

    private void drawOrbitPath(Graphics2D g2d) {
        g2d.setPaint(Color.gray);
        g2d.drawOval(WINDOW_SIZE / 2 - ORBIT_RADIUS, WINDOW_SIZE / 2 - ORBIT_RADIUS,
                2 * ORBIT_RADIUS, 2 * ORBIT_RADIUS);
    }

    private void drawAndRotatePlanet(Graphics2D g2d, double orbitX, double orbitY, double planetRotation) {
        AffineTransform originalTransform = g2d.getTransform();

        g2d.translate(WINDOW_SIZE / 2 + orbitX, WINDOW_SIZE / 2 + orbitY);
        g2d.rotate(planetRotation);
        g2d.setPaint(Color.blue);
        g2d.fill(new Ellipse2D.Double(-PLANET_RADIUS, -PLANET_RADIUS, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS));

        g2d.setTransform(originalTransform);
    }

    private void clearWindow(Graphics2D g) {
        g.setPaint(Color.white);
        g.fill(new Rectangle(0, 0, WINDOW_SIZE, WINDOW_SIZE));
        g.setPaint(Color.black);
    }

    private void sustain(long t) {
        long finish = (new Date()).getTime() + t;
        while ((new Date()).getTime() < finish) {
        }
    }

    public static void main(String[] argv) {
        Soal4 f = new Soal4();
        f.setTitle("Solar System Animation 2");
        f.setSize(WINDOW_SIZE, WINDOW_SIZE);
        f.setVisible(true);
    }
}
