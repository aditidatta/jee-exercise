package dungeon;

import java.io.Serializable;
import java.util.Random;

public class Enemy extends Character implements Serializable{

	private Item item;
	private int levelHp;
	public Enemy (String n, String q, int h, int l, int g, Item i){
		super(n,q, h, l,g);
		item = i;
		levelHp=l;
	}
	public Item getItem()
	{
		return item;
	}
	
	public int getLevelHp(){
		return levelHp;
	}
	
	@Override
	void attack(Character c) {
		// TODO Auto-generated method stub
		Random randomGenerator = new Random();
		int damage = randomGenerator.nextInt(getHp()/2+1)+1;
		c.takeDamage(damage);
		System.out.println("A "+getName()+" hits "+c.getName()+" for "+damage+" damage");
	}
	
	

}
