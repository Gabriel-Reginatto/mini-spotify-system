package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Playlist> playlists;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome, this));
    }

    public Playlist buscarPlaylist(String nome) throws Exception {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(nome)) return p;
        }
        throw new Exception("Playlist não encontada.");
    }

    public void removerPlayList(Playlist p) {

    }

}
