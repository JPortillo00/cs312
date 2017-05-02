
import javax.swing.JOptionPane;

public class galvan_wordgame
{
	
		public static void main(String[] args)
		{
			String firstName;
			String age;
			String nameCity;
			String nameCollege;
			String profession;
			String animalType;
			String petName;

			firstName =
				JOptionPane.showInputDialog("What is " +
					"your first name?");
			age =
				JOptionPane.showInputDialog("What is " +
					"your age?");
			nameCity =
				JOptionPane.showInputDialog("Name any " +
					"city you like.");
			nameCollege =
				JOptionPane.showInputDialog("Name any " +
				"college.");
			profession =
				JOptionPane.showInputDialog("Name a profession.");
			animalType =
				JOptionPane.showInputDialog("Name an animal.");
			petName =
				JOptionPane.showInputDialog("Type in a " +
				"pet name.");

			JOptionPane.showMessageDialog(null, "There once was a " +
				"person named " + firstName + ", who lived in " +
				nameCity + ". By the age of " + age + ", " + firstName +
				" went to college at " + nameCollege + ". " +
				firstName + " graduated and went to work as a " +
				profession + ". Then, " + firstName + " adopted a(n) " +
				animalType + " named " + petName + ". They both lived " +
				"happily ever after!");
			System.exit(0);
		}
}