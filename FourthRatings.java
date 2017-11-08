
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
        RaterDatabase.addRatings("data/" + ratingsfile);
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
    
    private double dotProduct(Rater me, Rater r){
        // translate ratings from (0 to 10) to (-5 to 5)
        double dotProduct = 0;
        ArrayList<String> myRatedMovies = me.getItemsRated();
        for (String id : myRatedMovies) {
            if (r.hasRating(id)) {
                double myRating = me.getRating(id);
                double rRating = r.getRating(id);
                myRating -= 5;
                rRating -= 5;
                dotProduct += myRating * rRating;
            }
        }
        return dotProduct;
    }
    
    private ArrayList<Rating> getSimilarities(String id) {
        
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for (Rater r : RaterDatabase.getRaters()){
            if (id != r.getID()) {
                Rating rater = new Rating(r.getID(), dotProduct(me, r));
                list.add(rater);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
    
    public ArrayList<Rating> getSimilarRatings( String id, 
                                                int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> ret = new ArrayList<Rating>();
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        
        for (String movieID : movies){
            double weightedAverage = 0;
            double sum = 0;
            int countRaters = 0;
            
            for(int k=0; k < numSimilarRaters; k++){
                Rating r = list.get(k);
                double weidht = r.getValue();
                String raterID = r.getItem();
                Rater myRater = RaterDatabase.getRater(raterID);
                if(myRater.hasRating(movieID)) {
                    countRaters ++;
                    sum += weight * myRater.getRating(movieID);
                }
                
            }
        } 
        return ret;
    }
}
