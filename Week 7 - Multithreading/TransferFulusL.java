import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Akunku {
    int money = 150;
    // Setiap objek akun memiliki gemboknya sendiri
    Lock lock = new ReentrantLock(); 
}

public class TransferFulusL {
    public static void main(String[] args) throws InterruptedException {
        Akunku a1 = new Akunku();
        Akunku a2 = new Akunku();

        Thread t1 = new Thread(() -> {
            // Mengunci gembok a1
            a1.lock.lock(); 
            try {
                System.out.println("T1: Mengunci a1 menggunakan ReentrantLock.");
                Thread.sleep(100);

                // Mengunci gembok a2
                a2.lock.lock(); 
                try {
                    System.out.println("T1: Mengunci a2. Melakukan penjumlahan.");
                    a2.money += a1.money;
                } finally {
                    // Wajib unlock di dalam finally agar gembok terbuka meski ada error
                    a2.lock.unlock(); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                a1.lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            // Urutan kunci tetap a1 lalu a2 untuk mencegah deadlock
            a1.lock.lock(); 
            try {
                System.out.println("T2: Mengunci a1. Menunggu gembok a1 dilepas jika sedang dipakai.");
                Thread.sleep(100);

                a2.lock.lock();
                try {
                    System.out.println("T2: Mengunci a2. Melakukan penjumlahan.");
                    a1.money += a2.money;
                } finally {
                    a2.lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                a1.lock.unlock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir a1: " + a1.money);
        System.out.println("Saldo Akhir a2: " + a2.money);
    }
}