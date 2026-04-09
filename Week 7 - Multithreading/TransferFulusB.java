class Akun {
    int money = 150;
} // Set semua object Akun mmeiliki money 150

public class TransferFulusB {
    public static void main(String[] args) throws InterruptedException {
        Akun a1 = new Akun(); // Money 150 (awal)
        Akun a2 = new Akun(); // Money 150 (awal)

        Thread t1 = new Thread(() -> {
            synchronized (a1) { // Thread 1 mengunci a1 sehingga tidak ada thread lain yang dapat menggunakan a1
                System.out.println(
                        "Synchronized digunakan untuk mengunci a1 melalui thread t1, tidak ada thread lain yang dapat mengakses");
                System.out.println(
                        "Thread ini melakukan penguncian pada a1 dan menjalankan programnya terlebih dahulu baru dapat di akses oleh thread lain");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                } // Tangkap error yang terjadi bila mana Ketika thread sedang tertidur terdapat
                  // perintah .stop() (sudah usang sih)
                  // atau perintah .interrurpt(), tanpa ini program akan "bingung" menentukan
                  // keadaan dirinya bekerja atau tidak
                synchronized (a2) { // Thread 1 mengunci a2 untuk melakukan penjumlahan terlebih dahulu agar tidak
                                    // terjadi race condition (akan merubah sehingga penguncian dibutuhkan)
                    System.out.println(
                            "Thread 1 mengunci a2 untuk melakukan penjumlahan pada object a2 dengan objek a1 agar tidak terjadi race condition");
                    a2.money += a1.money;
                }
            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (a1) { // Thread 2 mengunci a1 agar thread lain tidak dapat mengakses a1
                System.out.println(
                        "Tukar penguncian agar tidak terjadi deadlock, t2 akan menunggu atau mengater agar a1 selesai digunakan oleh t1 .");
                System.out.println(
                        "Thread ini melakukan penguncian pada a1 dan menjalankan programnya terlebih dahulu baru dapat di akses oleh thread lain. t1 juga sedang di kunci sehingga tidak bisa di akses");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Tangkap error yang terjadi bila mana Ketika thread sedang
                    // tertidur terdapat
                    // perintah .stop() (sudah usang sih)
                    // atau perintah .interrurpt(), tanpa ini program akan "bingung" menentukan
                    // keadaan dirinya bekerja atau tidak
                }
                synchronized (a2) { // Thread 2 mengunci a2 untuk melakukan penjumlahan terlebih dahulu agar tidak
                                    // terjadi race condition (akan merubah sehingga penguncian dibutuhkan)
                    System.out.println(
                            "Thread 2 mengunci a2 untuk melakukan penjumlahan pada object a1 dengan objek a2 agar tidak terjadi race condition ");
                    a1.money += a2.money;
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + a1.money);
        System.out.println("Saldo Akhir acc2: " + a2.money);

    }
}
