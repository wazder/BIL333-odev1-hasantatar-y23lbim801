import javax.swing.*;
import java.awt.*;

public class DDALine extends JPanel {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DDALine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ddaAlgorithm(g, x1, y1, x2, y2);
    }

    public void ddaAlgorithm(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float Xinc = dx / (float) steps;
        float Yinc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += Xinc;
            y += Yinc;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DDALine line = new DDALine(100, 50, 200, 150);
        frame.setTitle("DDA Line");
        frame.add(line);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
