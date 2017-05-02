/*
 * Topic 16.  Booleans.
 * Author: VN
 */

public class BooleanTests
{
    public static void main (String [] args) {
    }
    
    public static boolean hasAnOddDigit (int n) {
        while (n > 0) {
            if ((n%2 == 1)) return true;
            else n /= 10;
        }
        return false;
    }
    
    public static boolean allDigitsOdd(int n) {
        while (n > 0) {
            if (n%2 == 0) return false;
            else n /= 10;
        }
        return true;
    }
    
    public static boolean isAllVowels(String a) {
        for (int i = 0; i < a.length(); i++ ) {
            // Run through the characters in the String.
            // If the current character is a, e, i, o OR u,
            // try the next character in the string.  If it is
            // neither a, nor e, nor i, nor o, nor u, return false.
            if (!(a.substring(i, i+1).equalsIgnoreCase("a") ||
                a.substring(i, i+1).equalsIgnoreCase("e") ||
                a.substring(i, i+1).equalsIgnoreCase("i") ||
                a.substring(i, i+1).equalsIgnoreCase("o") ||
                a.substring(i, i+1).equalsIgnoreCase("u") )){
                    return false;
            } 
        }
        return true;
    }   
    
    /*
     * This method has the same function as isAllVowels, but uses
     * DeMorgan's laws to write the logic differently.
     * If the current character in the String a is neither a, nor e,
     * nor i, nor o, nor u, then it is not a vowel.  Return false.
     */
    public static boolean isAllVowels2(String a) {
        for (int i = 0; i < a.length(); i++ ) {
            if ((!a.substring(i, i+1).equalsIgnoreCase("a") &&
                !a.substring(i, i+1).equalsIgnoreCase("e") &&
                !a.substring(i, i+1).equalsIgnoreCase("i") &&
                !a.substring(i, i+1).equalsIgnoreCase("o") &&
                !a.substring(i, i+1).equalsIgnoreCase("u") )){
                    return false;
            } 
        }
        return true;        
    }
    
}