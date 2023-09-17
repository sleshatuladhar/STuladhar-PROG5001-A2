import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class
 *
 * @author (Slesha Tuladhar)
 * @version (18/09/2023)
 */
public class Main
{
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
    }
    
    public static void main(String[] args){
        //Initialise variables
        Scanner scanner = new Scanner(System.in);
        String fileName;
        ArrayList<Student> students = new ArrayList<Student>();
        
        //Get file name from user
        System.out.println("Enter the file name:");
        fileName = scanner.nextLine();
    }
}
