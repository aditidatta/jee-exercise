package test;

class Main{
	public static void main(String args[]){
		String a = "123+";
		int l = a.length();
		System.out.println(l);
		String str = "";
		int i = 0;
		
		for(i = 0; i< l; i++){
			if(Character.isDigit(a.charAt(i)))
			str = str + a.charAt(i);
		}
		
		int num = Integer.parseInt(str);
		System.out.println(num);
	}
}
