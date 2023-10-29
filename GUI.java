import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Dimension;

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
    private JPanel bottomPanel;

    private JButton convertButton;
    private JButton clearButton;

    private ArrayList<JCurrencyField> currencyFields;

    private int fieldMarginHorizontal = 20;
    private int fieldMarginVertical = 10;
    private int fieldRows = 2;
    private int fieldCols = 2;

    /**
     * Gets the contents of all currency fields and returns it as an ArrayList of doubles
     * @return an ArrayList of parsed Doubles equal to what's inside the currency fields
     */
    public ArrayList<Double> GetContents(){
        ArrayList<Double> contents = new ArrayList<Double>();
        for (JCurrencyField currencyField : currencyFields) {
            contents.add(currencyField.Get());
        }
        return contents;
    }

    /**
     * Sets the contents of the currency text fields to be an ArrayList of a given amount
     * @param amount the arraylist to set the contents of the currency fields to
     */
    public void SetContents(ArrayList<Double> amount) {
        for (int i = 0; i < currencyFields.size(); i++) {
            currencyFields.get(i).Set(amount.get(i));
        }
    }

    /**
     * Resets all text fields to hold their currency titles
     */
    public void ResetContents(){
        for (JCurrencyField field : currencyFields) {
            field.ResetTitle();
        }
    }

    private Font textFont;

    /**
     * The main constructor for the class
     * 
     * @param width  the width of the window
     * @param height the height of the window
     * @param backend  the backend to attach this gui to
     */
    public GUI(int width, int height, Backend backend) {

        textFont = new Font("Times", Font.PLAIN, 20);

        frame = new JFrame("MConvert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);

        mainPanel = new JPanel(new GridLayout(2, 1));
        topPanel = new JPanel(new GridLayout(fieldRows, fieldCols));
        bottomPanel = new JPanel(new GridLayout(1, 2));

        convertButton = new JButton("Convert");
        convertButton.setFont(textFont);
        convertButton.addActionListener(new ActionHelp(this, backend));

        clearButton = new JButton("Clear");
        clearButton.setFont(textFont);
        clearButton.addActionListener(new ClearHelp(this));

        bottomPanel.add(convertButton);
        bottomPanel.add(clearButton);

        currencyFields = new ArrayList<JCurrencyField>();
        for (int i = 0; i < backend.getCurrencySize(); i++) {
            JCurrencyField c = new JCurrencyField(backend.getCurrencyAtIndex(i));
            c.setMargin(new Insets(fieldMarginVertical, fieldMarginHorizontal, fieldMarginVertical, fieldMarginHorizontal));
            c.setHorizontalAlignment(SwingConstants.CENTER);
            c.setFont(textFont);
            currencyFields.add(c);
            topPanel.add(c);
        }
        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}