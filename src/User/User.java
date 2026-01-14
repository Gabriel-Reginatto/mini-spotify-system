package User;

import model.Media;
import model.Playlist;

import java.util.ArrayList;
import java.util.Collections;
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
        return Collections.unmodifiableList(playlists);
    }

    public void createPlaylist(String name) {
        playlists.add(new Playlist(name, this));
    }

    public Playlist searchPlaylistByName(String name)  {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        throw new model.PlaylistNaoEncontrada(
                "Playlist não encontrada: " + name
        );
    }

    public void removePlayListByName(String name) {
        Playlist p = searchPlaylistByName(name);
        playlists.remove(p);
    }

    public void listPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
            return;
        }

        for (Playlist p : playlists) {
            System.out.println(p);
        }
    }

    public boolean addMediaInPlaylist(String playlistName, Media m) {
        Playlist p = searchPlaylistByName(playlistName);
        boolean added = p.addMedia(m);
        if (!added) {
            System.out.println("Mídia já existe na playlist: " + m.getTitle());
        }
        return added;
    }

    public boolean removeMediaInPlaylist(String playlistName, Media m) {
        Playlist p = searchPlaylistByName(playlistName);
        boolean removed = p.removeMedia(m);
        if(!removed) {
            System.out.println("Mídia não encontrada na playlist: " + m.getTitle());
        }
        return removed;
    }
}
