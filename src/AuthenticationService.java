import java.util.ArrayList;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    public AuthenticationService() {
        users = new ArrayList<User>();
    }

    @Override
    public User signUp(String username, String password) {
        for (User u : users) {
            if (Objects.equals(u.getUsername(), username)) {
                return null;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return new User(username, password);
            }
        }
        return null;
    }
}