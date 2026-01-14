package system;

import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public User getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException(
                    "Email não pode ser nulo."
            );
        }
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public User login(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email inválido."
            );
        }
        User user = getUserByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException(
                    "Usuário não encontrado."
            );
        }
        return user;
    }
}

