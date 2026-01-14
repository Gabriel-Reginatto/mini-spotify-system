package system;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private List<User> users;

    public SystemManager() {
        this.users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        boolean exists = users.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));
        if (exists) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }
        return users.add(user);
    }

}
