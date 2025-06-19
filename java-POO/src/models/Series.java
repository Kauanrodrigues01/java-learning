package models;

public class Series extends Title {
    private int seasons;
    private int episodesForSeason;
    private int minutesForEpisode;
    private boolean active;

    public Series(String title, int releaseYear, boolean includedInPlan, int seasons, int episodesForSeason, int minutesForEpisode, boolean active) {
        super(title, releaseYear, includedInPlan);
        this.seasons = seasons;
        this.episodesForSeason = episodesForSeason;
        this.minutesForEpisode = minutesForEpisode;
        this.active = active;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesForSeason() {
        return episodesForSeason;
    }

    public void setEpisodesForSeason(int episodesForSeason) {
        this.episodesForSeason = episodesForSeason;
    }

    public int getMinutesForEpisode() {
        return minutesForEpisode;
    }

    public void setMinutesForEpisode(int minutesForEpisode) {
        this.minutesForEpisode = minutesForEpisode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDurationInMinutes() {
        return (seasons * episodesForSeason * minutesForEpisode);
    }
}