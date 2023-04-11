package FresherFootball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class SignIn extends JPanel {

    private JFrame frame;
    private JLabel title, login;
    private JPanel signInPanel, containerPanel, titlePanel;
    private JTextField username, password;
    private FrameListener fl;
    private JButton submit, create;

    public SignIn(Dimension screenDim, JFrame frame) {
        this.frame = frame;

        // Set layout and color
        setLayout(null);
        setBackground(new Color(200, 200, 200));
        // Set size of panel
        setMinimumSize(new Dimension(screenDim.width / 2, screenDim.height / 2));
        setPreferredSize(new Dimension(screenDim.width / 2, screenDim.height / 2));

        // Add panel for title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBackground(new Color(30, 30, 30));
        this.titlePanel = titlePanel;

        // Add panel for contentpane
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(null);
        containerPanel.setBackground(Color.white);
        this.containerPanel = containerPanel;

        // Add SignIn Panel
        JPanel signInPanel = new JPanel();
        signInPanel.setLayout(null);
        signInPanel.setBackground(new Color(235, 235, 235));
        signInPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add Title Label
        JLabel title = new JLabel();
        title.setForeground(Color.white);
        title.setText(" Fresher Football");
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        title.setHorizontalAlignment(SwingConstants.LEFT); // Align text to center horizontally
        this.title = title;

        // Add Login Label
        JLabel login = new JLabel("Login");
        login.setFont(new Font("Arial", Font.BOLD, 40));
        this.login = login;

        // Add Logo label
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Logo.png"));
        Image image = imageIcon.getImage().getScaledInstance(400, 125, Image.SCALE_SMOOTH); // scale the image to a preferred size
        ImageIcon scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
        JLabel logo = new JLabel(scaledIcon);
        logo.setBounds(50, 5, 400, 125);

        // Add Username JTextField
        JTextField username = new JTextField();
        username.setForeground(Color.gray);
        username.setFont(new Font("Arial", Font.BOLD, 30));
        username.setText("Username...");
        this.username = username;

        // Add Password JTextField
        JTextField password = new JTextField();
        password.setForeground(Color.gray);
        password.setFont(new Font("Arial", Font.BOLD, 30));
        password.setText("Password...");
        this.password = password;

        // Add submit button
        JButton submit = new JButton();
        submit.setText("Submit");
        submit.setBackground(new Color(0, 0, 220));
        submit.setOpaque(true);
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        submit.setForeground(Color.white);
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        this.submit = submit;

        // Add create account button
        JButton create = new JButton();
        create.setText("Create Account");
        create.setOpaque(true);
        create.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));
        create.setForeground(Color.blue);
        create.setBackground(new Color(235, 235, 235));
        create.setFont(new Font("Arial", Font.BOLD, 20));
        this.create = create;

        // Add Button Listeners
        ButtonListener bl = new ButtonListener();
        create.addMouseListener(bl);
        create.addActionListener(bl);
        submit.addMouseListener(bl);
        submit.addActionListener(bl);

        // Add componets to JPanel
        signInPanel.add(login);
        signInPanel.add(logo);
        signInPanel.add(username);
        signInPanel.add(password);
        signInPanel.add(submit);
        signInPanel.add(create);

        this.signInPanel = signInPanel;

        // Add a focus listener to the JTextField
        TextFieldListener tl = new TextFieldListener();
        username.addFocusListener(tl);
        password.addFocusListener(tl);

        // Add a component listener to the frame to listen for resizing events
        FrameListener fl = new FrameListener();
        this.fl = fl;
        frame.addComponentListener(fl);

        titlePanel.add(title);
        containerPanel.add(signInPanel);
        add(titlePanel);
        add(containerPanel);
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
            float fontSize = Math.max(height / 12f, 10f);
            title.setFont(title.getFont().deriveFont(fontSize));

            FontMetrics metrics = title.getFontMetrics(title.getFont());
            int textHeight = metrics.getHeight();

            titlePanel.setBounds(0, 0, width, textHeight);

            // Set the width and height of the text
            title.setBounds(0, 0, width, textHeight + 4);

            // Set the width and height of the panel
            containerPanel.setBounds(0, textHeight, width, height-textHeight+4);

            int cWidth = containerPanel.getWidth();
            int cHeight = containerPanel.getHeight();
            signInPanel.setBounds((cWidth-500)/2, (cHeight-500)/2, 500, 500);

            // Get the width and height of the panel and the text height
            int pWidth = signInPanel.getWidth();
            int pHeight = signInPanel.getHeight();

            // Set Login bounds
            login.setBounds(0, 130, pWidth, 50);
            login.setHorizontalAlignment(SwingConstants.CENTER);

            // Set TextField and button bounds
            username.setBounds(50, 200, 400, 50);
            password.setBounds(50, 275, 400, 50);
            create.setBounds(50, 375, 160, 50);
            submit.setBounds(295, 375, 150, 50);
        }
    }

    private class TextFieldListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() == username && username.getText().equals("Username...")) {
                username.setText("");
                username.setForeground(Color.black);
            }
            if (e.getSource() == password && password.getText().equals("Password...")) {
                password.setText("");
                password.setForeground(Color.black);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource() == username && username.getText().equals("")) {
                username.setForeground(Color.gray);
                username.setText("Username...");
            }
            if (e.getSource() == password && password.getText().equals("")) {
                password.setForeground(Color.gray);
                password.setText("Password...");
            }
        }

    }

    private class ButtonListener implements MouseListener, ActionListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == create) {
                create.setBackground(new Color(220, 220, 220));
            }
            if (e.getSource() == submit) {
                submit.setBackground(new Color(0, 0, 180));
            }
        }

        public void mouseExited(MouseEvent e) {
            if (e.getSource() == create) {
                create.setBackground(new Color(235, 235, 235));
            }
            if (e.getSource() == submit) {
                submit.setBackground(new Color(0, 0, 220));
            }

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    private static class TextBorder extends AbstractBorder {
        private Color color;
        private int thickness;

        public TextBorder(Color color, int thickness) {
            this.color = color;
            this.thickness = thickness;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Rectangle textBounds = c.getBounds();
            g.setColor(color);
            g.fillRect(textBounds.x - thickness, textBounds.y - thickness,
                       textBounds.width + thickness * 2, textBounds.height + thickness * 2);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = thickness;
            return insets;
        }
    }
}







