import java.util.*;

public class MatrixMultiply {
	public static void main (String [] args) {
		int [][] x1 = {{1, 2, 3}};
		int [][] y1 = {{3}, {2}, {1}};
		int [][] product;
		product = multiply (x1, y1);
		System.out.println(Arrays.deepToString(product));
		
		int [][] x2 = {{1, 2}, {2, 3}, {4, 5}};
		int [][] y2 = {{7, 8, 9, 0}, {-1, 3, 4, 1}};
		product = multiply (x2, y2);
		System.out.println(Arrays.deepToString(product));
		
		int [][] x3 = {{1, 2}};
		int [][] y3 = {{7, 8, 9}};
		product = multiply (x3, y3);
		System.out.println(Arrays.deepToString(product));
	}

	public static int [][] multiply (int [][] a, int [][] b) {
		int aRows = a.length;
		int aCols = a[0].length;
		int bRows = b.length;
		int bCols = b[0].length;
		int [][] product;

		if (aCols != bRows) {
			System.out.println("\nERROR: Cannot multiply a and b.");
			return new int [0][0];
		}
		product = new int [aRows][bCols];
		for (int row = 0; row < aRows; row++) {
			for (int col = 0; col < bCols; col++) {
				product[row][col] = multiply1rx1c(a, b, row, col);
			}
		}
		return product;
	}
	
	public static int multiply1rx1c (int [][] A, int [][] B, int rowA, int colB) {
		int sum = 0;
		for (int i = 0; i < A[rowA].length; i ++ ) {
			sum += A[rowA][i]*B[i][colB];
		}
		return sum;
	}
}