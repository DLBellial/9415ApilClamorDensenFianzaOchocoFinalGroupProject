package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class MyProgram {
    // Contains the Gui
    static JButton residentbutton, malebutton, femalebutton, exitbutton;

    //resident
    static JFrame residentFrame;
    static JLabel residentLabel;
    static JButton residentBack;
    //male
    static JFrame maleFrame;
    static JLabel maleLabel;
    static JButton maleBack;
    //female
    static JFrame femaleFrame;
    static JLabel femaleLabel;
    static JButton femaleBack;

    public static void main(String[] args) {
        Frame();
    }

    //menu frame
    public static void Frame(){
        JFrame frame = new JFrame("Citizen");
        frame.setSize( 500,500 );
        frame.getContentPane().setLayout( new FlowLayout() );
        residentbutton = new JButton("Sort Resident");
        malebutton = new JButton("Sort Male");
        femalebutton = new JButton("Sort Female");
        exitbutton = new JButton("Exit");

        frame.add( residentbutton );
        frame.add( malebutton );
        frame.add( femalebutton );
        frame.add( exitbutton );

        frame.setLayout( new GridLayout(4, 1) );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //perform action every button
        residentbutton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                buttonResident();
            }
        } );
        malebutton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                buttonMale();
            }
        } );
        femalebutton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                buttonFemale();
            }
        } );
    }

    public static void buttonResident(){
        residentFrame = new JFrame("Citizen");
        residentFrame.setSize( 500,500 );
        residentLabel = new JLabel("Sort Male");
        residentLabel.setBounds( 30, 10, 150,100 );
        residentBack = new JButton("Back");
        residentBack.setBounds( 100, 400, 200, 30 );

        residentFrame.getContentPane().add( residentLabel );
        residentFrame.getContentPane().add( residentBack );
    }

    public static void buttonMale(){
        maleFrame = new JFrame("Citizen");
        maleFrame.setSize( 500,500 );
        maleLabel = new JLabel("Sort Resident");
        maleLabel.setBounds( 30, 10, 150,100 );
        maleBack = new JButton("Back");
        maleBack.setBounds( 100, 400, 200, 30 );

        maleFrame.getContentPane().add( maleLabel );
        maleFrame.getContentPane().add( maleBack );
    }

    public static void buttonFemale(){
        femaleFrame = new JFrame("Citizen");
        femaleFrame.setSize( 500,500 );
        femaleLabel = new JLabel("Sort Female");
        femaleLabel.setBounds( 30, 10, 150,100 );
        femaleBack = new JButton("Back");
        femaleBack.setBounds( 100, 400, 200, 30 );

        femaleFrame.getContentPane().add( femaleLabel );
        femaleFrame.getContentPane().add( femaleBack );
    }


}
