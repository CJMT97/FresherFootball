package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LoadScreenPanel extends JPanel {
    public LoadScreenPanel(){
        //Get Screen dimension
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();

        //Set color and size and layout
        setLayout(null);
        setBackground(Color.black);
        setPreferredSize(new Dimension(screenDim.width/2, screenDim.height/2));

        //Create and add image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/LoadScreen.png"));
        Image image = imageIcon.getImage().getScaledInstance(screenDim.width/2-10, screenDim.height/2-10, Image.SCALE_AREA_AVERAGING); // scale the image to a preferred size
        ImageIcon scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
        JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the scaled ImageIcon
        imageLabel.setBounds(5, 5, screenDim.width/2-10, screenDim.height/2-10);
        add(imageLabel); // add the JLabel to the panel

    }
}
