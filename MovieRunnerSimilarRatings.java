
/**
 * Write a description of class MovieRunnerSimilarRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerSimilarRatings
{
    public void printAverageRatings(){
        // ratings_short.csv
        String moviefile = "ratedmoviesfull.csv";
        // ratings.csv
        // ratedmoviesfull.csv

        FourthRatings tr = new FourthRatings("data/ratings.csv");
        MovieDatabase.initialize(moviefile);
        ArrayList<Rating> ratedMovieList = tr.getAverageRatings(35);
        Collections.sort(ratedMovieList);        
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedMovieList.size() + " movies");
        
        for (Rating rm : ratedMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            
            System.out.println(avgRating + " " + movieTitle);
        }
        
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        String moviefile = "ratedmoviesfull.csv";
        FourthRatings tr = new FourthRatings("data/ratings.csv");
        MovieDatabase.initialize(moviefile);
        
        YearAfterFilter yaf = new YearAfterFilter(1990);
        GenreFilter gf = new GenreFilter("Drama");
        AllFilters YearGenre = new AllFilters();
        YearGenre.addFilter(yaf);
        YearGenre.addFilter(gf);
        
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(8, YearGenre);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratedFilteredMovieList.size() + " movie(s) matched");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            String genres = MovieDatabase.getGenres(rm.getItem());
            int year = MovieDatabase.getYear(rm.getItem());
            
            System.out.println(avgRating + " " + year + " " + movieTitle + "\n" +
                               "\t" + genres);
        }
    }
    
    
}
