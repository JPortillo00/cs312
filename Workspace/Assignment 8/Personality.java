/**
 * @authors: Student 1: Virin Tamprateep
 *           Student 2:
 *           
 * CS312 Assignment 8.
 *
 *  On <MY|OUR> honor, Virin Tamprateep and <NAME2>, this programming assignment is <MY|OUR> own work
 *  and <I|WE> have not provided this code to any other student.
 *
 *
 * A program to process data from the Keirsey Temperament Sorter.
 *
 * Student 1: Virin Tamprateep
 * UTEID: vt4624
 * email address: v2tamprateep@verizon.net
 * Section 5 digit ID: 53550
 * Grader name: Lewis Fishgold
 * Number of slip days used on this assignment: 0
 *
 * Student 2:
 * UTEID:
 * email address:
 * Section 5 digit ID:
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Personality {
    // The main method to process the data from the peronality tests
    public static void main(String[] args) throws FileNotFoundException {
        //gets the input file
        Scanner keyboard = new Scanner (System.in);
        String file = getInFile(keyboard);
        Scanner inFileReader = new Scanner(new File (file));
        int noOfRecords = inFileReader.nextInt(); // scans in number of people in document
        inFileReader.nextLine();
        //analyzes data for however many people are on the document
        for (int i = 0; i < noOfRecords; i++){
            System.out.print(getName(inFileReader) + ":");
            int[] sortedData = analyzeData(inFileReader);
            interpretData(sortedData);
        }
        keyboard.close();
        inFileReader.close();
    }

    //method to get the name of the input file.
    public static String getInFile(Scanner keyboard) {
        System.out.print("Enter the name of the file with the personality data: ");
        String dataFile = keyboard.next();
        return dataFile;    
    }

    //grabs name from the input file
    public static String getName(Scanner inFileReader){
        String name = inFileReader.nextLine();
        int nameLength = name.length();
        //puts appropriate spaces in from for format
        for (int i = 0; i < 28 - nameLength; i++){
            name = " " + name;
        }
        return name;
    }

    //creates array that keeps count of A's and B's and updates
    public static int[] analyzeData(Scanner inFileReader){
        String data = inFileReader.nextLine();
        //format for array
        //{A for Q1, B for Q1, A for Q2-3, B for Q2-3, A for Q4-5, B for Q4-5, A for Q6-7, B for Q6-7}
        int[] abCount = {0, 0, 0, 0, 0, 0, 0, 0};
        int count = 0;
        while (count < 70){
            if (data.charAt(count) == 'A'){
                abCount[scaleCount(count)]++;
            } else if (data.charAt(count) == 'B'){
                abCount[scaleCount(count) + 1]++;
            } else{}
            count++;
        }
        return abCount;
    }

    //makes it so that the right element of the array is updated
    public static int scaleCount(int count){
        count = count%7;
        if (count%2 != 0){
            count++;
        }
        return count;
    }

    //prints personality statistics and result
    public static void interpretData(int[] sortedData){
        int[] percentB = calculateData(sortedData);
        for (int i = 0; i < 4; i++){
            if (percentB[i] != -1){
                System.out.printf("%11d", percentB[i]);
            } else System.out.print(" NO ANSWERS");
        }
        System.out.println(" = " + getPersonality(percentB));
    }

    //creates an array that stores 4 int for the percentages of B's for each of the 4 catagories
    public static int[] calculateData(int[] sortedData){
        int[] percentB = new int[4];
        for (int i = 0; i < 4; i++){
            if (sortedData[2*i] + sortedData[2*i + 1] != 0){
                percentB[i] = (int) Math.round(100*sortedData[2*i + 1]/(1.0*sortedData[2*i] + sortedData[2*i + 1])); //rounds percent
            } else {percentB[i] = -1;}
        }
        return percentB;
    }

    //takes in percentages and returns the 4 letter personality result
    public static String getPersonality(int[] percentB){
        String personality = "";
        String[] letterChoice = {"E", "I", "S", "N", "T", "F", "J", "P", "-"};

        for (int i = 0; i < 4; i++){
            if (percentB[i] > 0){
                if (percentB[i] < 50){
                    personality += letterChoice[2 * i];
                }else if (percentB[i] > 50){
                    personality += letterChoice[2 * i + 1];
                } else personality += "X";
            } else personality += letterChoice[8];
        }
        return personality;
    }
}