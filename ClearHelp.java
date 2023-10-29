import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearHelp implements ActionListener{

    private GUI gui;

    @Override
    public void actionPerformed(ActionEvent e){
        gui.ResetContents();
    }

    public ClearHelp(GUI gui){
        this.gui = gui;
    }
}
