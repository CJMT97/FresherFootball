package FresherFootball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class AccountBanner extends JPanel implements Instances {

    private JLabel imageLabel, title, settingsImageLabel;
    private ImageIcon scaledIcon, settingsIcon, newScaledIcon2;
    private Image image, settingsImage;
    private FFHome ffh;
    private boolean activePanel = false;

    public AccountBanner(FFHome ffh) {
        this.ffh = ffh;
        setLayout(null);
        setBackground(Color.black);

        // Create and add image

        BufferedImage bufferedImage = dbManager.getImage(dbManager.getAccount().getAccountNum());
        if (bufferedImage == null) {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/default.png"));
            image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale the image to a
            scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
            JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the scaled ImageIcon
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
            imageLabel.setBounds(5, 5, 70, 70);
            this.imageLabel = imageLabel;
        }else{
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale the image to a
            scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
            JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the scaled ImageIcon
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
            imageLabel.setBounds(5, 5, 70, 70);
            this.imageLabel = imageLabel;
        }

        // Create and add image
        ImageIcon settingsIcon = new ImageIcon(getClass().getResource("/Settings.png"));
        this.settingsIcon = settingsIcon;
        settingsImage = settingsIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale the image to a
                                                                                               // preferred size
        ImageIcon scaledSettingsIcon = new ImageIcon(settingsImage); // create a new ImageIcon object with the scaled
                                                                     // image
        JLabel settingsImageLabel = new JLabel(scaledSettingsIcon); // create a JLabel with the scaled ImageIcon
        // settingsImageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        this.settingsImageLabel = settingsImageLabel;

        // Set Title
        JLabel title = new JLabel();
        title.setText("Fresher Football");
        title.setForeground(Color.white);
        title.setFont(new Font("Impact", Font.PLAIN, 30));
        title.setBounds(80, 5, screenDim.width - 80, 70);
        this.title = title;

        PanelListener pl = new PanelListener();
        imageLabel.addMouseListener(pl);
        settingsImageLabel.addMouseListener(pl);

        add(settingsImageLabel);
        add(imageLabel);
        add(title); // add the JLabel to the panel
    }

    public void setImageBounds(int height) {
        long startTime = System.currentTimeMillis();
        BufferedImage resizedImage = new BufferedImage(height / 8 - 10, height / 8 - 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(image, 0, 0, height / 8 - 10, height / 8 - 10, null);
        g2d.dispose();

        ImageIcon newScaledIcon = new ImageIcon(resizedImage);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");

        imageLabel.setIcon(newScaledIcon);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        imageLabel.setBounds(5, 5, height / 8 - 10, height / 8 - 10);

        this.settingsImage = settingsIcon.getImage().getScaledInstance(height / 8 - 10, height / 8 - 10,
                Image.SCALE_SMOOTH);
        newScaledIcon2 = new ImageIcon(settingsImage);

        settingsImageLabel.setIcon(newScaledIcon2);
        settingsImageLabel.setBorder(new CircleBorder(newScaledIcon2, false));
        settingsImageLabel.setBounds(frame.getWidth() - height / 8 - 20, 5, height / 8 - 8, height / 8 - 8);
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

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() == imageLabel && !activePanel) {
                System.out.println("2");
                ffh.addDetails();
                activePanel = true;
                imageLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 171, 255), 4));
                return;
            } else if (e.getSource() == imageLabel && activePanel) {
                System.out.println("1");
                imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
                ffh.dropDetails();
                activePanel = false;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == imageLabel) {
                imageLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 171, 255), 4));
            }
            if (e.getSource() == settingsImageLabel) {
                settingsImageLabel.setBorder(new CircleBorder(newScaledIcon2, true));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == imageLabel) {
                imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
                System.out.println("!");
            }
            if (e.getSource() == settingsImageLabel) {
                settingsImageLabel.setBorder(new CircleBorder(newScaledIcon2, false));
            }
        }

    }

    private class CircleBorder implements Border {
        private final ImageIcon icon;
        private boolean selected;

        public CircleBorder(ImageIcon icon, boolean selected) {
            this.selected = selected;
            this.icon = icon;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(0, 171, 255));
            } else {
                g2.setColor(Color.white);
            }
            int diameter = Math.min(width, height) - 6;
            int thickness = 4;
            int radius = diameter / 2;
            int centerX = x + width / 2;
            int centerY = y + height / 2;
            g2.setStroke(new BasicStroke(thickness));
            g2.draw(new Ellipse2D.Double(centerX - radius, centerY - radius, diameter, diameter));

        }

        public Insets getBorderInsets(Component c) {
            int radius = Math.min(icon.getIconWidth(), icon.getIconHeight()) / 2;
            int top = c.getHeight() / 2 - icon.getIconHeight() / 2 + radius;
            int left = c.getWidth() / 2 - icon.getIconWidth() / 2 + radius;
            return new Insets(top, left, top, left);
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }
}
