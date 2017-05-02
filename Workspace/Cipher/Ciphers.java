/**
 * @author  Jairo Portillo
 * @version 02/28/14
 * CS312 Assignment 5.
 *
 * On my honor, Jairo Portillo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to encrypt and decrypt phrases using
 * a columnar transposition cipher.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment: 1
 */
import java.util.Scanner;
public class Ciphers {
    public static final int MAX_ROWS = 6;
    // main method to demonstrate various encrytpions and
    // decryptions using a columnar transposition cipher
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        showIntro();
        doEncryptions(keyboard);
        doDecryptions(keyboard);
        showTests();
        keyboard.close();
    }

    // show the introduction to the program
    public static void showIntro() {
        System.out.println("This program demonstrates a transposition cipher.");
        System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
        System.out.println();
        System.out.println("This program will demonstrate encrypting a message with");
        System.out.println("a columnar transposition cipher, both with and without");
        System.out.println("padding characters. The program will then decrypt a message");
        System.out.println("assuming it was encrypted with a columnar transposition cipher");
        System.out.println("with padding.\n");
    }   
    //encryptNoPad is a method that encrpyts the message without padding
    public static void encryptNoPad(String encrypt, int rows){//This method encrypts without pad
        System.out.println("Message encrypted with columnar transposition cipher and no padding.");
        for( int i = 2; i <= rows  ; i++){
            System.out.println("Encrypted with " + i + " rows: " + encryptMessage(encrypt,i));
        }
    }
    //encryptPad is a method that encrypts the message with padding whether or not it is needed
    public static void encryptPad(String encrypt, int rows){//This method encrypts with padding
        System.out.println("\nMessage encrypted with columnar transposition cipher and padding");
        for(int i = 2; i <= rows ; i++){
            String origin = encrypt;
            if (origin.length()%i != 0){
                do{
                    origin += "X";
                }    
                while(origin.length()%i != 0);
                System.out.println("\nClear text padded for " + i + " rows: " + origin);
                System.out.println("Encrypted with " + i + " rows: " + encryptMessage(origin,i));
            } else if (origin.length()%i == 0) {
                System.out.println("\nClear text padded for " + i + " rows: " + origin);
                System.out.println("Encrypted with " + i + " rows: " + encryptMessage(origin,i));
            }
        }
    }
    //This method is the main method that does the encryption 
    public static String encryptMessage(String message, int row){
        String ans = "";
        for(int j = 0; j + 1 <= row;j++){
            int Coor = 0;
            while ( Coor  <= message.length()-1 - j){
                ans += message.charAt(Coor + j);
                Coor += row;}
        }      
        return ans;
    }
    //This method does the actual encryption when nessecary
    public static void doEncryptions(Scanner keyboard) {
        System.out.println("\nA demonstration of encrypting with a columnar transposition cipher: ");
        System.out.print("Enter the message to encrypt: ");
        String input = keyboard.nextLine();
        System.out.println();
        encryptNoPad(input,MAX_ROWS);
        encryptPad(input,MAX_ROWS);
    }
    //This method determine whether an incrption needs to be padded or not to be decrpted
    public static void doDecrypt(String code, int rows){
        System.out.println("Message Decrypted with a Columnar Transposition Cipher");
        for(int i = 2; i <= rows; i++){
            String origin = code;
            System.out.println();
            if(origin.length()%i != 0){
                do{
                    origin += "X";
                }while(origin.length()%i != 0);
                System.out.println("Decrypted text padded for " + i + " rows: " + origin); 
                System.out.println("Decrypted with " + i + " rows: " + decryptMessage(origin,i));    
            }else{
                System.out.println("Decrypted text padded for " + i + " rows: " + origin); 
                System.out.println("Decrypted with " + i + " rows: " + decryptMessage(origin,i));
            }     
        }
    }
    //This method has the central code that decrypts the the message
    public static String decryptMessage(String code, int rows){
        String ans = "";
        for(int i = rows; i <= rows; i++){
            ans = "";
            int numCols = (code.length() / rows) + Math.min(1, code.length() % rows);
            for(int j = 0; j <= numCols  - 1 ; j++){
                for(int k = 0; k  <= rows - 1;k++){
                    ans += code.charAt( j + k*numCols); 
                }
            }            
        }
        return ans;
    }
    //This method does the decryptions 
    public static void doDecryptions(Scanner keyboard) {
        System.out.println();
        System.out.println("A demonstration of decrpting with a columnar transposition cipher:");
        System.out.println("If th length of the message is not a multiple of the number of rows \nit will be padded, which may throw off the decryption");
        System.out.print("\nEnter the message to decrypt: ");
        String input = keyboard.nextLine();
        System.out.println();
        doDecrypt(input,MAX_ROWS);
    }

    public static void showTests() {
        System.out.println();
        System.out.println("This displays automatic tests of the program: ");

        String encryptedMessage = "AEIBFJCGXDHX"; // this was encrypted with 4 rows.
        String expected = "ABCDEFGHIJXX";        
        decryptTest(encryptedMessage, expected, 4, 1);

        encryptedMessage = "CPEOURMT!"; // this was encrypted with 3 rows.
        expected = "COMPUTER!";
        decryptTest(encryptedMessage, expected, 3, 2);

        encryptedMessage = "JLN!eoe!svrXuedXsssX__!X"; // this was encrypted with 6 rows.
        expected = "Jesus_Loves_Nerds!!!XXXX";
        decryptTest(encryptedMessage, expected, 6, 3);

        encryptedMessage = "Ies__iLPcohsvy!"; // this was encrypted with 3 rows.
        expected = "I_Love_Physics!";
        decryptTest(encryptedMessage, expected, 5, 4);

        String clearMessage = "Dell_CS_HallXXX";
        expected = "DCleSll_XlHX_aX";
        encryptTest(clearMessage, expected, 5, 1);

        clearMessage = "Texas_LonghornsX";
        expected = "Tsnre_gnxLhsaooX";
        encryptTest(clearMessage, expected, 4, 2);

        clearMessage = "Obama_is_coming_to_UT!XX";
        expected = "Omici__!basontUXa__mgoTX";
        encryptTest(clearMessage, expected, 3, 3);

        clearMessage = "Richard_FeynmanX";
        expected = "RcadFymnihr_enaX";
        encryptTest(clearMessage, expected, 2, 4);
    }
    //Decrypt test
    public static void decryptTest(String encryptedMessage,
    String expected, int rows, int testNumber) {
        System.out.println();
        String actual = decryptMessage(encryptedMessage, rows);
        System.out.println("expected: " + expected + ", actual: " + actual);
        if(expected.equals(actual))
            System.out.println("passed decrypt test" + testNumber);
        else
            System.out.println("FAILED DECRYPT TEST " + testNumber);
    }
    //encrypt test
    public static void encryptTest(String clearMessage,
    String expected, int rows, int testNumber) {
        System.out.println();
        String actual = encryptMessage(clearMessage, rows);
        System.out.println("expected: " + expected + ", actual: " + actual);
        if(expected.equals(actual))
            System.out.println("passed encrypt test" + testNumber);
        else
            System.out.println("FAILED ENCRYPT TEST " + testNumber);
    }
}