package FresherFootballApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountDetailsPanel extends JPanel implements Instances {

    private JPanel panel;
    private FrameListener fl;
    private JLabel username, name, accNumber, age, country, imageLabel;
    private Image image;
    private ImageIcon scaledIcon;
    private FFHome ffh;

    public AccountDetailsPanel(FFHome ffh) {
        this.ffh = ffh;
        System.out.println("1");

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
        JLabel age = new JLabel("Age: " + account.convertToDate(account.getDOB()));
        age.setFont(new Font("Arial", Font.BOLD, 20));
        age.setForeground(Color.white);
        this.age = age;

        // Add JLabel for Name
        JLabel country = new JLabel("Country: " + account.getCountry());
        country.setFont(new Font("Arial", Font.BOLD, 20));
        country.setForeground(Color.white);
        this.country = country;

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

        System.out.println("3");
    }

    public FrameListener getFl() {
        return fl;
    }

    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {

            if(ffh.checkActive()){
            long startTime1 = System.currentTimeMillis();
            System.out.println("2");
            // Get the width and height of the frame and the text height
            int width = getWidth();
            int height = getHeight();

            System.out.println(width + " and " + height);

            // Scale the font size based on the width of the frame
            float fontSize = Math.max(width / 15f, 10f);
            name.setFont(name.getFont().deriveFont(fontSize));

            username.setBounds(height / 2, 65, panel.getWidth() - height / 2, panel.getHeight() / 8);
            accNumber.setBounds(height / 2, 95, panel.getWidth() - height / 2, panel.getHeight() / 8);
            name.setBounds(height / 2, 10, panel.getWidth() - height / 2, panel.getHeight() / 8);
            country.setBounds(height / 2, 125, panel.getWidth() - height / 2, panel.getHeight() / 8);
            age.setBounds(height / 2, 155, panel.getWidth() - height / 2, panel.getHeight() / 8);

            long startTime = System.currentTimeMillis();
            int width4 = image.getWidth(null);
            int height4 = image.getHeight(null);


            BufferedImage resizedImage = new BufferedImage(height / 2 - 10, height / 2 - 10, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(image, 0, 0, height / 2 - 10, height / 2 - 10, null);
            g2d.dispose();

            ImageIcon newScaledIcon = new ImageIcon(resizedImage);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Time elapsed: " + elapsedTime + " milliseconds");

            imageLabel.setIcon(newScaledIcon);
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
            imageLabel.setBounds(0, 0, height / 2 - 10, height / 2 - 10);

            long endTime1 = System.currentTimeMillis();
            long elapsedTime1 = endTime1 - startTime1;
            System.out.println("Time elapsed: " + elapsedTime1 + " milliseconds");
            }

        }
    }
}
