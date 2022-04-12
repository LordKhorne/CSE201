import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Comment {
	
	//------------------ Constructors --------------------------------
	
	
	//Creates a text file that contains the comments for a specific app
	public Comment(String app) {
		String fileName = app + "Comments.txt";
		
		File newFile = new File(fileName);
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//------------------ Methods --------------------------------------
	public static void addComment(String app, String comment) {
		String fileName = app + "Comments.txt";
		File newFile = new File(fileName);
		
		try {
			FileWriter fileWriter = new FileWriter(newFile, true);
			
			fileWriter.write("\n" + comment);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//------------------ Getters and Setters --------------------------
	public static ArrayList<String> getComments(String app) {	
		String fileName = app + "Comments.txt";
		ArrayList comments = new ArrayList<String>();
		File newFile = new File(fileName);
		
		try {
			Scanner s = new Scanner(newFile);
			while (s.hasNextLine()) {
				String comment = s.nextLine();
				comments.add(comment);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return comments;
	}
	
	public static String dispComments(String app) {
		ArrayList comments = getComments(app);
		String com = "";
		for (int i = 0; i < comments.size(); i++) {
			com += comments.get(i) + "\n";
		}
		return com;
	}
	
	//------------------ Test --------------------------------------
	public static void main(String[] args) {
		//Comment test = new Comment("test");
		addComment("test", "adding a comment");
		dispComments("test");
	}
}
