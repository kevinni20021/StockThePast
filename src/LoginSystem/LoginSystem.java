package LoginSystem;


/**
 * This class is responsible for creating accounts
 */
public class LoginSystem {
    private AccountManager accounts;
    public String errorMsg;


    /**
     * This constructor is created to link with the class AccountManager()
     */
    public LoginSystem() {
        this.accounts = new AccountManager();
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
    public Account login(String username, String password) {
        switch (this.accounts.login(username, password)) {
            case 0 -> {
                //System.out.println("Login Successful");
                return this.accounts.getActive();
            }
            case 1 -> errorMsg = "Already logged in";
            case 2 -> errorMsg = "Incorrect username or password";
            case 3 -> errorMsg = "User not in system, please create a new account";
            default -> errorMsg = "Error with login, contact administrator";
        }
        return null;
    }

    /**
     * This method is responisble for creating a new account
     * @param username the username that the user wants for the new account
     * @param password the password that the user wants for the new account
     */
    public void createAccount(String username, String password) {
        this.accounts.createAccount(username, password);
    }


    /**
     * This method will log the user out
     */
    public void logout() {
        this.accounts.logout();
    }

    public Account getAccount(){
        return this.accounts.getActive();
    }
}
