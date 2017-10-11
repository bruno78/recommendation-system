
/**
 * Write a description of class FirstRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings
{
    
    public ArrayList<Movie> loadMovies(String fileName){
        
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        FileResource fr = new FileResource("./data/" + fileName);
        CSVParser movieData = fr.getCSVParser();
        
        for(CSVRecord movieEntry: movieData){

            Movie movie = new Movie(
                movieEntry.get("id"),
                movieEntry.get("title"),
                movieEntry.get("year"),
                movieEntry.get("genre"), 
                movieEntry.get("director"),
                movieEntry.get("country"),
                movieEntry.get("poster"),
                Integer.parseInt(movieEntry.get("minutes"))
            );
            
            movieList.add(movie);
        }
       
        return movieList;
    }
    
    
    public ArrayList<Rater> loadRaters(String fileName){
        
        ArrayList<Rater> movieRaterList = new ArrayList<Rater>();
        FileResource fr = new FileResource("./data/" + fileName);
        CSVParser raterData = fr.getCSVParser();
        
        for (CSVRecord raterEntry : raterData) {
            
            if(movieRaterList.size() == 0) {
                Rater rater = new Rater(raterEntry.get("rater_id"));
                rater.addRating(raterEntry.get("movie_id"),
                                Double.parseDouble(raterEntry.get("rating")));
                
                movieRaterList.add(rater);
            }
            else {
                
                String id = raterEntry.get("rater_id");
                boolean found = false;
                
                for (int i = 0; i < movieRaterList.size(); i++) {
                    Rater rater = movieRaterList.get(i);
                    
                    if (rater.getID().equals(id)){
                        rater.addRating(raterEntry.get("movie_id"),
                                Double.parseDouble(raterEntry.get("rating")));
                        found = true;
                    }
                }
                
                if (!found) {
                    Rater rater = new Rater(raterEntry.get("rater_id"));
                    rater.addRating(raterEntry.get("movie_id"),
                                    Double.parseDouble(raterEntry.get("rating")));
                
                    movieRaterList.add(rater);
                }
            }       
        } 
        
        return movieRaterList;
    }
    
    
    
    public void testLoadMovies(){
        int comedyCount = 0;
        int longMovies = 0;
        int moviePerDirector = 0;

        // ArrayList<Movie> movieDataFull = loadMovies("ratedmoviesfull.csv");
         ArrayList<Movie> movieDataFull = loadMovies("ratedmovies_short2.csv");
        HashMap<String, Integer> directorsMovies = new HashMap<String, Integer>();
        
 
        for (Movie movie : movieDataFull){
            String[] directors = movie.getDirector().split(",");
            
            if(directors.length == 1){
                moviePerDirector ++;
            }
            
            if(movie.getGenres().indexOf("Comedy") != -1) {
                comedyCount ++;
            }
            if(movie.getMinutes() > 150){
                longMovies ++;
            }
            
            // Inserting movies into a Hashmap
            for(int i = 0; i < directors.length; i++){
                String director = directors[i].trim();
                
                if (directorsMovies.containsKey(director)) {
                    directorsMovies.put(director, directorsMovies.get(director) + 1);
                }
                else {
                    directorsMovies.put(director, 1);
                }
            }
            
        }
        
        int maxValue = 0;
        int oneMovie = 0;
        for (String director : directorsMovies.keySet()){
            int currValue = directorsMovies.get(director);
            if(currValue == 1){
                oneMovie ++;
            }
            if (currValue > maxValue){
                maxValue = currValue;
            }
            // System.out.println("director: " + director + 
            //                   ", movies directed: " + directorsMovies.get(director) + "\n");
            
        }
        
        for (String director : directorsMovies.keySet()){
            if(directorsMovies.get(director) == maxValue){
                System.out.println("Director with higher number of movies: " + director);
            }
        }
        
        System.out.println(movieDataFull.size());
        System.out.println("Number of movies include the Comedy genre: " + comedyCount);
        System.out.println("Number of movies longer than 150 min: " + longMovies);    
        System.out.println("Maxinum Number of films directed by one director: " + moviePerDirector);
    }
    
    
    public void testLoadRaters() {
        // ArrayList<Rater> raterData = loadRaters("ratings_short.csv");
        ArrayList<Rater> raterData = loadRaters("ratings.csv");
        //ArrayList<Rater> raterData = loadRaters("ratedmoviesfull.csv");
        int maxRatings = 0;
        //String id = "2";
        String id = "193";
        int ratingsPerMovie = 0;
        String movieId = "1798709";
        ArrayList<String> totalMovies = new ArrayList<String>();
        /*
        for (Rater r : raterData){ 
            ArrayList<String> itemsList = r.getItemsRated();
            
            System.out.println("Id: " + r.getID() + " number of ratings: " + r.numRatings());
            
            for (String item : itemsList){
                System.out.println("List of rated items: " + item + ": " + r.getRating(item));
            }
            System.out.println("\n");
        }
        */
        System.out.println("Total raters: " + raterData.size()); 
        
        for (Rater r : raterData){
            if(r.getID().equals(id)) {
                 System.out.println("Number of ratings for user " + id + ": " + r.numRatings()); 
            }
        }
        
        for (Rater r : raterData){
            int currRatings = r.numRatings();
            if(currRatings > maxRatings){
                maxRatings = currRatings;
            }
        }
        System.out.println("Maximum number of ratings: " + maxRatings);
        for (Rater r : raterData) {
            if(r.numRatings() == maxRatings) {
                System.out.println("User with maximum ratings: " + r.getID());
            }
        }
       
        for (Rater r : raterData){ 
            ArrayList<String> itemsList = r.getItemsRated();
       
            for (String item : itemsList){
                if(item.equals(movieId)) {
                    ratingsPerMovie ++;
                }
            }
        }
        System.out.println("Total of ratings for movieID: " + movieId + " :" + ratingsPerMovie);
        
        for (Rater r : raterData) {
            ArrayList<String> itemsList = r.getItemsRated();
       
            for (String item : itemsList){
                if(!totalMovies.contains(item)) {
                    totalMovies.add(item);
                }
            }
        }
        System.out.println("Total movies rated by all raters: " + totalMovies.size());
    }
}