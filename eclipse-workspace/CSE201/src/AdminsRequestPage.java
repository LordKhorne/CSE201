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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class AdminsRequestPage extends JFrame{
	//private JPanel contentPane;
	
	
	static AdminsRequestPage frame;
	
	public AdminsRequestPage() {
		
		frame = this;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame contentPane = new JFrame("Admins Request Page");
        contentPane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane.setSize(600, 600);

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
        
        //Adding and deleting applications for admin
        JButton add = new JButton("Add");
        JButton delete = new JButton("Delete");
        panel.add(add);
        panel.add(delete);

        JButton returnBut = new JButton("Return");
		returnBut.setBounds(0, 0, 50, 50);
		panel.add(returnBut);
		
		returnBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	contentPane.setVisible(false);
				
				AppGUI newWindow = new AppGUI();
				
				newWindow.apps.clear();
				
				File reader = new File("appList.txt");
				try {
					Scanner appReader = new Scanner(reader);
					while (appReader.hasNextLine()) {
						String name = appReader.nextLine();
						Application tmp = new Application(name);
						newWindow.apps.add(tmp);
						
						
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				newWindow.createFrame();
				
            	
            }
		});
        
        

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
        
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		String filename= "appList.txt";
            		FileWriter fw = new FileWriter(filename,true); 
            		fw.write(textBox.getText() + "\n");//appends the string to the file
            		fw.close();
            		comments.append("You just added \"" + textBox.getText() + "\" to the app list!" + "\n");
                	textBox.setText(null);
            	}catch(IOException ioe){
            	    System.err.println("IOException: " + ioe.getMessage());
            	}

            }
         });
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		File filename = new File("appList.txt");  
            		File temp = new File("myTempFile.txt");  
            		
            		String delete = textBox.getText();
            		FileWriter fw = new FileWriter(temp,true); 
            		BufferedReader reader = new BufferedReader(new FileReader(filename));
            		
            		for(String line; (line = reader.readLine()) != null;) {
            			if(line.equals(delete)) {
            				continue;
            			}
            			fw.write(line + "\n");
            		}
            		comments.append("You just deleted \"" + textBox.getText() + "\" from the app list!" + "\n");
                	textBox.setText(null);
                	 fw.close(); 
                     reader.close(); 
                	boolean successful = temp.renameTo(filename);
                    System.out.println(successful);
            	}catch(IOException ioe){
            	    System.err.println("IOException: " + ioe.getMessage());
            	}
            }
         });
        
	}
}
