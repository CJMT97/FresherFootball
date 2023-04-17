package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

class ImageLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    public ImageLabel(ImageIcon icon) {
        super(icon);
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Get the image icon
        ImageIcon icon = (ImageIcon) getIcon();
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = image.createGraphics();
        icon.paintIcon(this, g2, 0, 0);
        g2.dispose();

        // Calculate the position and size of the icon inside the label
        Insets insets = getInsets();
        int x = insets.left + (getWidth() - insets.left - insets.right - icon.getIconWidth()) / 2;
        int y = insets.top + (getHeight() - insets.top - insets.bottom - icon.getIconHeight()) / 2;
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        // If the image is transparent, we need to draw a background color
        if (image.getTransparency() == BufferedImage.TRANSLUCENT) {
            g.setColor(Color.red);
            g.fillRect(x, y, width, height);
        }

        // Draw the icon
        g.drawImage(image, x, y, null);

        // Create and set the border
        Border border = BorderFactory.createEmptyBorder(y, x, y, x);
        setBorder(BorderFactory.createCompoundBorder(getBorder(), border));
    }
}
