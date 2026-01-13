package model;

public abstract class Media {
    private String title;
    private String creator;
    private int duration;
    private Genre genre;

    public Media(String title, String creator, int duration, Genre genre) {
        this.title = title;
        this.creator = creator;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " - " +
                creator + " - " +
                duration + " - " +
                genre;
    }
}


