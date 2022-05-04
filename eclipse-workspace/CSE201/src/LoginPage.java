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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class LoginPage extends JFrame {

		
	private JPanel contentPane;
	static LoginPage frame;
	
	public static void main(String[] args) {
				
		// Test comment
		
		try {
			
			frame = new LoginPage();
			frame.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
				
	}
	


		/**
		 * Create the frame.
		 */
		public LoginPage() {
			
			frame = this;
			setTitle("Meta-Repo");
			
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
			
			JTextField loginUName = new JTextField(15);
			loginUName.setBounds(239, 260, 282, 31);
			loginUName.setFont(new Font("Serif", Font.PLAIN, 14));
			loginUName.setBorder(BorderFactory.createCompoundBorder(border,
		    BorderFactory.createEmptyBorder(3, 10, 3, 10)));
			contentPane.add(loginUName);
			
			JTextField loginPass = new JTextField(15);
			loginPass.setBounds(239, 310, 282, 31);
			loginPass.setFont(new Font("Serif", Font.PLAIN, 14));
			loginPass.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(3, 10, 3, 10)));
			contentPane.add(loginPass);
			
			JLabel noAcc = new JLabel("Account not found!");
			noAcc.setFont(new Font("Georgia", Font.BOLD, 12));
			noAcc.setBounds(310, 400, 300, 30);
			noAcc.setForeground(Color.RED);
			noAcc.setVisible(false);
			contentPane.add(noAcc);
			
			JLabel yesAcc = new JLabel("Account already exists!");
			yesAcc.setFont(new Font("Georgia", Font.BOLD, 12));
			yesAcc.setBounds(310, 400, 300, 30);
			yesAcc.setForeground(Color.RED);
			yesAcc.setVisible(false);
			contentPane.add(yesAcc);
			
			JLabel yesAccMade = new JLabel("Account created!");
			yesAccMade.setFont(new Font("Georgia", Font.BOLD, 12));
			yesAccMade.setBounds(310, 400, 300, 30);
			yesAccMade.setForeground(Color.GREEN);
			yesAccMade.setVisible(false);
			contentPane.add(yesAccMade);
			
			JLabel wrngPass = new JLabel("Wrong Password!");
			wrngPass.setFont(new Font("Georgia", Font.BOLD, 12));
			wrngPass.setForeground(Color.RED);
			wrngPass.setBounds(310, 400, 300, 30);
			wrngPass.setVisible(false);
			contentPane.add(wrngPass);
			
			JButton loginBut = new JButton("Login");
			loginBut.setBounds(265, 360, 211, 44);
			contentPane.add(loginBut);
			
			JButton registerBut = new JButton("Register Account");
			registerBut.setBounds(265, 425, 211, 44);
			contentPane.add(registerBut);
			
			registerBut.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	
	            	String[] parts;
	            	boolean found = false;
	            	
	            	try(Scanner sca = new Scanner(new File("AccountFiles.txt"))){
	        			while(sca.hasNextLine() && !found) {
	        				
	        				if(loginUName.getText().isEmpty()) return;
	        				
	        				yesAcc.setVisible(false);
	    					wrngPass.setVisible(false);
	    					noAcc.setVisible(false);
	    					yesAccMade.setVisible(false);
	        				String nxt = sca.nextLine();
	        				parts= nxt.split(" ", 2);;
	        				if(parts[0].equals(loginUName.getText())) {
	        					
	        					wrngPass.setVisible(false);
        						noAcc.setVisible(false);
        						yesAcc.setVisible(true);
	        					found = true;
	        					
	        				} 
	        				
	        			}
	        					
	        				if(found == false)	{
	        					
	        					String fileName = "AccountFiles.txt";
	        					File newFile = new File(fileName);
	        					
	        					try {
	        						FileWriter fileWriter = new FileWriter(newFile, true);
	        						
	        						fileWriter.write("\n" + loginUName.getText() + " " + loginPass.getText());
	        						fileWriter.close();
	        						yesAcc.setVisible(false);
	        						wrngPass.setVisible(false);
	        						noAcc.setVisible(false);
	        						yesAccMade.setVisible(true);
	        						
	        					} catch (IOException e1) {
	        						
	        						
	        						e1.printStackTrace();
	        					}
	        					
	        				}
	        				
	            	} catch (Exception e1) {
	        			e1.printStackTrace();
	        		}
	            	
	            }
			});
			
			
			
			loginBut.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	yesAcc.setVisible(false);
					wrngPass.setVisible(false);
					noAcc.setVisible(false);
					yesAccMade.setVisible(false);
					
	            	String[] parts;
	            	boolean found = false;
	            	
	            	try(Scanner sca = new Scanner(new File("AccountFiles.txt"))){
	        			while(sca.hasNextLine() && !found) {
	        				
	        				String nxt = sca.nextLine();
	        				parts= nxt.split(" ", 3);;
	        				if(parts[0].equals(loginUName.getText())) {
	        					
	        					found = true;
	        					
	        					if(parts[1].equals(loginPass.getText())) {
	        						
	        						File newFile = new File("AccountInfo.txt");
	        							
	        						try {
	        							FileWriter fileWriter = new FileWriter(newFile, false);
	        								
	        							fileWriter.write(loginUName.getText() + " " + parts[2]);
	        							fileWriter.close();
	        							
	        						} catch (IOException e4) {
	        							
	        							e4.printStackTrace();
	        							
	        						}
	        						
	        						frame.setVisible(false);
	        						
	        						AppGUI newWindow = new AppGUI();
	        						File reader = new File("appList.txt");
	        						try {
	        							Scanner appReader = new Scanner(reader);
	        							
	        							if(newWindow.apps.size() == 0) {
	        							
	        								while (appReader.hasNextLine()) {
	        									String name = appReader.nextLine();
	        									Application tmp = new Application(name);
	        									newWindow.apps.add(tmp);
	        								
	        								
	        								}
	        							}
	        						} catch (FileNotFoundException e1) {
	        							// TODO Auto-generated catch block
	        							e1.printStackTrace();
	        						}
	        						
	        						
	        						
	        						newWindow.createFrame();
	        						
	        						
	        					} else {
	        						
	        						yesAcc.setVisible(false);
	        						noAcc.setVisible(false);
	        						wrngPass.setVisible(true);
	        						loginPass.setText("");
	        						
	        					}
	        					
	        				}
	        					
	        			}
	        			
	        			if (!found) {
	        				
	        				yesAcc.setVisible(false);
	        				wrngPass.setVisible(false);
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
