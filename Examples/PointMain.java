public class PointMain {

	public static void main (String [] args) {
		Point p1 = new Point();
		Point p2 = new Point();

		p1.x = 1;
		p1.y = 1;

		p2.x = 3;
		p2.y = 4;

		System.out.println("p1's distance from origin is " +  p1.distanceFromOrigin());
		System.out.println("p2's distance from origin is " +  p2.distanceFromOrigin());
	}
}