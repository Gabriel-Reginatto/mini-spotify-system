package system;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {

    private List<User> users = new ArrayList<>();

    public void registerUser(String name, String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (emailExists(email)) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        users.add(new User(name, email));
    }

    public User login(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    private boolean emailExists(String email) {
        return users.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }
}
