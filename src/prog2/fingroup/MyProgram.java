package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This is a program that assists students by displaying
 * their past, currently enrolled, and upcoming courses
 * and utilizes CSV(Comma Separated Variables) files to
 * retrieve data. Users are also able to enter new courses
 * and grades which the program can compute the weighted
 * average for.
 *
 *
 * @authors Enrico Ochoco, Densen Kirk, Clamor John Daniel, Fianza Markuzz, Apil Rohanna, Taberna Margarette Casey
 * @version 1.0
 * @since 2021-04-28
 */

public class MyProgram {

    /**
     * This is the main method with its only function to call
     * the GUI method.
     *
     * @param args Unused.
     */
    public static void main(String [] args) throws Exception {
        MyProgramUtility.Record();
        GUI();
    }


    /**
     * This is the method that initializes and creates the window and buttons
     * and their respective action listeners
     *
     * @throws Exception
     */
    public static void GUI() throws Exception {
        //Retrieves the local machine's screen size to be used to center the window
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
        //Creates an action listener corresponding to the button press
        residentbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    showSortedLists(screenSize, MyProgramUtility.displaySortedResidents());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });



        //Button for displaying Citizens based on their Genders
        JButton genderbutton = new JButton("Sort Males from Females");
        panel.add(genderbutton);
        //Creates an action listener corresponding to the button press
        genderbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    showSortedLists(screenSize, MyProgramUtility.displaySortedGenders());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });



        //Button for displaying Citizens based on their Districts
        JButton districtbutton = new JButton("Sort Based on Districts");
        panel.add(districtbutton);
        districtbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    showSortedLists(screenSize, MyProgramUtility.displaySortedDistricts());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });



        //Button for displaying Citizens based on their Ages
        JButton agebutton = new JButton("Sort by Ascending Age");
        panel.add(agebutton);
        //Creates an action listener corresponding to the button press
        agebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    showSortedLists(screenSize, MyProgramUtility.displaySortedAges());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });



        //Button for displaying Citizens based on their Last Names
        JButton lastNamebutton = new JButton("Sort Last Names Alphabetically");
        panel.add(lastNamebutton);
        //Creates an action listener corresponding to the button press
        lastNamebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    showSortedLists(screenSize, MyProgramUtility.displaySortedLastNames());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        //Button for exiting the program
        JButton exitbutton = new JButton("Exit");
        panel.add(exitbutton);
        //Creates an action listener corresponding to the button press
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    /**
     * This method displays the sorted arrays into the graphic user interface by creating
     * a new and bigger window.
     *
     * @param screenSize
     * @param record
     */
    public static void showSortedLists(Dimension screenSize, ArrayList<Citizen> record){
        JFrame frame = new JFrame("Citizens");
        frame.setSize( 800,800 );
        frame.setVisible(true);

        ArrayList<Citizen> recordArray = record;
        String[][] data = new String[MyProgramUtility.lineNumber][8];
        for (int a = 0; a < data.length; a++){
            data[a][0]  = recordArray.get(a).firstName;
            data[a][1]  = recordArray.get(a).lastName;
            data[a][2]  = recordArray.get(a).email;
            data[a][3]  = recordArray.get(a).address;
            data[a][4]  = String.valueOf(recordArray.get(a).age);
            data[a][5]  = String.valueOf(recordArray.get(a).resident);
            data[a][6]  = String.valueOf(recordArray.get(a).district);
            data[a][7]  = String.valueOf(recordArray.get(a).gender);
        }
        String[] columnNames = {"First Name", "Last Name", "Email", "Address", "Age", "Residency", "Districts", "Gender"};
        JTable table = new JTable(data, columnNames);
        table.setBounds(30,40,780,780);
        // adding it to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
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
        frame.add(back);
        //Creates an action listener corresponding to the button press
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    GUI();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }
}
