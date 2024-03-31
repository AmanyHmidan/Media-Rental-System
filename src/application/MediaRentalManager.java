  package application;
import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalInt{
	
    ArrayList<Customer> customers=new ArrayList<>();
    ArrayList<Media> media=new ArrayList<>();
	
	public MediaRentalManager() {
		
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	/*public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}*/
	public ArrayList<Media> getMedia() {
		return media;
	}
	/*public void setMedia(ArrayList<Media> media) {
		this.media = media;
	}*/
	@Override
	public void addCustomer(String id,String name, String address,String mobile, String plan) {
		customers.add(new Customer(id,name,address,mobile,plan));
		
	}
	@Override
	public void addMovie(String code,String title, int copiesAvailable, String rating) {
		if(rating.equals("HR")||rating.equals("DR")||rating.equals("AC"))
			media.add(new Movie(code,title,copiesAvailable,rating));
		else
			throw new IllegalArgumentException("Invalid rating");
		
	}
	@Override
	public void addGame(String code,String title, int copiesAvailable, double weight) {
		media.add(new Game(code,title,copiesAvailable,weight));
		
	}
	@Override
	public void addAlbum(String code,String title, int copiesAvailable, String artist, String songs) {
		media.add(new Album(code,title,copiesAvailable,artist,songs));
		
	}
	@Override
	public void setLimitedPlanLimit(int value) {
		for(int i=0; i<customers.size(); i++) {
			if((customers.get(i).getPlan()).equals("LIMITED"))
				customers.get(i).setValue(value);
		}
		
	}
	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customers);
		String c = "";
		for(int i=0; i<customers.size(); i++)
			c += customers.get(i).toString() + "\n";
		
		return c;
	}
	@Override
	public String getAllMediaInfo() {
		Collections.sort(media);
		String m ="";
		for(int i=0; i<media.size(); i++)
			 m += media.get(i).toString() + "\n";
			
		return m;
	}
	@Override
	public boolean addToCart(String customerId, String mediaCode) {
		 Customer customer = null;
		 for(int i=0; i<customers.size(); i++) {
			 if((customers.get(i).getId()).equals(customerId)) {
				 customer = customers.get(i);
				 break;
			 }
		 }
		 
		 ArrayList<String> cart = customer.getCart();
		 
		 if (!(cart.contains(mediaCode))) {
			 cart.add(mediaCode);
			 for(int i=0; i<media.size(); i++) {
				 if(media.get(i).getCode().equals(mediaCode)) {
					 (media.get(i).numOfCopies)--;
				 }
			 }
			 return true;
		 }
		 
		 
		   
		   return false;	 
		   
	}
	@Override
	public boolean removeFromCart(String customerId, String mediaCode) {
		Customer customer =null;
		for(int i=0; i<customers.size(); i++) {
			if((customers.get(i).getId()).equals(customerId)) {
				customer = customers.get(i);
				break;
			}
		}
		ArrayList<String> cart = customer.getCart();
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).equals(mediaCode)) {
				cart.remove(mediaCode);
				return true;
			}
		}
		
		return false;
	}
  /*	@Override
	public String processRequests() {
		Collections.sort(customers);
		for(int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if(c.getPlan().equals("LIMITED")) {
				for(int j=0; j<c.getCart().size(); j++) { 
			        
					  for(int k=0; k<media.size(); k++) 
						  if(media.get(k).code.equals(c.getCart().get(j)))
							  if(media.get(k).numOfCopies>0)
				              	if(j<c.getValue()) {
					   	          c.getRented().add(c.getCart().get(j));
						          System.out.println("Sending["+c.getCart().get(j)+"] to ["+c.getName()+"]");
						          c.getCart().remove(j);
					           }  
					            else
						        System.out.println("item "+j+" in cart can not be added because limit is "+c.getValue());
						
				}
			}
			else if(c.getPlan().equals("UNLIMITED")) {			
				  for(int j=0; j<c.getCart().size(); j++) {
					  for(int k=0; k<media.size(); k++) 
						  if(media.get(k).code.equals(c.getCart().get(j)))
							  if(media.get(k).numOfCopies>0) {
						         c.getRented().add(c.getCart().get(j));
					           	System.out.println("Sending["+c.getCart().get(j)+"] to ["+c.getName()+"]");
						        c.getCart().remove(j);
							  }
				  }
			   }
			
		}
		return "processing requests is done";
	} */
	@Override
	public String processRequests(String id, String code) {
		Collections.sort(customers);
		Customer c = null;
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).getId().equals(id)) {
				c = customers.get(i);
				break;
			}
		}
		
		for(int i=0; i<c.getCart().size(); i++) {
			if(c.getCart().get(i).equals(code)) {
				for(int j=0; j<media.size(); j++) {
					if(media.get(j).getCode().equals(code)) {
						if(media.get(j).getNumOfCopies() > 0) {
							if(c.getPlan().equals("UNLIMITED")) {
							   if(!(c.getRented().contains(code))) {
								   c.getRented().add(code);
								    System.out.println("Sending["+c.getCart().get(i)+"] to ["+c.getName()+"]");
								   c.getCart().remove(code);
								  
							   }
							}
							else if(c.getPlan().equals("LIMITED")) {
								if(c.getRented().size() < c.getValue()) {
									if(!(c.getRented().contains(code))) {
										   c.getRented().add(code);
										   System.out.println("Sending["+c.getCart().get(i)+"] to ["+c.getName()+"]");
										   c.getCart().remove(code);
										   
									   }
								}
								
							}
						}
					}
				}
			}
		}
		
		return "processing requests is done";
	}
	
	@Override
	public boolean returnMedia(String customerId, String mediaCode) {
		for(int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if(c.getId() .equals(customerId)) {
				for(int j=0; j<c.getRented().size(); j++) {
					if(c.getRented().get(j).equals(mediaCode)) {
						c.getRented().remove(j);
						for(int k=0; k<media.size(); k++)
							if(media.get(k).code.equals(mediaCode))
								media.get(k).numOfCopies++;
						return true;
					}
				}
			}
		}
	
		return false;
	}
	
	 @Override 
	public boolean returnAllMedia(String customerId) {
		for(int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if(c==null)
				return false;
			if(c.getId() .equals(customerId)) {
				for(int j=0; j<c.getRented().size(); j++) { 	
						for(int k=0; k<media.size(); k++) {
							if(media.get(k).getCode().equals(c.getRented().get(j))) {
							  // c.getRented().remove(j);
							   (media.get(k).numOfCopies)++;
							}
						}	
				}
				c.getRented().clear();
				return true;
			}
		}
	
		return true;
	} 
	
	@Override
	public ArrayList<String> searchMedia(String code,String title, String rating, String artist, String songs) {
		ArrayList<String> result=new ArrayList<>();
		
		if(code==null && title==null && rating==null &&  artist==null && songs==null) {
			for(int i=0; i<media.size(); i++) {
					result.add(media.get(i).title);
			}
		}
		else if(code != null && title==null && rating==null &&  artist==null && songs==null) {
			for(int i=0; i<media.size(); i++) {
				if(media.get(i).code.equals(code))
					result.add(media.get(i).title);
		    }
		}
		else if(title!=null && rating==null &&  artist==null && songs==null) {
			for(int i=0; i<media.size(); i++) {
				if(media.get(i).title.equals(title))
					result.add(media.get(i).title);
		}
	 }
		else if( rating!=null &&  artist==null && songs==null) {
			for(int i=0; i<media.size(); i++) {
				if(media.get(i) instanceof Movie ) {
					if( media.get(i).getRating().equals(rating))
						result.add(media.get(i).title);
				}				
		}
	 }
		else if( rating==null &&  artist!=null && songs==null) {
			for(int i=0; i<media.size(); i++) {
				if(media.get(i) instanceof Album ) {
					if( media.get(i).getArtist().equals(artist))
						result.add(media.get(i).title);
				}				
		}
	 }
		else if( rating==null &&  artist==null && songs!=null) {
			for(int i=0; i<media.size(); i++) {
				if(media.get(i) instanceof Album ) {
					if( media.get(i).getSongs().equals(songs))
						result.add(media.get(i).title);
				}				
		}
	 }
		return result;
  }

/*	@Override
	public boolean returnAllMedia(String customerId) {
		for(int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if(c.getId() .equals(customerId)) {
				for(int j=0; j<c.getRented().size(); j++) {
					 
						c.getRented().remove(j);
						for(int k=0; k<media.size(); k++)
							if(media.get(k).code.equals(c.getRented().get(j)))
								media.get(k).numOfCopies++;
						
					
				}
				return true;
			}
		}
		return false;
	} */

	
} 
