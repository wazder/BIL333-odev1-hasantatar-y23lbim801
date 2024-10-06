import javax.swing.*;
import java.awt.*;

public class DrawTicaretBresenhamLine extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // "T" harfi
        bresenhamAlgorithm(g, 60, 50, 140, 50); // T'nin üst çizgisi
        bresenhamAlgorithm(g, 100, 50, 100, 150); // T'nin dikey çizgisi

        // "I" harfi
        bresenhamAlgorithm(g, 170, 50, 170, 150); // I'nin dikey çizgisi

        // "C" harfi
        bresenhamAlgorithm(g, 190, 50, 240, 50); // C'nin üst çizgisi
        bresenhamAlgorithm(g, 190, 50, 190, 150); // C'nin sol dikey çizgisi
        bresenhamAlgorithm(g, 190, 150, 240, 150); // C'nin alt çizgisi

        // "A" harfi
        bresenhamAlgorithm(g, 260, 150, 290, 50); // A'nın sol eğik çizgisi
        bresenhamAlgorithm(g, 290, 50, 320, 150); // A'nın sağ eğik çizgisi
        bresenhamAlgorithm(g, 275, 100, 305, 100); // A'nın orta çizgisi

        // "R" harfi
        bresenhamAlgorithm(g, 340, 50, 340, 150); // R'nin sol dikey çizgisi
        bresenhamAlgorithm(g, 340, 50, 380, 80); // R'nin üst yarım çember çizgisi
        bresenhamAlgorithm(g, 380, 80, 340, 100); // R'nin alt yarım çember çizgisi
        bresenhamAlgorithm(g, 340, 100, 380, 150); // R'nin çapraz çizgisi

        // "E" harfi
        bresenhamAlgorithm(g, 400, 50, 450, 50); // E'nin üst çizgisi
        bresenhamAlgorithm(g, 400, 100, 450, 100); // E'nin orta çizgisi
        bresenhamAlgorithm(g, 400, 150, 450, 150); // E'nin alt çizgisi
        bresenhamAlgorithm(g, 400, 50, 400, 150); // E'nin dikey çizgisi

        // "T" harfi
        bresenhamAlgorithm(g, 480, 50, 560, 50); // T'nin üst çizgisi
        bresenhamAlgorithm(g, 520, 50, 520, 150); // T'nin dikey çizgisi
    }

    // Bresenham çizgi çizme algoritması
    public void bresenhamAlgorithm(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.fillRect(x1, y1, 4, 4);  // Çizgi kalınlığı 4 piksel
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawTicaretBresenhamLine drawing = new DrawTicaretBresenhamLine();
        frame.setTitle("Ticaret Bresenham Line");
        frame.add(drawing);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
