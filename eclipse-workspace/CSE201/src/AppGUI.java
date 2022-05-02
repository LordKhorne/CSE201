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
//					Search window = new Search();
//					window.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
            	
            }
		
		});
		
		JButton CommentBut = new JButton("Comments");
		CommentBut.setBounds(600, 0, 80, 20);
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
		
		DefaultListModel<String> l1 = new DefaultListModel<>();
		for (Application a : apps) {
			l1.addElement(a.name);
		}
		
		list = new JList<>(l1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.add(list);
		
		
		
		
		JButton nextBut = new JButton("Press to select");
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
