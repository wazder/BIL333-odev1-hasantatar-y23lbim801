import javax.swing.*;
import java.awt.*;

public class DrawTicaretDDALine extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // "T" harfi
        ddaAlgorithm(g, 60, 50, 140, 50); // T'nin üst çizgisi
        ddaAlgorithm(g, 100, 50, 100, 150); // T'nin dikey çizgisi

        // "I" harfi
        ddaAlgorithm(g, 170, 50, 170, 150); // I'nin dikey çizgisi

        // "C" harfi
        ddaAlgorithm(g, 190, 50, 240, 50); // C'nin üst çizgisi
        ddaAlgorithm(g, 190, 50, 190, 150); // C'nin sol dikey çizgisi
        ddaAlgorithm(g, 190, 150, 240, 150); // C'nin alt çizgisi

        // "A" harfi
        ddaAlgorithm(g, 260, 150, 290, 50); // A'nın sol eğik çizgisi
        ddaAlgorithm(g, 290, 50, 320, 150); // A'nın sağ eğik çizgisi
        ddaAlgorithm(g, 275, 100, 305, 100); // A'nın orta çizgisi

        // "R" harfi
        ddaAlgorithm(g, 340, 50, 340, 150); // R'nin sol dikey çizgisi
        ddaAlgorithm(g, 340, 50, 380, 80); // R'nin üst yarım çember çizgisi
        ddaAlgorithm(g, 380, 80, 340, 100); // R'nin alt yarım çember çizgisi
        ddaAlgorithm(g, 340, 100, 380, 150); // R'nin çapraz çizgisi

        // "E" harfi
        ddaAlgorithm(g, 400, 50, 450, 50); // E'nin üst çizgisi
        ddaAlgorithm(g, 400, 100, 450, 100); // E'nin orta çizgisi
        ddaAlgorithm(g, 400, 150, 450, 150); // E'nin alt çizgisi
        ddaAlgorithm(g, 400, 50, 400, 150); // E'nin dikey çizgisi

        // "T" harfi
        ddaAlgorithm(g, 480, 50, 560, 50); // T'nin üst çizgisi
        ddaAlgorithm(g, 520, 50, 520, 150); // T'nin dikey çizgisi
    }

    // DDA çizgi çizme algoritması
    public void ddaAlgorithm(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float Xinc = dx / (float) steps;
        float Yinc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 4, 4); // Çizgi kalınlığı 4 piksel
            x += Xinc;
            y += Yinc;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawTicaretDDALine drawing = new DrawTicaretDDALine();
        frame.setTitle("Ticaret DDA Line");
        frame.add(drawing);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
