import javax.swing.JTextField;

/**
 * A class to specify a text input field for a given currency
 * 
 * @author Mackenzie Blackaby
 */
public class JCurrencyField extends JTextField{

    private Currency currency;

    /**
     * Gets the title of the currency
     * @return the title of the attached currency
     */
    public String GetTitle(){
        return currency.getTitle();
    }

    /**
     * The constructor for this class
     * @param c thecurrency to attach to this class
     */
    public JCurrencyField(Currency c){
        this.currency = c;
        setText(currency.getTitle());
    }

    /**
     * Resets the content of this text field to the title of the currency
     */
    public void ResetTitle(){
        setText(currency.getTitle());
    }

    /**
     * Gets a double value of what's inside the text input field
     * @return the value of the text contents
     */
    public double Get(){
        String text = this.getText().replaceAll("[a-zA-Z]", "");
        return Double.parseDouble(text.isBlank() ? "0" : text);
    }

    /**
     * Sets the content of the field to be a given value plus the Currency's symbol
     * @param p the value to set  to
     */
    public void Set(double p){
        this.setText(currency.getSymbol() + String.valueOf((double)Math.round(p*100)/100));
    }
}
