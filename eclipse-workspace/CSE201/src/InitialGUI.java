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

public class InitialGUI extends JFrame {

		
	private JPanel contentPane;
	static InitialGUI frame;
	
	public static void main(String[] args) {
				
		// Test comment
		
		try {
			
			frame = new InitialGUI();
			frame.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
				
	}
	


		/**
		 * Create the frame.
		 */
		public InitialGUI() {
			
			setTitle("Meta-Repo");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			
			JLabel ttlTxt = new JLabel("Meta-Repo");
			ttlTxt.setFont(new Font("Georgia", Font.BOLD, 50));
			ttlTxt.setBounds(235, 20, 400, 200);
			contentPane.add(ttlTxt);
			
			JLabel uNamTxt = new JLabel("Username:");
			uNamTxt.setFont(new Font("Georgia", Font.BOLD, 12));
			uNamTxt.setBounds(155, 260, 121, 30);
			contentPane.add(uNamTxt);
			
			JLabel passTxt = new JLabel("Password:");
			passTxt.setFont(new Font("Georgia", Font.BOLD, 12));
			passTxt.setBounds(155, 310, 121, 30);
			contentPane.add(passTxt);
			
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			
			JTextArea loginUName = new JTextArea();
			loginUName.setBounds(239, 260, 282, 31);
			//loginUName.lineLimit(2);
			loginUName.setFont(new Font("Serif", Font.PLAIN, 14));
			loginUName.setLineWrap(false);
			loginUName.setWrapStyleWord(true);
			loginUName.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(5, 10, 10, 10)));
			contentPane.add(loginUName);
			
			JTextArea loginPass = new JTextArea();
			loginPass.setBounds(239, 310, 282, 31);
			//loginUName.lineLimit(2);
			loginPass.setFont(new Font("Serif", Font.PLAIN, 14));
			loginPass.setLineWrap(false);
			loginPass.setWrapStyleWord(true);
			loginPass.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(5, 10, 10, 10)));
			contentPane.add(loginPass);
			
			
			JButton loginBut = new JButton("Login");
			loginBut.setBounds(265, 360, 211, 44);
			contentPane.add(loginBut);
			
			JLabel noAcc = new JLabel("Account not found!");
			noAcc.setFont(new Font("Georgia", Font.BOLD, 12));
			noAcc.setBounds(310, 400, 300, 30);
			noAcc.setForeground(Color.RED);
			noAcc.setVisible(false);
			contentPane.add(noAcc);
			
			JLabel wrngPass = new JLabel("Wrong Password!");
			wrngPass.setFont(new Font("Georgia", Font.BOLD, 12));
			wrngPass.setForeground(Color.RED);
			wrngPass.setBounds(310, 400, 300, 30);
			wrngPass.setVisible(false);
			contentPane.add(wrngPass);
			
			loginBut.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	String[] parts;
	            	boolean found = false;
	            	
	            	try(Scanner sca = new Scanner(new File("AccountFiles.txt"))){
	        			while(sca.hasNextLine() && !found) {
	        				
	        				String nxt = sca.nextLine();
	        				parts= nxt.split(" ", 2);;
	        				if(parts[0].equals(loginUName.getText())) {
	        					
	        					found = true;
	        					
	        					if(parts[1].equals(loginPass.getText())) {
	        						
	        						frame.setVisible(false);
	        						
	        					} else {
	        						
	        						wrngPass.setVisible(true);
	        						loginPass.setText("");
	        						
	        					}
	        					
	        				}
	        					
	        			}
	        			
	        			if (!found) {
	        				
	        				noAcc.setVisible(true);
	        				loginPass.setText("");
	        				
	        			}
	        			
	        		} catch (Exception e1) {
	        			e1.printStackTrace();
	        		}
	        	}
	            	
	            	
	            });
			
			
			
		}

}
