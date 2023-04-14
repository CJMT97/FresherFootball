package FresherFootball;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

import java.awt.Color;

public class test implements Instances{
    public static void main (String[] args){
        /*DBManager db = new DBManager();
        db.nextAccountNum();
        db.setupAccount("Renee", "Brookeland", "NaeNae", "Inver56");*/

        dbManager.setAccount("xXCJMT97Xx");
        System.out.println(dbManager.getAccount().getFirstName());

        Register r = new Register();
        FFHome ffh = new FFHome();
        AccountDetailsPanel adp = new AccountDetailsPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.blue);
        frame.setPreferredSize(new Dimension(screenDim.width/2 + screenDim.width/4, screenDim.height/2 + screenDim.height/4));
        frame.setMinimumSize(new Dimension(600, 550));
        frame.getContentPane().add(ffh);
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2, screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);

        ffh.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }
}
