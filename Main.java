import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

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
        
        //Read from file
        readFromFile(fileName, students);
    }
    
    // Function to read data from file 
    public static void readFromFile(String fileName, ArrayList<Student> students){
        String line;
        String splitBy = ",";
        students.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // read first two lines that are headers
            br.readLine();
            br.readLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
