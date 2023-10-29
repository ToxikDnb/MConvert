import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class for managing the clear button
 * 
 * @author Mackenzie Blackaby
 */
public class ClearHelp implements ActionListener{

    private GUI gui;

    /**
     * The standard action performed function
     * 
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        gui.ResetContents();
    }

    /**
     * Default constructor for the class
     * 
     * @param gui the working GUI
     */
    public ClearHelp(GUI gui){
        this.gui = gui;
    }
}
