package FresherFootball;

import java.awt.Cursor;
import javax.swing.JDialog;

/**
 * <p>
 * Fresher Football is a app for footballers who want to track there progress
 * can add trainings, teams, stats and exercises
 * </p>
 * 
 * <p>
 * The main method sets and displays the Fresher Football logo while the application loads
 * </p>
 * 
 * @author Charlie Templeton
 */
public class FresherFootball implements Instances{

    public static void main(String[] args) {
        // Create and show the loading screen for the app
        JDialog loadScreen = new JDialog();
        LoadScreenPanel loadScreenPanel = new LoadScreenPanel();
        loadScreen.setUndecorated(true);
        loadScreen.getContentPane().add(loadScreenPanel);
        loadScreen.pack();
        loadScreen.setLocation(screenDim.width / 2 - loadScreen.getSize().width / 2,
                screenDim.height / 2 - loadScreen.getSize().height / 2);
        loadScreen.setVisible(true);

        // Pauses the thread for 5 seconds
        loadScreen.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            Thread.sleep(5000); // sleep for 5 seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadScreen.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        loadScreen.dispose();

        // Creates GUI and catches if exception is thrown
        try {
            createGUI();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * <p>
     * Creates the GUI for the Fresher Football app
     * <p>
     */
    public static void createGUI() {
                frameManager.setComponets();
                frameManager.signIn();
    }
}