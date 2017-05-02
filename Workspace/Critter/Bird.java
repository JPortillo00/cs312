import java.awt.*;

public class Bird extends Critter {
    // method comment goes here
    public int n = 1;
    public int m = 1;
    public Bird(){}

    public boolean eat(){
        return false;
    }

    public  Attack  fight(String  opponent)  {
        if(opponent.equals("%"))
            return  Attack.ROAR;
        else
            return Attack.POUNCE;
    }

    public Color getColor() {
        return Color.BLUE;
    }

    public  Direction  getMove(){
        if(n == 1){
            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.NORTH;
        } else if (n == 2){
            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.EAST;
        }else if (n == 3){
            if(m==3){
                m = 1;
                n++;}
            m++;
            return Direction.SOUTH;
        }else{
            if(m==3){
                m = 1;
                n = 1;}
            m++;
            return Direction.WEST;
        }
    }

    public String toString() {
        if(n == 1){
            return "^";
        } else if (n == 2){
            return ">";
        }else if (n == 3){
            return "V";
        }else{
            return "<";
        }
    }
}