package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Media> mediaList;
    private User user;

    public Playlist(String nome, User user) {
        this.name = name;
        this.mediaList = new ArrayList<>();
    }


}
