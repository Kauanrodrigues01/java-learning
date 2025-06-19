package models;


abstract public class Audio {
    private String title;
    private int totalReproductions = 0;
    private int totalLikes = 0;

    public Audio(String title) {
        this.title = title;
    }

    public void like() {
        totalLikes++;
    }

    public void reproduce() {
        totalReproductions++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalReproductions() {
        return totalReproductions;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getClassification() {
        if (totalLikes > (totalReproductions / 3)) {
            return 10;
        } else {
            return 7;
        }
    }

    abstract public void displayInfo();
}
