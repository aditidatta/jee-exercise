package dungeon;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ItemGenerator {
	ArrayList<Item> itemList;
	Random randomGenerator = new Random();
	
	public ItemGenerator(){
		
		itemList = new ArrayList<>();
		Scanner s = null;
		try {
			s = new Scanner(new File("ItemList.txt"));
			 //s.useDelimiter(",");
			 
			 while (s.hasNext()) {
				 
				 String str[] = s.nextLine().split(",");
				 itemList.add(new Item(str[0],Integer.parseInt(str[1])));
				 
				
			 }
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
          if (s != null) {
              s.close();
          }
		}
	}
	
	public Item generateItem(){
		
		return itemList.get(randomGenerator.nextInt(itemList.size()));
	}
}
