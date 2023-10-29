/**
 * MConvert
 * 
 * The main driver class for the application
 * @author Mackenzie Blackaby
 */
public class MConvert {
    public static void main(String[] args) {
        Backend backend = new Backend();
        GUI mainGui = new GUI(400, 250, backend);
    }
}