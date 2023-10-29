/**
 * A class to hold data about a specific currency
 *
 * @author Mackenzie Blackaby
 */
public class Currency {
    private String title;
    private String symbol;
    private double toDollar;

    /**
     * The constructor for the class
     *  
     * @param title the name/title of the currency
     * @param symbol the symbol that goes in front of the amount
     * @param toDollar the conversion rate of how much of this currency equals 1 USD
     */
    public Currency(String title, String symbol, double toDollar){
        this.title = title;
        this.symbol = symbol;
        this.toDollar = toDollar;
    }

    /**
     * Returns title
     * @return the title
     */
    public String getTitle(){
        return title;
    }

    /**
     * Returns symbol
     * @return the symbol
     */
    public String getSymbol(){
        return symbol;
    }

    /**
     * Gets an amount of this currency from a specified number of USD
     * 
     * @param dollars the amount of dollars to convert from
     * @return the amount of this currency that is the same value as the dollars parameter
     */
    public double getValueFromDollars(double dollars){
        return dollars * toDollar;
    }

    /**
     * Gets an amount of dollars from a specified number of this currency
     * 
     * @param thisAmount the amount of this currency to convert to dollars
     * @return the amount of dollars converted from this currency 
     */
    public double getValueToDollars(double thisAmount){
        return thisAmount / toDollar;
    }
}
