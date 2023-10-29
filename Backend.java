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

    public Backend(){
        currencies = new ArrayList<Currency>();
        for(int i = 0; i < titles.length; i++){
            currencies.add(new Currency(titles[i], symbols[i], dollarTo[i]));
        }
    }

    public int getCurrencySize(){
        return currencies.size();
    }

    public Currency getCurrencyAtIndex(int index){
        return currencies.get(index);
    }

    public ArrayList<Double> getValues(double dollarAmount){
        ArrayList<Double> values = new ArrayList<Double>();
        for (Currency currency : currencies) {
            values.add(currency.getValueFromDollars(dollarAmount));
        }
        return values;
    }
}
