
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
        String moviefile = "ratedmoviesfull.csv";
        // ratings.csv
        // ratedmoviesfull.csv

        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        ArrayList<Rating> ratedMovieList = tr.getAverageRatings(35);
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
    
    public void printAverageRatingsByYear(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        YearAfterFilter yaf = new YearAfterFilter(2000);
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(20, yaf);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedFilteredMovieList.size() + " movies");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            int year = MovieDatabase.getYear(rm.getItem());
            
            System.out.println(avgRating + " " + year + " " + movieTitle);
        }
        
    }
    
    public void printAverageRatingsByGenre(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        GenreFilter genreFilter = new GenreFilter("Comedy");
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(20, genreFilter);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedFilteredMovieList.size() + " movies");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            String genres = MovieDatabase.getGenres(rm.getItem());
            
            System.out.println(avgRating + " " + movieTitle + "\n" +
                               "\t" + genres);
        }
    }
    
    public void printAverageRatingsByMinutes(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        MinutesFilter minutesFilter = new MinutesFilter(105, 135);
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(5, minutesFilter);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedFilteredMovieList.size() + " movies");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            int time = MovieDatabase.getMinutes(rm.getItem());
            
            System.out.println(avgRating + " Time: " + time + " " + movieTitle);
        }
    }
    
    public void printAverageRatingsByDirectors(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        DirectorsFilter directorsFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(4, directorsFilter);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("found " + ratedFilteredMovieList.size() + " movies");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            String directors = MovieDatabase.getDirector(rm.getItem());
            
            System.out.println(avgRating + " " + movieTitle + "\n" +
                               "\t" + directors);
        }
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        
        YearAfterFilter yaf = new YearAfterFilter(1990);
        GenreFilter gf = new GenreFilter("Drama");
        AllFilters YearGenre = new AllFilters();
        YearGenre.addFilter(yaf);
        YearGenre.addFilter(gf);
        
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(8, YearGenre);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
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
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        String moviefile = "ratedmoviesfull.csv";
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize(moviefile);
        
        MinutesFilter mf = new MinutesFilter(90, 180);
        DirectorsFilter df = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        AllFilters directorMinutes = new AllFilters();
        directorMinutes.addFilter(mf);
        directorMinutes.addFilter(df);
        
        ArrayList<Rating> ratedFilteredMovieList = tr.getAverageRatingsByFilter(3, directorMinutes);
        Collections.sort(ratedFilteredMovieList);
        
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println(ratedFilteredMovieList.size() + " movie(s) matched");
        
        for (Rating rm : ratedFilteredMovieList){
            String movieTitle = MovieDatabase.getTitle(rm.getItem());
            Double avgRating = rm.getValue();
            String directors = MovieDatabase.getDirector(rm.getItem());
            int time = MovieDatabase.getMinutes(rm.getItem());
            
            System.out.println(avgRating + " time: " + time + " " + movieTitle + "\n" +
                               "\t" + directors);
        }
    }
}
