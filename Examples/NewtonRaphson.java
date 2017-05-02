
/**
 * Write a description of class m here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// This program uses the Newton Raphson approximation technique
// to find the square root of a number.
public class NewtonRaphson {
    public static void main (String[] args) {
        double root;
        double number = 12; 
        System.out.println("Finding square root of " + number);

        root = number / 2; // first approximation of the square root
        int iterations = 6; // number of times we repeat the operation 
                            // to get closer and closer to the real root.
        for (int i = 0; i < iterations; i ++ ) { 
            root = (number/root + root) / 2;
            System.out.println(root*root); // This number will get closer
                                            // and closer to the original 
                                            // number (12).
        }   
        System.out.println(root);

    }   
}