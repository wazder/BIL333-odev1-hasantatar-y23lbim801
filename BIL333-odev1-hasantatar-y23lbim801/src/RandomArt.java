import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomArt extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();

        // Rastgele çizgiler üretme
        for (int i = 0; i < 20; i++) {
            int x1 = rand.nextInt(getWidth());
            int y1 = rand.nextInt(getHeight());
            int x2 = rand.nextInt(getWidth());
            int y2 = rand.nextInt(getHeight());
            int colorR = rand.nextInt(256);
            int colorG = rand.nextInt(256);
            int colorB = rand.nextInt(256);
            g.setColor(new Color(colorR, colorG, colorB));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RandomArt art = new RandomArt();
        frame.setTitle("Random Art");
        frame.add(art);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
