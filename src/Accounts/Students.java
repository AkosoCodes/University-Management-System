// Packages and Imports
package Accounts;
import Other.OtherFunctions;
import java.io.IOException;
import java.util.Scanner;

// TODO: Once fees are paid, update the amount by writing to file and saving.

public class Students extends Users{

    private int feesPaid;
    private final String name;
    private final int grade;
    private final int feesTotal;

    // Constructor
    public Students(String ID, String name, int grade, String password, int feesPaid){
        super(ID, password);
        feesTotal = 10000;

        this.name = name;
        this.grade = grade;
        this.feesPaid = feesPaid;

        try{
            checkID();
        } catch (IOException e){
            System.out.println("Invalid format of student ID.");
        }

    }

    @Override // To String Method to print the array
    public String toString() {
        return  ID + " | " + name +
                " | Year "+ grade+
                " | Fees Paid: "+ feesPaid;
    }

    @Override // Regex Check
    public void checkID() throws IOException {
        if(!ID.matches("^[S][0-9]{1,2}$")){
            throw new IOException();
        }
    }

    @Override // Returns the way the text needs to be saved in File
    public String saveFormat(){
        return ID+","+name+","+grade+","+password+","+feesPaid;
    }

    @Override
    public void showInfo() {

        System.out.println("----------------------------------------");
        System.out.println("        Student Information Page");
        System.out.println("----------------------------------------");
        System.out.println("|Full name: " + name);
        System.out.println("|Student ID: " + ID);
        System.out.println("|Grade: Year " + grade);
        System.out.println("----------------------------------------");

    } // Shows Information of the Student
    public void showTuition(){

        System.out.println("----------------------------------------");
        System.out.println("        Student Tuition Page");
        System.out.println("----------------------------------------");
        System.out.println("|Tuition paid: " + feesPaid + " out of " + feesTotal+ " EUR.");
        System.out.println("|Left to pay: " + feesOwed() + " EUR.");
        System.out.println("----------------------------------------");

    } // Shows the Total Tuition Paid and the Total Tuition left to Pay.
    public void payTuition(){

        System.out.println("----------------------------------------");
        System.out.println("           Make Payment Page");
        System.out.println("----------------------------------------");
        System.out.println("How much would you like to pay? Please");
        System.out.println("input the amount in EUR.");

        Scanner scan = new Scanner(System.in);
        int payment = scan.nextInt();
        updateFeesPaid(payment);

        System.out.println(payment + " EURs have successfully been processed.");
        System.out.println("----------------------------------------");
        OtherFunctions.writeUserFile();
    } // Makes a Payment towards the Tuition, and adds it to the total Paid.

    public void updateFeesPaid(int fees){
        feesPaid += fees;
    } // Updates the total Tuition paid.
    public int feesOwed(){
        int feesOwed = feesTotal - feesPaid;
        return feesOwed;
    } // Calculates the total Tuition owed.

}


