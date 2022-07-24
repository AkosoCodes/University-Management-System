// Packages and Imports
package Accounts;
import java.io.IOException;

interface Account {

    String saveFormat(); // Save Format method
    void showInfo(); // Shows the information of the account
    void checkID() throws IOException; // Check ID method

}
