
/*
 * CS312 Assignment 1.
 * On my honor, Jairo Portillo, this programming assignment is my own work.
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Jairo Portillo
 *  email address: Portillo.jairojr@gmail.com
 *  UTEID:jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  Number of slip days used on this assignment:
*/

    public class Song2
    {
    public static void flyDie ()
    {   System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();// This method contains the last three lines of each stanza including the space 
    }
    /*The Following methods contain the lines in which why she swallowed each animal.
     The name of the method is suppose to hint at which line it represents.
     Example SppidertoFly would be Spider to eat Fly*/
    public static void SpidertoFly()
    {
    System.out.println("She swallowed the spider to catch the fly,");
    }
    public static void BirdtoSpider()
    {
    System.out.println("She swallowed the bird to catch the spider,");
    }   
    public static void CattoBird()
    {
    System.out.println("She swallowed the cat to catch the bird,");
    }
    public static void DogtoCat()
    {
    System.out.println("She swallowed the dog to catch the cat,");
    }
    public static void GoattoDog()
    {
    System.out.println("She swallowed the goat to catch the dog,");
    }
    public static void CowtoGoat()
    {
    System.out.println("She swallowed the cow to catch the goat,");
    }
        public static void main(String [] args)
   {
    System.out.println("There was an old woman who swallowed a fly.");
    flyDie();
    //The first two lines of the stanza are printed as they are unique from one another.
    System.out.println("There was an old woman who swallowed a spider,");
    System.out.println("That wriggled and iggled and jiggled inside her.");
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a bird,");
    System.out.println("How absurd to swallow a bird.");
    BirdtoSpider();
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a cat,");
    System.out.println("Imagine that to swallow a cat.");
    CattoBird();
    BirdtoSpider();
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a dog,");
    System.out.println("What a hog to swallow a dog.");
    DogtoCat();
    CattoBird();
    BirdtoSpider();
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a goat,");
    System.out.println("She just opened her throat to swallow a goat.");
    GoattoDog();
    DogtoCat();
    CattoBird();
    BirdtoSpider();
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a cow,");
    System.out.println("I don't know how she swallowed a cow.");
    CowtoGoat();
    GoattoDog();
    DogtoCat();
    CattoBird();
    BirdtoSpider();
    SpidertoFly();
    flyDie();
    System.out.println("There was an old woman who swallowed a horse,\nShe died of course.");
        

    
}
    }