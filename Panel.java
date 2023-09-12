import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    String equation;

    Panel(String eq){ 
        this.setPreferredSize(new Dimension(500,500));
        equation = eq;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(2));
        Color grey = new Color(238,238,238);
        //g2D.setBackground(Color.blue);
        g2D.setPaint(grey);
        g2D.fillRect(0, 0, 400, 50);
        g2D.setPaint(Color.white);
        g2D.fillRect(50, 50, 400, 100);
        g2D.setPaint(Color.black);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g2D.setStroke(new BasicStroke(10));
        g2D.drawString(equation, 65, 110);
    }  

    public void updateEquation(String e) {
        equation = e;
    }
    
}
