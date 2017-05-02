import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
    // method comment goes here
    private boolean test = true ;
    private static int n;
    private int m = 0;

    public Hippo(int hunger){
        n = hunger;
    }

    public boolean eat(){
        if( n > 0){
            n--;
            return true;
        }else{
            return false;
        }
    }

    public  Attack  fight(String opponent)  {
        if( n > 0){
            return Attack.SCRATCH;
        }else{
            return Attack.POUNCE;
        }
    }

    public Color getColor() {
        if( n > 0){
            return Color.GRAY;
        }else{
            return Color.WHITE;
        }
    }

    public  Direction  getMove(){
        Random rand = new Random();
        int dir = 1 + rand.nextInt(4);
        switch(dir){
        
            case 1:
            return Direction.NORTH;
            
            case 2:            
            return Direction.SOUTH;
            
            case 3:          
            return Direction.EAST;
            
            case 4:            
            return Direction.WEST;
            
            default:
            return Direction.CENTER;
        
        }
    }

    public String toString() {
        return "" + n;      
    }
}
