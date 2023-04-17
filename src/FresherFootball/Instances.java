package FresherFootball;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * <p>
 * Instances interface cotains all the shared classes and variables for Fresher Football
 * </p>
 * @author Charlie Templeton
 */

public interface Instances {
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    FrameManager frameManager = new FrameManager();
    JFrame frame = new JFrame("Fresher Football");
    DBManager dbManager = new DBManager();
}   
