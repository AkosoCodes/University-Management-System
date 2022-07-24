// Packages and Imports
package Other;
import java.util.Scanner;
import Accounts.Professors;
import Accounts.Students;
import Accounts.University;
import News.Math;
import News.Science;
import News.Programming;

public class Menus{

    // Scanner Object
    static Scanner scan = new Scanner(System.in);
    static int check;

    // MENUS
    public void mainMenu(){

        // Welcome Message
        System.out.println("---------------------------");
        System.out.println("Welcome to Java University!");
        System.out.println("---------------------------");

        do {
            System.out.println("What would you like to do?");
            System.out.println("1- Log In");
            System.out.println("2- Recent News");
            System.out.println("3- Exit");
            System.out.println("---------------------------");
            check = scan.nextInt();

            switch (check) {
                case 1 -> // Login Menu
                        loginMenu();
                case 2 -> // News Menu
                        newsMenu();
                case 3 -> { // Exit Application
                        OtherFunctions.exitMessage();
                }
            }

        } while (check < 1 || check >3); // repeats until the user gives a valid input.

    } // Main Menu
    public void loginMenu(){

        boolean loop = false;
        do {
            // Enter the ID
            System.out.println("---------------------------");
            System.out.println("Please enter ID:");
            String inputID = scan.next();

            // Enter the Password
            System.out.println("Please enter password:");
            String inputPass = scan.next();

            // Goes through the User List and checks whether the ID and Password Match.
            for(int i=0; i<OtherFunctions.userList.size(); i++){

                check = 0;

                if(inputID.equals(OtherFunctions.userList.get(i).getID()) && inputPass.equals(OtherFunctions.userList.get(i).getPass())){
                    // If the ID starts with S, open the Student Menu
                    if(inputID.startsWith("S")){
                        check = 1;
                        studentLogIn((Students)OtherFunctions.userList.get(i));
                        break;
                    }

                    // If the ID starts with P, open the Professor Menu
                    if(inputID.startsWith("P")){
                        check = 1;
                        professorLogIn((Professors)OtherFunctions.userList.get(i));
                        break;
                    }

                    if(inputID.startsWith("U")){
                        check = 1;
                        universityLogIn((University)OtherFunctions.userList.get(i));
                        break;
                    }

                } else if(i + 1 == OtherFunctions.userList.size() && check != 1){
                    System.out.println("The credentials did not match.");
                    System.out.println("Please try again.");
                    System.out.println();

                    loop = true;
                } else {
                    loop = false;
                }
            }

        }while(loop);

    } // Login Menu
    public void newsMenu(){

        // News - Articles objects
        Programming programming = new Programming();
        Math math = new Math();
        Science science = new Science();

        boolean loop = false;
        do {
            check = 0;
            do {
                // Welcome Message
                System.out.println("---------------------------");
                System.out.println("       Recent News");
                System.out.println("---------------------------");

                System.out.println("Please select a topic:");
                System.out.println("1- Programming");
                System.out.println("2- Math");
                System.out.println("3- Science");
                System.out.println("4- Exit");
                System.out.println("---------------------------");
                check = scan.nextInt();
            } while (check < 1 || check > 4);

            switch (check) {
                case 1 -> {
                    programming.content();
                    OtherFunctions.goBack();
                }
                case 2 -> {
                    math.content();
                    OtherFunctions.goBack();
                }
                case 3 -> {
                    science.content();
                    OtherFunctions.goBack();
                }
                case 4 -> loop = OtherFunctions.Exit("News");
            }
        } while (!loop);
    } // News Menu

    // Logins
    public void studentLogIn(Students student){

        boolean loop = false;
        do {
            do {
                System.out.println();
                System.out.println("---------------------------");
                System.out.println("       Student Portal");
                System.out.println("---------------------------");

                System.out.println("What would you like to do?");
                System.out.println("1- Show Info");
                System.out.println("2- Tuition Info");
                System.out.println("3- Make a payment");
                System.out.println("4- Go back");
                System.out.println("---------------------------");

                check = scan.nextInt();

            }while(check < 1 || check >4);

            switch (check) {
                case 1 -> {
                    student.showInfo();
                    OtherFunctions.goBack();
                }
                case 2 -> {
                    student.showTuition();
                    OtherFunctions.goBack();
                }
                case 3 -> {
                    student.payTuition();
                    OtherFunctions.goBack();
                }
                case 4 -> loop = true;
            }
        } while(!loop);

    } // Student Log In
    public void professorLogIn(Professors professor){

        boolean loop = false;
        do {
            do {
                System.out.println();
                System.out.println("---------------------------");
                System.out.println("      Professor Portal");
                System.out.println("---------------------------");

                System.out.println("What would you like to do?");
                System.out.println("1- Show Info");
                System.out.println("2- Show list of Students");
                System.out.println("3- Go back");
                System.out.println("---------------------------");

                check = scan.nextInt();

            }while(check < 1 || check >3);

            switch (check) {
                case 1 -> {
                    professor.showInfo();
                    OtherFunctions.goBack();
                }
                case 2 -> {
                    professor.showStudents();
                    OtherFunctions.goBack();
                }
                case 3 -> {
                    loop = true;
                }
            }
        } while(!loop);
    } // Professor Log In
    public void universityLogIn(University university){

        boolean loop = false;
        do {
            do {
                System.out.println();
                System.out.println("---------------------------");
                System.out.println("     University Portal");
                System.out.println("---------------------------");

                System.out.println("What would you like to do?");
                System.out.println("1- Show Info");
                System.out.println("2- Student List");
                System.out.println("3- Professor List");
                System.out.println("4- Go back");
                System.out.println("---------------------------");

                check = scan.nextInt();

            }while(check < 1 || check >4);

            switch (check) {
                case 1 -> {
                    university.showInfo();
                    OtherFunctions.goBack();
                }
                case 2 -> {
                    OtherFunctions.printStudents();
                    OtherFunctions.goBack();
                }
                case 3 -> {
                    OtherFunctions.printProfessors();
                    OtherFunctions.goBack();
                }
                case 4 -> loop = true;
            }
        } while(!loop);

    } // University Log In

}