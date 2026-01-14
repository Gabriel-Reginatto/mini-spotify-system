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

    public List<Media> search(String title, String creator, Genre genre) {
        return mediaList.stream()
                .filter(m -> (title == null || m.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                                    (creator == null || m.getCreator().toLowerCase().contains(creator.toLowerCase())) &&
                                    (genre == null || m.getGenre() == genre))
                .collect(Collectors.toList());
    }

    public List<Media> search(String term) {
        return search(term, term, null);
    }

    public List<Media> listAll() {
        if (mediaList.isEmpty()) {
            System.out.println("Catálogo vazio.");
        }
        return new ArrayList<>(mediaList);
    }

    public Media searchByTitle(String title) {
        return mediaList.stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }


}

