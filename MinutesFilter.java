
public class MinutesFilter implements Filter
{
    int myMin;
    int myMax;
    
    public MinutesFilter(int min, int max){
        myMin = min;
        myMax = max;
    }
    
    @Override
    public boolean satisfies(String id){
        return MovieDatabase.getMinutes(id) >= myMin && 
                MovieDatabase.getMinutes(id) <= myMax;
    }
}
