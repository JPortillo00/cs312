/**
 * CS312 Assignment 8
 * On my honor, Jairo Portillo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only charcaters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment: 0
 *
 * Number of slip days I am using:0
 */

import java.util.*;

public class Decrypt {

    public static void main(String[] arg)
    {
        String encryptedText = DecryptUtilities.convertFileToString();        
        // The other method from DecryptUtilities you will have to use is
        // DecryptUtilities.getDycryptionKey(int[]), but first you need to
        // do get an array with the frequency of all ASCII characters in the
        // encrypted text. Count ALL charcaters from ASCII code 0 to ASCII code 127
        char [] ascii = ASCII();
        int [] CharFreq = Frequencies (encryptedText, ascii);
        char [] key = DecryptUtilities.getDecryptionKey(CharFreq);
        System.out.println("The encrypted text is: \n");
        System.out.println(encryptedText);
        FreqCode(ascii,CharFreq,key);
        System.out.println();
        Decoding(encryptedText,key,ascii);
    }

    public static char [] ASCII (){
        char [] ascii = new char [128];
        for (int i = 0; i <= 127; i++){
            ascii[i] = (char) i ;}
        return ascii;
    }

    public static void Decoding(String Text, char [] key, char [] ascii){
        Scanner input = new Scanner(System.in);
        boolean chce = true;
        String decryptedText = "";
        do{        
            decryptedText = Decryption(Text,key,ascii);
            System.out.println("The current version of the decrypted text is:");
            System.out.println("\n" + decryptedText);
            System.out.println("Do you want to make a change to the key?");
            System.out.print("Enter 'Y' or 'y' to make change: ");
            String inpt = input.next();
            if(inpt.equalsIgnoreCase("y")){
                chce = true;
                key = inputChanges(decryptedText,ascii,key,input);
            }else{
                chce = false;
            }           
        }while(chce);
        Summary(decryptedText,key,ascii);
    }

    public static char [] inputChanges(String Text, char [] ascii, char [] key, Scanner input){
        System.out.print("Enter the character in the decrypted text you want to change: ");
        char chce = input.next().charAt(0);
        System.out.print("Enter the character you want to change '" + chce + "' to: ");
        char chnge = input.next().charAt(0);
        System.out.println("'" + chce + "' will be swapped with '" + chnge + "' in the decrypted file.");
        System.out.println();              
        for(int i = 0; i < 128; i++){
            if(key[i] == chce){ 
                key[i] = (char) chnge;
            }else if (key [i] == chnge){
                key[i] = chce;   
            }else{   
                key[i] = (char) key[i];
            }        
        }
        return key;
    }

    public static String Decryption (String Text, char [] key, char [] ascii){
        Scanner Encrypt = new Scanner(Text);
        String decrypt = "";
        while(Encrypt.hasNextLine()){
            String line = Encrypt.nextLine();            
            for(int j = 0; j < line.length(); j++){
                char X = line.charAt(j);
                for( int i = 32; i <= 126; i++){
                    char Y = ascii[i];
                    char Z = key [i];
                    if (X==Y){
                        decrypt += Z;                
                    }else{
                        decrypt += "";
                    }                   
                }        
            } 
            decrypt += "\n";
        }
        return decrypt;
    }

    public static int [] Frequencies (String Text, char [] ascii){
        Scanner Encrypt = new Scanner(Text);
        int freq [] = new int [128];              
        while(Encrypt.hasNextLine()){
            String line = Encrypt.nextLine(); 
            for( int i = 0; i <= 127; i++){
                char X = ascii[i];
                for(int j = 0; j < line.length(); j++){
                    char Y = line.charAt(j);
                    if (X == Y){
                        freq[i] += 1;
                    } else {
                        freq[i] += 0;
                    }
                }        
            }               
        }
        return freq;   
    }  

    public static void FreqCode (char [] ascii, int [] CharFreq, char [] key){
        System.out.println("Frequencies of characters.");
        System.out.println("Character - Frequency");
        for(int i = 32; i <= 126; i++)
            System.out.println(ascii[i] + " - " + CharFreq[i]);

        System.out.println("\nThe current version of the key for ASCII characters 32 to 126 is: ");
        for(int i = 32; i <= 126; i++)
            System.out.println("Encrypt character: " + ascii[i] + ", decrypt character: " + key[i]); 

    }   

    public static void Summary(String Text, char [] key, char [] ascii){
        System.out.println("\nThe current version of the key for ASCII characters 32 to 126 is: ");
        for(int i = 32; i <= 126; i++)
            System.out.println("Encrypt character: " + ascii[i] + ", decrypt character: " + key[i]);

        System.out.println("\nThe final version of the decrypted text is:");
        System.out.println("\n" + Text);            
    }
}