package models;

import java.util.ArrayList;
import java.util.List;

public class Episode implements Evaluable {
    private int number;
    private String title;
    private Series series;
    private List<Double> ratings = new ArrayList<Double>();

    public Episode(int number, String title, Series series) {
        this.number = number;
        this.title = title;
        this.series = series;
    }

    public String toString() {
        return title + ", Episode by " + series.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public void rate(double score) {
        if (score >= 0 && score <= 5) {
            ratings.add(score);
        } else {
            System.out.println("Invalid rating, please enter a number between 0 and 5");
        }
    }

    @Override
    public double getAverageRating() {
        int totalRatings = getTotalRatings();
        double sumRatings = ratings.stream().mapToDouble(Double::doubleValue).sum();
        return (totalRatings > 0) ? sumRatings / totalRatings : 0;
    }

    @Override
    public int getTotalRatings() {
        return ratings.size();
    }
}
