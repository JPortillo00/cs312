
/**
 * Write a description of class k here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; // necessary for using Graphics and Color
public class Bus
{
    public static void main (String [] args) {
        int width = 400, height = 300;
        DrawingPanel whiteBoard = new DrawingPanel(width, height);
        whiteBoard.setBackground(Color.LIGHT_GRAY);
        Graphics pen = whiteBoard.getGraphics();
        
        pen.setColor(Color.YELLOW);
        pen.fillRect(100, 50, 200, 100);

        // int busULX = 100, busULY = 50, busWidth = 200, busHeight = 100;
        // draw bus body
        pen.fillRect(100, 50, 200, 100);
        pen.setColor(Color.CYAN);
        // draw bus Window
        pen.fillRect(240, 60, 60, 50);
        pen.setColor(Color.BLUE);
        pen.drawRect(240, 60, 60, 50);
        // draw wheels
        // int wheelRad = 20;
        pen.setColor(Color.BLACK);
        pen.fillOval(125, 130, 40, 40);
        pen.fillOval(250, 130, 40, 40);
        // draw small windows

        for (int i = 0; i < 4; i++) {
            pen.setColor(Color.CYAN);
            pen.fillRect(120 + i*30, 70, 20, 20);
        }
        pen.drawString("School Bus",150, 120);
    }
}
