import java.util.*;

public class search_feature {
	public static void main(String[] args) {
		String[] apps = { "jump", "link", "Facebook", "Bumble", "tinder", "hootsuite", "James", "jim"

		};
		
		ArrayList<String> matches = new ArrayList<String>();
		
		System.out.print("Search: ");
		searchFeature(apps, matches);

	}
	

	public static void searchFeature(String[] arr, ArrayList<String> match) {

		Scanner input = new Scanner(System.in);

		String appName = input.next();
		
		
	
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equalsIgnoreCase(appName)|| (arr[i].startsWith(appName)) || (arr[i].toLowerCase().startsWith(appName) )) {
				match.add(arr[i]);

		
			}
		}

		for (String str : match) {
			System.out.print(str + " ");
		}
		
		if (match.size() == 0) {
			System.out.println("Sorry, app not found");
			
		}
		
match.clear();

	}

}
