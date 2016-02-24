package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileHandling {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner s = null;
		try {
			 s = new Scanner(new File("EnemyList1"));
			 //s.useDelimiter(",\\s*");
			 //
			 
			 while (s.hasNext()) {
				 
				 String str[] = s.nextLine().split(",");
			 	 System.out.print(str[0]+" "+str[1]+" "+str[2]);
			 }
			 
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} finally {
          if (s != null) {
              s.close();
          }
		}
	}

}
