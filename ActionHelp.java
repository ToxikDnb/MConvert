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

    public ActionHelp(GUI gui, Backend backend){
        this.backend = backend;
        this.gui = gui;
    }

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
