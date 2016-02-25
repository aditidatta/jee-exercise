package testThis;

import box.Box;


class ThisKW{
	public static void main(String args[]){
		Box mybox = new Box(10, 5, 6);
		double volume = mybox.volume();
		System.out.println(volume);
	}
}