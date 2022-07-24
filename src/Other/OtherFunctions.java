// Packages and Imports
package Other;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import Accounts.Professors;
import Accounts.Students;
import Accounts.University;
import Accounts.Users;

public class OtherFunctions {

    // List of all Users as objects
    public static ArrayList<Users> userList = new ArrayList<Users>();

    // Design Abstract Factory Pattern
    public static Users userFactory(String data){

        String[] elements = data.split(",");
        String ID = elements[0];
        String name = elements[1];

        if(ID.startsWith("S")){

            int grade = Integer.parseInt(elements[2]);
            String password = elements[3];
            int feesPaid = Integer.parseInt(elements[4]);

            Students tempStudent = new Students(ID, name, grade, password, feesPaid);
            return tempStudent;

        } else if(ID.startsWith("P")){

            String password = elements[2];
            int salary = Integer.parseInt(elements[3]);
            String subject = elements[4];

            Professors tempProf = new Professors(ID, name, password, salary, subject);
            return tempProf;

        } else if(ID.startsWith("U")){

            University tempUn = new University(ID, name);
            return tempUn;

        }
        return null;
    }

    public static void readFile(){

        ArrayList<String> fileLine = new ArrayList<String>();
        File userFile = new File("users.txt");

        try{
            Scanner scan = new Scanner(userFile);

            while(scan.hasNextLine()){
                fileLine.add(scan.nextLine());
            }

        } catch (FileNotFoundException e){
            System.out.println("Cannot find file");
        }

        for (int i=0; i<fileLine.size(); i++){

            userList.add(userFactory(fileLine.get(i)));
        }
    } // Reads the file and creates objects
    public static void writeUserFile(){

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("users.txt"));

            for(int i = 0; i < userList.size(); i++){
                fileWriter.write(userList.get(i).saveFormat() + "\n");
            }
            fileWriter.close();

        } catch (IOException e){
            System.out.println("Error writing to file.");
        }

    } // Writes to the file

    public static void printStudents(){
        for(Users user : userList){
            if(user instanceof Students){
                System.out.println(((Students) user).toString());
            }
        }
    } // Prints the Student list
    public static void printProfessors(){
        for(Users user : userList){
            if(user instanceof Professors){
                System.out.println(((Professors) user).toString());
            }
        }
    } // Prints the Professor list

    public static void goBack(){
        int goBackCheck;
        do {
            System.out.println("Press 0 to go back.");
            goBackCheck = Main.scan.nextInt();
        } while(goBackCheck !=0);

    } // Validates input and returns to last sub menu
    public static boolean Exit(String exitName){

        // takes the parameter of exitName to confirm which Menu is being exited.
        System.out.println("Are you sure you want to exit " + exitName + "?");
        System.out.println("Press 0 to exit, or any other digit to cancel.");
        int exitCheck = Main.scan.nextInt();

        return exitCheck == 0;
    } // Confirms the exit of a menu
    public static void exitMessage(){
        System.out.println();
        System.out.println();
        System.out.println(
                "   _____  ____   ____  _____    ______     ________   _ \n" +
                        "  / ____|/ __ \\ / __ \\|  __ \\  |  _ \\ \\   / /  ____| | |\n" +
                        " | |  __| |  | | |  | | |  | | | |_) \\ \\_/ /| |__    | |\n" +
                        " | | |_ | |  | | |  | | |  | | |  _ < \\   / |  __|   | |\n" +
                        " | |__| | |__| | |__| | |__| | | |_) | | |  | |____  |_|\n" +
                        "  \\_____|\\____/ \\____/|_____/  |____/  |_|  |______| (_)\n");
    } // Exit message

}