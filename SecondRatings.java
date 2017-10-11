
/**
 * Write a description of class SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    public int getMovieSize() {
        return myMovies.size();
    }
    
    public int getRaterSize() {
        return myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters){
        double count = 0.0;
        double sum = 0.0;
        
        for(Rater r : myRaters){
            if(r.hasRating(id)) {
                sum += r.getRating(id);
                count ++;
            }
        }
        return (count >= minimalRaters) ? (double)(sum/count) : 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings( int minimalRaters) {
        ArrayList<Rating> averageRatings = new ArrayList<Rating>();
        
        for (Movie m : myMovies) {
            String id = m.getID();
            double rating = getAverageByID(id, minimalRaters);
            Rating movieAvgRate = new Rating(id, rating);
            
            if(rating != 0){
                averageRatings.add(movieAvgRate);
            }    
        }
        return averageRatings;
    }
    
    public String getTitle(String id){
        for (Movie m : myMovies){
            if(m.getID().equals(id)){
                return m.getTitle();
            }
        }
        return "Movie with ID " + id + " not found";
    }
    
    public String getID(String movieTitle){
        for (Movie m : myMovies){
            if(m.getTitle().equals(movieTitle)){
                return m.getID();
            }
        }
        return "NO SUCH TITLE";
    }
}