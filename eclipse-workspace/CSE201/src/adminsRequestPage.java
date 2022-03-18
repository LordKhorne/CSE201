import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class adminsRequestPage extends JFrame{
	//private JPanel contentPane;
	
	
	static adminsRequestPage frame;
	
	public adminsRequestPage() {
		
		frame = this;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame contentPane = new JFrame("Admins Request Page");
        contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setSize(400, 400);

        //creating text and text bar at the bottom
        JPanel panel = new JPanel(); 
        JLabel label = new JLabel("Enter Text:");
        JTextField textBox = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(textBox);
        panel.add(send);
        panel.add(reset);

        JTextArea comments = new JTextArea();

        //Adding Components to the frame.
        contentPane.getContentPane().add(BorderLayout.SOUTH, panel);
        contentPane.getContentPane().add(BorderLayout.CENTER, comments);
        contentPane.setVisible(true);	
       
        
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	comments.append(textBox.getText() + "\n");
            	textBox.setText(null);
            }
         });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	textBox.setText(null);
            }
         });
	}
}
