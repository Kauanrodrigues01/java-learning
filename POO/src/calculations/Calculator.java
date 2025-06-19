package calculations;

import models.Title;

public class Calculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void addTitleTime(Title movie) {
        totalTime += movie.getDurationInMinutes();
    }

    public void removeTitleTime(Title movie) {
        totalTime -= movie.getDurationInMinutes();
    }
}
