/*public static int digitSum(int n) {
    int sum = 0;
    if (n < 0) n = -n;
    for (int i = 0; i == 0; i = 0) {  // Infinite loop; i==0 is always true, but java is fooled into compiling and running this
        if (n == 0) return sum;
        else {
            sum += n%10;
            n = n/10;
        }
    }
    return 0;  // code never reaches here
}*/

import java.util.Scanner;

public class BMI2 {
        public static void main (String [] args) {
                Scanner cons = new Scanner (System.in);
                double bmi1 = person(cons);
                double bmi2 = person(cons);
                report (1, bmi1);
                report (2, bmi2);
                System.out.println("Difference is " + Math.abs(bmi1 - bmi2));
        }
        
        /* this method gets the weight and height of a person, and returns 
           BMI.
        */
        public static double person (Scanner cons) {
                double wt;  // this should be declared 1 line down, ideally
                System.out.println("Enter next Person's info.");
                System.out.print("Enter weight in lbs.: ");
                wt = cons.nextDouble();
                System.out.print("Enter height in inches.: ");
                double ht = cons.nextDouble();
                System.out.println();
                return bmi(wt, ht);
        }
        
        public static double bmi (double w, double h) {
                return w*703/(h*h);
        }
        
        // Outputs information about a person's BMI and weight status.
    public static void report(int number, double bmi) {
        System.out.printf("Person %d's BMI = %.2f\n", number, bmi);
                if (bmi < 18.5) {
                        System.out.println("underweight");
                } else if (bmi < 25) {
                        System.out.println("normal");
                } else if (bmi < 30) {
                        System.out.println("overweight");
                } else {
                        System.out.println("obese");
                }
    }
}