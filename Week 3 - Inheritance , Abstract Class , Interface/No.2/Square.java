public class Square extends Rectangle{
    private double side;

    public Square (){
        super(1.0,1.0);
    }

    public Square (double side){
        super(side, side);
    }

    public Square (boolean isKondisi, double side, String warna){
        super(isKondisi, side, side, warna );
    } 

    // Setter Getter side 

    public double getSide (){
        return side;
    }

    @Override
    public void setwidth(double sisi) {
        if (sisi > 0){
            super.setwidth(sisi);
            super.setlength(sisi);
        } else {
            System.out.println("Sisi tidak boleh kurang dari sama dengan 0!");
        }

    }

    @Override
    public void setlength(double sisi) {
        if (sisi > 0){
            super.setlength(sisi);
            super.setwidth(sisi);
        } else {
            System.out.println("Sisi tidak boleh kurang dari sama dengan 0!");
        }

    }

    @Override
        public String isString() {
        return "A Square with side= " + getwidth() + " , which is a subclass of " + super.isString();
    }

}

/*
Sediakan constructor yang sesuai (seperti yang ditunjukkan dalam diagram kelas)! Petunjuk:
public Square(double side) { 
    super(side, side);  // Call superclass Rectangle(double, double)
}
Override metode toString() untuk mengembalikan "A Square with side=xxx, which is a subclass of yyy", di mana yyy adalah output dari metode toString() milik superclass!
Apakah Anda perlu melakukan override pada getArea() dan getPerimeter()? Cobalah!
Override setLength() dan setWidth() untuk mengubah width sekaligus length, guna menjaga geometri persegi!


*/