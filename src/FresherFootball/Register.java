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

public class Register extends JPanel implements Instances {

    private JLabel title, register, fnLabel, lnLabel, usLabel, psLabel, cpsLabel, aLabel, cLabel, slash1, slash2;
    private JPanel registerPanel, containerPanel, titlePanel;
    private JTextField username, password, firstName, lastName, confirmPassword, day, month, year, country;
    private FrameListener fl;
    private JButton submit, create, next, previous, login;

    public Register() {

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
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);
        registerPanel.setBackground(new Color(235, 235, 235));
        registerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add Title Label
        JLabel title = new JLabel();
        title.setForeground(Color.white);
        title.setText(" Fresher Football");
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        title.setHorizontalAlignment(SwingConstants.LEFT); // Align text to center horizontally
        this.title = title;

        // Add Login Label
        JLabel register = new JLabel("Register");
        register.setFont(new Font("Arial", Font.BOLD, 40));
        this.register = register;

        // Add Logo label
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Logo.png"));
        Image image = imageIcon.getImage().getScaledInstance(400, 125, Image.SCALE_SMOOTH); // scale the image to a
                                                                                            // preferred size
        ImageIcon scaledIcon = new ImageIcon(image); // create a new ImageIcon object with the scaled image
        JLabel logo = new JLabel(scaledIcon);
        logo.setBounds(50, 5, 400, 125);

        // Add FirstName Label
        JLabel fnLabel = new JLabel();
        fnLabel.setText("First Name");
        fnLabel.setFont(new Font("Arial", Font.BOLD, 15));
        this.fnLabel = fnLabel;

        // Add LastName Label
        JLabel lnLabel = new JLabel();
        lnLabel.setText("Last Name");
        lnLabel.setFont(new Font("Arial", Font.BOLD, 15));
        this.lnLabel = lnLabel;

        // Add Age Label
        JLabel aLabel = new JLabel();
        aLabel.setText("Date of Birth");
        aLabel.setFont(new Font("Arial", Font.BOLD, 15));
        this.aLabel = aLabel;

        // Add slash1 Label
        JLabel slash1 = new JLabel();
        slash1.setText("/");
        slash1.setFont(new Font("Arial", Font.BOLD, 30));
        this.slash1 = slash1;

        // Add slash2 Label
        JLabel slash2 = new JLabel();
        slash2.setText("/");
        slash2.setFont(new Font("Arial", Font.BOLD, 30));
        this.slash2 = slash2;

        // Add Country Label
        JLabel cLabel = new JLabel();
        cLabel.setText("Country");
        cLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cLabel.setVisible(false);
        this.cLabel = cLabel;

        // Add usLabel Label
        JLabel usLabel = new JLabel();
        usLabel.setText("Username");
        usLabel.setFont(new Font("Arial", Font.BOLD, 15));
        usLabel.setVisible(false);
        this.usLabel = usLabel;

        // Add psLabel Label
        JLabel psLabel = new JLabel();
        psLabel.setText("Password");
        psLabel.setFont(new Font("Arial", Font.BOLD, 15));
        psLabel.setVisible(false);
        this.psLabel = psLabel;

        // Add cpsLabel Label
        JLabel cpsLabel = new JLabel();
        cpsLabel.setText("Confirm Password");
        cpsLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cpsLabel.setVisible(false);
        this.cpsLabel = cpsLabel;

        // Add FirstName JTextField
        JTextField firstName = new JTextField();
        firstName.setForeground(new Color(200, 200, 200));
        firstName.setFont(new Font("Arial", Font.BOLD, 20));
        firstName.setText("Enter Firstname...");
        this.firstName = firstName;

        // Add LastName JTextField
        JTextField lastName = new JTextField();
        lastName.setForeground(new Color(200, 200, 200));
        lastName.setFont(new Font("Arial", Font.BOLD, 20));
        lastName.setText("Enter Lastname...");
        this.lastName = lastName;

