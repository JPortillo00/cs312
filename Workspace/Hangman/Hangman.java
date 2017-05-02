/**
 * @author  Jairo Portillo
 * @version 03/06/14
 * CS312 Assignment 6.
 *
 * On my honor, Jairo Portillo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play Hangman
 * against the computer.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment: 0
 */

import java.util.Scanner;

public class Hangman {
    public static final String Alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
    public static final int NumGuess = 5;

    public static void main(String[] args) {
        intro();
        PhraseBank phrases = new PhraseBank();
        Scanner keyboard = new Scanner(System.in);
        boolean YES = true;

        while(YES){
            playGame(keyboard,phrases);//Runs through the game.
            YES = playAgain(keyboard);//Checks if player wants to play again.
        }
        }
    // show the intro to the program
    public static void intro() {
        System.out.println("This program plays the game of hangman.");
        System.out.println("When the window opens select the file");
        System.out.println("with the phrases you want to use.\n");
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter capital letters as your guesses.");
        System.out.println("After " + NumGuess + " wrong guesses you lose.");
    }
    //method that contains the game.
    public static void playGame(Scanner input,PhraseBank phrases){
        int wrngGuess = 0;
        String alpha = Alphabet;
        String guess = " ";
        System.out.println("I am thinking of a " + phrases.getTopic() + " ... \n");
        String Phrse = phrases.getNextPhrase();//contains the actual phrase
        String HddnPhrse = HidePhrase(Phrse,guess,alpha);//Hides phrase.        
        while (check(wrngGuess,HddnPhrse,Phrse)){
            guess = playerGuesses(input,HddnPhrse,alpha);
            HddnPhrse = phraseReveal(guess, Phrse, HddnPhrse, alpha);//Stores the Hidden phrase as it begins to reveal guessed letters.
            wrngGuess += checkGuess(guess,Phrse,alpha,wrngGuess);//Checks guess to make sure it is valid, correct, etc.
            alpha = alphabetRplce(guess,alpha); //Store the alphabet after it has been changed due to a guess
        }
        EndSummary(wrngGuess,HddnPhrse,Phrse);
    }
    //checks conditions to make sure if game should continue
    public static boolean check (int wrngGuess, String HddnPhrse, String Phrse){
        if(wrngGuess == NumGuess || HddnPhrse.equalsIgnoreCase(Phrse)){
            return false;
        }else if (wrngGuess < NumGuess) {
            return true;
        }
        return false;
    }
    //This method asks and stores the guess that is inputed
    public static String playerGuesses(Scanner plyr, String hddn, String alpha){
        System.out.println("The current phrase is " + hddn);
        System.out.println("The letters you have not guessed yet are: ");
        System.out.println(alpha);
        System.out.print("Enter your next guess: ");
        String guess = plyr.next();
        guess = guess.toUpperCase();
        System.out.println();
        return guess;
    }
    //Checks guess in order to see if it is valid and prints the corresponding statments.
    public static int checkGuess( String guess, String phrase, String alpha, int wrngGuess){
        if (phrase.contains(guess) && alpha.contains(guess) ){
            System.out.println("You guessed " + guess +".");
            System.out.println("That is present in the secret phrase.");
            if (wrngGuess == 1) {
                System.out.println("You have made " + wrngGuess + " wrong guess.\n");
            }else{
                System.out.println("You have made " + wrngGuess + " wrong guesses.\n");
            }
            return 0;
        } else if ( !phrase.contains(guess) && alpha.contains(guess)){
            System.out.println("You guessed " + guess +".");
            System.out.println("That is not present in the secret phrase.");
            if (wrngGuess == 1) {
                wrngGuess++;
                System.out.println("You have made " + wrngGuess + " wrong guess.\n");
            }else{
                wrngGuess++;
                System.out.println("You have made " + wrngGuess + " wrong guesses.\n");
            }
            return 1;
        } else if (!alpha.contains(guess)){
            System.out.println(guess +" not a valid guess.");
            return 0;
        } 
        return 0;
    }
    //Removes letters that are guessed for the presented alphabet
    public static String alphabetRplce(String guess, String alpha){
        if (alpha.contains(guess)){
            return alpha.replace(guess + " ","");
        } else {
            return alpha;}
    }
    //Hides th phrase leaving * and _
    public static String HidePhrase(String phrse, String guess, String alpha){
        int lngth = phrse.length();
        String hddn = "";
        for( int i = 0; i < lngth ; i++){
            if (phrse.charAt(i) == '_'){
                hddn += "_";        
            }else {
                hddn += "*";
            }
        }
        return hddn;
    }
    //Reveals the letters that are guessed correctly concealling the unknown letters
    public static String phraseReveal( String guess, String phrse, String hddn, String alpha){
        int lngth = phrse.length();
        while(phrse.contains(guess)){
            int chce = phrse.indexOf(guess);
            if( chce < lngth){
                phrse = phrse.substring(0,chce) + "*" + phrse.substring(chce + 1);
                hddn = hddn.substring(0,chce) + guess + hddn.substring(chce + 1);
            } else {
                phrse = phrse.substring(0,chce) + "*";
                hddn = hddn.substring(0,chce - 1) + guess;
            }    
        }
        return hddn;
    }
    //Asks the player if they desire to play again
    public static boolean playAgain(Scanner input){
        System.out.println("\nDO you want to play again?");
        System.out.print("Enter 'Y' or 'y' to play again: ");
        String yes = input.next();
        if (yes.equalsIgnoreCase("y")){
            return true;
        } else {
            return false;
        }
    }   
    //Prints results of game after a final result is declared.
    public static void EndSummary( int wrngGuess, String HddnPhrse,String Phrse){
        if (HddnPhrse.equalsIgnoreCase(Phrse)){
            System.out.println("The phrase is " + Phrse + ".");
            System.out.println("YOU WIN!!!!");    
        } else if ( wrngGuess == NumGuess){
            System.out.println("You lose. The secret phrase was " + Phrse + ".");
        }
    }
}
