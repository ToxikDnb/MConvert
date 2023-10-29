import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        double dirhams = gui.GetDirham();
        double pounds = gui.GetPounds();
        if(dirhams == 0) gui.setDirham(backend.GetDirham(pounds));
        else if(pounds == 0) gui.SetPounds(backend.GetPounds(dirhams));
    }
}
