import java.util.ArrayList;

/**
 * This class handles all backend functions for the app
 * 
 * @author Mackenzie Blackaby
 */
public class Backend {

    private String[] titles = {"American Dollars", "Great British Pounds", "Moroccan Dirhams", "EU Euros"};
    private String[] symbols = {"$",  "£", "MAD ", "€"};
    private double[] dollarTo = {1, 0.82, 10.27, 0.95};
    private ArrayList<Currency> currencies;

    /**
     * The constructor for the backend class
     */
    public Backend(){
        currencies = new ArrayList<Currency>();
        for(int i = 0; i < titles.length; i++){
            currencies.add(new Currency(titles[i], symbols[i], dollarTo[i]));
        }
    }

    /**
     * This returns the amount of currencies currently programmed into this app
     * 
     * @return the amount of currencies registered into this program
     */
    public int getCurrencySize(){
        return currencies.size();
    }

    /**
     * Gets a currency at a given index
     * 
     * @param index the index to get
     * @return Currency type object at the given index
     */
    public Currency getCurrencyAtIndex(int index){
        return currencies.get(index);
    }

    /**
     * Returns the values of each of the currencies from a specified USD amount
     * 
     * 
     * @param dollarAmount the amount in dollars to convert to all currencies
     * @return an ArrayList of all the currencies' converted values
     */
    public ArrayList<Double> getValues(double dollarAmount){
        ArrayList<Double> values = new ArrayList<Double>();
        for (Currency currency : currencies) {
            values.add(currency.getValueFromDollars(dollarAmount));
        }
        return values;
    }
}
