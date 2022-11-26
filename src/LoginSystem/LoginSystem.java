package LoginSystem;

public class LoginSystem {
    private AccountManager accounts;

    public LoginSystem() {
        this.accounts = new AccountManager();
    }

    public void login(String username, String password) {
        this.accounts.login(username, password);
    }

    public void createAccount(String username, String password) {
        this.accounts.createAccount(username, password);
    }
}
