public class Point {

	int x, y;

	public void translate (int dx, int dy)  {
		x = x + dx;
		y = y + dy;
	}

	public double distanceFromOrigin () {
		return Math.sqrt(x*x + y*y);
	}
}