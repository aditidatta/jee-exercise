package dungeon;


import java.awt.Point;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	
	public static ItemGenerator ig = new ItemGenerator();
	public static EnemyGenerator eg = new EnemyGenerator();
	public static Scanner scan = new Scanner(System.in);
	public static Random randomGenerator = new Random();
	public static Level level = new Level();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int levelNum ;
		Point location;
		
		Hero hero=null;
		if(initDataCheck() == true){
			hero = readData();
			levelNum =  hero.getLevel();
			level.generateLevel(levelNum);
			location = level.findStartLocation();
			
		}
		else{
			levelNum =  1;
			level.generateLevel(levelNum);
			location = level.findStartLocation();
			
			System.out.println("What is your name, Traveler? ");
			
			String name = scan.nextLine();
			hero = new Hero(name,"Woo Hoo!", level.getMaxHp(),1,0,location);
			System.out.println(name + " enters the Dungeon of Despair.");
		}
		
		
		char room = level.getRoom(location);
		while(hero.getHp() != 0){
			location = hero.getLocation();
			level.displayMap(location);
			System.out.println("Choose a direction: \n1. North \n2. South \n3. East \n4. West");
			int direction = scan.nextInt();
			
			
			if(updateLocation(hero, direction)){
				room = level.getRoom(location);
				level.displayMap(location);
			}
			else
				System.out.println("Cannot move that direction!");
			
			if(room == 'm'){
				dealWithEnemy(hero, eg.generateEnemy(hero.getLevel()));
			}
			
			else if(room == 'i'){
				dealWithItem(hero, ig.generateItem());
			}
			
			else if(room == 's'){
				ifSellItems(hero);
			}
			
			else if(room == 'f'){
				if(levelNum<3){
					levelNum++;
					updateLevel(hero, levelNum);
				}
				else{
					System.out.println(hero.getName()+" wins the game!");
					break;
				}
			}
		}
		
		
		scan.close();
	}
	
	
	
	public static boolean initDataCheck(){
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("hero.dat");
	         fileIn.close();
	         return true;
	      }catch(IOException i)
	      {
	         return false;
	      }
	}
	
	
	public static Hero readData(){
		Hero hero = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("hero.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         hero = (Hero) in.readObject();
	         
	         in.close();
	         fileIn.close();
	         
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Hero class not found");
	         c.printStackTrace();
	      }
		
		return hero;
		
	}
	
	
	
	public static boolean updateLocation(Hero hero, int direction){
		if(direction == 1 && hero.getLocation().x != 0){
			hero.goNorth(level);
		}
		else if (direction == 2 && hero.getLocation().x != 3){
			hero.goSouth(level);
		}
		else if (direction == 3 && hero.getLocation().y != 3){
			hero.goEast(level);
		}
		else if (direction == 4 && hero.getLocation().y != 0){
			hero.goWest(level);
		}
		else{
			return false;
		}
		return true;
	}
	
	
	
	
	public static void updateLevel(Hero hero, int levelNum){
		
		hero.increaseLevel();
		System.out.println(hero.getName()+ " is at now level "+hero.getLevel());
		level.generateLevel(levelNum);
		level.setMaxHp(level.getMaxHp()*2);
		hero.setLocation(level.findStartLocation());
		
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream("hero.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(hero);
	         out.close();
	         fileOut.close();
	         System.out.printf("Hero's data saved in hero.dat");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		
		
		
	}
	
	
	
	
	public static void ifSellItems(Hero hero){
		if(hero.getItems().size() == 0){
			return;
		}
		
		System.out.print( hero.getName()+" has ");
		
		for(int i = 0; i < hero.getItems().size(); i++){
			System.out.print(hero.getItems().get(i).getName()+ " ");
		}
		System.out.println();
		System.out.print("Do you want to sell all the Items? [y/n]");
		char option = scan.next().charAt(0);
		if(option == 'y'){
			hero.removeAllItems();
		}
	}
	
	
	
	
	public static void dealWithItem(Hero hero, Item item){
		System.out.println(hero.getName() + " has found a " + item.getName());
		System.out.println("What do you do?\n" 
							+ "1. Keep it\n"
							+ "2. Sell it"	);
		if(item.isPotion()){
			System.out.println("3. Drink health potion");
		}
		int option = scan.nextInt();
		
		if(option == 1){
			if(!hero.pickUpItem(item))
				System.out.println(hero.getName()+" has max items");
			
		}
		else if(option == 2){
			System.out.println("You sell your " + item.getName() 
								+ " for " + item.getValue() + " golds." );
			hero.collectGold(item.getValue());
		}
		else if(option == 3){
			drinkHealthPotion(hero);
		}
	}
	
	
	
	public static void drinkHealthPotion(Hero hero){
		
		hero.heal(level.getMaxHp() - hero.getHp());
		System.out.println(hero.getName()+" has "+hero.getHp()+" health");
	}
	
	
	
	public static void dealWithEnemy(Hero hero, Enemy enemy){
		while(true){
			System.out.println(hero.getName()+" has "+hero.getHp()+" health.");
			System.out.println(hero.getName()+" has encountered a "+enemy.getName());
			System.out.println("It has "+enemy.getHp()+" health.");
			System.out.println("What do you do?\n"
				 			+"1. Run Away\n"
				 			+"2. Attack" );
			if(hero.hasPotion() != -1){
				System.out.println("3. Drink health potion");
			}
			int option = scan.nextInt();
		
			if(option == 1){
				System.out.println("A "+enemy.getName()+" hits "+hero.getName()+" while escaping.");
				enemy.attack(hero);
				System.out.println(hero.getName()+" has "+hero.getHp()+" health.");
				int direction = randomGenerator.nextInt(5);
				while(!updateLocation(hero,direction)){
					direction = randomGenerator.nextInt(5);
				}
				break;
			}
			else if(option == 2){
				if(hero.getHp() !=0)
					hero.attack(enemy);
				else{
					System.out.println(enemy.getName()+" just killed "+hero.getName());
					System.out.println(enemy.getName()+ " says "+enemy.getQuip());
					System.out.println("Game Over");
					break;
				}
				
				
				if(enemy.getHp() !=0)
					enemy.attack(hero);
				else{
					System.out.println(hero.getName()+" just killed a "+enemy.getName());
					System.out.println(hero.getName()+ " says "+hero.getQuip());
					hero.collectGold(enemy.getGold());
					System.out.println(hero.getName()+" receives "+enemy.getGold()+" golds.");
					if(enemy.getItem().getName().equals("Health Potion")){
						System.out.println(hero.getName()+" finds a "+enemy.getItem().getName());
						System.out.print("Drink it? [y/n]");
						char opt = scan.next().charAt(0);
						if(opt == 'y')
							drinkHealthPotion(hero);
					}
					else if(hero.pickUpItem(enemy.getItem())){
						System.out.println(hero.getName()+" receives a "+enemy.getItem().getName());
					}
					break;
				}
				
			}
			
			else if(option == 3){
				hero.removeItem(hero.hasPotion());
				drinkHealthPotion(hero);
			}
		}
	}

}
