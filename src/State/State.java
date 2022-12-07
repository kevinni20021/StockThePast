package State;


/**
 * This is the interface responsible for the state design pattern
 */
public interface State {

    /**
     * This method is used for getting the username and password of the user
     * @param username
     * @param password
     */
    void getUser(String username, String password);


    /**
     * This is a getter method to get the state of the current page
     * @return the current state
     */
    String getState();
}
