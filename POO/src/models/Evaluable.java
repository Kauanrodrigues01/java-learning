package models;

public interface Evaluable {
    void rate(double score);
    double getAverageRating();
    int getTotalRatings();
}
