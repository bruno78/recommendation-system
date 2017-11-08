
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

        FourthRatings tr = new FourthRatings("ratings.csv");
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
    
    public void printSimilarRatings(){
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";
        String id = "71";
        int minimalRaters = 5;
        int similarRaters = 20;
        
        FourthRatings fr = new FourthRatings(ratingsFile);
        MovieDatabase.initialize(movieFile);
        ArrayList<Rating> ratings = fr.getSimilarRatings(id, similarRaters, minimalRaters);
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratings.size() + " movie(s) matched");
        
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i).getValue() + " " + MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
    
    public void printSimilarRatingsByGenre(){
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";
        String id = "964";
        int minimalRaters = 5;
        int similarRaters = 20;
        GenreFilter genreFilter = 
        new GenreFilter("Mystery");
        
        FourthRatings fr = new FourthRatings(ratingsFile);
        MovieDatabase.initialize(movieFile);
        
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, similarRaters, 
                                     minimalRaters, genreFilter);
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratings.size() + " movie(s) matched");
        
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i).getValue() + " " + MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
    
    public void printSimilarRatingsByDirector(){
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";
        String id = "120";
        int minimalRaters = 2;
        int similarRaters = 10;
        DirectorsFilter directorFilter = 
        new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        
        FourthRatings fr = new FourthRatings(ratingsFile);
        MovieDatabase.initialize(movieFile);
        
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, similarRaters, 
                                     minimalRaters, directorFilter);
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratings.size() + " movie(s) matched");
        
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i).getValue() + " " + MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
    
    public void printSimilarRatingsByGenreAndMinutes(){
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";
        String id = "168";
        int minimalRaters = 3;
        int similarRaters = 10;
        
        GenreFilter genreFilter = new GenreFilter("Drama");
        MinutesFilter minutesFilter = new MinutesFilter(80, 160);
        AllFilters genreAndMinutesFilters = new AllFilters();
        genreAndMinutesFilters.addFilter(genreFilter);
        genreAndMinutesFilters.addFilter(minutesFilter);
        
        FourthRatings fr = new FourthRatings(ratingsFile);
        MovieDatabase.initialize(movieFile);
        
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, similarRaters, 
                                     minimalRaters, genreAndMinutesFilters);
        
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratings.size() + " movie(s) matched");
        
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i).getValue() + " " + MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
                                                        
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes(){
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";
        String id = "314";
        int minimalRaters = 5;
        int similarRaters = 10;
        
        YearAfterFilter yearAfterFilter = new YearAfterFilter(1975);
        MinutesFilter minutesFilter = new MinutesFilter(70, 200);
        AllFilters yearAndMinutesFilters = new AllFilters();
        yearAndMinutesFilters.addFilter(yearAfterFilter);
        yearAndMinutesFilters.addFilter(minutesFilter);
        
        FourthRatings fr = new FourthRatings(ratingsFile);
        MovieDatabase.initialize(movieFile);
        
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, similarRaters, 
                                     minimalRaters, yearAndMinutesFilters);
                                     
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratings.size() + " movie(s) matched");
        
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println(ratings.get(i).getValue() + " " + MovieDatabase.getTitle(ratings.get(i).getItem()));
        }
    }
}
