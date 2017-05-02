public class BinarySearch {

	public static void main(String[] args) {
		int [] a = {1, 3, 5, 7, 9, 11};
		int b = 7;
		int lo = 0, hi = a.length-1;
		int found = -1;
		// Keep searching until found or not found is determined.
		do {
			found = search(a, lo, hi, b);
			if (found == -2) lo = (lo + hi)/2 + 1;  	// search upper half now
			if (found == -3) hi = (lo + hi)/2 - 1;	// search lower half now
		} while (found == -2 || found == -3);
		System.out.println(found);
	}
	
	// Search sub array of b for val, between lo and hi indices.
	public static int search (int [] b, int lo, int hi, int val) {
		if (lo > hi) return -1;			// Not found.
		int mid = (lo + hi)/2;
		
		if (val == b[mid]) return mid;  // found!!!
		if (val > b[mid]) return -2;		// may be in upper half of array	
		return -3;						// may be in lower half of array
	}
}