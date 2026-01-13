package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private List<Media> mediaList;

    public Catalog() {
        this.mediaList = new ArrayList<>();
    }

    public boolean addMedia(Media m) {
        if (m == null) {
            throw new IllegalArgumentException(
                    "Mídia não pode ser nula."
            );
        } else if (!mediaList.contains(m)) {
            mediaList.add(m);
            return true;
        }
        return false;
    }

    public boolean removeMedia(Media m) {
        if (m == null) {
            throw new IllegalArgumentException(
                    "Mídia não pode ser nula."
            );
        }
        return mediaList.remove(m);
    }

    public List<Media> getMediaList() {
        return new ArrayList<>(mediaList);
    }

    public List<Media> searchByTitle(String title) {
        return mediaList.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Media> searchByCreator(String creator) {
        return mediaList.stream()
                .filter(m -> m.getCreator().toLowerCase().contains(creator.toLowerCase()))
                .collect(Collectors.toList());
    }

}
