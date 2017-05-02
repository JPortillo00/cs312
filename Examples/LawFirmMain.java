
public class LawFirmMain
{
    public static void main (String[] args) {
        Employee e = new Employee();
        Lawyer l = new Lawyer();
        
        String se = e.getVacationForm();
        String sl = l.getVacationForm();
        System.out.println(se + "\n" + sl);
    }
}