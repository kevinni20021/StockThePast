package LoginSystem;

import java.util.HashMap;

public class AccountManager {
    private HashMap<String, HashMap<String, Account>> accounts; //<username, <password, account>>
    public boolean currLoggedin; //if any user is already logged in
    private Account activeAccount;

    //take a snapshot of the current user state to save in accounts
    //public User.User saveUserState {}
    public AccountManager() {
        this.accounts = new HashMap<>();
    }
    //all print statements will be replaced with error codes in the future
    //Error code 0 means login successful
    //Error code 1 means Already logged in
    //Error code 3 means User.User not in system
    //Error code 2 means incorrect username or password
    public int login(String username, String password) {
        if (this.isCurrLoggedin()) {
            return 1;
        }
        if (this.accounts.containsKey(username)) {
            if (this.accounts.get(username).containsKey(password)) {
                this.activeAccount = this.accounts.get(username).get(password);
                this.activeAccount.login();
                this.setCurrLoggedin(true);
                return 0;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    public int createAccount(String username, String password) {
        if (this.accounts.containsKey(username)){
            return 0;
        } else {
            HashMap<String, Account> passanduser = new HashMap<String, Account>();
            passanduser.put(password, new Account(username, password)); //new Acoount(new User.User)
            this.accounts.put(username, passanduser);
            return 1;
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

    public HashMap<String, HashMap<String, Account>> getAccounts() {return accounts;}
}
