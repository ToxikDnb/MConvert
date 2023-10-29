public class Currency {
    private String title;
    private String symbol;
    private double toDollar;

    public Currency(String title, String symbol, double toDollar){
        this.title = title;
        this.symbol = symbol;
        this.toDollar = toDollar;
    }

    public String getTitle(){
        return title;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getValueFromDollars(double dollars){
        return dollars * toDollar;
    }

    public double getValueToDollars(double thisAmount){
        return thisAmount / toDollar;
    }
}
