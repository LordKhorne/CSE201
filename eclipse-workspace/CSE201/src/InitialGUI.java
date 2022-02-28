import javax.swing.JFrame;


public class InitialGUI extends JFrame {

		
	public static void main(String[] args) {
				
		try {
			
			InitialGUI frame = new InitialGUI();
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
			
	}

}
