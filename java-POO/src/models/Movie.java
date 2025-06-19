package models;

public class Movie extends Title{
    private int durationInMinutes;

    public Movie(String title, int releaseYear, boolean includedInPlan, int durationInMinutes) {
        super(title, releaseYear, includedInPlan);
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}