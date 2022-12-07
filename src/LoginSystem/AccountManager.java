package LoginSystem;

import java.util.HashMap;


/**
 * This class is responsible for managing and creating accounts
 */
public class AccountManager {
    private HashMap<String, HashMap<String, Account>> accounts; //<username, <password, account>>
    public boolean currLoggedin; //if any user is already logged in
    private Account activeAccount;


    /**
     * Take a snapshot of the current user state to save in accounts
     */
    public AccountManager() {
        this.accounts = new HashMap<>();
    }


    /**
     * all print statements will be replaced with error codes in the future
     * Error code 0 means login successful
     * Error code 1 means Already logged in
     * Error code 3 means User not in system
     * Error code 2 means incorrect username or password
     * @param username the username that the user enter to log in
     * @param password the password that the user enter to log in
     * @return the error code listed above
     */
    public int login(String username, String password) {
//        System.out.println(this.accounts);
//        System.out.println(username);
//        System.out.println(this.accounts.containsKey(username));
        if (this.isCurrLoggedin()) {
            return 1;
            //System.out.println("Already logged in");
        }
        if (this.accounts.containsKey(username)) {
            if (this.accounts.get(username).containsKey(password)) {
                this.activeAccount = this.accounts.get(username).get(password);
                this.activeAccount.login();
                this.setCurrLoggedin(true);
                return 0;
                //System.out.println("Login Successful");
            } else {
                return 2;
                //System.out.println("Incorrect username or password");
            }
        } else {
            return 3;
            //System.out.println("User not in system, please create a new account");
        }
    }


    /**
     * This method is responsible for creating a new account
     * @param username the username that the new account uses
     * @param password the password that the new account uses
     */
    public void createAccount(String username, String password) {
        if (this.accounts.containsKey(username)){
            //System.out.println("Username is taken");
        } else {
            HashMap<String, Account> passanduser = new HashMap<String, Account>();
            passanduser.put(password, new Account(username, password)); //new Acoount(new User)
            this.accounts.put(username, passanduser);
        }
    }


    /**
     * This method checks if the current user is logged in
     * @return true if the current user is logged in, false otherwise
     */
    private boolean isCurrLoggedin() {
        return currLoggedin;
    }


    /**
     * This method set the current user's logged in state
     * @param currLoggedin the current user's logged in state
     */
    public void setCurrLoggedin(boolean currLoggedin) {
        this.currLoggedin = currLoggedin;
    }


    /**
     * This method gets the current active account
     * @return the account that is currently active
     */
    public Account getActive() {
        return this.activeAccount;
    }


    /**
     * This method will log the user out
     */
    public void logout(){
        this.setCurrLoggedin(false);
        this.activeAccount = null;
    }
}
