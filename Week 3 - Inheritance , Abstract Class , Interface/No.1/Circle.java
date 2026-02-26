/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle { // Save as "Circle.java"
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color;

    // Constructors (overloaded)
    /** Constructs a Circle instance with default value for radius and color */
    public Circle() { // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */
    public Circle(double r) { // 2nd constructor
        radius = r;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */
    public Circle (double r, String clr) {
        radius = r;
        color = clr;
    }

    // Getter color
    public String getColor (){
        return color;
    }

    // Setter Color
    public void setColor (String clr){
        this.color = clr;
    }

    /** Returns the radius */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double rad) {
        if (rad > 0){
            this.radius = rad;
        } else {
            System.out.println("radius tidak boleh 0!");
        }
    }

    //Setter Radius + Kondisional

    /** Returns the area of this Circle instance */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** * Return a self-descriptive string of this instance in the form of
     * Circle[radius=?,color=?] 
     */
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}
