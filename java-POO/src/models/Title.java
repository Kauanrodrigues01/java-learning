package models;

import java.util.ArrayList;
import java.util.List;

abstract public class Title implements Evaluable {
    private String title;
    private int releaseYear;
    private boolean includedInPlan;
    private final List<Double> ratings = new ArrayList<>();

    @Override
    public String toString() {
        return title;
    }

    public Title(String title, int releaseYear, boolean includedInPlan) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.includedInPlan = includedInPlan;
    }

    public void displayTechnicalDetails() {
        System.out.println("Title: " + title);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Included in plan: " + includedInPlan);
        System.out.println("Rating: " + getAverageRating());
        System.out.println("Total ratings: " + getTotalRatings());
    }

    public void rate(double score) {
        if (score >= 0 && score <= 5) {
            ratings.add(score);
        } else {
            System.out.println("Invalid rating, please enter a number between 0 and 5");
        }
    }

    public double getAverageRating() {
        double totalScore = ratings.stream().mapToDouble(Double::doubleValue).sum();
        int totalRatings = getTotalRatings();

        return totalRatings > 0 ? (totalScore / totalRatings) : 0;
    }

    public int getTotalRatings() {
        return ratings.size();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncMovieludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    abstract public int getDurationInMinutes();
}
