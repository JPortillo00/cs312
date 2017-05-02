
/**
 * This program draws 2 buses of two different sizes. The buses 
 * move towards the right at different speeds.  Works with DrawingPanel.java.
 * 
 * @author (VN) 
 * @version (a version number or a date)
 */
import java.awt.*;                          // Needed for Graphics methods.
public class ParametrizedBus
{
    public static void main (String [] args) {
        int width = 2000, height = 600;        // Size of panel
        DrawingPanel p = new DrawingPanel(width, height);
        p.setBackground(Color.LIGHT_GRAY);    // Gray background
        Graphics pen = p.getGraphics();
        bus(100, 50, 1, pen);                // Draw bus of size 1
        bus(400, 250, 2, pen);                // Draw bus of size 2

        // Draw the moving buses
        for (int j = 0; j < 300; j++) {
            // Erase previously drawn bus by overwriting with gray rectangle.
            pen.setColor(Color.LIGHT_GRAY);
            pen.fillRect(0, 0, width, height);
            // Draw the buses with x position increasing by 4 and 2 pixels every 40 ms.
            bus(100+j*4, 50, 1, pen);
            bus(400+j*2, 250, 2, pen);
            p.sleep(40);
        }
    }

/*
 * This method draws a school bus whose position and size are parametrized.
*/
    public static void bus(int x, int y, int scale, Graphics g) {
        g.setColor(Color.YELLOW);
        int busULX = x, busULY = y;         // Upper left corner X and Y
        int busWidth = 200*scale, busHeight = 100*scale;

        // draw bus body
        g.fillRect(busULX, busULY, busWidth, busHeight);
        g.setColor(Color.CYAN);

        // draw bus front Window
        g.fillRect(busULX+3*busWidth/4, busULY+busHeight/4, busWidth/4, busHeight/3);

        // draw wheels
        g.setColor(Color.BLACK);
        int wheelRad = busHeight/4;
        g.fillOval(busULX + busWidth/8, busULY + busHeight - wheelRad, wheelRad*2, wheelRad*2);
        g.fillOval(busULX + 4*busWidth/6, busULY + busHeight - wheelRad, wheelRad*2, wheelRad*2);

        // Draw writing on side of bus
        g.drawString("School Bus",busULX + busWidth/5, busULY + busHeight/2);

        // draw small windows
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.CYAN);
            int windowSize = busHeight/4;
            g.fillRect(busULX + i*windowSize*3/2, busULY + windowSize/2, windowSize, windowSize);
        }
    }
}