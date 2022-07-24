// Packages and Imports
package Other;
import java.util.Scanner;

public class Main {

    static Menus menu = new Menus(); //Menu Object
    static Scanner scan = new Scanner(System.in); // Scanner Object

    // MAIN
    public static void main(String[] args){

        OtherFunctions.readFile(); // Reads the File and loads data
        menu.mainMenu(); //Starts the main menu

    }

    // Andrija Stanković - 2020230164
    // :)

}