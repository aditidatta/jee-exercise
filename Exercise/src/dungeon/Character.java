package dungeon;

import java.io.Serializable;

public abstract class Character implements Serializable{
	private String name; 
	private String quip;
	private int level;
	private int hp;
	private int gold;
	
	public Character (String n, String q)
	{
		name = n;
		quip = q;
	}
	
	public Character (String n, String q, int h, int l, int g)
	{
		name = n;
		quip = q;
		level = l;
		hp = h;
		gold = g;
		
	}

	
	public String getName()
	{
		return name;
	}
	
	public String getQuip()
	{
		return quip;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public void increaseLevel()
	{
		level++;
		hp = hp*2;
	}
	
	public void heal(int h)
	{
		hp += h;
	}
	
	public void takeDamage (int h)
	{
		hp -= h;
		if(hp < 0){
			hp = 0;
		}
	}

	public void collectGold (int g)
	{
		gold += g;
	}
	
	public void setLevel(int levelNum){
		level = levelNum;
	}
	
	abstract void attack (Character c);
	
}

