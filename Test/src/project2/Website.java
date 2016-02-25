package project2;

public class Website {
	private String webName;
	private int count = 0;
	
	public Website(String w) {
		webName = w;
		count++;
	}
	
	
	public String getName(){
		return webName;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setName(String webName){
		this.webName = webName;
	}
	
	public void incCount(){
		count++;
	}
	
	
}