import java.awt.*;
import java.awt.geom.*;

class Soal1 extends Frame {

    Soal1() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GeneralPath gp = new GeneralPath();
        float x = 60f;
        float y = 80f;
        float width = 140f;
        float height = 60f;
        float cornerRadius = 20f;

        gp.moveTo(x + cornerRadius, y);
        gp.lineTo(x + width - cornerRadius, y);
        gp.quadTo(x + width, y, x + width, y + cornerRadius);
        gp.lineTo(x + width, y + height - cornerRadius);
        gp.quadTo(x + width, y + height, x + width - cornerRadius, y + height);
        gp.lineTo(x + cornerRadius, y + height);
        gp.quadTo(x, y + height, x, y + height - cornerRadius);
        gp.lineTo(x, y + cornerRadius);
        gp.quadTo(x, y, x + cornerRadius, y);
        gp.closePath();

        g2d.draw(gp);

        g2d.setStroke(new BasicStroke(1.0f));

        drawSimpleCoordinateSystem(250, 150, g2d);
    }

    public static void drawSimpleCoordinateSystem(int xmax, int ymax, Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        Font fo = g2d.getFont();
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);

        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        s = "  ";
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            if (i > 99) {
                s = "";
            }
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        Soal1 f = new Soal1();
        f.setTitle("Rounded Box");
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
