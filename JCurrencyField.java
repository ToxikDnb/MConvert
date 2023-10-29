import javax.swing.JTextField;

public class JCurrencyField extends JTextField{

    private Currency currency;

    public String GetTitle(){
        return currency.getTitle();
    }

    public JCurrencyField(Currency c){
        this.currency = c;
        setText(currency.getTitle());
    }

    public void ResetTitle(){
        setText(currency.getTitle());
    }

    public double Get(){
        String text = this.getText().replaceAll("[a-zA-Z]", "");
        return Double.parseDouble(text.isBlank() ? "0" : text);
    }

    public void Set(double p){
        this.setText(currency.getSymbol() + String.valueOf((double)Math.round(p*100)/100));
    }
}
