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

public class Stone extends Critter {
	// method comment goes here
	public Attack fight(String opponent) {
		return Attack.ROAR;
	}

	// method comment goes here
	public Color getColor() {
		return Color.GRAY;
	}

	// method comment goes here
	public String toString() {
		return "@";
	}
}