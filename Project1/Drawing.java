import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/***************************************************************
 * @author - Jake Irons
 * @class - CIS 162-04
 **************************************************************/
public class Drawing extends JPanel{
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(500, 300);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g){
        int logox = 0;
        int logoy = 0;
        int contactx = -20;
        int contacty = 0;
        int imagex = 0;
        int imagey = 0;
        // this statement required
        super.paintComponent(g);
        // optional: paint the background color (default is white)
        setBackground(Color.BLACK);

        //name
        g.setColor(Color.PINK);
        Font name = new Font("serif", Font.ITALIC, 50);
        g.setFont(name);
        g.drawString("Jake's Sweets Shop", 50, 50);

        //motto
        g.setColor(Color.PINK);
        Font motto = new Font("sanserif", Font.ITALIC, 15);
        g.setFont(motto);
        g.drawString("Whether its candy, ice cream, or cakes... come get it from Jake's!", 35, 250);

        //contact information
        g.setColor(Color.WHITE);
        Font contactName = new Font("serif", Font.BOLD, 15);
        g.setFont(contactName);
        g.drawString("JAKE IRONS", contactx + 85, contacty + 90);
        Font contactPosition = new Font("serif", Font.ITALIC, 10);
        g.setFont(contactPosition);
        g.drawString("Owner", contactx + 85, contacty + 105);
        Font contactInfo = new Font("times", Font.PLAIN, 13);
        g.setFont(contactInfo);
        g.drawString("(222) 555-5555", contactx + 85, contacty + 145);
        g.drawString("ironsj@email.com", contactx + 85, contacty + 160);
        g.drawString("123 Sesame St. SE", contactx + 85, contacty + 190);
        g.drawString("NYC, New York", contactx + 85, contacty +205);

 
        //logo
        g.setColor(Color.PINK);
        g.fillOval(logox + 194, logoy + 85, 100, 140);
        g.setColor(Color.WHITE);
        g.fillRect(logox + 242, logoy + 120, 5, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(logox + 215, logoy + 90, 60, 60);
        g.setColor(Color.YELLOW);
        g.fillRect(logox + 215, logoy + 110, 60, 20);
        g.setColor(Color.ORANGE);
        g.drawRect(logox + 215, logoy + 110, 60, 20);

        //image
        BufferedImage photo = null;
        try {
            File file = new File("IMG_5433.jpg");
            photo = ImageIO.read(file);
        }
        catch (IOException e){
            g.drawString("Problem reading the file", 100, 100);
        }
        g.drawImage(photo, imagex + 340, imagey + 80, 85, 150, null);
    }
}
