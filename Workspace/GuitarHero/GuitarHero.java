/*
 * CS312 Assignment 12.
 * On my honor, Jairo Portillo, this programming assignment is my own work.
 * Section Number:
 *
 * A program to play 37 notes mimicking guitar string plucking.
 *
 *  Name: Jairo Portillo
 *  email address: portillo.jairojr@gmail.com
 *  UTEID:jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  No slip days are allowed on this assignment:
 */

import java.util.*;

public class  GuitarHero {
    //0-36 index;
    public static final char keyboard [] = new char [] {'q','2','w','e','4','r','5','t','y','7','u','8','i','9','o','p','-','[','=','z','x','d','c','f','v','g','b','n','j','m','k',',','.',';','/','\'',' '};
    public static final double freq [] = new double [37];
    public static final ArrayList <GuitarString> Guitar = new ArrayList <GuitarString> ();
    public static void main(String[] args) {
        Frequency(freq);
        guitarStrings(Guitar);        
        final double TEXT_POS_X = .5;
        final double TEXT_POS_Y = .5;

        StdDraw.text(TEXT_POS_X, TEXT_POS_Y + .05, "0200405007080900-0=00D0F0G00J0K0;0'000000");
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y + .00, "Q2WE4R5TY7U8I9OP-[=ZXDCFVGBNJMK,.;/'|spce|");
        //StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "..2......4");
        //StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "..2......4");

        play(Guitar);
    }

    public static void Frequency (double [] freq){
        for(int i = 0; i < keyboard.length; i++){
            freq[i] = 440.0 * Math.pow(1.05956,i-24);
        }
    }

    public static void guitarStrings(ArrayList <GuitarString> Guitar){
        for(int i = 0;i < freq.length;i++){
            Guitar.add(new GuitarString(freq[i]));    
        }
    }

    public static double Sample(){
        double sample = 0;
        for(int i = 0; i < keyboard.length;i++){
            sample += Guitar.get(i).sample();
        }        
        return sample;
    }
    
    public static void TIC(){
        double sample = 0;
        for(int i = 0; i < keyboard.length;i++){
            Guitar.get(i).tic();
        }        
            }
      
    private static void play(ArrayList <GuitarString> Guitar) {        // the main input loop
        while (true) {
            int k = 0;
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                int i = 0;
                boolean test = false;
                // the user types this character
                //char input = StdDraw.nextKeyTyped();
                char key = StdDraw.nextKeyTyped();
                while(test == false && i < keyboard.length){
                    if (key == keyboard[i])
                        test = true;
                    else
                        i++;
                }

                // pluck the corresponding string
                if (test) {
                    Guitar.get(i).pluck();
                    k=i;}
                /*else if (key == 'c') 
                stringC.pluck();*/
            }
            
            // compute the superposition of the samples
                double sample = Sample();

                // send the result to standard audio
                StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            TIC();
            //stringC.tic();
        }

    }

}