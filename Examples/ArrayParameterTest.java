//Shows the effect of declaring a new array in a method with the
//same name as the old one.

import java.util.*;

public class ArrayParameterTest
{
    public static void main (String[] args) {
        int [] a = {1, 2};          // Create a new array
        System.out.println("1: " + Arrays.toString(a)); 
        dbl1(a); // Call dbl1 : CHANGES input array -- first element doubled
        System.out.println("2: " + Arrays.toString(a));
        dbl2(a); // Call dbl2:  NO CHANGE to input array
        System.out.println("3: " + Arrays.toString(a));
        
    }
    /*
     * Doubles the first element of the input array
     */
    public static void dbl1 (int [] b) {
        b[0] *= 2;
    }
    
    /*
     * Creates a new array with the SAME NAME as the input array,
     * and thereby destroys the old reference to the input array within
     * the method. 
     */
    public static void dbl2 (int [] c) {
        System.out.println("in dbl2: " + Arrays.toString(c));
        c = new int[2]; // Create NEW array, with same pointer c.
        // c no longer refers to the array that was passed in to this method.
        c[0] = 3; c[1] = 4;
        c[0] *= 2;
        System.out.println("in dbl2: " + Arrays.toString(c));
        
    }
}
