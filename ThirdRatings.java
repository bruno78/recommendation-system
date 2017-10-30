
/**
 * Write a description of class thirdRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class ThirdRatings
{

    private ArrayList<EfficientRater> myRaters;
    
    public ThirdRatings() {
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    public int getRaterSize() {
        return myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters){
        double count = 0.0;
        double sum = 0.0;
        
        for(EfficientRater r : myRaters){
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
    
    

}