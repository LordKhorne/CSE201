
public class Application {
	
	//------------------- Variables --------------------------------
	
	public String name;
	public String description;
	public String[] comments;
	
	//------------------ Constructors --------------------------------
	
	public Application(String x) {
		name = x;
	}
	
	public Application(String x, String y) {
		name = x;
		description = y;
	}
	
	public Application(String x, String y, String[] z) {
		name = x;
		description = y;
		comments = z;
	}
	
	// ----------------- Getters and Setters ---------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getComments() {
		return comments;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}
	
	
}
