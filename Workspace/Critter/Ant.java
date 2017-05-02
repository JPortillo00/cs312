/**
 * @authors: Student 1:
 *           Student 2:
 *           
 * CS312 Assignment 11.
 *
 *  On <MY|OUR> honor, <NAME1> and <NAME2), this programming assignment is <MY|OUR> own work
 *  and <I|WE> have not provided this code to any other student.
 *
 * A class to simulate an environment with animals.
 *
 * Student 1: (Turnin account used)
 * UTEID:
 * email address:
 * Section 5 digit ID:
 * Grader name:
 * Number of slip days used on this assignment:
 *
 * Student 2:
 * UTEID:
 * email address:
 * Section 5 digit ID:
 * 
 */

// Stone objects are displayed as S and always stay put.
// They always pick ROAR in a fight.
//
import java.awt.*;

public class Ant extends Critter {

    public static boolean wS;
    public static boolean NS = true;

    public Ant(boolean walkSouth){
        wS = walkSouth;
    }

    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    public boolean eat(){
        return true;
    }

    public  Direction  getMove(){
        if(wS){

            if(NS){
                NS = false;
                return Direction.SOUTH;
            }else{
                NS = true;
                return Direction.EAST;}

        }else{

            if(NS){
                NS = false;
                return Direction.NORTH;
            }else{
                NS = true;
                return Direction.EAST;}

        }
    }

    // method comment goes here
    public Color getColor() {
        return Color.RED;
    }

    // method comment goes here
    public String toString() {
        return "%";
    }
}