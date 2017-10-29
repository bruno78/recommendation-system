
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
        // SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        SecondRatings sr = new SecondRatings();
        System.out.println(sr.getMovieSize());
        System.out.println(sr.getRaterSize());
        ArrayList<Rating> ratedMovieList = sr.getAverageRatings(12);
        Collections.sort(ratedMovieList);
        int count = 0;
        for (Rating rm : ratedMovieList){
            String movieTitle = sr.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            
            System.out.println(avgRating + " " + movieTitle);
            count ++;
        }
        System.out.println("Total movies: " + count);
    }
    
    public void getAverageRatingsOneMovie(){
        //SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        SecondRatings sr = new SecondRatings();
        ArrayList<Rating> avgList = sr.getAverageRatings(3);
        // String movieTitle = "The Godfather";
        // String movieTitle = "No Country for Old Men";
        // String movieTitle = "Inside Llewyn Davis";
        String movieTitle = "The Maze Runner";
        String movieTitle1 = "Moneyball";
        String movieTitle2 = "Vacation";
        String id = sr.getId(movieTitle2);
        
        for (Rating r : avgList){
            if(r.getItem().equals(id)){
                System.out.println(movieTitle2 + " " + r.getValue());
            }

            
        }
    }
}
