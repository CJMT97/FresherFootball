package FresherFootball;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class FresherFootball{

    private static Dimension screenDim;
    public static void main(String[] args){
        //Get Dimension of screen
        screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        
        //Create and show the loading screen for the app
        JDialog loadScreen = new JDialog();
        LoadScreenPanel loadScreenPanel = new LoadScreenPanel();
        loadScreen.setUndecorated(true);
        loadScreen.getContentPane().add(loadScreenPanel);
        loadScreen.pack();
        loadScreen.setLocation(screenDim.width / 2 - loadScreen.getSize().width / 2, screenDim.height / 2 - loadScreen.getSize().height / 2);
        loadScreen.setVisible(true);

        //Pauses the thread for 5 seconds
        loadScreen.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            Thread.sleep(5000); // sleep for 5 seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadScreen.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        loadScreen.dispose();

        //Creates GUI and catches if exception is thrown
        try{
        createGUI();
        }catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }

    public static void createGUI(){
        FrameManager frameManager = new FrameManager(screenDim);
        frameManager.signIn();
    }
}