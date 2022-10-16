import java.awt.*;
import java.awt.event.*;

public class SimpleFrame extends Frame {
    SimpleFrame(String s) {
        super(s);
        setSize(500, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                dispose(); // Закрытие окна
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        int dx = d.width, dy = d.height;
        g.drawLine(0 ,0, dx, dy);
        g.drawLine(dx, 0, 0, dy);
        g.drawRect(dx/2-25, dy/2-25, 50,50);
        g.drawOval(dx/2-45, dy/2-45, 90, 90);
        g.drawArc(0, dy/2, 500,100, 0, 180);
        setBackground(Color.cyan);
        setForeground(Color.RED);
    }

    public static void main(String[] args) {
        new SimpleFrame("Окно");
    }
}
