import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int[] a = {2, 3, 5, 1, 6, 9, 4};
		
		for (int i = 0; i < a.length-1; i ++) {
			int j = i+1;
			int tmp = a[j];
			while ((j > 0) && (a[j-1] > tmp)) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = tmp;
			System.out.println(Arrays.toString(a));
		}
	}

}