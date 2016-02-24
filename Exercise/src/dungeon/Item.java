package dungeon;

import java.io.Serializable;

public class Item implements Serializable{
	private String name;
	private int goldValue;
	public Item (String n, int v){
		name = n;
		goldValue = v;
	}
	public String getName(){
		return name;
	}
	public int getValue (){
		return goldValue;
	
	}
	
	public boolean isPotion(){
		if(name.equals("Health Potion"))
			return true;
		return false;
	}
	
	public String toString(){
		return name + " " + goldValue;
	}
	

}
