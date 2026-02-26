public class Shape {
    private String color;
    private boolean kondisi;

    public Shape (){
        color = "green";
        kondisi = true;
    }

    public Shape (String warna, boolean kond){
        color = warna;
        kondisi = kond;
    }

    // Getter dan Setter Color 
    public String getColor (){
        return color;
    } 

    public void setColor (String warna){
        this.color = warna;
    }

    // Getter dan Setter kondisi
    public boolean getKondisi (){
        return kondisi;
    } 

    public void setKondisi (boolean kond){
        this.kondisi = kond;
    }

    // Print isString 

    public String isString() {
        if (getKondisi() == true){
            return "A Shape with color of " + getColor() +  " and filled";
        } else {
            return "A Shape with color of " + getColor() +  " Not filled";
        }
        
    }
} 

