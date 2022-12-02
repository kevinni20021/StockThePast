package LoginSystem;

import java.util.HashMap;

public class AccountManager {
    private HashMap<String, HashMap<String, Account>> accounts; //<username, <password, account>>
    public boolean currLoggedin; //if any user is already logged in
    private Account activeAccount;

    //take a snapshot of the current user state to save in accounts
    //public User saveUserState {}
    public AccountManager() {
        this.accounts = new HashMap<>();
    }
    //all print statements will be replaced with error codes in the future
    //Error code 0 means login successful
    //Error code 1 means Already logged in
    //Error code 3 means User not in system
    //Error code 2 means incorrect username or password
    public int login(String username, String password) {
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

    public void createAccount(String username, String password) {
        if (this.accounts.containsKey(username)){
            System.out.println("Username is taken");
        } else {
            HashMap<String, Account> passanduser = new HashMap<String, Account>();
            passanduser.put(password, new Account(username, password)); //new Acoount(new User)
            this.accounts.put(username, passanduser);
        }
    }
    private boolean isCurrLoggedin() {
        return currLoggedin;
    }

    public void setCurrLoggedin(boolean currLoggedin) {
        this.currLoggedin = currLoggedin;
    }

    public Account getActive() {
        return this.activeAccount;
    }

    public void logout(){
        this.setCurrLoggedin(false);
        this.activeAccount = null;
    }
}
