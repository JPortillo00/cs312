public class Lawyer extends Employee
{
    public int getVacationDays () {
        return super.getVacationDays() + 5;
    }
    
    public String getVacationForm() {
        return "pink";
    }
    
    public void sue() {
        System.out.println("See you in court!!  Bwahahahah");
    }
}