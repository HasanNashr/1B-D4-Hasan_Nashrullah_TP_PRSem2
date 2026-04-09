class Account {
    int balance = 150;
} // Setiap account yang dibuat punya 150

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(); //Nilai awal akun 150
        Account acc2 = new Account(); // Nilai awal akun 150    

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Thread 1 mengunci acc1 sehingga tidak ada thread lain yang 
                System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                } // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception?

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                    System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                    System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
