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
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:
 */
import java.util.Scanner;
public class RockPaperScissors {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static void main(String[] args) {
        Scanner player = new Scanner(System.in);
        String name = Name(player);
        int rnds = NoRounds(player,name);
        Game(player,rnds,name);
    }
    //Name ask for players name and returns input
    public static String Name (Scanner play){
        System.out.println("Welcome to Rock, Paper, Scissors. I, The Computer, will be you \nopponent.");
        System.out.print("Please type in your name and press return: ");
        return play.nextLine();
    }   
      // NoRounds asks for the number of rounds the player desires to play
    public static int NoRounds (Scanner play, String name){
        System.out.println("Welcome " + name+ ".");
        System.out.println("All right " + name + ". " + "How many rounds would you like \nto play?");
        System.out.print("Enter the number of rounds you want to play and press \nreturn: ");
        return play.nextInt();
    }
    //Game method plys through all the rounds; computes sum of wins, losses, draw; and outputs results of each round and over all match.  
    public static void Game (Scanner playIn,int r,String n){
        int wins = 0, losses = 0, draws = 0;
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

            wins = Win(plyrChce,cpuOpt,wins);
            losses = Lose(plyrChce,cpuOpt,losses);
            draws = Draw(plyrChce,cpuOpt,draws);
        }
        System.out.println();
        MatchResults(n,r,wins,losses,draws);
    }

    /*The Methods ComputerChoice and PlayerChoice are used 
     * so the program may print out the correct expression after both have mad a choice. ie. 1 prints Rock etc.
     */
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

    public static void MatchOutcomes(int plyr, int comp){ 
        /*This method producs the outcome statements 
         * dependent on the computer's and player's choice*/
        if ( plyr == comp){
            System.out.println();
            System.out.println("This round is a draw");
            System.out.println();
        }else if (comp == ROCK && plyr == PAPER){
            System.out.println();
            System.out.println("Paper covers rock. You win.");
            System.out.println();
        }else if (comp == ROCK && plyr == SCISSORS){
            System.out.println();
            System.out.println("Rock breaks scissors. I win.");
            System.out.println();
        }else if (comp == PAPER && plyr == SCISSORS){
            System.out.println();
            System.out.println("Scissors cut paper. You win.");
            System.out.println();
        }else if (comp == PAPER && plyr == ROCK){
            System.out.println();
            System.out.println("Paper covers rock. I win.");
            System.out.println();
        }else if (comp == SCISSORS && plyr == ROCK ){
            System.out.println();
            System.out.println("Rock break scissors. You win.");
            System.out.println();
        }else if (comp == SCISSORS && plyr == PAPER ){
            System.out.println();
            System.out.println("Scissors cut paper. I win.");
            System.out.println();
        }
    }

    /*The following methods: Win, Lose, Draw are methods that sum up the outcomes of the games.
    The Method Win records the number of times the player has won.
    The Method Lose records the number of times the player has loss or in other owrds the computer has won.
    The method Draw records the number of time the computer and player have tied in a round.*/
    public static int Win( int ply, int com, int w){
        if (com == ROCK && ply == PAPER){
            return w + 1;
        } else if (com == PAPER && ply == SCISSORS){
            return w + 1;
        }else if (com == SCISSORS && ply == ROCK ){
            return w + 1;
        } else{
            return w;}
    }

    public static int Lose( int ply, int com, int l){
        if (com == ROCK && ply == SCISSORS){
            return l + 1;
        }else if (com == PAPER && ply == ROCK){
            return l + 1;
        }else if (com == SCISSORS && ply == PAPER ){
            return l + 1;
        }else {
            return l;
        }
    }

    public static int Draw( int ply, int com, int d){
        if ( ply == com){
            return d + 1;
        } else {
            return d;}
        }
    // The following method prints out the Match Summary of the game.
    public static void MatchResults(String Name, int Rounds, int WINS, int LOSE, int DRAWS){
        System.out.println("Number of games of Rock, Paper, Scissors: " + Rounds);
        System.out.println("Number of times Computer won: " + LOSE);
        System.out.println("Number of times " + Name + " won: " + WINS);
        System.out.println("Number of draws: " + DRAWS);
        if ( WINS > LOSE){
            System.out.println("You are a master at Rock, Paper, Scissors.");
        } else if (LOSE > WINS){
            System.out.println("I, Computer, am a master at Rock, Paper, Scissors");
        }else if (WINS == LOSE){
            System.out.println("We are evenly matched at this game.");
        }
    }
}