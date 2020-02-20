import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;

public class Wheel extends JFrame {
    //  double Phi =  (1 + Math.sqrt(5)) / 2;

    int WIN_WIDTH = 1000;
    int WIN_HEIGHT = 1000;

    JPanel jPanel1 = new MyPanel();
    FlowLayout flowLayout1 = new FlowLayout();

    public Wheel() {
        super();
        try {
            initComponents();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    class MyPanel extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //   Dimension d = getSize();

            g2.setPaint(Color.black);
            g2.setBackground(Color.white);

            int radius=300;

            g2.setStroke(new BasicStroke(2));

            for(int n=100;n<=800;n+=25) {
                drawCircle(WIN_WIDTH/2, WIN_HEIGHT/2, n, g);
            }
            drawSpokes(WIN_WIDTH/2, WIN_HEIGHT/2, 800, g);
        }
    }

    static void drawCircle(int x, int y, int radius, Graphics g) {

        int xx=x-radius/2;
        int yy=y-radius/2;

        g.drawOval(xx, yy, radius, radius);
    }

    static void drawSpokes(int x, int y, int radius, Graphics g) {
        Double xx;
        Double yy;
        Double circ=2*Math.PI;
        for(Double c=0.0;c<circ;c+=circ/180.0) {
            xx=radius/2*Math.cos(c);
            yy=radius/2*Math.sin(c);
            g.drawLine(x,y,x-xx.intValue(),y-yy.intValue());
        }
    }

    private void initComponents() {
        this.setBounds(0, 0,WIN_WIDTH, WIN_HEIGHT);
        this.setSize(WIN_WIDTH, WIN_HEIGHT);
        getContentPane().setLayout(new BorderLayout());

        this.jPanel1.setBounds(0, 0,WIN_WIDTH, WIN_HEIGHT);
        this.jPanel1.setSize(WIN_WIDTH, WIN_HEIGHT);
        this.jPanel1.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        getContentPane().add(jPanel1, "Center");

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
                                   public void windowClosing(java.awt.event.WindowEvent e0) {
                                       System.exit(0);
                                   }
                               });
    }

    public static void main(String args[]) {
        new Wheel().setVisible(true);
    }
}




