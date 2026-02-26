public class TestCylinder { // save as "TestCylinder.java"
    public static void main(String[] args) {
        
        // Declare and allocate a new instance of cylinder
        // with default color, radius, and height
        Cylinder c1 = new Cylinder();

        System.out.println("Cylinder:" 
            + " radius=" + c1.getRadius() 
            + " height=" + c1.getHeight() 
            + " surface area=" + c1.getArea() 
            + " volume=" + c1.getVolume()
            + " color=" + c1.getColor());
        
        System.out.println(c1.toString());

        // Declare and allocate a new instance of cylinder
        // specifying height, with default color and radius
        Cylinder c2 = new Cylinder(10.0); 
        c2.setHeight(20.0); // Specifying height

        System.out.println("Cylinder:" 
            + " radius=" + c2.getRadius() 
            + " height=" + c2.getHeight() 
            + " surface area=" + c2.getArea() 
            + " volume=" + c2.getVolume()
            + " color= " + c2.getColor());

        System.out.println(c2.toString());

        // Declare and allocate a new instance of cylinder
        // specifying radius and height, with default color
        Cylinder c3 = new Cylinder(2.0, 10.0);
        c3.setRadius(3.0); // Specifying rad
        c3.setHeight(15.0);// Specifying height
        System.out.println("Cylinder:" 
            + " radius=" + c3.getRadius() 
            + " height=" + c3.getHeight() 
            + " surface area=" + c3.getArea() 
            + " volume=" + c3.getVolume()
            + " color=" + c3.getColor());

        System.out.println(c3.toString());
    }
}
