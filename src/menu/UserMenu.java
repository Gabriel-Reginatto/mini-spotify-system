package menu;

import model.Catalog;
import model.Media;
import model.Playlist;
import User.User;

import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private final User user;
    private final Catalog catalog;
    private final Scanner scanner = new Scanner(System.in);

    public UserMenu(User user, Catalog catalog) {
        this.user = user;
        this.catalog = catalog;
    }

    public void start() {
        int option;

        do {
            System.out.println("\n=== MENU DO USUÁRIO ===");
            System.out.println("1 - Ver catálogo");
            System.out.println("2 - Pesquisar mídia");
            System.out.println("3 - Criar playlist");
            System.out.println("4 - Adicionar mídia à playlist");
            System.out.println("5 - Remover mídia da playlist");
            System.out.println("6 - Listar playlists");
            System.out.println("7 - Ver duração de uma playlist");
            System.out.println("0 - Logout");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> showCatalog();
                case 2 -> searchMedia();
                case 3 -> createPlaylist();
                case 4 -> addMediaToPlaylist();
                case 5 -> removeMediaFromPlaylist();
                case 6 -> user.listPlaylists();
                case 7 -> showPlaylistDuration();
                case 0 -> System.out.println("Logout realizado.");
                default -> System.out.println("Opção inválida.");
            }

        } while (option != 0);
    }

    // ================= MÉTODOS =================

    private void showCatalog() {
        List<Media> medias = catalog.listAll();

        if (medias.isEmpty()) {
            System.out.println("Catálogo vazio.");
            return;
        }

        medias.forEach(System.out::println);
    }

    private void searchMedia() {
        System.out.print("Digite o termo de busca: ");
        String term = scanner.nextLine();

        List<Media> result = catalog.search(term);

        if (result.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
            return;
        }

        result.forEach(System.out::println);
    }

    private void createPlaylist() {
        System.out.print("Nome da playlist: ");
        String name = scanner.nextLine();

        user.createPlaylist(name);
        System.out.println("Playlist criada com sucesso!");
    }

    private void addMediaToPlaylist() {
        System.out.print("Nome da playlist: ");
        String playlistName = scanner.nextLine();

        System.out.print("Título da mídia: ");
        String mediaTitle = scanner.nextLine();

        Media media = catalog.searchByTitle(mediaTitle);

        if (media == null) {
            System.out.println("Mídia não encontrada no catálogo.");
            return;
        }

        user.addMediaInPlaylist(playlistName, media);
        System.out.println("Mídia adicionada à playlist!");
    }

    private void removeMediaFromPlaylist() {
        System.out.print("Nome da playlist: ");
        String playlistName = scanner.nextLine();

        System.out.print("Título da mídia: ");
        String mediaTitle = scanner.nextLine();

        Media media = catalog.searchByTitle(mediaTitle);

        if (media == null) {
            System.out.println("Mídia não encontrada no catálogo.");
            return;
        }

        user.removeMediaInPlaylist(playlistName, media);
        System.out.println("Mídia removida da playlist!");
    }

    private void showPlaylistDuration() {
        System.out.print("Nome da playlist: ");
        String name = scanner.nextLine();

        Playlist p = user.searchPlaylistByName(name);

        System.out.printf("Duração total: %.2f minutos%n", p.totalDuration());
    }
}
