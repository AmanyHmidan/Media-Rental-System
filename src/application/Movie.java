package application;

public class Movie extends Media  {
	
	private String rating;
	
	public Movie(String code,String title,int numOfCopies,String rating) {
		super(code,title,numOfCopies);
		this.rating=rating;
	}
	

	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [code=" + code + "title=" + title + ", number of copies="+numOfCopies+", rating="+rating+ "]";
	}


	@Override
	public String getArtist() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getSongs() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}


	




}
