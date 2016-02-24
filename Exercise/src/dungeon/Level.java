package dungeon;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class Level implements Serializable{
	char [][] level;
	int levelMaxHp;
	
	public Level(){
		levelMaxHp = 10;
		level = new char[4][4];
	}
	
	public void generateLevel(int levelNum)
	{
		File file = null;
		Scanner s = null;
		
		if (levelNum == 1)
		{ 
			file = new File("level1.txt");
		}
		else if (levelNum == 2)
		{
			file = new File("level2.txt");
		}
		else if (levelNum == 3)
		{
			file = new File("level3.txt");
		}
		
		try {
			 s = new Scanner(new BufferedInputStream(new FileInputStream(file)));
			 
			 int i = 0; int j = 0;
			 while (s.hasNext()) {
				 if(j == 4){
					 i++;
					 j=0;
				 }
				 level[i][j] = s.next().charAt(0);
				 j++;
			 }
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
           if (s != null) {
               s.close();
           }
		}
		
	
	}
	
	public void setMaxHp(int hp){
		levelMaxHp = hp;
	}
	
	public int getMaxHp(){
		return levelMaxHp;
	}

	
	public char getRoom(Point p)
	{
		return level[p.x][p.y];
	}
	
	public void displayMap(Point p)
	{
		System.out.println("Dungoen Map:");
		for(int i = 0; i < level.length; i ++){
			for(int j = 0; j < level[i].length; j ++){
				if(i == p.x && j == p.y)
					System.out.print("* ");
				else
					System.out.print(level[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public Point findStartLocation()
	{
		for(int i = 0; i < level.length; i++){
			for(int j = 0; j < level.length; j++){
				if(level[i][j] == 's')
					return new Point(i,j);
			}
		}
		
		return new Point(level.length,0);
	}
	
	

}
