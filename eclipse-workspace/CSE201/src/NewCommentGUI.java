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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCommentGUI extends JFrame {
	private JTextArea oldComments;
	private JTextField username;
	private JTextField comment;
	public NewCommentGUI(String app) {
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel main = new JPanel();
		getContentPane().add(main);
		JFrame frame = this;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String appString = app + " Comment Section";
		
		JLabel title = new JLabel(appString);
		title.setBounds(0, 0, 450, 46);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Georgia", Font.BOLD, 20));
		
		oldComments = new JTextArea(20, 20);
		oldComments.setBounds(0, 192, 450, 300);
		oldComments.setText(Comment.dispComments(app));
		oldComments.setEditable(false);
		oldComments.setColumns(30);
		main.setLayout(null);
		main.add(title);
		main.add(oldComments);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 45, 75, 16);
		main.add(usernameLabel);
		
		username = new JTextField();
		username.setBounds(97, 40, 130, 26);
		main.add(username);
		username.setColumns(10);
		
		comment = new JTextField();
		comment.setBounds(97, 73, 249, 40);
		main.add(comment);
		comment.setColumns(10);
		
		JLabel commentLabel = new JLabel("Comment:");
		commentLabel.setBounds(10, 85, 75, 16);
		main.add(commentLabel);
		
		JButton postButton = new JButton("Post");
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tmp = "";
				tmp = username.getText() + ": " + comment.getText() +"\n";
				Comment.addComment(app, tmp);
				oldComments.setText(Comment.dispComments(app));
				username.setText("");
				comment.setText("");
				
			}
		});
		postButton.setBounds(356, 80, 94, 29);
		main.add(postButton);
		
		JButton backButton = new JButton("Back to List");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				AppGUI newWindow = new AppGUI();
				newWindow.createFrame();
				
			}
		});
		backButton.setBounds(0, 153, 117, 29);
		main.add(backButton);
	}

	
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewCommentGUI frame = new NewCommentGUI();
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.setSize(800, 800);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
}