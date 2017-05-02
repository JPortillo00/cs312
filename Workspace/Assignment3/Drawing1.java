
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Jairo Portillo
 * @version 2/13/14
 * CS312 Assignment 3.
 * On my honor, Jairo Portillo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to create a drawing. Part 1 of the assignment, worth 4 points.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID:53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:
 */

public class Drawing1 {
    public static void main(String[] args) {
        int width = 400, height = 200;
        DrawingPanel greenSheet = new DrawingPanel(width,height);
        greenSheet.setBackground(Color.GREEN);
        Graphics pen = greenSheet.getGraphics();
        pen.drawLine(0,100,400,100);
        pen.drawLine(200,0,200,400);
        for(int i = 0; 1>=i; i++)//This loop codes for bothe displays as it is a transformation of an image
        {
        pen.setColor(Color.RED);
        pen.fillOval(0 + 200*i,0 + 100*i,200,100);
        pen.setColor(Color.BLACK);
        pen.drawLine(100 + 200*i,0 + 100*i,100 + 200*i,100 + 100*i);
        pen.drawLine(0 + 200*i,50 + 100*i ,200 + 200*i,50 + 100*i);
        }
                   
    }
}