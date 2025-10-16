import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InteractiveScanlineFill extends Frame implements MouseListener, KeyListener {
    private ArrayList<Point> points = new ArrayList<>();
    private boolean fill = false;

    public InteractiveScanlineFill() {
        super("Interactive Scanline Fill");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true); // Important for key events
        requestFocusInWindow();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (points.size() > 1) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < points.size(); i++) {
                Point p1 = points.get(i);
                Point p2 = points.get((i + 1) % points.size());
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        if (fill && points.size() >= 3) {
            scanlineFill(g);
        }
    }

    private void scanlineFill(Graphics g) {
        int n = points.size();
        int[] px = new int[n];
        int[] py = new int[n];

        for (int i = 0; i < n; i++) {
            px[i] = points.get(i).x;
            py[i] = points.get(i).y;
        }

        int ymin = py[0], ymax = py[0];
        for (int i = 1; i < n; i++) {
            ymin = Math.min(ymin, py[i]);
            ymax = Math.max(ymax, py[i]);
        }

        g.setColor(Color.ORANGE);

        for (int y = ymin; y <= ymax; y++) {
            ArrayList<Integer> intersections = new ArrayList<>();
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                if ((py[i] < y && py[j] >= y) || (py[j] < y && py[i] >= y)) {
                    int x = px[i] + (y - py[i]) * (px[j] - px[i]) / (py[j] - py[i]);
                    intersections.add(x);
                }
                j = i;
            }

            intersections.sort(Integer::compareTo);

            for (int i = 0; i < intersections.size() - 1; i += 2) {
                int x1 = intersections.get(i);
                int x2 = intersections.get(i + 1);
                g.drawLine(x1, y, x2, y);
            }
        }
    }

    // Mouse Click: Add point
    public void mouseClicked(MouseEvent e) {
        if (!fill) {
            points.add(e.getPoint());
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // Press "F" to fill
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F && points.size() >= 3) {
            fill = true;
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new InteractiveScanlineFill();
    }
}
