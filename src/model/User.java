package model;

import exception.PlaylistNaoEncontrada;

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

    public void createPlaylist(String name) {
        playlists.add(new Playlist(name, this));
    }

    public Playlist searchPlaylistByName(String name)  {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
    }

    public void removePlayListByName(String name) {
        Playlist p = searchPlaylistByName(name);
        playlists.remove(p);
    }

}
