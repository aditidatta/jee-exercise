package box;

public class Box {
	double width;
	double height;
	double depth;
	// This is the constructor for Box.
	public Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	// compute and return volume
	public double volume() {
		return width * height * depth;
	}
}