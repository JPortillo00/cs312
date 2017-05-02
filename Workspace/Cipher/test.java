
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    public static final int R = 6;
    public static void main(String [] args){
        encrypt();

    }
    public static void encrypt(){
        String mess = "Hook_'em_Horns!!!";

        for( int i = 2; i <= R  ; i++){
            String ans = "";
            for(int j = 0; j + 1 <= i;j++){
                int index = 0;
                while ( index  <= mess.length()-1 - j){
                    ans += mess.charAt(index + j);
                    index += i;}
            }

            System.out.println(ans);}

    }
    public static void decrypt(){
    String code = "Ho_e_on!!ok'mhrs!X";
    
    
    }
}
