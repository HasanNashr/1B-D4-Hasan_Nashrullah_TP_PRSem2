public class Rectangle extends Shape {
    private double width, length;

    public Rectangle (){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle (double width, double length){
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle (boolean isKondisi, double width, double length, String warna){
        super(warna, isKondisi);
        this.width = width;
        this.length = length;
    } 

    // Getter dan Setter width

    public double getwidth (){
        return width;
    } 

    public void setwidth (double width){
        if (width > 0){
            this.width = width;
        } else {
            System.out.println("width tidak boleh kurang dari 0!");
        }
        
    }

    // Getter dan Setter length

    public double getLength (){
        return length;
    } 

    public void setlength (double length){
        if (length > 0){
            this.length = length;
        } else {
            System.out.println("length tidak boleh kurang dari 0!");
        }
        
    }

    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return 2 * (length + width);
    }

     @Override
        public String isString() {
        return "A Rectangle with width= " + width + " and length= " + length + ", which is a subclass of " + super.isString();
    }


}

/*
Dua variabel instans width (double) dan length (double).
Tiga constructor seperti yang ditunjukkan. No-arg constructor menginisialisasi width dan length ke 1.0.
Getter dan setter untuk semua variabel instans.
Metode getArea() dan getPerimeter().
Override metode toString() yang diwarisi, untuk mengembalikan "A Rectangle with width=xxx and length=zzz, which is a subclass of yyy", di mana yyy adalah output dari metode toString() milik superclass.


*/