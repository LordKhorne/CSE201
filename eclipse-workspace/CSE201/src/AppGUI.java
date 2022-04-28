import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
					Search window = new Search();
					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
            	
            }
		
		});
		
		JButton CommentBut = new JButton("Comments");
		CommentBut.setBounds(430, 0, 100, 20);
		panel.add(CommentBut);
		
		CommentBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e3) {
            	
            	EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frame.setVisible(false);
        					CommentGUI frame = new CommentGUI();
        					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        					frame.setSize(800, 800);
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
            	
            }
		
		});
		
		JPanel buttonsPanel = new JPanel(new GridLayout(5, 5, 2, 2));
		
		//DefaultListModel tmp = new DefaultListModel();
		JButton[] buttons = new JButton[apps.size()];
		for (int i = 0; i < apps.size(); i++) {
//			tmp.addElement(apps.get(i).getName());
			buttons[i] = new JButton(apps.get(i).getName());
			buttons[i].setSize(1, 1);
			buttons[i].setActionCommand(buttons[i].getName());
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String app = e.getActionCommand();
					//JOptionPane.showMessageDialog(null, "You have clicked: " + app); Test
					createAppFrame(app);
				}
				
			});
			buttonsPanel.add(buttons[i]);
		}
		
//		JList appList = new JList(tmp);
//		appList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		appList.setLayoutOrientation(JList.VERTICAL_WRAP);
//		buttons.setBounds(320, 20, 400, 200);
//		panel.add(BorderLayout.CENTER, appList);
		
		panel.add(buttonsPanel, BorderLayout.CENTER);
		frame.getContentPane().add(panel);
		frame.pack();
		
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