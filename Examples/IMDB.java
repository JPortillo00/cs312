
import java.io.*;
import java.util.*;

/*
 * This program reads data from an IMDB database, and displays movies 
 * whose data matches a user-defined search term.
 */
public class IMDB {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner (System.in);
		String searchTerm = getWord(console);
		
		Scanner infile = new Scanner (new File("imdb.txt"));
		int matches = 0;
		String line = searchWord(infile, searchTerm);
		if (line.length() > 0) printHeader();
		while (line.length() > 0) {
			matches ++;
			display(line);
			line = searchWord(infile, searchTerm);
		}
		System.out.println("Number of matches: " + matches);
		infile.close();
	}
	
	/*
	 * Get the search term, converted to lower case.
	 */
	public static String getWord(Scanner console) {
		System.out.print("Enter search term: ");
		return console.nextLine().toLowerCase();
	}
	
	/*
	 * Print header.
	 */
	public static void printHeader () {
		System.out.println("Rank\tVotes\tRating\tTitle");
	}
	
	/*
	 * Search for the next line in the database that matches search term, 
	 * converted to lower case.
	 */
	public static String searchWord(Scanner infile, String searchTerm) {
		while (infile.hasNextLine()) {
			String line = infile.nextLine();
			if (line.toLowerCase().contains(searchTerm)) {
				return line;
			}
		}		
		return ""; // if no match
	}
	
	/*
	 * Display the matching line.
	 */
	public static void display (String line) {
		Scanner sc = new Scanner (line);
		int rank = sc.nextInt();
		double rating = sc.nextDouble();
		int votes = sc.nextInt();
		String title= "";
		while (sc.hasNext()) {
			title += sc.next() + " ";
		}
		System.out.println(rank + "\t" + votes + "\t" + rating + "\t" + title.trim());
	}
}