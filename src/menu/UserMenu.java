package menu;

import User.User;
import model.Catalog;
import model.Media;
import model.Playlist;

import java.util.List;
import java.util.Scanner;

public class UserMenu {

        private final User user;
        private final Catalog catalog;
        private final Scanner scanner;

        public UserMenu(User user, Catalog catalog) {
            this.user = user;
            this.catalog = catalog;
            this.scanner = new Scanner(System.in);
        }

        public void start() {
            int option;

            do {
                showMenu();
                option = readInt();

                switch (option) {
                    case 1 -> showCatalog();
                    case 2 -> searchMedia();
                    case 3 -> createPlaylist();
                    case 4 -> addMediaToPlaylist();
                    case 5 -> user.listPlaylists();
                    case 6 -> showPlaylistDuration();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }

            } while (option != 0);
        }

        private void showMenu() {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Ver catálogo");
            System.out.println("2 - Pesquisar mídia");
            System.out.println("3 - Criar playlist");
            System.out.println("4 - Adicionar mídia à playlist");
            System.out.println("5 - Listar playlists");
            System.out.println("6 - Duração da playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
        }

        /* ================= FUNCIONALIDADES ================= */

        private void showCatalog() {
            List<Media> all = catalog.listAll();

            if (all.isEmpty()) {
                System.out.println("Catálogo vazio.");
                return;
            }

            all.forEach(System.out::println);
        }

        private void searchMedia() {
            System.out.print("Digite título, artista ou gênero: ");
            String input = scanner.nextLine();

            List<Media> result = catalog.search(input);

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
            System.out.println("Playlist criada com sucesso.");
        }

        private void addMediaToPlaylist() {
            System.out.print("Nome da playlist: ");
            String playlistName = scanner.nextLine();

            System.out.print("Digite o nome da mídia: ");
            String mediaTitle = scanner.nextLine();

            List<Media> medias = catalog.search(mediaTitle);

            if (medias.isEmpty()) {
                System.out.println("Mídia não encontrada no catálogo.");
                return;
            }

            Media media = medias.get(0); // pega a primeira encontrada
            user.addMediaInPlaylist(playlistName, media);

            System.out.println("Mídia adicionada à playlist.");
        }

        private void showPlaylistDuration() {
            System.out.print("Nome da playlist: ");
            String name = scanner.nextLine();

            Playlist p = user.searchPlaylistByName(name);

            if (p == null) {
                System.out.println("Playlist não encontrada.");
                return;
            }

            System.out.println("Duração total: " + p.totalDuration() + " min");
        }

        /* ================= UTIL ================= */

        private int readInt() {
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Digite um número válido: ");
            }
            int value = scanner.nextInt();
            scanner.nextLine(); // limpar buffer
            return value;
        }
    }


