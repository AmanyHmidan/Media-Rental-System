package application;

public class Game extends Media  {
	
	private double weight; // weight of the game in grams
	
	public Game(String code,String title,int numOfCopies,double weight) {
		super(code,title,numOfCopies);
		this.weight=weight;
	}
	

	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Game [code=" + code+ "title=" + title + ", number of copies="+numOfCopies+", weight="+weight+ "]";
	}


	@Override
	public String getRating() {
		// TODO Auto-generated method stub
		return null;
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


	



}
