
import java.util.*;
public class RandomChoice {
	public static final int NUM_OF_TRIALS = 1000000;
	public static void main (String [] args) {
		Random rand = new Random();
		int [] numbers = new int[100];
		for (int i = 1; i <= NUM_OF_TRIALS; i++) {
			int current = rand.nextInt(100);
			numbers[current] ++; 
		}
		System.out.println("NUM_OF_TRIALS = " + NUM_OF_TRIALS);
		System.out.println(Arrays.toString(numbers));
		getRange(numbers);
	}
	
	public static void getRange (int[] a) {
		int max = a[0];
		int min = a[0];
		for (int ai : a) {
			if (ai > max) max = ai;
			if (ai < min) min = ai;
		}
		System.out.printf("MAX: %d, MIN: %d, RANGE = %d\n", max, min, max-min);
	}
}
 