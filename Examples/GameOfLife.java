import java.awt.*;

public class GameOfLife {
	public static final int H = 500, W = 500;
	
	public static void main (String [] args) {
		
		DrawingPanel panel = new DrawingPanel(W, H);
		Graphics g = panel.getGraphics();
		
		boolean [][] oscillator = new boolean[7][7];
		oscillator[3][1] = true;
		oscillator[3][2] = true;
		oscillator[3][3] = true;
		
		printPalet(oscillator);
		for (int i = 0; i < 4; i++) {			
			nextGen(oscillator);
			printPalet(oscillator);
			draw(oscillator, g, 20, 20);
			panel.sleep(500);
			
		}		
		
        /*
         * A glider, that slowly moves out of the screen.
         */
        boolean [][] glider = new boolean [50][50] ;
        glider[4][4] = true;
        glider[4][5] = true;
        glider[4][6] = true;
        glider[3][6] = true;
        glider[2][5] = true;
        //printArray(glider);
        draw (glider, g, 20, 20);
        for (int noGens = 0; noGens < 50; noGens++) {
            nextGen(glider);
            //printArray(glider);
            panel.sleep(200);
            draw(glider, g, 10, 10);
        }
    }

	public static int getNeighbors(boolean [][] p, int row, int col) {	
		int neighbors = 0;
		
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				boolean valid = ((r!=0) || (c!=0)) && isInside(p, row+r, col+c);
				if (valid) {
					if (p[row+r][col+c]) neighbors++;
				}
			}
		}
		return neighbors;		
	}
	
	public static boolean isInside(boolean[][] p, int r, int c) {
		boolean inside = !((r > p.length-1) || (r < 0));
		inside &= !((c > p.length-1) || (c < 0));
		return inside;		
	}
	
	public static void nextGen(boolean[][] p) {
		int nArray[][] = new int[p.length][p[0].length];
		
		for (int row = 0; row < p.length; row++) {
			for (int col = 0; col < p[0].length; col++) {
				nArray[row][col] = getNeighbors(p, row, col);
			}
		}
		
		for (int r=0; r < p.length; r++) {
			for (int c=0; c < p[0].length; c++) {
				int n = nArray[r][c];
				if (n == 3) p[r][c] = true;
				if ((n < 2) || (n > 3)) p[r][c] = false;
			}
		}		
	}
	
	public static void printPalet (boolean[][] p) {
		for (boolean[] row: p) {
			for (boolean cell:row) {
				if (cell) System.out.print("*");
				else System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}		
	
	public static void displayN (int[][] p) {
		for (int[] row: p) {
			for (int cell:row) {
				System.out.print(cell);
			}
			System.out.println();
		}
		System.out.println();
	}	

    /*
     * Use drawing panel to draw the current state of the game.  The picture starts
     * at the specified offset on the Panel.
     */

    public static void draw (boolean palet [][], Graphics pen, int xOffset , int yOffset) {
        int step = 20;
        pen.setColor(Color.WHITE);
        pen.fillRect(0,  0,  W,  H);
                
        for (int yStep = 0; yStep < palet.length; yStep ++ ) {  // Y direction step
            for (int xStep = 0; xStep < palet[0].length; xStep ++ ) { // X direction step
            	pen.setColor(Color.LIGHT_GRAY);
                pen.drawRect(xOffset+xStep*step, yOffset+yStep*step, step, step);
                if (palet[yStep][xStep]) {
                    pen.setColor(Color.BLACK);
                    pen.fillRect(xOffset+xStep*step, yOffset+yStep*step, step, step);
                }
            }
        }
    }
}