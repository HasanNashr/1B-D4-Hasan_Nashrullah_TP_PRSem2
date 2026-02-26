public class RestaurantMain_V2 {
    public static void main(String[] args) {
        Restaurant_V2 resto = new Restaurant_V2();

        resto.setNama(Restaurant_V2.id, "Pizza");
        resto.setHarga(Restaurant_V2.id, 250000);
        resto.setStok(Restaurant_V2.id, 20);
        
        Restaurant_V2.nextId(); 

        resto.setNama(Restaurant_V2.id, "Spaghetti");
        resto.setHarga(Restaurant_V2.id, 80000);
        resto.setStok(Restaurant_V2.id, 20);
        
        Restaurant_V2.nextId();

        resto.setNama(Restaurant_V2.id, "Tenderloin Steak");
        resto.setHarga(Restaurant_V2.id, 60000);
        resto.setStok(Restaurant_V2.id, 30);

        Restaurant_V2.nextId();

        resto.setNama(Restaurant_V2.id, "Chicken Steak");
        resto.setHarga(Restaurant_V2.id, 45000);
        resto.setStok(Restaurant_V2.id, 30);

        resto.tampilkanMenu();

        System.out.println("\n PROSES PEMESANAN ");
        
        resto.pesanMakanan("Spaghetti", 2);

        resto.pesanMakanan("Pizza", 15);

        resto.pesanMakanan("Bakso", 45);

        System.out.println("\n UPDATE STOK ");
        resto.tampilkanMenu();
    }
}