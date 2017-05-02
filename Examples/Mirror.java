
/**
 * Write a description of class m here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mirror {
    
    public static final int SIZE = 3;

    public static void main (String [] args) {
        edge();
        topHalf();
        bottomHalf();
        edge();
    }

    public static void edge () {
        int width = 4*SIZE;
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.print("+");
        System.out.println();
    }

    /*
       Top Half of the Mirror
    */
    public static void topHalf() {
        int noOfLines = SIZE;

        // one loop iteration for each line
        for (int line = 1; line <= noOfLines; line++) { 
            System.out.print("|");

            // print spaces
            int noOfSpaces = (SIZE - line)*2;
            for (int j = noOfSpaces; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("<>");

            //print dots
            int noOfDots = 4*line - 4;
            for (int k = noOfDots; k > 0; k--) {
                System.out.print(".");
            }
            System.out.print("<>");

            // print spaces
            for (int j = noOfSpaces; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    // bottomHalf same as topHalf, but indexing of outer loop (with variable line) changed.
    public static void bottomHalf() {
        int noOfLines = SIZE;

        // one loop iteration for each line
        for (int line = noOfLines; line > 0; line--) { 
            System.out.print("|");

            // print spaces
            int noOfSpaces = (SIZE - line)*2;
            for (int j = noOfSpaces; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("<>");

            //print dots
            int noOfDots = 4*line - 4;
            for (int k = noOfDots; k > 0; k--) {
                System.out.print(".");
            }
            System.out.print("<>");

            // print spaces
            for (int j = noOfSpaces; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
