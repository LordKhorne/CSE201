
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

	public class Overview extends JFrame {

			
		private JPanel contentPane;
		static Overview frame;
		
		public static void main(String[] args) {
					
			try {
				
				frame = new Overview();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
					
		}
		


			/**
			 * Create the frame.
			 */
			public Overview() {
				
				setTitle("About");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 800, 600);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel contentPane2 = new JPanel();
				contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
				
				JLabel label = new JLabel("About");
				label.setFont(new Font("Georgia", Font.BOLD, 50));
				label.setBounds(320, 20, 400, 200);
				contentPane.add(label);
				
				JButton loginDirect = new JButton("Login");
				loginDirect.setBounds(20, 20, 70, 22);
				contentPane.add(loginDirect);
				
				JTextArea aboutTxt = new JTextArea();
				aboutTxt.append("This application is a repository for other applications. \nMeta-Repo can be compared to"
						+ " things such as the Apple App \nStore or the Google Play store. It is home to any "
						+ "applications \nwith features that help find, sort, and comment on certain \napplications. "
						+ "This application can sort applications in a few \ndifferent ways (i.e. A-Z). "
						+ "Each application has an area for users \nto leave comments, as well as a way to edit the "
						+ "comment \nsections if you are a moderator. Meto-Repo has a way to filter \napplications to "
						+ "narrow down your search, a request page for \nusers, and a search bar on each page. All of"
						+ " this is available to \neach user after they login using the initial login page.");
				aboutTxt.setOpaque(false);
				aboutTxt.setFont(new Font("Georgia", Font.PLAIN, 20));
				aboutTxt.setBounds(130, 185, 550, 275);
				aboutTxt.setEditable(false);
				contentPane.add(aboutTxt);
			
			loginDirect.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	LoginPage frame2 = null;
	            	frame2 = new LoginPage();
	            	frame.setVisible(false);
	            	frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            	frame2.setVisible(true);
	            	
	        	}
	            
	            });
			
			}
	}