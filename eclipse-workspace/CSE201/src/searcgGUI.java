import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class searcgGUI extends JFrame{

	private String[] apps;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JTextField searchField;
	private JTextArea results;
	private JPanel buttonsPanel;
	ArrayList<String> matches;

	public searcgGUI() {
		frame = new JFrame();
		frame.setSize(500, 390);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("Search Function");
		frame.setLayout(new BorderLayout());
		buttonsPanel = new JPanel(new BorderLayout() );
		
	

		label = new JLabel("Find an app:");

		searchField = new JTextField(15);

		JButton submit = new JButton("Submit");

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] apps = { "Instagram", "Snapchat", "Canvas", "GroupMe", "Tinder", "Disney+"
		, "TikTok", "Google", "YouTube", "Twitter","Amazon", "Ebay", "Venmo", "DoorDash", "Jetpack Joyride", "Egg Inc", "Angry Birds", "Hulu", "Spotify" };

			  matches = new ArrayList<String>();
				String appName = searchField.getText();
				
				if (!(searchField.getText().length() >= 1)) {
					results = new JTextArea(20, 40);
				    results.setText("Please enter at least one letter");
				    panel.add(results, BorderLayout.SOUTH);
				    results.revalidate();
				    
					
				}
				
				
				
				
				
				
				
				
				

				for (int i = 0; i < apps.length; i++) {
					if (apps[i].equalsIgnoreCase(appName) || (apps[i].startsWith(appName))
							|| (apps[i].toLowerCase().startsWith(appName))) {
						matches.add(apps[i]);

					}
				}

				String[] appFinale = new String[matches.size()];
				JButton[] buttons = new JButton[matches.size()];

				for (int i = 0; i < matches.size(); i++) {
					 buttons[i] = new JButton(""+ matches.get(i));
					 buttons[i].setSize(1, 1);
			
					 
				panel.add(buttons[i], BorderLayout.SOUTH);
				buttons[i].revalidate();
				}
				
				
				
				
				
				if (matches.size() == 0) {
					
					
					results = new JTextArea(20, 40);
				    results.setText("Sorry, app not found");
				    panel.add(results, BorderLayout.SOUTH);
				    results.revalidate();

				}

			}

		});
		



		//
		

		JButton clear = new JButton("clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				searchField.setText(null);
//				results.setVisible(false);
//				
				panel.removeAll();
				//add your elements
				panel.revalidate();
				panel.repaint();
				
				panel.add(label,BorderLayout.NORTH);
				panel.add(searchField,BorderLayout.NORTH);
				panel.add(submit,BorderLayout.NORTH);
				panel.add(clear,BorderLayout.NORTH);
				searchField.setText(null);
			
			}

		});
		
		
		
		

		panel = new JPanel();

		panel.add(label,BorderLayout.NORTH);
		panel.add(searchField,BorderLayout.NORTH);
		panel.add(submit,BorderLayout.NORTH);
		panel.add(clear,BorderLayout.NORTH);
		
		//panel.add(buttonsPanel, BorderLayout.SOUTH);
	

		frame.add(panel);
		//frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new searcgGUI();

	}

}
