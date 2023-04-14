package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * <p>
 * SignIn class creates the GUI for signing in to an account for Fresher Football
 * </p>
 * 
 * @author Charlie Templeton
 */

public class SignIn extends JPanel implements Instances{
    private JLabel title, login;
    private JPanel signInPanel, containerPanel, titlePanel;
    private JTextField username, password;
    private FrameListener fl;
    private JButton submit, create;

    /**
     * <p>
     * The Constructor for SignIn class creates the GUI
     * </p>
     */
    public SignIn(){

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
        System.out.println(getClass().getResource("/Logo.png"));
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
    
    /**
     * <p>
     * getFl method returns the framelistener for the current frame
     * </p>
     * @return fl Frame Listener for the Fresher Fottball Frame
     */
    public FrameListener getFl() {
        return fl;
    }

    /**
     * <p>
     * FrameListener class repaints the frame as the frame changes in size
     * </p>
     */
    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Get the width and height of the frame and the text height
            int width = getWidth();
            int height = getHeight();

            // Scale the font size based on the width of the frame
            float fontSize = Math.max(height / 15f, 10f);
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

    /**
     * <p>
     * TextFieldListener class listens for if a textfield is selected or not
     * </p>
     */
    private class TextFieldListener implements FocusListener {

        /**
         * <p>
         * focusGained method sets the textfield to null if not text has been added
         * </p>
         */
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

        /**
         * <p>
         * focusLost method sets the textfield text to default messages if no text has been added
         * otherwise it leaves it as is
         * </p>
         */
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

    /**
     * <p>
     * ButtonListener class has mouse listener and action listener,
     * mouse listener check if mouse is over the buttons, action lister checks if
     * the button is pressed
     * </p>
     */
    private class ButtonListener implements MouseListener, ActionListener {
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * <p>
         * mouseEntered method sets background color of buttons if mouse 
         * is over the button
         * </p>
         * @param e The action event triggering this method
         */
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == create) {
                create.setBackground(new Color(220, 220, 220));
            }
            if (e.getSource() == submit) {
                submit.setBackground(new Color(0, 0, 180));
            }
        }

        /**
         * <p>
         * mouseExited method sets background color of buttons if mouse 
         * is no longer over the button
         * </p>
         * @param e The action event triggering this method
         */
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

        /**
         * <p>
         * actionPerformed method listens for if a button is clicked and then
         * performs actions base on which button was pressed
         * </p>
         * @param e The action event triggering this method
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit && !username.getText().equals("") && !password.getText().equals("")) {
                DBManager.setAccount(username.getText());
                if(dbManager.checkNotNull() && dbManager.checkPassword(password.getText())){
                    frameManager.homePage();
                }else if(!dbManager.checkNotNull()){
                    System.out.println("No account with username: " + username.getText());
                }else if(!dbManager.checkPassword(password.getText())){
                    System.out.println("Wrong pasword");
                }
                else{
                    System.out.println("No");
                }

                dbManager.getAccount();
            }
            if(e.getSource() == create){
                frameManager.clearFrame();
                frameManager.register();
            }
        }
    }
}