        // Add Age JTextField
        JTextField day = new JTextField();
        day.setForeground(new Color(200, 200, 200));
        day.setFont(new Font("Arial", Font.BOLD, 20));
        day.setText("00");
        day.setHorizontalAlignment(SwingConstants.CENTER);
        this.day = day;

        // Add Age JTextField
        JTextField month = new JTextField();
        month.setForeground(new Color(200, 200, 200));
        month.setFont(new Font("Arial", Font.BOLD, 20));
        month.setText("00");
        month.setHorizontalAlignment(SwingConstants.CENTER);
        this.month = month;

        // Add Age JTextField
        JTextField year = new JTextField();
        year.setForeground(new Color(200, 200, 200));
        year.setFont(new Font("Arial", Font.BOLD, 20));
        year.setText("0000");
        year.setHorizontalAlignment(SwingConstants.CENTER);
        this.year = year;

        // Add Country JTextField
        JTextField country = new JTextField();
        country.setForeground(new Color(200, 200, 200));
        country.setFont(new Font("Arial", Font.BOLD, 20));
        country.setText("Enter Country...");
        this.country = country;

        // Add Username JTextField
        JTextField username = new JTextField();
        username.setForeground(new Color(200, 200, 200));
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setText("Enter Username...");
        username.setVisible(false);
        this.username = username;

        // Add Password JTextField
        JTextField password = new JTextField();
        password.setForeground(new Color(200, 200, 200));
        password.setFont(new Font("Arial", Font.BOLD, 15));
        password.setText("Enter Password...");
        password.setVisible(false);
        this.password = password;

        // Add confirmPassword JTextField
        JTextField confirmPassword = new JTextField();
        confirmPassword.setForeground(new Color(200, 200, 200));
        confirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
        confirmPassword.setText("Confirm Password...");
        confirmPassword.setVisible(false);
        this.confirmPassword = confirmPassword;

        // Add next button
        JButton next = new JButton();
        next.setText("Next");
        next.setBackground(new Color(0, 0, 220));
        next.setOpaque(true);
        next.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        this.next = next;

