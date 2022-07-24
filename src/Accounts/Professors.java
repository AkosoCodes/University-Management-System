// Packages and Imports
package Accounts;
import Other.OtherFunctions;
import java.io.IOException;

public class Professors extends Users{

    private final String name;
    private final int salary;
    private final String subject;

    // Constructor
    public Professors(String ID, String professorName, String password, int professorSalary, String subject){
        super(ID, password);

        this.name = professorName;
        this.salary = professorSalary;
        this.subject = subject;

        try{
            checkID();
        } catch (IOException e){
            System.out.println("Invalid format of Professor ID.");
        }

    }

    @Override // To String method
    public String toString() {

        return  ID +" | "+ name+
                " | '" + subject + "'"+
                " | Salary: " + salary + " EUR.";
    }

    @Override // Regex Check
    public void checkID() throws IOException {
        if(!ID.matches("^[P][0-9]{1,2}$")){
            throw new IOException();
        }
    }

    @Override // Returns the way the text needs to be saved in File
    public String saveFormat(){
        return ID+","+name+","+password+","+salary+","+subject;
    }

    @Override
    public void showInfo() {

        System.out.println("----------------------------------------");
        System.out.println("       Professor Information Page");
        System.out.println("----------------------------------------");
        System.out.println("|Full name: " + name);
        System.out.println("|Professor ID: " + ID);
        System.out.println("|Subject: " + subject);
        System.out.println("|Current Salary: " + salary+ " EUR.");
        System.out.println("----------------------------------------");
    } // Shows Information of the Professor
    public void showStudents(){
        System.out.println("Here is the list of Students:");
        OtherFunctions.printStudents();
    } // Shows a list of all Students





}
