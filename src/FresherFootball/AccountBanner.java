package FresherFootball;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AccountBanner extends JPanel implements Instances {

    private JLabel imageLabel, title;
    private ImageIcon imageIcon;
    private Image image;
    private FFHome ffh;

    public AccountBanner(FFHome ffh) {
        this.ffh = ffh;
        setLayout(null);
        setBackground(Color.black);

        // Create and add image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/default.png"));
        this.imageIcon = imageIcon;

        image = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale the image to a preferred
                                                                                    // size

        ImageIcon scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
        JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the scaled ImageIcon
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        imageLabel.setBounds(5, 5, 70, 70);
        this.imageLabel = imageLabel;

        // Set Title
        JLabel title = new JLabel();
        title.setText("Fresher Football");
        title.setForeground(Color.white);
        title.setFont(new Font("Impact", Font.PLAIN, 30));
        title.setBounds(80, 5, screenDim.width - 80, 70);
        this.title = title;

        PanelListener pl = new PanelListener();
        imageLabel.addMouseListener(pl);

        add(imageLabel);
        add(title); // add the JLabel to the panel
    }

    public void setImageBounds(int height) {
        this.image = imageIcon.getImage().getScaledInstance(height / 8 - 10, height / 8 - 10, Image.SCALE_SMOOTH); 
        ImageIcon newScaledIcon = new ImageIcon(image);

        imageLabel.setIcon(newScaledIcon);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        imageLabel.setBounds(15, 5, height / 8 - 10, height / 8 - 10);
    }

    public void setTitle(int width, int height) {
        // Scale the font size based on the width of the frame
        float fontSize = Math.max(height / 10f, 10f);
        title.setFont(title.getFont().deriveFont(fontSize));

        FontMetrics metrics = title.getFontMetrics(title.getFont());
        int textHeight = metrics.getHeight();

        title.setBounds(height / 8 + 5, 0, width - 2 * (height / 8), textHeight + 4);
        title.setHorizontalAlignment(SwingConstants.HORIZONTAL);
    }

    public void removeImage() {
        remove(imageLabel);
    }

    public class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == imageLabel) {
                ffh.addDetails();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == imageLabel) {
                imageLabel.setBorder(BorderFactory.createLineBorder(Color.blue, 4));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == imageLabel) {
                imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
            }
        }

    }
}
