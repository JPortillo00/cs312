import java.awt.*;
import java.util.*;

public class Cat extends Critter {
    // method comment goes here    
    public Cat(){}

    public boolean eat(){      
            return true;        
    }

    public  Attack  fight(String opp)  {
        Random rand = new Random();
        boolean n = rand.nextBoolean();
        if(opp.equalsIgnoreCase("V")|| opp.equals(">")||opp.equals(">")||opp.equals("^")){
            return Attack.SCRATCH;
        }else{
            return Attack.POUNCE;
        }
    }

    public Color getColor() {
        return Color.BLACK;
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
           return "C";      
        }
    }

