
public class RectangleArea {
	/*
     * Define two public attributes width and height of type int.
     */
    public int width;
    public int height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    public RectangleArea(int w, int h) {
        width = w;
        height = h;
    }
    
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    public int getArea() {
        return width * height;
    }
}
