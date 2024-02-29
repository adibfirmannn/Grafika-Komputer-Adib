import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Soal5 extends JPanel implements ActionListener {
    private Timer timer;
    private double waveHeight = 10.0;
    private double waveFrequency = 0.2;
    private double waveOffset = 0.0;

    public Soal5() {
        timer = new Timer(20, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        waveOffset += 0.1;

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawWavingLine(g2d, getWidth(), getHeight());

        drawHeart(g2d, getWidth() / 2, getHeight() / 2 - 10);
    }

    private void drawHeart(Graphics2D g2d, int x, int y) {
        int width = 50;
        int height = 50;

        x -= width / 2;
        y -= height / 4;

        g2d.setColor(Color.RED);
        g2d.fillArc(x, y, width / 2, height / 2, 0, 180);
        g2d.fillArc(x + width / 2, y, width / 2, height / 2, 0, 180);
        g2d.fillRect(x, y + height / 4, width, height / 4);

        int[] xPoints = { x, x + width / 2, x + width };
        int[] yPoints = { y + height / 2, y + height, y + height / 2 };
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    private void drawWavingLine(Graphics2D g2d, int windowWidth, int windowHeight) {
        g2d.setColor(Color.BLACK);

        int centerY = windowHeight / 2;
        int amplitude = (int) waveHeight;

        for (int x = 0; x < windowWidth; x++) {
            int y = centerY + (int) (amplitude * Math.sin(waveFrequency * x + waveOffset));
            g2d.drawLine(x, y, x, y);
        }
    }

    public static void main(String[] argv) {
        JFrame frame = new JFrame("Beating Heart Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Soal5 animation = new Soal5();
        frame.add(animation);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
