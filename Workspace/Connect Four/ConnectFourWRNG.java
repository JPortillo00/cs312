/*
 * CS312 Assignment 10
 * A program to play connect four.
 *
 * On my honor this program is my own work:
 * <Jairo Portillo>
 *
 *  email address: portillo.jairojr@gmail.com
 *  UTEID: jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:2
 *
 * Number of slip days I am using: 2
 */

import java.util.*;

public class ConnectFourWRNG
{
    public static final int [] COLUMNS = new int [] {1,2,3,4,5,6,7}; // change the amount of integers in the array makes the game larger
    public static final int CONNECT = 4 - 1; // CONNECT allows to change if more than four want to be connected 
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Player 1 enter your name: ");
        String plyr1 = input.nextLine();
        String p1 = "r";
        System.out.print("Player 2 enter your name:");
        String plyr2 = input.nextLine();
        String p2 = "b";
        String [][] board = Board();//6x7 array        
        currentBoard(board);
        boolean test = false;
        boolean turn = true;
        while(test == false){
            if( turn ){
                board = Game(input,board,plyr1,p1,p2);
                test = drawGame(board,p1,p2);
                test = winChck(board,p1,p2,plyr1);
                currentBoard(board);
                turn = false;
            }else{
                board = Game(input,board,plyr2,p2,p1);
                test = drawGame(board,p1,p2);
                test = winChck(board,p2,p1,plyr2);
                currentBoard(board);
                turn = true;
            }
            //Game(input,board,plyr2,p2,p1);
        }
    }

    //Tells which players turn it is and prompts for input
    public static String [][] Game(Scanner input, String board [][], String plyr, String pce1, String pce2){
        System.out.println("\n" + plyr + " it is your turn.");
        System.out.println("Your pieces are the " + pce1 + "'s.");
        System.out.print(plyr + ", enter the column to drop your checker: ");
        String inpt = input.nextLine();
        inpt = alphaChck(input,inpt,plyr);
        return boardChck(input,board,inpt,pce1,pce2,plyr);        
    }

    //Checks if a columns is full, if the value enter is within range, and prompts the user for new input
    public static String [][] boardChck(Scanner input, String board [][], String inpt, String pce1, String pce2, String plyr){
        Scanner line = new Scanner (inpt);
        int i = board.length - 1;
        boolean test = true;
        int in = line.nextInt() - 1;
        while( i>=0 && test ){
            if( in < 0 || in >= COLUMNS.length){
                System.out.println((in + 1) + " is not a valid column.");
                inpt = input.nextLine(); 
                inpt = alphaChck(input,inpt,plyr);
                line = new Scanner (inpt);
                in = line.nextInt() - 1;
                i = board.length-1;
            }else if(board[i][in].equals(".")){
                board[i][in] = pce1;
                test = false;
                i--;
            }else if (board[0][in].equalsIgnoreCase(pce1) || board[0][in].equalsIgnoreCase(pce2)){
                System.out.println("Column " + (in + 1) + " is full.");
                System.out.print(plyr + ", enter the column to drop your checker: ");
                inpt = input.nextLine(); 
                inpt = alphaChck(input,inpt,plyr);
                line = new Scanner (inpt);
                in = line.nextInt() - 1;
                i = board.length-1;
            }

            
        }
        return board;
    }    

    //Uses the methods that sweep the game to check if there is a winner
    public static boolean winChck (String board [][],String pce1, String pce2, String plyr){
        if(southChck(board,pce1,pce2) || eastChck(board,pce1,pce2) || seChck(board,pce1,pce2) || swChck(board,pce1,pce2)){
            System.out.println(plyr + " wins!!!");
            return true;
        }
        return false;
    }

    //Checks if the board is full and game is a draw
    public static boolean drawGame(String board [][],String pce1, String pce2){
        int i = 0;
        while(i < COLUMNS.length && (board[0][i].equalsIgnoreCase(pce1) || board[0][i].equalsIgnoreCase(pce2)) ){
            i++;
        }
        if( i == COLUMNS.length){
            System.out.println("This game is a draw.");
            return true;
        }
        return false;    
    }    

    //Sweeps to check if the peices are in a row verically
    public static boolean southChck(String board [][],String pce1, String pce2){
        int limit = board.length - 4;
        int [] i = new int [] {0,0};
        boolean [] test = new boolean []{true,false,false,false};
        boolean fnltest = false;
        while(!fnltest && i[1] < COLUMNS.length){
            while(!fnltest && i[0] <= limit){
                test[0] = board[i[0]][i[1]].equals(pce1);
                if(test[0]){
                    for(int n = 1; n <= CONNECT ;n++)
                    test[n] = board[i[0]][i[1]].equals(board[i[0]+ n][i[1]]);
                       
                    if(test[0]==test[1] && test[0]==test[2] && test[0]==test[3])
                        fnltest = true;

                }else{
                    fnltest = false;}
                i[0]++;
            }
            i[0] = 0;
            i[1]++;
        } 
        if(fnltest){
            return true;
        }
        return false;
    }

    //Sweeps the rows to see if the peices are in a row horizontally 
    public static boolean eastChck(String board [][],String pce1, String pce2){
        int limit = COLUMNS.length - 4;
        int [] i = new int [] {0,0};
        boolean [] test = new boolean []{true,false,false,false};
        boolean fnltest = false;
        while(!fnltest && i[0] < board.length){
            while(!fnltest && i[1] <= limit){
                test[0] = board[i[0]][i[1]].equals(pce1);
                if(test[0]){
                    
                    for(int n = 1; n <= CONNECT ;n++)
                    test[n] = board[i[0]][i[1]].equals(board[i[0]][i[1] + n]);
                    
                    if(test[0]==test[1] && test[0]==test[2] && test[0]==test[3])
                        fnltest = true;                    

                }else{
                    fnltest = false;}
                i[1]++;
            }
            i[1]=0;
            i[0]++;
        } 
        if(fnltest){
            return true;
        }
        return false;
    }

    //Checks if the peices are in a row in the South East direction
    public static boolean seChck(String board [][],String pce1, String pce2){
        int limit1 = board.length - 4;
        int limit2 = COLUMNS.length - 4;
        int [] i = new int [] {0,0};
        boolean [] test = new boolean []{true,false,false,false};
        boolean fnltest = false;
        while(!fnltest && i[0] <= limit1){
            while(!fnltest && i[1] <= limit2){
                test[0] = board[i[0]][i[1]].equals(pce1);
                if(test[0]){
                    
                    for(int n = 1; n <= CONNECT ;n++)
                    test[n] = board[i[0]][i[1]].equals(board[i[0] + n][i[1] + n]);
                    
                    if(test[0]==test[1] && test[0]==test[2] && test[0]==test[3])
                        fnltest = true;

                }else{
                    fnltest = false;}
                i[1]++;
            }
            i[1]=0;
            i[0]++;
        } 
        if(fnltest){
            return true;
        }
        return false;
    }
    
    //Sweeps the board an checks if the peices in a diagonal Southwest
    public static boolean swChck(String board [][],String pce1, String pce2){
        int limit = COLUMNS.length - 4;
        int [] i = new int [] {board.length - 1,0};
        boolean [] test = new boolean []{true,false,false,false};
        boolean fnltest = false;
        while(!fnltest && i[0] >= 4){
            while(!fnltest && i[1] <= limit){
                test[0] = board[i[0]][i[1]].equals(pce1);
                if(test[0]){ 
                    
                    for(int n = 1; n <= CONNECT ;n++)
                    test[n] = board[i[0]][i[1]].equals(board[i[0] - n][i[1] + n]);
                    
                    if(test[0]==test[1] && test[0]==test[2] && test[0]==test[3])
                        fnltest = true;

                }else{
                    fnltest = false;}
                i[1]++;
            }
            i[1] = 0;
            i[0]--;
        } 
        if(fnltest){
            return true;
        }
        return false;
    }

    //Creates the array that is to be the board
    public static String [][] Board (){
        String [][] brd = new String [COLUMNS.length - 1][COLUMNS.length];
        for( int j = 0; j < brd.length ; j++){
            for(int i = 0; i < brd[j].length ;i++){
                brd[j][i]= ".";
            }
        }
        return brd;
    }

    //Prints out the current board after the board has been updated.
    public static void currentBoard(String brd [][]){
        System.out.println("\nCurrent Board");
        int num;
        for(int i = 0; i < COLUMNS.length;i++){
            num = COLUMNS[i];
            System.out.print(num + " ");            
        }
        System.out.println("Column Numbers");
        for(int i = 0; i < brd.length; i++){
            for (int j = 0 ; j < brd[i].length; j++){
                System.out.print( brd[i][j] + " ");
            }
            System.out.println();
        }
     }

    //Checks whether or not the input is a non integer. And request a new input.
    public static String alphaChck (Scanner input, String inpt, String plyr){
        Scanner line = new Scanner(inpt);
        boolean test = true;
        while(test){
            if(line.hasNextInt()){
                test = false;
            }else {
                System.out.println(inpt + " is not an integer.");
                System.out.print(plyr + ", enter the column to drop your checker: ");
                inpt = input.nextLine();
                line = new Scanner (inpt);
                test = true;
            }          
        }
        return inpt;
    }
}

