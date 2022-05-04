import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DescriptionGUI extends JFrame {
	
	public DescriptionGUI(String name) {
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel label = new JLabel(name + " Description");
		label.setBounds(0, 0, 800, 65);
		label.setFont(new Font("Georgia", Font.BOLD, 50));
		panel.add(label);
		
		JTextArea desc = new JTextArea(20, 20);
		desc.setBounds(130, 250, 550, 275);
		desc.setFont(new Font("Georgia", Font.PLAIN, 20));
		desc.setLineWrap(true);
		desc.setWrapStyleWord(true);
		desc.setOpaque(false);
		File f = new File(name + "Description.txt");
		try {
			Scanner sc = new Scanner(f);
			if (sc.hasNextLine()) {
				desc.setText(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desc.setEditable(false);
		panel.add(desc);
		
		JButton backButton = new JButton("Back to List");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				dispose();
				AppGUI.createFrame();
				
			}
		});
		backButton.setBounds(670, 700, 117, 29);
		panel.add(backButton);
		
	}
	
	public static void main(String[] args) {
		/*
		File reader = new File("appList.txt");
		try {
			Scanner appReader = new Scanner(reader);
			while (appReader.hasNextLine()) {
				String name = appReader.nextLine();
				File newFile = new File(name + "Description.txt");
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}
	
}
