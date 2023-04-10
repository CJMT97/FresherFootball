package FresherFootball;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;

public class FrameManager {

    private JFrame frame;
    private Dimension screenDim;

    public FrameManager(Dimension screenDim){
        this.screenDim = screenDim;

        JFrame frame = new JFrame("Fresher Football");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(screenDim.width/2 + screenDim.width/4, screenDim.height/2 + screenDim.height/4));
        frame.setMinimumSize(new Dimension(screenDim.width/4, screenDim.height/4));
        frame.pack();
        frame.setLocation(screenDim.width / 2 - frame.getSize().width / 2, screenDim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        this.frame = frame;
    }

    public void signIn(){
        SignIn signInPanel = new SignIn(screenDim, frame);
        clearFrame();
        frame.getContentPane().add(signInPanel);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
        frame.pack();

    }

    public void clearFrame(){
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
    }
}
