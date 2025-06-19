package calculations;

import models.Evaluable;

public class Classification {
    public void classify(Evaluable evaluable) {
        double averageRatings = evaluable.getAverageRating();
        if (averageRatings > 4) {
            System.out.println("It is among the favorites of the moment");
        } else if (averageRatings > 3) {
            System.out.println("Well classified");
        } else if (averageRatings > 2) {
            System.out.println("It is among the moment");
        } else {
            System.out.println("Bad!");
        }
    }
}
