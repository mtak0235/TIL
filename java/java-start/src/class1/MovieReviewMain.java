package class1;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview []movieReview = new MovieReview[] {new MovieReview(), new MovieReview()};
        movieReview[0].title = "snow white and a hunts man";
        movieReview[0].contents = "gorgeous queen with her opposites";
        movieReview[1].title = "about time";
        movieReview[1].contents = "infinite loop on life";
        for (MovieReview review : movieReview) {
            System.out.println(review);
        }
    }
}
