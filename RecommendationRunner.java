
/**
 * Write a description of class RecommendationRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class RecommendationRunner implements Recommender 
{
    public ArrayList<String> getItemsToRate (){
        
        ArrayList<String> res = new ArrayList<String>();
        int numToDisplay = 10;
        int minimalRaters = 5;
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        Random rand = new Random();
        
        for(int i = 0; i < numToDisplay; i++){
            int r = rand.nextInt(movies.size());
            String title = movies.get(r);
            if (!res.contains(title)) {
                res.add(title);
            }
        }
        return res;
    }
    public void printRecommendationsFor (String webRaterID){
        
        FourthRatings fr = new FourthRatings();
        ArrayList<Rating> ratings = fr.getSimilarRatings(webRaterID,1,1);
        int length = 10;
        
        if(ratings.size()<10){
            length = ratings.size();
        }
        
        if(ratings.size() == 0){
            int index = 0;
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            Random rand = new Random();
            HashSet <String> titles = new HashSet <String>();
            for(int i =0; i < 10; i++){
                int r = rand.nextInt(movies.size());
                String title = movies.get(r);
                if (ratings.size()!=0 && !titles.contains(title)) {
                    ratings.add(new Rating(title, 5.00));
                    titles.add(title);
                    index++;
                }
                if(index > 10){
                    break;
                }
            }
        }
        
        System.out.println
        (
        "<style>"                                                                         +
        "  body { background-color: #1d1f20; }"                                           +
        "  h2.error { background-color: #ffd700; color: #dc143c; margin: 5; }"            +
        "  #customers, h2 { font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;" +
        "                   border-collapse: collapse; width: 100%;text-align: center;}"  +
        "  #custmers td, #customers th, h2 { border: 1px solid #3e3a3a; padding: 8px;}"   +
        "  #customers tr { background-color: #343537; color: #efefef; }"                  +
        "  #customers tr:nth-child(even) { background-color: #686666; }"                  +
        "  #customers tr:hover { background-color: #ff4444; }"                            +
        "  #customers th { padding-top: 12px; padding-bottom: 12px; text-align: center;"  +
        "                  background-color: #ef040a; color: white; }"                    +
        "  #customers img { height: 50%; }"                                               +
        "  h2 { background-color: #ef040a; }"                                             +
        "</style>"                                                                        +
        "<div class=\"content\">"                                                         +
        "  <div class=\"ui-widget\">"                                                     +
        "   <html>"                                                                       +
        "<h2>BGT Flix - These are some movies you may like</h2>"                          +
        "<table id=\"customers\">"                                                        +
        "  <tr>"                                                                          + 
        "    <th>#</th>"                                                                  +
        "    <th>Poster</th>"                                                             +
        "    <th>Title</th>"                                                              +
        "    <th>Genre</th>"                                                              +
        "    <th>Year</th>"                                                               +
        "    <th>Time</th>"                                                               +
        "  </tr>"                                                                         +
        "  <tr>"                                                                          
        );
        
        for(int i=0; i< length; i++) {
            int num = i+1;
            System.out.println("    <td>"+num+"</td>");
            System.out.println("    <td><img src=");
            System.out.println(     "\""+MovieDatabase.getPoster(ratings.get(i).getItem())+"\"");
            System.out.println(" /> </td>");
            System.out.println("    <td>"+MovieDatabase.getTitle(ratings.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getCountry(ratings.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getYear(ratings.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getMinutes(ratings.get(i).getItem())+" Minutes"+"</td>");
            System.out.println("  </tr>");
        }       
    }
}
