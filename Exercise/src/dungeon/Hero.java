package dungeon;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Hero extends Character implements Serializable
{
	private ArrayList<Item> items;
	private Point location;
	
	public Hero (String n, String q, int h, int l, int g, Point start){
		super(n, q, h, l, g);
		location = start;
		items = new ArrayList<>();
	}
	
	public Point getLocation (){
		return location;
	}
	
	public void setLocation (Point p){
		location = p;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void removeAllItems(){
		items.clear();
	}
	
	public void removeItem(Item i){
		items.remove (i);
	}
	
	public void removeItem(int index){
		items.remove (index);
	}
	
	public char goNorth (Level l){
		location.x = location.x-1;
		char r = l.getRoom(new Point(location.x, location.y));
		return r;
	}
	
	public char goSouth (Level l){
		location.x = location.x+1;
		char r = l.getRoom(new Point(location.x, location.y));
		return r;
	}
	
	public char goEast (Level l){
		location.y = location.y+1;
		char r = l.getRoom(new Point(location.x, location.y));
		return r;
	}
	
	public char goWest (Level l){
		location.y = location.y-1;
		char r = l.getRoom(new Point(location.x, location.y));
		return r;
	}
	
	public boolean pickUpItem(Item i){
		
		if (items.size() < 5)
		{
			items.add(i);
			return true;
		}else{
			return false;
		}
		
	}
	
	public int hasPotion(){
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).isPotion()){
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public String toString(){
		return "Name: "+getName()+", Quip: "+getQuip()+", Hit points: "
				+getHp()+", Level: "+getLevel()+", Gold: "+getGold();
	}
	
	@Override
	void attack(Character c) {
		Random randomGenerator = new Random();
		int damage = randomGenerator.nextInt(getHp()/2+1)+1;
		c.takeDamage(damage);
		System.out.println(getName()+" hits a "+c.getName()+" for "+damage+" damage");
	}

}
