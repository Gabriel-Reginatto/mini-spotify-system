package model;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private String name;
    private List<Media> mediaList;
    private User user;

    public Playlist(String name, User user) {
        this.name = name;
        this.user = user;
        this.mediaList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public List<Media> getMediaList() {
        return Collections.unmodifiableList(mediaList);
    }

    public boolean addMedia(Media m) {
        if (m == null) {
            throw new IllegalArgumentException("Media não pode ser nula");
        } else if (!mediaList.contains(m)) {
            mediaList.add(m);
            return true;
        }
        return false;
    }

    public boolean removeMedia(Media m) {
        if (m == null) {
            throw new IllegalArgumentException("Média não pode ser nula");
        }
        return mediaList.remove(m);
    }

    public double totalDuration() {
        double total = 0;
        for (Media media : mediaList) {
            total += media.getDuration();
        }
        return total;
    }

    public List<String> listTitle() {
        List<String> titles = new ArrayList<>();
        for (Media media : mediaList) {
            titles.add(media.getTitle());
        }
        return titles;
    }

    public Media searchMedia(String title) throws Exception {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        throw new Exception(
                "Mídia não encontrada na playlist!"
        );
    }

    public int countMediaByGenre(Genre g) {
        int count = 0;
        for (Media media : mediaList) {
            if (media.getGenre() == g)
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Duração total: %.2f min", name, totalDuration());

    }
}
