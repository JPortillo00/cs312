import java.awt.*;

public class Vulture extends Critter {
    // method comment goes here
    private int m = 1;
    private int n = 1;
    public boolean fight = false;
    public Vulture(){}

    public boolean eat(){
        if(fight)
            return true;
        else
            return false;
    }

    public  Attack  fight(String  opponent)  {
        fight = true;
        if(opponent.equals("%") || opponent.equals("S"))
            return  Attack.ROAR;
        else
            return Attack.POUNCE;
    }

    public Color getColor() {
        return Color.BLACK;
    }

    public  Direction  getMove(){
        switch(n){
            case 1:           
            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.NORTH;         

            case 2:        
            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.EAST;          

            case 3:        

            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.SOUTH;

            case 4:        

            if(m==3){
                m = 1;
                n = 1;}
            m++;            
            return Direction.WEST;

            default:
            return Direction.CENTER;
        }  
    }

    public String toString() {
        switch(n){
            case 1:
            return "^";
            case 2:
            return ">";
            case 3:
            return "V";
            case 4:
            return "<";
            default:
            return "^";      
        }
    }
}