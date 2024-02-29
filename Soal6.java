import javax.swing.*;
import java.awt.*;

public class Soal6 extends JFrame {

    public Soal6() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        drawLetterM(g2d, 50, 100);

        drawLetterA(g2d, 170, 100);

        drawLetterF(g2d, 290, 100);
    }

    private void drawLetterM(Graphics2D g2d, int x, int y) {
        int[] xPointsM = { x, x + 25, x + 50, x + 75, x + 100 };
        int[] yPointsM = { y + 100, y, y + 100, y, y + 100 };
        g2d.drawPolyline(xPointsM, yPointsM, 5);
    }

    private void drawLetterA(Graphics2D g2d, int x, int y) {
        int[] xPointsA = { x, x + 25, x + 50, x + 37, x + 12 };
        int[] yPointsA = { y + 100, y, y + 100, y + 50, y + 50 };
        g2d.drawPolyline(xPointsA, yPointsA, 5);
    }

    private void drawLetterF(Graphics2D g2d, int x, int y) {
        int[] xPointsF1 = { x, x };
        int[] yPointsF1 = { y, y + 100 };
        g2d.drawPolyline(xPointsF1, yPointsF1, 2);

        int[] xPointsF2 = { x, x + 50 };
        int[] yPointsF2 = { y + 50, y + 50 };
        g2d.drawPolyline(xPointsF2, yPointsF2, 2);

        int[] xPointsF3 = { x, x + 50 };
        int[] yPointsF3 = { y, y };
        g2d.drawPolyline(xPointsF3, yPointsF3, 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Soal6 frame = new Soal6();
            frame.setTitle("Letters: M, A, F");
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