        // Add previous button
        JButton previous = new JButton();
        previous.setText("Previous");
        previous.setBackground(new Color(235, 235, 235));
        previous.setOpaque(true);
        previous.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));
        previous.setForeground(Color.blue);
        previous.setFont(new Font("Arial", Font.BOLD, 20));
        previous.setVisible(false);
        this.previous = previous;

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
        create.setText("Create");
        create.setOpaque(true);
        create.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));
        create.setForeground(Color.white);
        create.setBackground(new Color(0, 0, 220));
        create.setFont(new Font("Arial", Font.BOLD, 20));
        create.setVisible(false);
        this.create = create;

        // Add login button
        JButton login = new JButton();
        login.setText("Return");
        login.setBackground(new Color(235, 235, 235));
        login.setOpaque(true);
        login.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));
        login.setForeground(Color.blue);
        login.setFont(new Font("Arial", Font.BOLD, 20));
        this.login = login;

        // Add Button Listeners
        ButtonListener bl = new ButtonListener();
        login.addMouseListener(bl);
        login.addActionListener(bl);
        previous.addMouseListener(bl);
        previous.addActionListener(bl);
        next.addMouseListener(bl);
        next.addActionListener(bl);
        create.addMouseListener(bl);
        create.addActionListener(bl);
        submit.addMouseListener(bl);
        submit.addActionListener(bl);

        // Add componets to JPanel
        registerPanel.add(register);
        registerPanel.add(logo);
        registerPanel.add(firstName);
        registerPanel.add(lastName);
        registerPanel.add(day);
        registerPanel.add(slash1);
        registerPanel.add(month);
        registerPanel.add(slash2);
        registerPanel.add(year);
        registerPanel.add(country);
        registerPanel.add(username);
        registerPanel.add(password);
        registerPanel.add(confirmPassword);
        registerPanel.add(next);
        registerPanel.add(create);
        registerPanel.add(previous);
        registerPanel.add(login);
        registerPanel.add(fnLabel);
        registerPanel.add(lnLabel);
        registerPanel.add(usLabel);
        registerPanel.add(aLabel);
        registerPanel.add(cLabel);
        registerPanel.add(psLabel);
        registerPanel.add(cpsLabel);

        this.registerPanel = registerPanel;

        // Add a focus listener to the JTextField
        TextFieldListener tl = new TextFieldListener();
        firstName.addFocusListener(tl);
        lastName.addFocusListener(tl);
        day.addFocusListener(tl);
        month.addFocusListener(tl);
        year.addFocusListener(tl);
        country.addFocusListener(tl);
        username.addFocusListener(tl);
        password.addFocusListener(tl);
        confirmPassword.addFocusListener(tl);
        

        // Add a component listener to the frame to listen for resizing events
        FrameListener fl = new FrameListener();
        this.fl = fl;
        frame.addComponentListener(fl);

        titlePanel.add(title);
        containerPanel.add(registerPanel);
        add(titlePanel);
        add(containerPanel);
    }

    /**
     * <p>
     * getFl method returns the framelistener for the current frame
     * </p>
     * 
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
            containerPanel.setBounds(0, textHeight, width, height - textHeight + 4);

            int cWidth = containerPanel.getWidth();
            int cHeight = containerPanel.getHeight();
            registerPanel.setBounds((cWidth - 500) / 2, (cHeight - 500) / 2, 500, 500);

            // Get the width and height of the panel and the text height
            int pWidth = registerPanel.getWidth();

            // Set Login bounds
            register.setBounds(0, 130, pWidth, 50);
            register.setHorizontalAlignment(SwingConstants.CENTER);

            // Set TextField, button and Label bounds
            firstName.setBounds(50, 225, 195, 50);
            lastName.setBounds(255, 225, 195, 50);
            day.setBounds(50, 315, 75, 50);
            slash1.setBounds(145, 315, 10, 50);
            month.setBounds(175, 315, 75, 50);
            slash2.setBounds(270, 315, 10, 50);
            year.setBounds(300, 315, 150, 50);
            country.setBounds(255, 225, 195, 50);
            username.setBounds(50, 225, 195, 50);
            password.setBounds(50, 315, 195, 50);
            confirmPassword.setBounds(255, 315, 195, 50);

            login.setBounds(50, 400, 160, 50);
            previous.setBounds(50, 400, 160, 50);
            next.setBounds(295, 400, 150, 50);
            create.setBounds(295, 400, 150, 50);

            fnLabel.setBounds(55, 210, 100, 15);
            lnLabel.setBounds(260, 210, 100,15);
            aLabel.setBounds(55, 300, 100, 15);
            cLabel.setBounds(260, 210, 100, 15);
            usLabel.setBounds(55, 210, 100, 15);
            psLabel.setBounds(55, 300, 100,15);
            cpsLabel.setBounds(260, 300, 150, 15);

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
            if (e.getSource() == username && username.getText().equals("Enter Username...")) {
                username.setText("");
                username.setForeground(Color.black);
            }
            if (e.getSource() == password && password.getText().equals("Enter Password...")) {
                password.setText("");
                password.setForeground(Color.black);
            }
            if (e.getSource() == firstName && firstName.getText().equals("Enter Firstname...")) {
                firstName.setText("");
                firstName.setForeground(Color.black);
            }
            if (e.getSource() == lastName && lastName.getText().equals("Enter Lastname...")) {
                lastName.setText("");
                lastName.setForeground(Color.black);
            }
            if (e.getSource() == confirmPassword && confirmPassword.getText().equals("Confirm Password...")) {
                confirmPassword.setText("");
                confirmPassword.setForeground(Color.black);
            }
            if (e.getSource() == day && day.getText().equals("00")) {
                day.setText("");
                day.setForeground(Color.black);
            }
            if (e.getSource() == month && month.getText().equals("00")) {
                month.setText("");
                month.setForeground(Color.black);
            }
            if (e.getSource() == year && year.getText().equals("0000")) {
                year.setText("");
                year.setForeground(Color.black);
            }
            if (e.getSource() == country && country.getText().equals("Enter Country...")) {
                country.setText("");
                country.setForeground(Color.black);
            }
        }

        /**
         * <p>
         * focusLost method sets the textfield text to default messages if no text has
         * been added
         * otherwise it leaves it as is
         * </p>
         */
        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource() == username && username.getText().equals("")) {
                username.setForeground(new Color(200, 200, 200));
                username.setText("Enter Username...");
            }
            if (e.getSource() == password && password.getText().equals("")) {
                password.setForeground(new Color(200, 200, 200));
                password.setText("Enter Password...");
            }
            if (e.getSource() == firstName && firstName.getText().equals("")) {
                firstName.setForeground(new Color(200, 200, 200));
                firstName.setText("Enter Firstname...");
            }
            if (e.getSource() == lastName && lastName.getText().equals("")) {
                lastName.setForeground(new Color(200, 200, 200));
                lastName.setText("Enter Lastname...");
            }
            if (e.getSource() == confirmPassword && confirmPassword.getText().equals("")) {
                confirmPassword.setForeground(new Color(200, 200, 200));
                confirmPassword.setText("Confirm Password...");
            }
            if (e.getSource() == day && day.getText().equals("")) {
                day.setForeground(new Color(200, 200, 200));
                day.setText("00");
            }
            if (e.getSource() == month && month.getText().equals("")) {
                month.setForeground(new Color(200, 200, 200));
                month.setText("00");
            }
            if (e.getSource() == year && year.getText().equals("")) {
                year.setForeground(new Color(200, 200, 200));
                year.setText("0000");
            }
            if (e.getSource() == country && country.getText().equals("")) {
                country.setForeground(new Color(200, 200, 200));
                country.setText("Enter Country...");
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
         * 
         * @param e The action event triggering this method
         */
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == login) {
                login.setBackground(new Color(220, 220, 220));
            }
            if (e.getSource() == create) {
                create.setBackground(new Color(0, 0, 180));
            }
            if (e.getSource() == submit) {
                submit.setBackground(new Color(0, 0, 180));
            }
            if (e.getSource() == previous) {
                previous.setBackground(new Color(220, 220, 220));
            }
            if (e.getSource() == next) {
                next.setBackground(new Color(0, 0, 180));
            }
        }

        /**
         * <p>
         * mouseExited method sets background color of buttons if mouse
         * is no longer over the button
         * </p>
         * 
         * @param e The action event triggering this method
         */
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == login) {
                login.setBackground(new Color(235, 235, 235));
            }
            if (e.getSource() == create) {
                create.setBackground(new Color(0, 0, 220));
            }
            if (e.getSource() == submit) {
                submit.setBackground(new Color(0, 0, 220));
            }
            if (e.getSource() == previous) {
                previous.setBackground(new Color(235, 235, 235));
            }
            if (e.getSource() == next) {
                next.setBackground(new Color(0, 0, 220));
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
         * 
         * @param e The action event triggering this method
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit && !username.getText().equals("") && !password.getText().equals("")) {
                DBManager.setAccount(username.getText());
                if (dbManager.checkNotNull() && dbManager.checkPassword(password.getText())) {
                    System.out.println("Yes");
                } else if (!dbManager.checkNotNull()) {
                    System.out.println("No account with username: " + username.getText());
                } else if (!dbManager.checkPassword(password.getText())) {
                    System.out.println("Wrong pasword");
                } else {
                    System.out.println("No");
                }

                dbManager.getAccount();
            }
            if(e.getSource() == next && isCompleted1()){
                firstName.setVisible(false);
                lastName.setVisible(false);
                day.setVisible(false);
                month.setVisible(false);
                year.setVisible(false);
                country.setVisible(true);
                username.setVisible(true);
                password.setVisible(true);
                confirmPassword.setVisible(true);

                fnLabel.setVisible(false);
                lnLabel.setVisible(false);
                aLabel.setVisible(false);
                cLabel.setVisible(true);
                usLabel.setVisible(true);
                psLabel.setVisible(true);
                cpsLabel.setVisible(true);

                login.setVisible(false);
                next.setVisible(false);
                previous.setVisible(true);
                create.setVisible(true);
                slash1.setVisible(false);
                slash2.setVisible(false);
            }
            if(e.getSource() == previous){
                firstName.setVisible(true);
                lastName.setVisible(true);
                day.setVisible(true);
                month.setVisible(true);
                year.setVisible(true);
                country.setVisible(false);
                username.setVisible(false);
                password.setVisible(false);
                confirmPassword.setVisible(false);

                fnLabel.setVisible(true);
                lnLabel.setVisible(true);
                aLabel.setVisible(true);
                cLabel.setVisible(false);
                usLabel.setVisible(false);
                psLabel.setVisible(false);
                cpsLabel.setVisible(false);

                login.setVisible(true);
                next.setVisible(true);
                previous.setVisible(false);
                create.setVisible(false);
                slash1.setVisible(true);
                slash2.setVisible(true);
            }
            if(e.getSource() == login){
                frameManager.clearFrame();
                frameManager.signIn();
            }
            if(e.getSource() == create && isCompleted2() && passwordsMatch() && checkAge()){
                String date = year.getText() + "-" + month.getText() + "-" + day.getText();
                dbManager.setupAccount(firstName.getText(), lastName.getText(), username.getText(), password.getText(), date, country.getText());
                frameManager.clearFrame();
                frameManager.signIn();
            }
        }
    }

    public boolean checkAge(){
        try{
            int x = Integer.parseInt(day.getText());
            int y = Integer.parseInt(month.getText());
            int z = Integer.parseInt(year.getText());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * <p>
     * isCompleted1 method checks if the firstname and lastname text fields
     * have been filled in 
     * </p>
     * @return true or false
     */
    public boolean isCompleted1(){
        boolean fnEmpty = (!firstName.getText().equals("") && !firstName.getText().equals("Enter Firstname..."));
        boolean lnEmpty = (!lastName.getText().equals("") && !lastName.getText().equals("Enter Lastname..."));
        boolean dEmpty = (!day.getText().equals("") && !day.getText().equals("00"));
        boolean mEmpty = (!month.getText().equals("") && !month.getText().equals("00"));
        boolean yEmpty = (!year.getText().equals("") && !year.getText().equals("00"));
        if(fnEmpty && lnEmpty && dEmpty && mEmpty && yEmpty){
            return true;
        }
        return false;
    }

    

    /**
     * <p>
     * isCompleted2 method checks if the username, password and confrim password text fields
     * have been filled in
     * </p>
     * @return true or false
     */
    public boolean isCompleted2(){
        boolean usEmpty = (!username.getText().equals("") && !username.getText().equals("Enter Username..."));
        boolean cEmpty = (!country.getText().equals("") && !country.getText().equals("Enter Country..."));
        boolean psEmpty = (!password.getText().equals("") && !password.getText().equals("Enter Password..."));
        boolean cpsEmpty = (!confirmPassword.getText().equals("") && !confirmPassword.getText().equals("Confirm Password..."));
        if(usEmpty && cEmpty && psEmpty && cpsEmpty){
            return true;
        }
        return false;
    }

    /**
     * <p>
     * passwordsMatch method check if the text in password textfield matches the password in
     * the confirm password textfield
     * </p>
     * @return true or false
     */
    public boolean passwordsMatch(){
        if(password.getText().equals(confirmPassword.getText())){
            return true;
        }
        return false;
    }
}
