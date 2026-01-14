package model;

public class Music extends Media {
    public Music(String title, String creator, double duration, Genre genre) {
        super(title, creator, (int) duration, genre);
    }
}
