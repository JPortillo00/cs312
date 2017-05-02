
/*
 * @authors: Student 1: Jairo Portillo
 *           Student 2: Erick Campos
 * CS312 Assignment 2.
 *  On OUR honor, Jairo Portillo and Erick Campos, this programming assignment is OUR own work
 *
 *  and WE have not provided this code to any other student.
 *
 * A program to print out the UT Tower via ASCII art.
 *
 * Student 1 (Turnin account used): Jairo Portilo
 * UTEID: jep2896
 * email address: portillo.jairojr@gmail.com
 * Section 5 digit ID: 53565
 * Grader name: Taylor
 * Number of slip days used on this assignment:
 *
 * Student 2: Erick Campos
 * UTEID: ejc985
 * email address: erick.j.campos@utexas.edu 
 * Section 5 digit ID: 53550
 * 
 */
public class Tower
{
    public static final int SIZE = 3; // Do not change this line in your submitted code
    public static void top(int SIZE) //This Method focus on the peak of the tower, the very top
    {
        for(int k =1 ; 2*SIZE + 2 >= k; k++){
            System.out.print(" ");
        }
        for (int i = 1;2 * SIZE - 1 >= i; i++)
        {
            System.out.print("#");
        }

        for (int i = 1; 2*SIZE - 2 >=i; i++){
            System.out.println(); 
            for(int k =1 ; 2*SIZE + 2 >= k; k++){
                System.out.print(" ");
            }
            for (int j = 1;2 * SIZE - 1 >= j; j++)
            {
                System.out.print("|");
            }
        }
        System.out.println();
        for(int k =1 ; 2*SIZE + 2 >= k; k++){
            System.out.print(" ");
        }
        for (int i = 1;2 * SIZE - 1 >= i; i++)
        {
            System.out.print("#");

        }
    } 

    public static void body(int SIZE)// This method focuses primariy on the part of the tower with the majority of the windows
    {
        System.out.println();
        for(int k =1 ; 2*SIZE >= k; k++){
            System.out.print(" ");
        }
        for(int i=1; SIZE*SIZE >=i; i++){
            for( int j=1; 2*SIZE + 3 >= j; j++){
                System.out.print("~");
            }
            System.out.println();
            for(int k =1 ; 2*SIZE >= k; k++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int k=1;SIZE >= k; k++){
                System.out.print("-O");
            }
            System.out.print("-|");
            System.out.println();
            for(int k =1 ; 2*SIZE >= k; k++){
                System.out.print(" ");
            }
        }
        for( int j=1; 2*SIZE + 3 >= j; j++){
            System.out.print("~");
        }
    }

    public static void bottom(int SIZE)// This Method focuses on the area of the tower with primarily commas and apostrophes
    {
        System.out.println();
        for(int line=0 ; SIZE/2 + 1 > line; line++) /* The formula SIZE/2 + 1 is used for the hieght of the tower 
        as 2/2 + 1 =2 and 3/2 + 1 =2*/
            {
            for(int space =1 ; 2*SIZE - 2*line >= space; space++){
                System.out.print(" ");
            }
            System.out.print("/");
            for(int b=1 ; SIZE + 2*line >= b; b++)
            {
                System.out.print("\"'");
            }
            System.out.println("\"\\");
        }
    }

    public static void base(int SIZE) //the method base codes for the very bottom of the tower that has the windows and the "steps"
    {
        for(int i = 1; SIZE >= i; i++)
        {
            System.out.print("/");
            for(int lines = 1; 3*SIZE >= lines; lines++)
            {
            System.out.print("\"O");
            }
            System.out.println("\"\\");
        }
    }

    public static void main (String[] args){
        {
            for( int i = 1; i<= 10;i++){
            top(i);
            body(i);
            bottom(i);
            base(i);}
        }
    }
}
