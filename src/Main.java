import User.User;
import menu.MenuStreaming;
import menu.UserMenu;
import model.*;
import system.SystemManager;

public class Main {
    public static void main(String[] args) {
        SystemManager system = new SystemManager();
        Catalog catalog = new Catalog();

        catalog.addMedia(new Music(
                "Back up",
                "Yeat",
                2,
                Genre.TRAP
        ));


        catalog.addMedia(new Music(
                "Sky",
                "Playboi carti",
                2,
                Genre.TRAP
        ));

        catalog.addMedia(new Podcast(
                "Flow Podcast",
                "Igor 3K",
                120,
                Genre.PODCAST
        ));

        catalog.addMedia(new AudioBook(
                "Clean Code",
                "Robert C. Martin",
                480,
                Genre.EDUCATION
        ));
        MenuStreaming menu = new MenuStreaming(system, catalog);
        menu.start();
    }
}

