import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Jairo Portillo
 * @version 2/13/14
 * CS312 Assignment 3.
 * On my honor, Jairo Portillo , this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to print out various ScintillationGrids. Part 2 of assignment 3.
 * Worth 16 points.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:
 */

public class ScintillationGrid {
    public static void main(String[] args) {
        int width = 900, height = 650;
        DrawingPanel backGround = new DrawingPanel(width,height);
        backGround.setBackground(Color.CYAN);
        Graphics pen = backGround.getGraphics();
        //Four Methods for four grids
        grids(pen,0,0,300,3,6);
        grids(pen,50,400,200,1,20);
        grids(pen,400,50,420,6,10);
        grids(pen,500,500,120,7,4);
    }
    //Grids method creates each of the grids when the parameters are entered
    public static void grids (Graphics a,int x, int y,int size,int lines, int thickness){
        int interval = (size-(thickness*lines))/(lines+1); 
        //the variable interval codes for the equation that tell the the interval between each line end to end
        blackBox(a,x,y,size);
        verticalLines(a,x,y,size,lines,thickness,interval);
        horizontalLines(a,x,y,size,lines,thickness,interval);
        circleDots(a,x,y,size,lines,thickness,interval);
    }
    //Method blackBox codes for the background of each grid
    public static void blackBox(Graphics p, int i,int j,int s){
        p.setColor(Color.BLACK);
        p.fillRect(i,j,s,s);
    }
    //Method verticalLines draws the vertical line for each grid
    public static void verticalLines(Graphics p,int x,int y,int s, int l, int t,int I){
        p.setColor(Color.LIGHT_GRAY);
        for(int i =1; l>=i;i++)
            p.fillRect(x+I*i+ t*(i-1)+1,y,t,s);
    }
    //Method horizontalLine draws the horizantal lines on the x axis for each grid
    public static void horizontalLines(Graphics p,int x,int y,int s, int l, int t,int I){
        p.setColor(Color.LIGHT_GRAY);
        for(int i =1; l>=i;i++)
            p.fillRect(x,y+I*i+ t*(i-1)+1,s,t);
    }
    //Method circleDots draws the white circles on the intersections of the lines
    public static void circleDots(Graphics p,int x,int y,int s, int l, int t,int I){
        p.setColor(Color.WHITE);
        int  m = Math.max(t+2,14*t/10); 
        int c = m/10;
        /*the variable c in a "correction" coeffient that helps keep the coordinates of the circles correct.
         * This coefficient helps make up (image-wise) for not deriving the ideal formula. 
         */
        for(int i =1; l>=i;i++){
            p.fillOval(x +i*I+(i-1)*t-c , y +I-c ,m,m);
            for(int j = 2; l>=j;j++){
                p.fillOval(x +I - c,y +j*I+(j-1)*t-c,m,m);
                p.fillOval(x +i*I+(i-1)*t-c ,y +j*I+(j-1)*t-c,m,m);
            }                      

        }
    }
}
