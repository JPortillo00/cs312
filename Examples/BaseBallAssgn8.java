import java.io.*;
import java.util.*;

/*
 * This program reads an input file that has 3 players' number of hits, 
 * at bats, and number of strike outs.  It then returns an array of double
 * that is the total number of hits, bats, and strike outs.
 */
public class BaseBallAssgn8 {

	public static void main(String[] args) throws FileNotFoundException {

		int[] batting = {100, 230, 40, 200, 400, 55, 60, 130, 15};
		System.out.println(Arrays.toString(sumStats(batting)));		
		
	}
	
	public static int[] sumStats (int [] batting) {
		int[] totals = new int[3];
		int i = 0;
		while (i < batting.length) {
			totals[i%3] += batting[i];
			i++;
		}
		return totals;
	}
}