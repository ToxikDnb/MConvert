import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * This is the action helper that binds backend functions to the button
 * 
 * @author Mackenzie Blackaby
 */
public class ActionHelp implements ActionListener{

    private GUI gui;
    private Backend backend;

    /**
     * The constructor for the action helper
     * 
     * @param gui the working GUI of the program
     * @param backend the working Backend of the program
     */
    public ActionHelp(GUI gui, Backend backend){
        this.backend = backend;
        this.gui = gui;
    }

    /**
     * This is the standard Actionlistener function required for button pressing
     * 
     * @param e the action event 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        ArrayList<Double> contents = gui.GetContents();
        Double selected = null;
        for (int i = 0; i < contents.size(); i++) {
            if(contents.get(i) != 0){
                selected = backend.getCurrencyAtIndex(i).getValueToDollars(contents.get(i));
            }
        }
        if(selected != null){
            gui.SetContents(backend.getValues(selected));
        }
    }
}
