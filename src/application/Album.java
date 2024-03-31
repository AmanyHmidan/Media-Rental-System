package application;

public class Album extends Media  {
	
	private String artist;
	private String songs; // songs that are part of the album
	
	public Album(String code,String title,int numOfCopies,String artist,String songs) {
		super(code,title,numOfCopies);
		this.artist=artist;
		this.songs=songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}
	
	@Override
	public String toString() {
		return "Album [code=" + code+ "title=" + title + ", number of copies="+numOfCopies+", artist="+artist+", songs="+songs+ "]";
	}

	@Override
	public String getRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
