
/**
 * Write a description of class FourthRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class FourthRatings
{
    public FourthRatings() {
        this("ratings.csv");
    }
    
    public FourthRatings(String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        RaterDatabase.addRatings(ratingsfile);
    }
    
    private double getAverageByID(String id, int minimalRaters){
        double count = 0.0;
        double sum = 0.0;
        
        for(Rater r : RaterDatabase.getRaters()){
            if(r.hasRating(id)) {
                sum += r.getRating(id);
                count ++;
            }
        }
        return (count >= minimalRaters) ? (double)(sum/count) : 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings( int minimalRaters) {
        ArrayList<Rating> averageRatings = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        
        for (String movieID : movies) {
            double rating = getAverageByID(movieID, minimalRaters);
            Rating movieAvgRate = new Rating(movieID, rating);
            
            if(rating != 0){
                averageRatings.add(movieAvgRate);
            }    
        }
        return averageRatings;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, 
                                                       Filter filterCriteria){
        ArrayList<Rating> avgRatingsByFilter = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        
        for (String movieID : movies){
            double rating = getAverageByID(movieID, minimalRaters);
            Rating movieAvgRate = new Rating(movieID, rating);
            
            if(rating != 0){
                avgRatingsByFilter.add(movieAvgRate);
            }
        }
        return avgRatingsByFilter;
    }
    
    private dotProduct(Rater me, Rater r){
    }
}
