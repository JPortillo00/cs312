import java.io.*;
import java.util.*;

/*
 * CS312 Assignment 7.
 * On my honor, Jairo Portillo, this programming assignment is my own work.
 * Section Number:
 *
 * A program to do simple word processing and a spell-check feature.
 *
 *  Name: Jairo Portillo
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID:53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment: 2
 */

// Add import statements here.

public class WordProcessor{
    public static void main(String [] args)throws FileNotFoundException{
        System.out.println("Enter name of file to be processed, including the .txt extension: ");
        Scanner input = new Scanner (System.in);
        String fileName = input.nextLine();
        Scanner file = new Scanner (new File(fileName));
        PrintStream out = new PrintStream (new File(fileName.replace(".txt","_OUT.txt")));
        int columns = NumberofColumns(file,out);
        Scanner Lines = new Scanner(Alignment(file));
        ColumnAdjust(file,columns,Capitalization(Lines),out);
        input.close();
        file.close();
        Lines.close();
    }

    public static int NumberofColumns(Scanner file, PrintStream out){ // This method prints put the rows that count the columns
        int col = file.nextInt();
        if( 5 <= col && col <= 80){
            System.out.println("The maximum output file length is CORRECT.");
        }
        else{
            System.out.println("The maximum output file length is INCORRECT!!!");
        }
        for (int i = 1; i <= col;i++)//tens place row
            out.print(i/10);
        out.println();
        for (int i = 1; i <= col;i++)//ones place row
            out.print(i%10);
        out.println();
        for (int i = 1; i <= col;i++)
            out.print("-");
        out.println();
        return col;
    }   

    public static String Alignment (Scanner file){// This method puts all the word tokens of the file into a single line
        String Line = "";
        while (file.hasNextLine()){
            while(file.hasNext()){
                if(file.hasNext()){
                    Line += file.next() + " ";
                }else {
                    Line += "";
                }
            }
        }
        return Line;
    }

    public static void ColumnAdjust ( Scanner file, int columns, Scanner align, PrintStream out){
        //The file is "written" in a manner where the number of characters in rows does not exceed the number of columns
        String line = "";
        while (align.hasNext()){
            String tkn = align.next();
            if (line.length() + tkn.length() > columns ){
                out.println(line);               
                line = tkn + " ";
            } else if(line.length() <= columns){
                line += tkn + " ";       
            }   

        }
        out.println(line);
    }

    public static Scanner Capitalization(Scanner line){
        /*This Method capitalizes the First word of the file and any others that
           follow periods, exclimation marks, or question marks*/      
        String FirsTkn = line.next();
        String IniLet = FirsTkn.substring(0,1);
        String NewIni = IniLet.toUpperCase();
        String Line = FirsTkn.replace(IniLet,NewIni) + " ";
        while(line.hasNext()){            
            String tkn1 = line.next(); 
            if(tkn1.endsWith(".") || tkn1.endsWith("!") || tkn1.endsWith("?")){
                if(line.hasNext()){
                    String tkn2 = line.next();
                    String a = tkn2.substring(0,1);
                    String b = a.toUpperCase();
                    Line += tkn1 + " " + tkn2.replace(a,b) + " "; 
                }else{
                    Line += tkn1;
                }
            }
            else{
                Line += tkn1 + " " ;
            }
        }
        return new Scanner (Line);
    }
}
