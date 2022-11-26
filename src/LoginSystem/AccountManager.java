package LoginSystem;

import java.util.HashMap;

public class AccountManager {
    private HashMap<String, HashMap<String, Account>> accounts; //<username, <password, account>>
    public boolean currLoggedin; //if any user is already logged in
    private Account activeAccount;

    //take a snapshot of the current user state to save in accounts
    //public User saveUserState {}

    public void login(String username, String password) {
        if (this.currLoggedin) {
            System.out.println("Already logged in");
        }
        if (this.accounts.containsKey(username)) {
            if (this.accounts.get(username).containsKey(password)) {
                this.activeAccount = this.accounts.get(username).get(password);
                this.activeAccount.setLoggedin(true);
                this.setCurrLoggedin(true);
            } else {
                System.out.println("Incorrect username or password");
            }
        } else {
            System.out.println("User not in system, please create a new account");
        }
    }

    public void createAccount(String username, String password) {
        if (this.accounts.containsKey(username)){
            System.out.println("Username is taken");
        } else {
            HashMap<String, Account> passanduser = new HashMap<String, Account>();
            passanduser.put(password, new Account());
            //set new account user
            this.accounts.put(username, passanduser);
        }
    }
    public boolean isCurrLoggedin() {
        return currLoggedin;
    }

    public void setCurrLoggedin(boolean currLoggedin) {
        this.currLoggedin = currLoggedin;
    }
}
