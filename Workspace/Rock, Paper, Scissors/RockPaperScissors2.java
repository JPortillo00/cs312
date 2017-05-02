/**
 * @author  Jairo Portillo
 * @version 02/21/2014
 * CS312 Assignment 4.
 *
 * On my honor, Jairo Portillo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play rock - paper - scissors
 * against the computer.
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID:
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:
 */
import java.util.Scanner;
public class RockPaperScissors2 {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static void main(String[] args) {
        Scanner player = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors. I, The Computer, will be you \nopponent.");
        System.out.print("Please type in your name and press return: ");
        String name = player.nextLine();
        System.out.println("Welcome " + name+ ".");
        System.out.println("All right " + name + ". " + "How many rounds would you like \nto play?");
        System.out.print("Enter the number of rounds you want to play and press \nreturn: ");
        int rnds = player.nextInt();
        Game(player,rnds,name);
        System.out.println();

    }

    public static void Game (Scanner playIn,int r,String n){
        for (int i = 1; i<=r;i++){
            RandomPlayer cpu = new RandomPlayer();
            int cpuOpt = cpu.play();
            System.out.println();
            System.out.println("Round "+ i+ ".");
            System.out.println( n + ", please enter your choice for this round.");
            System.out.print(" 1 for rock, 2 for paper, and 3 for scissors: ");
            int plyrChce = playIn.nextInt();
            System.out.println("Computer picked " + ComputerChoice(cpuOpt) + ", " + n + " picked " + PlayerChoice(plyrChce) + ".");
            MatchOutcomes(plyrChce,cpuOpt);
        }

    }

    public static void MatchOutcomes(int plyr, int comp){
        if ( plyr == comp){
            System.out.println();
            System.out.println("This round is a draw");
            System.out.println();
        }else if (comp == ROCK && plyr == PAPER){
            System.out.println();
            System.out.println("Paper covers rock. You win.");
            System.out.println();
            //Rock(plyr,wins,loses);
        }else if (comp == ROCK && plyr == SCISSORS){
            System.out.println();
            System.out.println("Rock breaks scissors. I win.");
            System.out.println();
        }else if (comp == PAPER && plyr == SCISSORS){
            System.out.println();
            System.out.println("Scissors cut paper. You win.");
            System.out.println();
            //Paper(plyr,wins,loses);
        }else if (comp == PAPER && plyr == ROCK){
            System.out.println();
            System.out.println("Paper covers rock. I win.");
            System.out.println();
        }else if (comp == SCISSORS && plyr == ROCK ){
            System.out.println();
            System.out.println("Rock break scissors. You win.");
            System.out.println();
            //Scissor(plyr,wins,loses);
        }else if (comp == SCISSORS && plyr == PAPER ){
            System.out.println();
            System.out.println("Scissors cut paper. I win.");
            System.out.println();
            }
    }

    public static int Rock(int q,int w, int l){
    if ( q == PAPER){
    System.out.println();
    System.out.println("Paper covers rock. You win.");
    System.out.println();
    return w = w + 1 ;
    }else if ( q == SCISSORS){
    System.out.println();
    System.out.println("Rock breaks scissors. I win.");
    System.out.println();
    return l = l + 1;

    }
    return 0;
    }

    public static int Paper(int s, int w, int l){
    if ( s == SCISSORS){
    System.out.println();
    System.out.println("Scissors cut paper. You win.");
    System.out.println();
    return w = w + 1;
    }else if ( s == ROCK){
    System.out.println();
    System.out.println("Paper covers rock. I win.");
    System.out.println();
    return l = l + 1;
    }
    return 0;
    }

    public static int Scissor(int t, int w, int l){
    if ( t == ROCK){
    System.out.println();
    System.out.println("Rock break scissors. You win.");
    System.out.println();
    return w = w + 1;
    }else if ( t == PAPER){
    System.out.println();
    System.out.println("Scissors cut paper. I win.");
    System.out.println();
    return l = l + 1;
    }
    return 0;
    }

    public static String ComputerChoice(int compChce){

        if (compChce == ROCK){
            String a = "rock";
            return a;
        } else if (compChce == PAPER){
            String b = "paper";
            return b;
        } else {
            String c = "scissors";
            return c;
        }    
    }

    public static String PlayerChoice(int plyrC){
        if (plyrC == ROCK){
            String x = "rock";
            return x;
        } else if (plyrC == PAPER){
            String y = "paper";
            return y;
        } else {
            String z = "scissors";
            return z;
        }    
    }
}