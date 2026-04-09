class Resto {
    private int chickenStock = 100;

    // Tambahkan synchronized di sini!
    public synchronized void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            chickenStock--;
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            // Opsional: Boleh ditambahkan agar tidak terlalu banyak print "habis"
            // System.out.println(cashierName + " gagal: Stok Habis!"); 
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        Runnable task = () -> {
            for (int i = 1; i <= 100; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A"); // Parameter hanya menerima String
        Thread kasir2 = new Thread(task, "Kasir-B"); // Parameter hanya menerima String
        Thread kasir3 = new Thread(task, "Kasir-C"); // Parameter hanya menerima String

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
