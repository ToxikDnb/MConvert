import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * GUI
 * 
 * This class contains the GUI of the project
 * 
 * @author Mackenzie Blackaby
 */
public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;

    private JButton convertButton;

    private ArrayList<JCurrencyField> currencyFields;

    public ArrayList<Double> GetContents(){
        ArrayList<Double> contents = new ArrayList<Double>();
        for (JCurrencyField currencyField : currencyFields) {
            contents.add(currencyField.Get());
        }
        return contents;
    }

    public void SetContents(ArrayList<Double> amount) {
        for (int i = 0; i < currencyFields.size(); i++) {
            currencyFields.get(i).Set(amount.get(i));
        }
    }

    private Font textFont;

    public GUI(int width, int height, Backend backend) {

        textFont = new Font("Times", Font.PLAIN, 20);

        frame = new JFrame("MConvert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);

        mainPanel = new JPanel(new GridLayout(2, 1));
        topPanel = new JPanel(new GridLayout(2, 2));

        convertButton = new JButton("Convert");
        convertButton.setFont(textFont);
        convertButton.addActionListener(new ActionHelp(this, backend));

        currencyFields = new ArrayList<JCurrencyField>();
        for (int i = 0; i < backend.getCurrencySize(); i++) {
            JCurrencyField c = new JCurrencyField(backend.getCurrencyAtIndex(i));
            c.setSize(width / 2, 50);
            c.setHorizontalAlignment(SwingConstants.CENTER);
            c.setFont(textFont);
            currencyFields.add(c);
            topPanel.add(c);
        }
        mainPanel.add(topPanel);
        mainPanel.add(convertButton);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}