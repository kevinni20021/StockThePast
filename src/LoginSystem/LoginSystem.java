package LoginSystem;

public class LoginSystem {
    private AccountManager accounts;
    public String errorMsg;

    public LoginSystem() {
        this.accounts = new AccountManager();
    }

    public Account login(String username, String password) {
        switch (this.accounts.login(username, password)) {
            case 0 -> {
                return this.accounts.getActive();
            }
            case 1 -> errorMsg = "Already logged in";
            case 2 -> errorMsg = "Incorrect username or password";
            case 3 -> errorMsg = "User not in system, please create a new account";
            default -> errorMsg = "Error with login, contact administrator";
        }
        return null;
    }

    public int createAccount(String username, String password) {
        return this.accounts.createAccount(username, password);
    }

    public void logout() {
        this.accounts.logout();
    }

    public Account getAccount(){
        return this.accounts.getActive();
    }
}
