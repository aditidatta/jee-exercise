package dungeon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EnemyGenerator {
	
	ArrayList<Enemy> enemyList;
	ItemGenerator ig;
	Random randomGenerator;
	
	public EnemyGenerator(){
		enemyList = new ArrayList<>();
		ig = new ItemGenerator();
		randomGenerator = new Random();
		
		Scanner s = null;
		try {
			 s = new Scanner(new File("EnemyList.txt"));
			 //s.useDelimiter(",\\s*");
			 
			 while (s.hasNext()) {
				 
				 String str[] = s.nextLine().split(",");
				 enemyList.add(new Enemy(str[0],str[1],Integer.parseInt(str[2]),1,randomGenerator.nextInt(10)+1,ig.generateItem()));
			 }
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
          if (s != null) {
              s.close();
          }
		}
	}
	
	public Enemy generateEnemy(int level){
		
		Enemy e = enemyList.get(randomGenerator.nextInt(enemyList.size()));
		e.setLevel(level);
		if(level > 1){
			if(e.getHp()==0)
				e.heal(e.getLevelHp()*level-e.getHp());
			else
				e.heal(e.getHp()*level-e.getHp());
		}
		return e;
		
	}
}
