package FresherFootballApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    private MenuBar menuBar;
    private JMenu menu;
    private boolean activeDetails  = false;
        

    // Default constructor
    public FFHome() {
        setLayout(null);
        setBackground(new Color(200, 200, 200));

        // Set size of panel
        setMinimumSize(new Dimension(screenDim.width / 2, screenDim.height / 2));
        setPreferredSize(new Dimension(screenDim.width / 2, screenDim.height / 2));

        AccountBanner accountBanner = new AccountBanner(this);
        this.accountBanner = accountBanner;

        AccountDetailsPanel accountDetailsPanel = new AccountDetailsPanel(this);
        this.accountDetailsPanel = accountDetailsPanel;

        MenuBar menuBar = new MenuBar();
        this.menuBar = menuBar;

        FrameListener fl = new FrameListener();
        this.fl = fl;
        frame.addComponentListener(fl);

        add(accountBanner);
        add(menuBar);
    }

    public Boolean checkActive(){
        return activeDetails;
    }

    public void addDetails() {
        activeDetails  = true;
        add(accountDetailsPanel);
        repaint();
        revalidate();
        getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
        accountDetailsPanel.getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }

    public void dropDetails() {
        activeDetails = false;
        remove(accountDetailsPanel);
        repaint();
        revalidate();
        getFl().componentResized(new ComponentEvent(frame, ComponentEvent.COMPONENT_RESIZED));
    }

    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Get the width and height of the frame and the text height
            int width = getWidth();
            int height = getHeight();

            accountBanner.setBounds(0, 0, width, height / 8);
            accountBanner.setImageBounds(height);
            accountBanner.setTitle(width, height);

            long startTime = System.currentTimeMillis();
            if (accountDetailsPanel != null) {
                accountDetailsPanel.setBounds((width - 600) / 2,
                        ((height / 8 + 20)) + ((height - (height / 8 + 20)) - 400) / 2, 600, 400);
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Time elapsed 3: " + elapsedTime + " milliseconds");

            menuBar.setBounds(0, height/8, width, 26);
        }
    }

    public FrameListener getFl() {
        return fl;
    }
}
