
/**
 * Write a description of class MovieRunnerAverage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
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
        ArrayList<Rating> ratedMovieList = sr.getAverageRatings(3);
        
        for (Rating rm : ratedMovieList){
            String movieTitle = sr.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            
            System.out.println(avgRating + " " + movieTitle);
            
        }
    }
    
    public void getAverageRatingsOneMovie(){
        SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        ArrayList<Rating> avgList = sr.getAverageRatings(3);
        for (Rating r : avgList){
            
        }
    }
}
