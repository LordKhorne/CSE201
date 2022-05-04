import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AppGUI {
	
	public static ArrayList<Application> apps = new ArrayList<Application>();
	private static JList<String> list;
	
	public static void main(String[] args) {
		
		
		File reader = new File("appList.txt");
		try {
			Scanner appReader = new Scanner(reader);
			while (appReader.hasNextLine()) {
				String name = appReader.nextLine();
				Application tmp = new Application(name);
				apps.add(tmp);
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		createFrame();
		
	}
	
	public static void createFrame() {
		JFrame frame = new JFrame("Applications");
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		
		JLabel title = new JLabel("Applications", SwingConstants.CENTER);
		title.setFont(new Font("Georgia", Font.BOLD, 40));
		title.setBounds(320, 20, 400, 200);
		panel.add(BorderLayout.NORTH, title);
		
		JButton searchBut = new JButton("Search");
		searchBut.setBounds(0, 0, 80, 20);
		panel.add(searchBut);
		
		searchBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
            	
            	frame.setVisible(false);
				try {
					
					frame.setVisible(false);
					searcgGUI frame = new searcgGUI();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
            	
            }
		
		});
		
		File reader = new File("AccountInfo.txt");
		String accountName = "";
		boolean administrator = false;
		
		try {
			Scanner appReader = new Scanner(reader);
			accountName = appReader.next();
			if(appReader.next().equals("true")) administrator = true;
			else administrator = false;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel account;
		if(administrator) account = new JLabel("Signed in as Administrator " + accountName);
		else account = new JLabel("Signed in as " + accountName);
		account.setFont(new Font("Georgia", Font.BOLD, 12));
		account.setBounds(450, -5, 500, 30);
		panel.add(account);
		
		JButton signoutBut = new JButton("Sign out");
		signoutBut.setBounds(700, 0, 80, 20);
		panel.add(signoutBut);
		
		signoutBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fileName = "AccountInfo.txt";
				File newFile = new File(fileName);
				
				try {
					FileWriter fileWriter = new FileWriter(newFile, false);
					
					fileWriter.write("");
					fileWriter.close();
					
				} catch (IOException e1) {
					
					
					e1.printStackTrace();
				}
				
				LoginPage frame2 = null;
            	frame2 = new LoginPage();
            	frame.setVisible(false);
            	frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	frame2.setVisible(true);
				
			}
			
		});
		
		if(administrator) {
			
			JButton manageAppsBut = new JButton("Manage Apps");
			manageAppsBut.setBounds(660, 30, 120, 20);
			manageAppsBut.setFont(new Font("Georgia", Font.BOLD, 12));
			panel.add(manageAppsBut);
			
			manageAppsBut.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					AdminsRequestPage frame2 = null;
	            	frame2 = new AdminsRequestPage();
	            	frame.setVisible(false);
	            	frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					
				}
				
			});
			
		}
		
		
		//JButton CommentBut = new JButton("Comments");
		//CommentBut.setBounds(300, 0, 80, 20);
		//panel.add(CommentBut);
		
//		CommentBut.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e3) {
//            	
//            	EventQueue.invokeLater(new Runnable() {
//        			public void run() {
//        				try {
//        					frame.setVisible(false);
//        					CommentGUI frame = new CommentGUI();
//        					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        					frame.setSize(800, 800);
//        					frame.setVisible(true);
//        				} catch (Exception e) {
//        					e.printStackTrace();
//        				}
//        			}
//        		});
//            	
//            }
//		
//		});
		
		DefaultListModel<String> l1 = new DefaultListModel<>();
		for (Application a : apps) {
			l1.addElement(a.name);
		}
		
		list = new JList<>(l1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.add(list);
		
		
		
		
		JButton nextBut = new JButton("Press to select comment section");
		nextBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					frame.setVisible(false);
					NewCommentGUI n = new NewCommentGUI(list.getSelectedValue());
					n.setVisible(true);
					n.setSize(800, 800);
				}
			}
			
		});
		panel.add(nextBut, BorderLayout.EAST);
		
		//frame.pack();
		//frame.getContentPane().add(panel);
		
		JButton nextBut2 = new JButton("Press to select description");
		nextBut2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					frame.setVisible(false);
					DescriptionGUI d = new DescriptionGUI(list.getSelectedValue());
					d.setVisible(true);
					d.setSize(800, 800);
				} 
			}
			
		});
		panel.add(nextBut2, BorderLayout.SOUTH);
		
		//frame.pack();
		frame.getContentPane().add(panel);
		
		
	}

	
	protected static void createAppFrame(String app) {
		// TODO Auto-generated method stub
//		Application tmp = apps.get(apps.indexOf(app));
//		
//		JFrame frame = new JFrame(app);
//		JPanel panel = new JPanel(new BorderLayout());
//		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(800, 800);
//		frame.setVisible(true);
//		
//		JLabel title = new JLabel(tmp.name, SwingConstants.CENTER);
//		title.setFont(new Font("Georgia", Font.BOLD, 40));
//		title.setBounds(320, 20, 400, 200);
//		panel.add(BorderLayout.NORTH, title);
	}
	
	
	
}
