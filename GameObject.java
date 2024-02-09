import java.awt.*;
import javax.swing.*;
public class GameObject { //Class for the Game Objects (Squares)
    private int x,y;
    private Color c;

    //Constructor
    public GameObject(){
        //generate a random x and y value for each GameObject
    x = (int)(Math.random() * 600);
    y = (int)(Math.random() * 600);
    //generate a random colour for each GameObject
    int red = (int)(Math.random() * 256);
    int green = (int)(Math.random() * 256);
    int blue = (int)(Math.random() * 256);
    c = new Color(red, green, blue);
    }

    public void  move(){
        //move each GameObject's x and y-axis values to a random value between -5 to 5
    x += (int)(Math.random() * 5)-(int)(Math.random() * 5);
    y += (int)(Math.random() * 5)-(int)(Math.random() * 5);

    }
    public void paint(Graphics g){
        g.setColor(c);//set colour to GameObject
        g.fillRect(x, y, 50, 50);//create square on the x and y which were generated above
    }
}
