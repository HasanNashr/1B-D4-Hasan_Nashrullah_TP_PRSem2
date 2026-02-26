public class MainProgram {
    public static void main(String[] args) {

        // Construktor Shape 1
        Shape s1 = new Shape(); 
        System.out.println("Warna Default:" + s1.getColor());
        System.out.println("Kondisi: " + s1.getKondisi());
        System.out.println(s1.isString());

        // Construktor Shape 2
        Shape s2 = new Shape("Hitam", true);
        System.out.println("Warna :" + s2.getColor());
        System.out.println("Kondisi: " + s2.getKondisi());
        System.out.println(s2.isString());

        // Construktor Rectangle 3
        Rectangle r1 = new Rectangle(true, 15.0, 10.0, "Kuning");
        System.out.println("Rectangle:" 
            + " Warna=" + r1.getColor() 
            + " Kondisi=" + r1.getKondisi() 
            + " Width=" + r1.getwidth() 
            + " length=" + r1.getLength()
            + " area= " + r1.getArea()
            + " perimeter= " + r1.getPerimeter());
        System.out.println(r1.isString());

        // Construktor Square 3
        Square ss1 = new Square(true, 15.0, "Emas");
        System.out.println("Square:" 
            + " Warna=" + ss1.getColor() 
            + " Kondisi=" + ss1.getKondisi() 
            + " Sisi=" + ss1.getwidth() 
            + " area= " + ss1.getArea()
            + " perimeter= " + ss1.getPerimeter());
        System.out.println(ss1.isString());

        // Construktor Circle 3
        Circle c1 = new Circle(true, 15.0, "Biru");
        System.out.println("Circle:" 
            + " Warna=" + c1.getColor() 
            + " Kondisi=" + c1.getKondisi() 
            + " Rad=" + c1.getRad() 
            + " area= " + c1.getArea()
            + " perimeter= " + c1.getPerimeter());
        System.out.println(c1.isString());
        








    }
}
