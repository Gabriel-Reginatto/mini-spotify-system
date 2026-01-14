package menu;

import User.User;
import model.Catalog;
import system.SystemManager;

import java.util.List;
import java.util.Scanner;

public class MenuStreaming {

    private final Scanner scanner;
    private final User user;
    private final Catalog catalog;

    public MenuStreaming(User user, Catalog catalog) {
        this.scanner = new Scanner(System.in);
        this.user = user;
        this.catalog = catalog;
    }

    private void showMenu() {

        int option;

        do {
            System.out.println("=== MiniSpotify ===");
            System.out.println("1 - Ver catálogo");
            System.out.println("2 - Pesquisar Mídia");
            System.out.println("3 - Criar playlist");
            System.out.println("4 - Adicionar mídia à playlist");
            System.out.println("5 - Listar playlists");
            System.out.println("6 - Duração da playlist");
            System.out.println("0 - Logout");
            System.out.println("Escolha uma opção: ");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    showCatalog();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    user.listPlaylists();
                    break;
                case 6:

                    break;

                case 0:
                    System.out.println("Logout realizado!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (option != 0);
    }

    private void showCatalog() {
        if (catalog.listAll().isEmpty()) {
            System.out.println("Catálogo vazio.");
            return;
        }
        catalog.listAll().forEach(System.out::println);
    }

    private void searchMediaMenu() {
        System.out.println("Digite para a busca: ");
        String title = scanner.nextLine();

        var results = catalog.search(title);

        if (results.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
            return;
        }
        System.out.println("Resultados: ");
        results.forEach(System.out::println);
    }
}

