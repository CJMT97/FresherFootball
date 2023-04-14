package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

/**
 * <p>
 * FFHome class responsible for the GUI for the home page of
 * Fresher Football
 * </p>
 * 
 * @author Charlie Templeton
 */
public class FFHome extends JPanel implements Instances {

    private AccountBanner accountBanner;
    private FrameListener fl;
    private AccountDetailsPanel accountDetailsPanel;

    // Default constructor
    public FFHome() {
        setLayout(null);
        setBackground(new Color(200, 200, 200));

        // Set size of panel
        setMinimumSize(new Dimension(screenDim.width / 2, screenDim.height / 2));
        setPreferredSize(new Dimension(screenDim.width / 2, screenDim.height / 2));

        AccountBanner accountBanner = new AccountBanner(this);
        this.accountBanner = accountBanner;

        FrameListener fl = new FrameListener();
        this.fl = fl;
        frame.addComponentListener(fl);

        add(accountBanner);
    }

    public void addDetails() {
        AccountDetailsPanel accountDetailsPanel = new AccountDetailsPanel();
        this.accountDetailsPanel = accountDetailsPanel;
        add(accountDetailsPanel);
        repaint();
        revalidate();
        getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
        accountDetailsPanel.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
        
    }

    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Get the width and height of the frame and the text height
            int width = getWidth();
            int height = getHeight();

            accountBanner.setBounds(0, 0, width, height / 8);
            accountBanner.setImageBounds(height);
            accountBanner.setTitle(width, height);

            if (accountDetailsPanel != null) {
                accountDetailsPanel.setBounds((width-600)/2, (height-400)/2, 600, 400);
            }
        }
    }

    public FrameListener getFl() {
        return fl;
    }
}
