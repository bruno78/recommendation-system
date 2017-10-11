
/**
 * Write a description of class MovieRunnerAverage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovieRunnerAverage
{
    public void printAverageRatings(){
        // ratings_short.csv
        // ratedmovies_short.csv
        // ratings.csv
        // ratedmoviesfull.csv
        SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        System.out.println(sr.getMovieSize());
        System.out.println(sr.getRaterSize());
    }
}
