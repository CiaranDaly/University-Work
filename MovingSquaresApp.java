//Ciaran Daly // V1.0 //CT255 Assignment 2 Semester 2

import javax.swing.*;
import java.awt.*;

public class MovingSquaresApp extends JFrame implements Runnable{

    private static final Dimension WindowSize = new Dimension(600,600);
    private static final int NUMGAMEOBJECTS = 30;
    private GameObject[] GameObjectArr = new GameObject[NUMGAMEOBJECTS];//game object array of size 30

    //TODO: Create and start a thread, use thread to perform animation on GameObjects, paint method to draw game objects
    //constructor
    public MovingSquaresApp() {
        this.setTitle("Week 2 Assignment");
        //this.getContentPane().setBackground(Color.white); moved to paint method
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WindowSize);

        for (int i = 0; i < NUMGAMEOBJECTS; i++) {
            GameObjectArr[i] = new GameObject(); //populate GameObject Array with individual
        }
        //Create and start new thread
        Thread t = new Thread(this);
        t.start();


        setVisible(true);
    }
    public void run() {
        while (true) {
            for (GameObject gameObject : GameObjectArr) {
                gameObject.move();//invoke move method for each game object of the Array
            }

            try {
                Thread.sleep(100);//sleep for 100ms
                //handle InterruptedException
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();//call this.repaint() to invoke paint method
        }
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight()); //sets full back round to white
        for (GameObject gameObject : GameObjectArr) {
            gameObject.paint(g);//loop through each game object in the array and call its paint method
        }
    }


    public static void main(String[] args){

        MovingSquaresApp Msa = new MovingSquaresApp();
    }

}
