/**
 * This class handles all backend functions for the app
 * 
 * @author Mackenzie Blackaby
 */
public class Backend {
    private double poundsToDirhams = 12;

    public Backend(){

    }

    public double GetDirham(double x){
        return x * poundsToDirhams;
    }

    public double GetPounds(double x){
        return x / poundsToDirhams;
    }
}
