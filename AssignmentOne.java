// Ciaran Daly // 21381943 // V1.0
import java.awt.*;
import javax.swing.*;


public class AssignmentOne extends JFrame{

    private static final Dimension WindowSize = new Dimension(600,600);

    public AssignmentOne(){
        this.setTitle("Week 1 Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WindowSize);
        setVisible(true);
    }

    public void paint (Graphics g) {
        //nested loop to produces the squares
        for (int x = 0; x < getWidth(); x += 50) { //increment by 50 as width & height of squares are 40, leaving 10px gap on x & y
            for (int y = 0; y < getHeight(); y += 50) {
                //create a random colour for each r g b value to create a random, arbitrary colour
                int red = (int)(Math.random() * 256);
                int green = (int)(Math.random() * 256);
                int blue = (int)(Math.random() * 256);
                //set colour of square with the random r g b values
                g.setColor(new Color(red, green, blue));
                //fillRect used to draw the created square at each x & y value location from the loop, with L40 & W40
                g.fillRect(x, y, 40, 40);
            }
        }
    }
    public static void main(String[] args) {
    new AssignmentOne();
    }
}