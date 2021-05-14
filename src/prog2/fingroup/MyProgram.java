package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram {
    public static void main(String [] args){
        GUI();
    }

    public static void GUI(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        JFrame frame = new JFrame("Citizen");
        JPanel panel = new JPanel();
        frame.setSize(300, 280);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(7,1));

        //Calculate the frame location
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        //Set the new frame location
        frame.setLocation(x, y);

        JLabel menu = new JLabel("~~~~~~~~~~~~~~ Menu ~~~~~~~~~~~~~~");
        menu.setBounds(400,50,20,20);
        panel.add(menu);


        //Buttons
        JButton residentbutton = new JButton("Sort Residents from Non-Residents");
        residentbutton.setBounds(250, 70, 30,30);
        panel.add(residentbutton);

        JButton genderbutton = new JButton("Sort Males from Females");
        genderbutton.setBounds(250, 90, 30,30);
        panel.add(genderbutton);

        JButton districtbutton = new JButton("Sort Based on Districts");
        districtbutton.setBounds(250,110,30,30);
        panel.add(districtbutton);

        JButton agebutton = new JButton("Sort by Ascending Age");
        agebutton.setBounds(250, 130, 30,30);
        panel.add(agebutton);

        JButton lastNamebutton = new JButton("Sort Last Names Alphabetically");
        lastNamebutton.setBounds(250, 150, 30,30);
        panel.add(lastNamebutton);

        JButton exitbutton = new JButton("Exit");
        exitbutton.setBounds(250, 170,30,30);
        panel.add(exitbutton);

    }
}
