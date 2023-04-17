package FresherFootball;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar extends JPanel{

    private FrameListener fl;
    private JButton home, team, training, stats;

    public MenuBar(){
        setLayout(null);
        setBackground(new Color(0, 171, 255));

        JButton home = new JButton("Home");
        home.setBounds(0, 0, 100, 20);
        home.setOpaque(true);
        home.setFont(new Font("Impact", Font.PLAIN, 20));
        home.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        home.setBackground(new Color(0, 171, 255));
        home.setForeground(Color.black);
        this.home = home;
        add(home);

        JButton team = new JButton("Team");
        team.setBounds(0, 0, 100, 20);
        team.setOpaque(true);
        team.setFont(new Font("Impact", Font.PLAIN, 20));
        team.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        team.setBackground(new Color(0, 171, 255));
        team.setForeground(Color.black);
        this.team = team;
        add(team);

        JButton training= new JButton("Training");
        training.setBounds(0, 0, 100, 20);
        training.setOpaque(true);
        training.setFont(new Font("Impact", Font.PLAIN, 20));
        training.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        training.setBackground(new Color(0, 171, 255));
        training.setForeground(Color.black);
        this.training = training;
        add(training);

        JButton stats = new JButton("Stats");
        stats.setBounds(0, 0, 100, 20);
        stats.setOpaque(true);
        stats.setFont(new Font("Impact", Font.PLAIN, 20));
        stats.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        stats.setBackground(new Color(0, 171, 255));
        stats.setForeground(Color.black);
        this.stats = stats;
        add(stats);

        // Add Button listeners
        ButtonListener bl = new ButtonListener();
        home.addMouseListener(bl);
        home.addActionListener(bl);
        team.addMouseListener(bl);
        team.addActionListener(bl);
        training.addMouseListener(bl);
        training.addActionListener(bl);
        stats.addMouseListener(bl);
        stats.addActionListener(bl);

        // Add a component listener to the frame to listen for resizing events
        FrameListener fl = new FrameListener();
        this.fl = fl;
        this.addComponentListener(fl);
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

    public class FrameListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            // Get the width and height of the frame and the text height
            int width = getWidth();

            home.setBounds(0, 0, width/4, 26);
            team.setBounds(width/4, 0, width/4, 26);
            training.setBounds(width/2, 0, width/4, 26);
            stats.setBounds((3*width)/4, 0, width/4, 26);
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
            if(e.getSource() == home){
                home.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            }
            if(e.getSource() == team){
                team.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            }
            if(e.getSource() == training){
                training.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            }
            if(e.getSource() == stats){
                stats.setBorder(BorderFactory.createLineBorder(Color.white, 1));
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
            if(e.getSource() == home){
                home.setBorder(BorderFactory.createLineBorder(Color.white, 0));
            }
            if(e.getSource() == team){
                team.setBorder(BorderFactory.createLineBorder(Color.white, 0));
            }
            if(e.getSource() == training){
                training.setBorder(BorderFactory.createLineBorder(Color.white, 0));
            }
            if(e.getSource() == stats){
                stats.setBorder(BorderFactory.createLineBorder(Color.white, 0));
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
            
        }
    }
}
