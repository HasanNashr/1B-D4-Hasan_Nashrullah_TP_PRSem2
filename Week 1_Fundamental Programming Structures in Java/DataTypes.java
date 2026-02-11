import java.util.Scanner;  

class DataTypes {
  public static void main(String[] args) {  
    Scanner scanner = new Scanner(System.in);

    System.out.println("Sample Input: ");
    int number = scanner.nextInt();
    
    scanner.nextLine();

    String[]isiNomor = new String [number];

    for (int i = 0; i < number; i++){
        isiNomor[i] = scanner.next();
    } 

    System.out.println("Sample Output : ");
    for (int i = 0; i < number; i++){
        String simpan_angka = isiNomor[i];
        try {
            long angka = Long.parseLong(simpan_angka);  
            System.out.println(isiNomor[i] + " can be fitted in.");
            if (angka >= Byte.MIN_VALUE && angka <= Byte.MAX_VALUE){
                System.out.println("* byte");
            }   
            if (angka >= Short.MIN_VALUE && angka <= Short.MAX_VALUE){
                System.out.println("* short");
            }
            if (angka >= Integer.MIN_VALUE && angka <= Integer.MAX_VALUE){
                System.out.println("* int");
            }   
            System.out.println("* long"); 
             
        } 
        
        catch (Exception e) {
            System.out.println(isiNomor[i]+ " can\'t be fitted anywhere.");
        }
    }
    scanner.close(); 
  }
}
