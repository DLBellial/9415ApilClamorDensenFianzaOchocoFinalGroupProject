package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram {

    /**
     * This is the main method with its only function to call
     * the GUI method.
     *
     * @param args Unused.
     */
    public static void main(String [] args){
        GUI();
    }


    /**
     * This is the method that initializes and creates the window and buttons
     * and their respective action listeners
     */
    public static void GUI(){
        //Retrieves the local machine's screen size to center the frame
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Creates the window for the main menu
        JFrame frame = new JFrame("Citizen");
        JPanel panel = new JPanel();
        frame.setSize(300, 280);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(7,1));

        //Calculates the frame's location based on the screen size
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        //Sets the new frame location
        frame.setLocation(x, y);

        //Label for the menu
        JLabel menu = new JLabel("~~~~~~~~~~~~~~ Menu ~~~~~~~~~~~~~~");
        menu.setBounds(400,50,20,20);
        panel.add(menu);


        //Button for displaying Citizens if they are Residents or Non-Residents
        JButton residentbutton = new JButton("Sort Residents from Non-Residents");
        panel.add(residentbutton);
        residentbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedResidents(screenSize);
            }
        });



        //Button for displaying Citizens based on their Genders
        JButton genderbutton = new JButton("Sort Males from Females");
        panel.add(genderbutton);
        genderbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedGenders(screenSize);
            }
        });



        //Button for displaying Citizens based on their Districts
        JButton districtbutton = new JButton("Sort Based on Districts");
        panel.add(districtbutton);
        districtbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedDistricts(screenSize);
            }
        });



        //Button for displaying Citizens based on their Ages
        JButton agebutton = new JButton("Sort by Ascending Age");
        panel.add(agebutton);
        agebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedAges(screenSize);
            }
        });



        //Button for displaying Citizens based on their Last Names
        JButton lastNamebutton = new JButton("Sort Last Names Alphabetically");
        panel.add(lastNamebutton);
        lastNamebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedLastNames(screenSize);
            }
        });


        //Button for exiting the program
        JButton exitbutton = new JButton("Exit");
        panel.add(exitbutton);
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    /**
     * This method creates a new window which displays the list of citizens and sorts them based
     * on who are residents and those who are not residents.
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedResidents(Dimension screenSize){
        JFrame frame = new JFrame("Residents and Non-Residents");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        //Centers the window
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        frame.add(panel);

        //frame.getContentPane().add(Stuff); //Temporary (Displays the sorted list)

        //Returns user to main menu
        JButton back = new JButton("Back");
        back.setBounds(300, 150, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI();
            }
        });
        frame.add(back);
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * genders (Male or Female).
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedGenders(Dimension screenSize){
        JFrame frame = new JFrame("Genders");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        //Centers the window
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        frame.add(panel);

        //frame.getContentPane().add(Stuff); //Temporary (Displays the sorted list)


        //Returns user to main menu
        JButton back = new JButton("Back");
        back.setBounds(250, 150, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI();
            }
        });
        frame.add(back);
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * districts.
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedDistricts(Dimension screenSize){
        JFrame frame = new JFrame("Districts");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        //Centers the window
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        frame.add(panel);

        //frame.getContentPane().add(Stuff); //Temporary (Displays the sorted list)


        //Returns user to main menu
        JButton back = new JButton("Back");
        back.setBounds(250, 150, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI();
            }
        });
        frame.add(back);
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * ages in an ascending manner (youngest to oldest).
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedAges(Dimension screenSize){
        JFrame frame = new JFrame("Ages");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        //Centers the window
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        frame.add(panel);

        //frame.getContentPane().add(Stuff); //Temporary (Displays the sorted list)

        //Returns user to main menu
        JButton back = new JButton("Back");
        back.setBounds(250, 150, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI();
            }
        });
        frame.add(back);
    }

    /**
     * This method creates a new window which displays the alphabetically sorted list of citizens
     * based on their last names.
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedLastNames(Dimension screenSize){
        JFrame frame = new JFrame("Surnames");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        //Centers the window
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        frame.add(panel);

        //frame.getContentPane().add(Stuff); //Temporary (Displays the sorted list)


        //Returns user to main menu
        JButton back = new JButton("Back");
        back.setBounds(250, 150, 30,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI();
            }
        });
        frame.add(back);
    }
}
