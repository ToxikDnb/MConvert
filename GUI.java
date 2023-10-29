import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;

/**
 * GUI
 * 
 * This class contains the GUI of the project
 * @author Mackenzie Blackaby
 */
public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;

    private JTextField gbp;
    public double GetPounds(){
        String text = gbp.getText().replaceAll("[a-zA-Z]", "");
        return Double.parseDouble(text.isBlank() ? "0" : text);
    }
    public void SetPounds(double p){
        gbp.setText(String.valueOf((double)Math.round(p*100)/100));
    }
    private JTextField mad;
    public double GetDirham(){
        String text = mad.getText().replaceAll("[a-zA-Z]", "");
        return Double.parseDouble(text.isBlank() ? "0" : text);
    }
    public void setDirham(double d){
        mad.setText(String.valueOf((double)Math.round(d*100)/100));
    }

    private JButton convertButton;
    
    private Font textFont;

    public GUI(int width, int height, Backend backend){

        textFont = new Font("Times",  Font.PLAIN, 20);

        frame = new JFrame("MConvert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);

        mainPanel = new JPanel(new GridLayout(2, 1));
        topPanel = new JPanel(new GridLayout(1, 2));

        gbp = new JTextField("British Pounds");
        gbp.setSize(width/2, 50);
        gbp.setHorizontalAlignment(SwingConstants.CENTER);
        gbp.setFont(textFont);
        mad = new JTextField("Moroccan Dirhams");
        mad.setSize(width/2, 50);
        mad.setHorizontalAlignment(SwingConstants.CENTER);
        mad.setFont(textFont);

        convertButton = new JButton("Convert");
        convertButton.setFont(textFont);
        convertButton.addActionListener(new ActionHelp(this, backend));

        topPanel.add(gbp);
        topPanel.add(mad);
        mainPanel.add(topPanel);
        mainPanel.add(convertButton);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}