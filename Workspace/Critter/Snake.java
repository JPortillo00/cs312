import java.awt.Color;
import java.util.Random;

/**
 * @author Vallath Nandakumar
 *
 */
public class Snake extends Critter {
	
	private boolean goEast;
	
	// How many moves to go horizontally before going SOUTH.
	private int maxEWMoves = 1;
	
	// How many horizontal moves made so far in one direction.
	private int noOfEWMoves = 0;
	
	public Snake (boolean goEast) {
		this.goEast = goEast;
	}
	
	public Attack fight (String opponent) {
		return Attack.SCRATCH;
	}
	
	public Direction getMove() {
		if (noOfEWMoves == maxEWMoves) {
			noOfEWMoves = 0;
			maxEWMoves++;
			goEast = !goEast;
			return Direction.SOUTH;
		}
		noOfEWMoves++;
		if (goEast) {
			return Direction.EAST;
		} else {
			return Direction.WEST;
		}		
	}
	
	public String toString () {
		return "S";
	}
	
	public Color getColor () {
		return Color.BLACK;
	}
	
	/*
	 * Eat randomly when food is encountered.
	 * @see Critter#eat()
	 */	
	public boolean eat () {
		Random rand = new Random();
		return rand.nextBoolean();
	}

}
