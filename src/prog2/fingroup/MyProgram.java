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
        residentbutton.setBounds(250, 70, 30,30);
        residentbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedResidents(screenSize);
            }
        });
        panel.add(residentbutton);


        //Button for displaying Citizens based on their Genders
        JButton genderbutton = new JButton("Sort Males from Females");
        genderbutton.setBounds(250, 90, 30,30);
        genderbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedGenders(screenSize);
            }
        });
        panel.add(genderbutton);


        //Button for displaying Citizens based on their Districts
        JButton districtbutton = new JButton("Sort Based on Districts");
        districtbutton.setBounds(250,110,30,30);
        districtbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedDistricts(screenSize);
            }
        });
        panel.add(districtbutton);


        //Button for displaying Citizens based on their Ages
        JButton agebutton = new JButton("Sort by Ascending Age");
        agebutton.setBounds(250, 130, 30,30);
        agebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedAges(screenSize);
            }
        });
        panel.add(agebutton);


        //Button for displaying Citizens based on their Last Names
        JButton lastNamebutton = new JButton("Sort Last Names Alphabetically");
        lastNamebutton.setBounds(250, 150, 30,30);
        lastNamebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSortedLastNames(screenSize);
            }
        });
        panel.add(lastNamebutton);

        //Button for exiting the program
        JButton exitbutton = new JButton("Exit");
        exitbutton.setBounds(250, 170,30,30);
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(exitbutton);

    }

    /**
     * This method creates a new window which displays the list of citizens and sorts them based
     * on who are residents and those who are not residents.
     *
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedResidents(Dimension screenSize){
        JFrame residentFrame = new JFrame("Residents and Non-Residents");
        residentFrame.setSize( 800,800 );
        int x = (screenSize.width - residentFrame.getWidth()) / 2;
        int y = (screenSize.height - residentFrame.getHeight()) / 2;
        residentFrame.setLocation(x, y);
        JLabel residentLabel = new JLabel("Sorted Residents from Non-Residents");
        residentLabel.setBounds( 30, 10, 150,100 );
        residentFrame.setVisible(true);

        residentFrame.getContentPane().add( residentLabel ); //Temporary
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * genders (Male or Female).
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedGenders(Dimension screenSize){
        JFrame genderFrame = new JFrame("Genders");
        genderFrame.setSize( 800,800 );
        int x = (screenSize.width - genderFrame.getWidth()) / 2;
        int y = (screenSize.height - genderFrame.getHeight()) / 2;
        genderFrame.setLocation(x, y);
        JLabel genderLabel = new JLabel("Sorted Males from Females");
        genderLabel.setBounds( 30, 10, 150,100 );
        genderFrame.setVisible(true);

        genderFrame.getContentPane().add(genderLabel); //Temporary
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * districts.
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedDistricts(Dimension screenSize){
        JFrame districtFrame = new JFrame("Districts");
        districtFrame.setSize( 800,800 );
        int x = (screenSize.width - districtFrame.getWidth()) / 2;
        int y = (screenSize.height - districtFrame.getHeight()) / 2;
        districtFrame.setLocation(x, y);
        JLabel districtLabel = new JLabel("Sorted Based on Districts");
        districtLabel.setBounds( 30, 10, 150,100 );
        districtFrame.setVisible(true);

        districtFrame.getContentPane().add(districtLabel); //Temporary
    }

    /**
     * This method creates a new window which displays the sorted list of citizens based on their
     * ages in an ascending manner (youngest to oldest).
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedAges(Dimension screenSize){
        JFrame ageFrame = new JFrame("Ages");
        ageFrame.setSize( 800,800 );
        int x = (screenSize.width - ageFrame.getWidth()) / 2;
        int y = (screenSize.height - ageFrame.getHeight()) / 2;
        ageFrame.setLocation(x, y);
        JLabel ageLabel = new JLabel("Sorted Based on Age");
        ageLabel.setBounds( 30, 10, 150,100 );
        ageFrame.setVisible(true);

        ageFrame.getContentPane().add(ageLabel); //Temporary
    }

    /**
     * This method creates a new window which displays the alphabetically sorted list of citizens
     * based on their last names.
     *
     * @param screenSize to compute screen size and center the window.
     */
    public static void showSortedLastNames(Dimension screenSize){
        JFrame lastNameFrame = new JFrame("Surnames");
        lastNameFrame.setSize( 800,800 );
        int x = (screenSize.width - lastNameFrame.getWidth()) / 2;
        int y = (screenSize.height - lastNameFrame.getHeight()) / 2;
        lastNameFrame.setLocation(x, y);
        JLabel lastNameLabel = new JLabel("Sorted Last Names Alphabetically");
        lastNameLabel.setBounds( 30, 10, 150,100 );
        lastNameFrame.setVisible(true);


        lastNameFrame.getContentPane().add(lastNameLabel); //Temporary
    }
}
