package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountDetailsPanel extends JPanel implements Instances {

    private JPanel panel;
    private FrameListener fl;
    private JLabel username, name, accNumber, age, country, imageLabel;
    private Image image;
    private ImageIcon imageIcon;

    public AccountDetailsPanel() {
        setLayout(null);
        setBackground(Color.black);
        setBorder(BorderFactory.createLineBorder(Color.white, 5));

        Account account = dbManager.getAccount();

        // Add JLabel for Username
        JLabel username = new JLabel("Username: " + account.getUsername());
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setForeground(Color.white);
        this.username = username;

        // Add JLabel for Account Number
        JLabel accNumber = new JLabel("Account Number: " + account.getAccountNum());
        accNumber.setFont(new Font("Arial", Font.BOLD, 20));
        accNumber.setForeground(Color.white);
        this.accNumber = accNumber;

        // Add JLabel for Name
        JLabel name = new JLabel(account.getFirstName() + " " + account.getLastName());
        name.setFont(new Font("Arial", Font.BOLD, 40));
        name.setForeground(Color.white);
        this.name = name;

        // Add JLabel for age
        JLabel age = new JLabel("Age: " + account.getAge());
        age.setFont(new Font("Arial", Font.BOLD, 20));
        age.setForeground(Color.white);
        this.age = age;

        // Add JLabel for Name
        JLabel country = new JLabel("Country: " + account.getCountry());
        country.setFont(new Font("Arial", Font.BOLD, 20));
        country.setForeground(Color.white);
        this.country = country;

        // Create and add image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/default.png"));
        this.imageIcon = imageIcon;
        Image image = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // scale the image to a                                                            // preferred size
        this.image = image;
        ImageIcon scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
        JLabel imageLabel = new JLabel(scaledIcon); // create a JLabel with the scaled ImageIcon
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        this.imageLabel = imageLabel;

        // Set size of panel
        setPreferredSize(new Dimension(screenDim.width / 2, screenDim.height / 2));
        setMaximumSize(new Dimension(screenDim.width / 2, screenDim.height / 2));

        FrameListener fl = new FrameListener();
        this.fl = fl;
        frame.addComponentListener(fl);

        panel = this;

        add(imageLabel);
        add(name);
        add(accNumber);
        add(username);
        add(age);
        add(country);

    }

    public FrameListener getFl() {
        return fl;
    }

    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Get the width and height of the frame and the text height
            int width = getWidth();
            int height = getHeight();

            // Scale the font size based on the width of the frame
            float fontSize = Math.max(width / 15f, 10f);
            name.setFont(name.getFont().deriveFont(fontSize));

            username.setBounds(height / 2, 65, panel.getWidth()-height/2, panel.getHeight() / 8);
            accNumber.setBounds(height / 2, 95, panel.getWidth()-height/2, panel.getHeight() / 8);
            name.setBounds(height / 2, 10, panel.getWidth()-height/2, panel.getHeight()/8);
            country.setBounds(height / 2, 125, panel.getWidth()-height/2, panel.getHeight() / 8);
            age.setBounds(height / 2, 155, panel.getWidth()-height/2, panel.getHeight() / 8);

            image = imageIcon.getImage().getScaledInstance(height / 2 - 10, height / 2 - 10, Image.SCALE_SMOOTH); 
            ImageIcon newScaledIcon = new ImageIcon(image);

            imageLabel.setIcon(newScaledIcon);
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
            imageLabel.setBounds(0, 0, height / 2 - 10, height / 2 - 10);


        }
    }
}
