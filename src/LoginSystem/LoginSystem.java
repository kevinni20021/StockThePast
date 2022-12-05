package LoginSystem;

public class LoginSystem {
    private AccountManager accounts;

    public LoginSystem() {
        this.accounts = new AccountManager();
    }

    public Account login(String username, String password) {
        switch (this.accounts.login(username, password)) {
            case 0 -> {
                System.out.println("Login Successful");
                return this.accounts.getActive();
            }
            case 1 -> System.out.println("Already logged in");
            case 2 -> System.out.println("Incorrect username or password");
            case 3 -> System.out.println("User not in system, please create a new account");
            default -> System.out.println("Error with login, contact administrator");
        }
        return null;
    }

    public void createAccount(String username, String password) {
        this.accounts.createAccount(username, password);
    }

    public void logout() {
        this.accounts.logout();
    }
}
