import java.util.Scanner;

public class OrderNumbers {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.print("Enter three numbers: ");
        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();
        double c = keyboard.nextDouble();

        if (a > b) {  
            // enter here if the order is abc, cab, acb
            if (a > c) {
                // enter here is abc, acb
                System.out.println("The highest number is " + a);
            }
            else  {
                // enter here if cab
                System.out.println ("The highest number is " + c);
            }
        }
        else if (b > c) {
            // enter here if bac, bca
            System.out.println("The highest number is " + b);
        }
        else {
            // enter here if cba
            System.out.println("The highest number is " + c);    
        }
    }
}