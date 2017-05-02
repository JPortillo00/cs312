/*
   This program asks the user for 2 integers, as boundaries.
   It then repeatedly asks for an integer between them, until 
   the sum of user entries >= 100.
   Illustrates while loops.
*/

import java.util.Scanner;
public class AddIntegers2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.printf("Enter 2 +ve ints in ascending order.: ");
		int a = sc.nextInt();
		int b = sc.nextInt();

		int sum = 0;
		String yes = "y";
		
		//outermost while loop keeps going until user says No.
		while (yes.equals("y")) {
			sum = 0;
			while (sum < 100) { // this loop reads user numbers while sum < 100
				int entry;
				entry = getUserEntry(sc, a, b);
				while (entry < a || entry > b) { // loop runs until user types in valid number
					System.out.println(entry + " is not valid.");
					entry = getUserEntry(sc, a, b);
				}
				sum += entry;
			}
			System.out.println("You reached " + sum);
			yes = playAgain(sc); // asks user if he wants to play again.
		}
		System.out.println("Thank you for playing. Bye!");
	}
	
	public static int getUserEntry (Scanner sc, int a, int b) {
		System.out.printf("Enter an integer between %d and %d incl.: ", a, b);
		return sc.nextInt();
	}
	
	public static String playAgain (Scanner sc) {
		System.out.print("Enter y or Y to play again: ");
		char entry = sc.next().charAt(0);
		if (entry == 'y' || entry == 'Y') return "y";
		else return "n";
	}
}
