package FresherFootball;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class test implements Instances{
    public static void main (String[] args){
        /*DBManager db = new DBManager();
        db.nextAccountNum();
        db.setupAccount("Renee", "Brookeland", "NaeNae", "Inver56");*/

        Register r = new Register();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(screenDim.width/2 + screenDim.width/4, screenDim.height/2 + screenDim.height/4));
        frame.setMinimumSize(new Dimension(500, 550));
        frame.getContentPane().add(r);
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2, screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);

        r.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }
}
