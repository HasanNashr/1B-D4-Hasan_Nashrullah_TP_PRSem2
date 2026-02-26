public class Circle extends Shape{
    private double radius;

    public Circle (){
        super();
        this.radius = 1.0;
    }

    public Circle (double rad){
        super();
        this.radius = rad;
    }

    public Circle (boolean isKondisi, double rad, String warna){
        super(warna, isKondisi);
        this.radius = rad;
    }

    // Getter dan Setter radius 
    public double getRad (){
        return radius;
    } 

    public void setRad (double rad){
        if (rad > 0){
            this.radius = rad;
        } else {
            System.out.println("Rad tidak boleh kurang dari 0!");
        }
        
    }
    
    public double getArea() {
        return radius * radius * Math.PI;
    } 

    public double getPerimeter() {
        return Math.PI * radius;
    } 

    @Override
    public String isString() {
        return "A Circle with radius= " + radius + ", which is a subclass of " + super.isString();
    }
}

/*
Sebuah variabel instans radius (double).
Tiga constructor seperti yang ditunjukkan. No-arg constructor menginisialisasi radius ke 1.0.
Getter dan setter untuk variabel instans radius.
Metode getArea() dan getPerimeter().
Override metode toString() yang diwarisi, untuk mengembalikan "A Circle with radius=xxx, which is a subclass of yyy", di mana yyy adalah output dari metode toString() milik superclass.


*/