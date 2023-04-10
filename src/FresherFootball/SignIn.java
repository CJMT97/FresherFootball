package FresherFootball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

public class SignIn extends JPanel {

    private JFrame frame;

    public SignIn(Dimension screenDim, JFrame frame) {
        this.frame = frame;

        // Set layout and color
        setLayout(null);
        setBackground(new Color(200, 200, 200));

        // Add Title Label
        JLabel title = new JLabel();
        title.setBackground(new Color(30, 30, 30));
        title.setForeground(Color.white);
        title.setOpaque(true);
        title.setText(" Fresher Football");
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        //title.setBounds(0, 0, screenDim.width, screenDim.height/6);
        title.setHorizontalAlignment(SwingConstants.LEFT); // Align text to center horizontally
        add(title);

        // Add JPanel for sign in
        JPanel signInPanel = getSignInPanel();

        add(signInPanel);

        // Add a component listener to the frame to listen for resizing events
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Get the width and height of the frame
                int width = getWidth();
                int height = getHeight();
                FontMetrics metrics = title.getFontMetrics(title.getFont());
                int textHeight = metrics.getHeight();

                // Scale the font size based on the width of the frame
                float fontSize = Math.max(width / 20f, 10f);
                title.setFont(title.getFont().deriveFont(fontSize));

                // Get the width and height of the text
                title.setBounds(0, 0, width, textHeight+4);
                signInPanel.setBounds(width-(width/2 + width/4), textHeight+34, width/2, height - (textHeight + 68));
            }
        });

        // Set size of panel
        setMinimumSize(new Dimension(screenDim.width / 3, screenDim.height / 3));
        setPreferredSize(new Dimension(screenDim.width / 2, screenDim.height / 2));
    }

    public JPanel getSignInPanel(){
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Times New Roman", Font.BOLD, 80));
        title.setBounds(10, 10, 100, 50);
        panel.add(title);

        panel.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Get the width and height of the frame
                int width = getWidth();
                int height = getHeight();
                FontMetrics metrics = title.getFontMetrics(title.getFont());
                int textHeight = metrics.getHeight();

                // Scale the font size based on the width of the frame
                float fontSize = Math.max(width / 20f, 10f);
                title.setFont(title.getFont().deriveFont(fontSize));

                // Get the width and height of the text
                title.setBounds(0, 0, width, textHeight+4);
                //signInPanel.setBounds(width-(width/2 + width/4), textHeight+34, width/2, height - (textHeight + 68));
            }
        });

        return panel;
    }
}
