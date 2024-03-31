package application;

public abstract class Media implements Comparable<Media>{
	protected String code;
	protected String title;
	protected int numOfCopies; // number of copies available
	
	public Media() {
		
	}

	public Media(String code,String title, int numOfCopies) {
		this.code=code;
		this.title = title;
		this.numOfCopies = numOfCopies;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.title);
	}
	
	public abstract String toString();
	
	public abstract String getRating();

	public abstract String getArtist();

	public abstract String getSongs();
	
	public abstract double getWeight();

	

	
	

	
	

}
