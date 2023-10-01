import java.util.*;
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
    
    // F1: Read data from file 
    public static void readFromFile(String fileName, ArrayList<Student> students){
        String line;
        String splitBy = ",";
        students.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // read first two lines that are headers
            br.readLine();
            br.readLine();
            
            while((line = br.readLine()) != null){
                //Split comma separated student info and store in respective variables
                String[] studentInfo = line.split(splitBy);
                String lastName = studentInfo[0];
                String firstName = studentInfo[1];
                int studentId = Integer.parseInt(studentInfo[2]);
                double a1Mark = studentInfo.length > 3 ? parseToDouble(studentInfo[3]) : 0;
                double a2Mark = studentInfo.length > 4 ? parseToDouble(studentInfo[4]) : 0;
                double a3Mark = studentInfo.length > 5 ? parseToDouble(studentInfo[5]) : 0;
                
                // Create new Student object
                Student student = new Student(lastName, firstName, studentId, a1Mark, a2Mark, a3Mark);
                //Add object to ArrayList
                students.add(student);
                
                //Print student data
                printStudentData(student);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    //Parse string to double if value is present else return 0
    public static double parseToDouble(String value){
        if(value.isEmpty())
            return 0;
        else
            return Double.parseDouble(value);
    }
    
    //F2: Print student data
    public static void printStudentData(Student student){
        System.out.println(student.getStudentData());
    }
}
