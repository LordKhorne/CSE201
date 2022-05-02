import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Search {

	protected Shell shell;
	private Text searchField;
	private Label results;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Search window = new Search();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Search Bar Function");
		
		searchField = new Text(shell, SWT.BORDER);
		searchField.setBounds(90, 18, 129, 19);
		
		Label searchLabel = new Label(shell, SWT.NONE);
		searchLabel.setBounds(22, 23, 59, 14);
		searchLabel.setText("Find App: ");
		
		Button submitButton = new Button(shell, SWT.NONE);
		submitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		String[] apps = { "jump", "link", "Facebook", "Bumble", "tinder", "hootsuite", "James", "jim"

				};
				
				ArrayList<String> matches = new ArrayList<String>();
				

				String appName = searchField.getText();
				
				for (int i = 0; i < apps.length; i++) {
					if (apps[i].equalsIgnoreCase(appName)|| (apps[i].startsWith(appName)) || (apps[i].toLowerCase().startsWith(appName) )) {
						matches.add(apps[i]);

				
					}
				}

//				for (String str : matches) {
//					results.setText("Results: "+ str + ", ");
//				}
//				
	
					
					    String[] appFinale = new String[matches.size()];
				
					     for(int i = 0; i < matches.size(); i++) {
					
					    	 appFinale[i] = matches.get(i);
					     }
					 	results.setText("Results: "+ Arrays.toString(appFinale));
					     
					     
			
				if (matches.size() == 0) {
					results.setText("Results: "+"Sorry, app not found");
					
				}
				
				
				
	
				
				
			}
		});
		submitButton.setBounds(229, 10, 96, 27);
		submitButton.setText("Submit");
		
		results = new Label(shell, SWT.NONE);
		results.setBounds(22, 67, 418, 195);
		results.setText("Results: ");

	}
}
