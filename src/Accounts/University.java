// Packages and Imports
package Accounts;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class University extends Users{

    // Constructor
    public University(String ID, String password) {
        super(ID, password);
    }

    @Override // Regex Check
    public void checkID() throws IOException {
        if(!ID.matches("^[U][0-9]{1,2}$")){
            throw new IOException();
        }
    }

    @Override // Returns the way the text needs to be saved in File
    public String saveFormat() {
        return ID+","+password;
    }

    @Override
    public void showInfo() {
        System.out.println("----------------------------------------");
        System.out.println("        University Status Page");
        System.out.println("----------------------------------------");
        System.out.println("|University ID: " + ID);
        System.out.println("|Revenue: " + calculateRevenue() + " EUR.");
        System.out.println("|Expenditure: " + calculateExpenditure() + " EUR.");
        System.out.println("|Total Profit: " + (calculateRevenue()-calculateExpenditure()) + " EUR.");
        System.out.println("----------------------------------------");
    } // Shows Information of the University
    public int calculateRevenue(){

        ArrayList<String> fileLine = new ArrayList<String>();
        ArrayList<Integer> income = new ArrayList<>();
        int feesTotal = 0;

        File userFile = new File("users.txt");

        try{
            Scanner scan = new Scanner(userFile);

            while(scan.hasNextLine()){
                fileLine.add(scan.nextLine());
            }

        } catch (FileNotFoundException e){
            System.out.println("Cannot find file");
        }

        for(int i=0; i<fileLine.size(); i++){
            String[] elements = fileLine.get(i).split(",");
            String ID = elements[0];

            if(ID.startsWith("S")){

                Integer incomeTemp = Integer.parseInt(elements[4]);
                income.add(incomeTemp);
            }
        }

        int sum = 0;
        for (int i=0; i<income.size(); i++){
            sum += income.get(i);
        }

        return sum;
    } // Sums up all tuition paid by Students
    public int calculateExpenditure(){

        ArrayList<String> fileLine = new ArrayList<String>();
        ArrayList<Integer> expenses = new ArrayList<>();
        int feesTotal = 0;

        File userFile = new File("users.txt");

        try{
            Scanner scan = new Scanner(userFile);

            while(scan.hasNextLine()){
                fileLine.add(scan.nextLine());
            }

        } catch (FileNotFoundException e){
            System.out.println("Cannot find file");
        }

        for(int i=0; i<fileLine.size(); i++){
            String[] elements = fileLine.get(i).split(",");
            String ID = elements[0];

            if(ID.startsWith("P")){

                Integer expenseTemp = Integer.parseInt(elements[3]);
                expenses.add(expenseTemp);
            }
        }

        int sum = 0;
        for (int i=0; i<expenses.size(); i++){
            sum += expenses.get(i);
        }

        return sum;
    } // Sums up all the salaries of the Professors
}
