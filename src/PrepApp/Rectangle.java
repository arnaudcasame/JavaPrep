package PrepApp;
/**
 * The <code>Rectangle</code> class describes a rectangle by its
 * length and width.
*/
public class Rectangle {
	
	/**
	 * The rectangle's length.
	*/
	private double length;
	/**
	 * The rectangle's width.
	*/
	private double width;
	
	/**
	 * Construct a <code>Rectangle</code> object given its length and width.  If either or both parameters are negative, set both to zero.
	 *
	 * @param length The rectangle's length, a <code>double</code>
	 * @param width The rectangle's width, a <code>double</code>
	*/
	public Rectangle(double length, double width) {
		this.length = length < 0 || width < 0 ? 0 : length;
		this.width = width < 0 || length < 0 ? 0 : width;
	}
	
	/**
	 * Calculates the perimeter as 2 x l + 2 x w.
	 *
	 * @return the perimeter of the <code>Rectangle</code> object, a <code>double</code>.
	*/
	public double getPerimeter() {
		return this.length * 2 + this.width * 2;
	}
	
	/**
	 * Calculates the area as l x w.
	 *
	 * @return the area of the <code>Rectangle</code> object, a <code>double</code>.
	*/	
	public double getArea() {
		return this.length * this.width;
	}
}