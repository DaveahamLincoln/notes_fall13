
public class Rectangle {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public Rectangle(int width, int height, int xVal, int yVal ){
		x= xVal;
		y= xVal;
		w = width;
		h = height;
		
	}
	
	public int getArea() {
		return w * h;
	}

}