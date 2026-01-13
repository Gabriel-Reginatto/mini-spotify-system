package model;

import java.util.ArrayList;
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
        return mediaList;
    }

    public void addMedia(Media m) {
        mediaList.add(m);
    }

    public void removeMedia(Media m) {
        mediaList.remove(m);
    }

    public double totalDuration() {
        double total = 0;
        for (Media media : mediaList) {
            total += media.getDuration();
        }
        return total;
    }

    public void listTitle() {
        for (Media media : mediaList) {
            System.out.println(media.getTitle());
        }
    }

    public Media searchMedia(String title) throws Exception {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        throw new Exception("Midia não encontrada na playlist");
    }
}
