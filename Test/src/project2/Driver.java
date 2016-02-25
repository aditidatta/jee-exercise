package project2;
import java.util.Random;
import java.util.Scanner; 

public class Driver {
	static Scanner input = new Scanner(System.in);
	static User[] userArray = new User[50];
	static int userCount =0, webCount = 0;
	static Random rand = new Random();
	static User currentUser;
	static int visits = 0;
	static Website[] websitesArray = new Website[50];
	static StackArray<String> stack = new StackArray<>(50);
	static QueueArray<String> queue = new QueueArray<>(50);
	
	public static void main(String[] args) {
		menu();
		
		input.close();
		stack = null;
		queue = null;
		websitesArray = null;
		
		System.out.println("\nGood Bye!");
		
	}
	
	
	
	public static void menu() {
		while(true){
			System.out.println("1. Register User and create User login");
			System.out.println("2. Login existing user");
			System.out.println("3. Visit a website");
			System.out.println("4. Check the complete browsing history of websites visited in chronological order");
			System.out.println("5. Check the history of websites visited in reverse chronological order");
			System.out.println("6. Number of times each website is visited");
			System.out.println("7. Most visited website");
			System.out.println("8. Logout");
			int selection = input.nextInt();
			switch(selection){
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 3:
				enterWebsite();
				break;
			case 4:
				chronoWeb();
				break;
			case 5:
				reverseChronoWeb();
				break;
			case 6:
				countOfWebsites();
				break;
			case 7:
				mostVisited();
				break;
			case 8:
				return;
			default:
				System.out.println("Enter a valid option");
					
			}
		}
	}
	
	public static String generateUserName(String ln){
		String username = ln.substring(0,4);
		int numGen = rand.nextInt(9999);
		username = username + String.format("%04d", numGen);
		return username;
	}
	
	public static boolean isPresent(String username){
		for(int i = 0; i< userCount; i++){
			if(username.equals(userArray[i].getUsername())){
				return true;
			}
		}
		
		return false;
		
	}
	
	public static void register(){
		System.out.println("Enter first name: ");
		String firstName = input.next();
		System.out.println("Enter last name: ");
		String lastName = input.next();
		System.out.println("Enter username: " );
		String username = input.next();
		if(isPresent(username)){
			System.out.println("Username already exists, select new Username:");
			username = input.next();
			if(isPresent(username)){
				System.out.println("Username already exists, select new Username:");
				username = input.next();
				if(isPresent(username)){
					username = generateUserName(lastName);
					System.out.println("Auto generated Username: " + username);
				}
			}
			
		}
		
		System.out.println("Enter password: ");
		String password = input.next();
		if(password.length() < 8){
			System.out.println("Password too short. Should be 8 characters long.");
			password = input.next();
		} 
		 
		userArray[userCount] = new User(username, firstName, lastName, password);
		userCount++;
		
		System.out.println();
	}	
	
	
	public static void login() {
		System.out.println("Enter username: ");
		String username = input.next();
		
		for(int i = 0; i<userCount; i++){
			if(username.equals(userArray[i].getUsername())){
				System.out.println("Enter password: ");
				String password = input.next();
				if(password.equals(userArray[i].getPassword())){
					System.out.println("You are loged in!");
					currentUser = userArray[i];
				}
				else
					System.out.println("Password doesn't match. Try again.");
			}
			else
				System.out.println("NO Such Username");
		}
		
		System.out.println();
		
	}
	
	
	public static void enterWebsite(){
		System.out.println("Enter Website: ");
		String website = input.next();
		/*currentUser.webArray[r][c++] = website;
		visits++;
		currentUser.webArray[r++][c] = "" + visits;*/
		for(int i = 0; i < webCount; i++){
			if(website.equals(websitesArray[i].getName())){
				websitesArray[i].incCount();
				return;
			}
		}
		websitesArray[webCount++] = new Website(website);
		stack.push(website);
		queue.enqueue(website);
		System.out.println();
	}
	
	public static void countOfWebsites(){
		for(int i = 0; i < webCount; i++){
			System.out.println(websitesArray[i].getName() + "\thas been visited " + websitesArray[i].getCount()+ " times\n\n");
		}
	}
	
	public static void mostVisited(){
		int high = 0;
		for(int i = 1; i < webCount; i++){
			if(websitesArray[i].getCount() < websitesArray[i].getCount())
				high = i;
		}
		System.out.println(websitesArray[high].getName() + "\thas been visited " + websitesArray[high].getCount()+ " times\n\n");
	}
	
	public static void chronoWeb() {
		int length = queue.size();
		for(int i = 0; i < length; i++){
			System.out.println(queue.peekFront());
			queue.dequeue();
		}
	}
	
	public static void reverseChronoWeb() {
		int length = stack.top+1;
		for(int i = 0; i < length; i++){
			System.out.println(stack.pop());
		}
	}
	
	
	

}
