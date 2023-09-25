
/**
 * Student class
 *
 * @author (Slesha)
 * @version (18/09/2023)
 */
public class Student
{
    // Define instance variables
    String lastName;
    String firstName;
    int studentId;
    double a1Mark;
    double a2Mark;
    double a3Mark;
    double totalMarks;
    
    //Define constructor
    public Student(String lastName, String firstName, int studentId, double a1Mark, double a2Mark, double a3Mark){
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentId = studentId;
        this.a1Mark = a1Mark;
        this.a2Mark = a2Mark;
        this.a3Mark = a3Mark;
        this.calculateTotalMarks();
    }
    
    public void calculateTotalMarks(){
        this.totalMarks = this.a1Mark + this.a2Mark + this.a3Mark;
    }
    
    public double getTotalMarks(){
        return this.totalMarks;
    }
}
