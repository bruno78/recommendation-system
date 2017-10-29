
/**
 * Write a description of class MovieRunnerWithFilters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerWithFilters
{
    public void printAverageRatings(){
        // ratings_short.csv
        String moviefile = "ratedmovies_short.csv";
        // ratings.csv
        // ratedmoviesfull.csv

        ThirdRatings tr = new ThirdRatings("ratings_short.csv");
        MovieDatabase.initialize(moviefile);
        ArrayList<Rating> ratedMovieList = tr.getAverageRatings(1);
        Collections.sort(ratedMovieList);        
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedMovieList.size() + " movies");
        
        for (Rating rm : ratedMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            
            System.out.println(avgRating + " " + movieTitle);
        }
        
    }
    /*
    public void getAverageRatingsOneMovie(){
        //ThirdRatings sr = new ThirdRatings("ratedmovies_short.csv", "ratings_short.csv");
        ThirdRatings sr = new ThirdRatings();
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
    */
}
