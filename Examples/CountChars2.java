/*
  Count the number of characters entered by the user,
  until they type 'quit'.
*/
import java.util.*;
public class CountChars2 {
	public static void main (String[] args) {
	Scanner sc = new Scanner (System.in);

	String response = "";
	int sum = 0;

	while (!(response.equals( "quit"))) {
		// always enters while loop, since response = "" initially.
		sum += response.length();
		System.out.print("Type a line, or 'quit' to exit: ");
		response = sc.nextLine();
		// cannot update sum here, because otherwise quit will be counted.
	}
	System.out.printf("YoU entered %d characters.\n", sum);
	}
}
