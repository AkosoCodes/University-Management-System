// Packages
package Accounts;

public abstract class Users implements Account{

    String ID;
    String password;

    // Constructor
    Users(String ID, String password){
        this.ID = ID;
        this.password = password;
    }

    // Get Methods
    public String getID(){
        return ID;
    }
    public String getPass(){
        return password;
    }
}
