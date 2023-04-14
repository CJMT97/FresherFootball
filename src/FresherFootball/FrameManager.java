package FresherFootball;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameManager implements Instances{

    public FrameManager(){}

    public void setComponets(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(screenDim.width/2 + screenDim.width/4, screenDim.height/2 + screenDim.height/4));
        frame.setMinimumSize(new Dimension(500, 550));
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2, screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        System.out.println(frame.getWidth() + " " + frame.getHeight());
    }

    public JFrame getFrame(){
        return frame;
    }

    public void signIn(){
        SignIn signInPanel = new SignIn();
        frame.getContentPane().add(signInPanel);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
        frame.pack();
        signInPanel.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }

    public void clearFrame(){
        frame.getContentPane().removeAll();
    }
}
