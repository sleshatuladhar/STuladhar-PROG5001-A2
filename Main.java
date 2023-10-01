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
        double thresholdMarks;
        
        //Get file name from user
        System.out.println("Enter the file name:");
        fileName = scanner.nextLine();
        
        //Read from file
        System.out.println("Reading from file: " + fileName);
        readFromFile(fileName, students);
        
        int menuItem;
        // Show menu and allow user to choose action
        printMenu();
        menuItem = scanner.nextInt();
        
        while(menuItem != 5){
                if(menuItem == 1){
                    //Print student data
                    printStudentData(students);
                } else if(menuItem == 2){
                    //F3: Get threshold marks from user
                    System.out.println("Enter threshold marks:");
                    thresholdMarks = scanner.nextDouble();
                    
                    //Get list of students with total marks less than threshold marks
                    System.out.println("List of students with total marks less than " + thresholdMarks + ": ");
                    filterStudentsByThreshold(students,thresholdMarks);
                } else if(menuItem == 3){
                    //F4: Get top 5 students with highest total marks
                    System.out.println("Top 5 students with highest total marks: ");
                    getTop5Students(students);
                } else if(menuItem == 4){
                    //F4: Get top 5 students with lowest total marks
                    System.out.println("Top 5 students with lowest total marks: ");
                    getLast5Students(students);
                }
                printMenu();
                menuItem = scanner.nextInt();
        }  
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
    public static void printStudentData(ArrayList<Student> students){
        for(Student student : students){
            System.out.println(student.getStudentData());
        }
    }
    
    //F3: Print list of students with total marks less than certain threshold
    public static void filterStudentsByThreshold(ArrayList<Student> students, double thresholdMarks){
        ArrayList<Student> filteredStudents = new ArrayList<Student>();
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            if(student.totalMarks < thresholdMarks){
                filteredStudents.add(student);
            }
        }
        printStudentData(filteredStudents);
    }
    
    //F4: Get top 5 students with highest total marks
    public static void getTop5Students(ArrayList<Student> students) {
        ArrayList<Student> top5Students = new ArrayList<Student>();
        for (Student student : students) {
            //Add first 5 students to array list and then start sorting for top 5
            if (top5Students.size() < 5) {
                top5Students.add(student);
            } else{
                for (int i = 0; i < 5; i++) {
                    if (student.totalMarks > top5Students.get(i).totalMarks) {
                        // Shift existing top student down if current student has higher marks
                        for (int j = 4; j > i; j--) {
                            top5Students.set(j, top5Students.get(j-1));
                        }
                        top5Students.set(i, student);
                        break;
                    }
                }
            }
        }

        // Print the top 5 students
        printStudentData(top5Students);
    }
    
    //F4: Get top 5 students with lowest total marks
    public static void getLast5Students(ArrayList<Student> students) {
        ArrayList<Student> last5Students = new ArrayList<Student>();
        for (Student student : students) {
            //Add first 5 students to array list and then start sorting for lowest 5
            if (last5Students.size() < 5) {
                last5Students.add(student);
            } else{
                for (int i = 0; i < 5; i++) {
                    if (student.totalMarks < last5Students.get(i).totalMarks) {
                        // Shift existing last student down if current student has lower marks
                        for (int j = 4; j > i; j--) {
                            last5Students.set(j, last5Students.get(j-1));
                        }
                        last5Students.set(i, student);
                        break;
                    }
                }
            }
        }

        // Print the lowest 5 students
        printStudentData(last5Students);
    }
    
    //Print menu
    public static void printMenu(){
        System.out.println("Please select a number: ");
        System.out.println("1) Display Student's Detail with total Marks");
        System.out.println("2) Display the list of students with total marks less than a given threshold.");
        System.out.println("3) Display top 5 students with the highest total marks");
        System.out.println("4) Display top 5 students with the lowest total marks");
        System.out.println("5) Exit");
    }
}
