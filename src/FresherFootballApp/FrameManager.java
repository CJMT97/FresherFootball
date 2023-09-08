package FresherFootballApp;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

/**
 * <p>
 * FrameManager class is responsible for updateing and managing the frame that Fresher
 * Football is displayed on 
 * </p>
 * @author Charlie Templeton
 */

public class FrameManager implements Instances{

    /**
     * <p>
     * Default Constructor
     * </p>
     */
    public FrameManager(){}

    /**
     * <p>
     * setComponets method sets up the default settings for the frame
     * </p>
     */
    public void setComponets(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(screenDim.width/2 + screenDim.width/4, screenDim.height/2 + screenDim.height/4));
        frame.setMinimumSize(new Dimension(600, 550));
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2, screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        System.out.println(frame.getWidth() + " " + frame.getHeight());
    }

    /**
     * <p>
     * getFrame Returns the JFrame that Fresher Football is displayed on
     * </p>
     * @return frame The JFrame that contains the GUI for Fresher Football
     */
    public JFrame getFrame(){
        return frame;
    }

    /**
     * <p>
     * signIn method creates a instance of the SignIn class and adds the GUI to the frame
     * </p>
     */
    public void signIn(){
        SignIn signInPanel = new SignIn();
        frame.getContentPane().add(signInPanel);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
        frame.pack();
        signInPanel.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }

    /**
     * <p>
     * clearFrame method clears the frame of all content
     * </p>
     */
    public void clearFrame(){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();
    }

    public void register(){
        Register register = new Register();
        frame.getContentPane().add(register);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
        frame.pack();
        register.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }

    public void homePage(){
        FFHome ffh = new FFHome();
        clearFrame();
        frame.getContentPane().add(ffh);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
        frame.pack();
        ffh.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }
}
