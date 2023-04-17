package FresherFootball;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Component;

public class test implements Instances {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException, IOException {
        /*
         * DBManager db = new DBManager();
         * db.nextAccountNum();
         * db.setupAccount("Renee", "Brookeland", "NaeNae", "Inver56");
         */

        String[] strings = { "240", "240", "240" };
        for (String str : strings) {
            str = "Bob";
        }
        for (String str : strings) {
            System.out.println(str);
        }


        dbManager.setAccount("xXCJMT97Xx");
        // System.out.println(dbManager.getAccount().getFirstName());

        ImageIcon imageIcon = new ImageIcon("/Users/charlietempleton/Desktop/sienna.jpg");
        dbManager.addImage(1000, imageIcon);

        // BufferedImage b = dbManager.getImage(1000);
        // ImageIcon icon = new ImageIcon(b);
        // JLabel imageLabel = new JLabel(icon);

        FFHome ffh = new FFHome();
        Register r = new Register();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.blue);
        frame.setPreferredSize(
                new Dimension(screenDim.width / 2 + screenDim.width / 4, screenDim.height / 2 + screenDim.height / 4));
        frame.setMinimumSize(new Dimension(600, 550));
        frame.getContentPane().add(ffh);
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2,
                screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);

        r.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));

        /*
         * 
         * Register r = new Register();
         * FFHome ffh = new FFHome();
         * 
         * ImageIcon imageIcon = new ImageIcon(
         * "/Users/charlietempleton/FootballApp/FresherFootball/src/Settings.png");
         * Image image = imageIcon.getImage().getScaledInstance(70, 70,
         * Image.SCALE_SMOOTH); // scale the image to a
         * // preferred size
         * ImageIcon scaledIcon = new ImageIcon(image);
         * JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the
         * scaled ImageIcon
         * AccountDetailsPanel adp = new AccountDetailsPanel();
         * // ImageLabel il = new ImageLabel(scaledIcon);
         * 
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.setBackground(Color.blue);
         * frame.setPreferredSize(
         * new Dimension(screenDim.width / 2 + screenDim.width / 4, screenDim.height / 2
         * + screenDim.height / 4));
         * frame.setMinimumSize(new Dimension(600, 550));
         * frame.getContentPane().add(ffh);
         * frame.pack();
         * frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2,
         * screenDim.height / 2 - frame.getSize().height / 2);
         * frame.setVisible(true);
         * 
         * ffh.getFl().componentResized(new ComponentEvent(frame,
         * ComponentEvent.COMPONENT_RESIZED));
         */
    }
}
