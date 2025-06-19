import calculations.Calculator;
import calculations.Classification;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Title> catalog = createCatalog();
        List<Episode> episodes = createEpisodes(catalog);

        displayCatalogDetails(catalog);
        displayEpisodeDetails(episodes);

        calculateTotalWatchTime(catalog);

        classifyEvaluables(catalog);
        classifyEvaluables(episodes);
    }

    private static List<Title> createCatalog() {
        List<Title> catalog = new ArrayList<>();

        Movie movie1 = new Movie("Maverick", 2000, true, 130);
        movie1.rate(4);
        movie1.rate(5);
        catalog.add(movie1);

        Series series1 = new Series("Breaking Bad", 2008, true, 5, 13, 45, false);
        series1.rate(5);
        series1.rate(4.5);
        series1.rate(5);
        catalog.add(series1);

        return catalog;
    }

    private static List<Episode> createEpisodes(List<Title> catalog) {
        List<Episode> episodes = new ArrayList<>();

        for (Title title : catalog) {
            if (title instanceof Series s) {
                Episode ep1 = new Episode(1, "Pilot", s);
                ep1.rate(4.5);
                ep1.rate(5);
                episodes.add(ep1);
            }
        }

        return episodes;
    }

    private static void displayCatalogDetails(List<Title> catalog) {
        System.out.println("==== CATALOG DETAILS ====\n");
        for (Title title : catalog) {
            title.displayTechnicalDetails();

            if (title instanceof Series s) {
                System.out.println("Seasons: " + s.getSeasons());
                System.out.println("Episodes per season: " + s.getEpisodesForSeason());
                System.out.println("Is active: " + (s.isActive() ? "Yes" : "No"));
            }

            System.out.println("----------------------------\n");
        }
    }

    private static void displayEpisodeDetails(List<Episode> episodes) {
        System.out.println("==== EPISODE DETAILS ====\n");
        for (Episode ep : episodes) {
            System.out.println("Episode " + ep.getNumber() + ": " + ep.getTitle());
            System.out.println("From series: " + ep.getSeries().toString());
            System.out.println("Average rating: " + ep.getAverageRating());
            System.out.println("----------------------------\n");
        }
    }

    private static void calculateTotalWatchTime(List<Title> catalog) {
        Calculator calculator = new Calculator();

        for (Title title : catalog) {
            calculator.addTitleTime(title);
        }

        System.out.println("Total marathon time: " + calculator.getTotalTime() + " minutes\n");
    }

    private static void classifyEvaluables(List<? extends Evaluable> list) {
        Classification classification = new Classification();

        for (Evaluable item : list) {
            System.out.println("Classification for: " + item);
            classification.classify(item);
            System.out.println();
        }
    }
}
