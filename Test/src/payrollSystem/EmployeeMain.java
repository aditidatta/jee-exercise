package payrollSystem;


import java.util.Arrays;
import java.util.Scanner;
	
class EmployeeMain {
	public static void main (String args[]) {

	Staff s[] = new Staff[2]; 
	Faculty f[] = new Faculty[2];
	PartTime pt[] = new PartTime[2];
	Employee e[] = new Employee[6];
	
	s[0] = new Staff(15.5, "Mesa", "Evan", "6", 'm');
	s[1] = new Staff(15.5, "Mesa", "Evan", "9", 'm');
	f[0] = new Faculty("GRAD", "Yee", "Brian", "11", 'm');
	f[1] = new Faculty("GRAD", "Yee", "Brian", "11", 'm');
	pt[0] = new PartTime(20, 20, "Mesa", "Cole", "12", 'm');
	pt[1] = new PartTime(20, 20, "Mesa", "Cole", "12", 'm');
	
	e[0] = s[0]; 
	e[1] = s[1];
	e[2] = f[0];
	e[3] = f[1];
	e[4] = pt[0];
	e[5] = pt[1];
	
	Arrays.sort(e); 
	
	for(int i = 0; i < e.length; i++)
		System.out.println(e[i].toString());


	}
}
