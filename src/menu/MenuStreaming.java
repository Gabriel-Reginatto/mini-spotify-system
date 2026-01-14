package menu;

import User.User;
import model.Catalog;
import system.SystemManager;

import java.util.Scanner;

public class MenuStreaming {

    private final SystemManager system;
    private final Catalog catalog;
    private final Scanner scanner = new Scanner(System.in);

    public MenuStreaming(SystemManager system, Catalog catalog) {
        this.system = system;
        this.catalog = catalog;
    }

    public void start() {
        int option;

        do {
            System.out.println("\n=== MINI SPOTIFY ===");
            System.out.println("1 - Registrar");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> register();
                case 2 -> login();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (option != 0);
    }

    private void register() {
        try {
            System.out.print("Nome: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            system.registerUser(name, email);
            System.out.println("Usuário registrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        User user = system.login(email);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Login realizado com sucesso!");

        UserMenu userMenu = new UserMenu(user, catalog);
        userMenu.start();
    }
}
