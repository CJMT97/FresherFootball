package FresherFootball;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public interface Instances {
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    FrameManager frameManager = new FrameManager();
    JFrame frame = new JFrame("Fresher Football");
    DBManager dbManager = new DBManager();
}   
