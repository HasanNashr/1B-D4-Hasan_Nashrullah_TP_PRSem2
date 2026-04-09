import java.util.Scanner;

public class PenjumlahanPararel {
    // Shared resource: Variabel untuk menyimpan hasil akhir dari semua thread
    private static long totalSum = 0;

    // Method synchronized agar penambahan hasil parsial ke totalSum aman (Thread Safe)
    private static synchronized void addPartialSum(long partial) {
        totalSum += partial;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();
        System.out.print("Masukkan Angka Akhir: ");
        long maxNumber = scanner.nextLong();

        Thread[] threads = new Thread[numThreads];

        // 2. Mekanisme Pembagian Tugas (Divide and Conquer)
        long baseRange = maxNumber / numThreads; 
        /*
            case 1 : 
            1000 / 3 = 333

            case 2 : 
            1000 / 4 = 250
        
        */ 
        long remainder = maxNumber % numThreads; // 1000 mod 3 = 1
        /*
            case 2 : 
            1000 mode 4 = 0
        
        */
        long start = 1;

        // 3. Pembuatan dan Penugasan Thread
        for (int i = 0; i < numThreads; i++) {
            long end = start + baseRange - 1; // 1 + 333 - 1 = 333
            /*
                case 2 : 
                1 + 250 - 1 = 250
            
            */
            
            // Distribusi sisa pembagian agar semua angka ter-cover
            if (i < remainder) {
                end += 1; 
                /*
                    i = 0
                    (i < 1) ? Yes end = 333 + 1 = 334
                    Logika ini hanya dapat berjalan satu kali

                    case 2 : 
                    i = 0
                    (i < 1) ? Yes end = 250 + 1 = 251
                    Logika ini hanya dapat berjalan satu kali
                */
            }

            // Variabel final lokal agar bisa diakses di dalam blok Lambda
            final long threadStart = start; // 1
            final long threadEnd = end; // 334
            final int threadId = i + 1;

            threads[i] = new Thread(() -> {
                // Menampilkan tugas yang dikerjakan
                System.out.println("Thread " + threadId + ": Menjumlahkan " + threadStart + " - " + threadEnd);
                
                long partialSum = 0;
                
                // Melakukan penjumlahan parsial
                for (long j = threadStart; j <= threadEnd; j++) {
                    partialSum += j; // 1 + 2 + 3 + 4 + ..... + 334 = ?
                }
                
                // Menampilkan hasil parsial
                System.out.println("Hasil parsial Thread " + threadId + ": " + partialSum);
                
                // Menambahkan hasil parsial ke total akhir dengan aman
                addPartialSum(partialSum);
            });

            // Menyiapkan titik awal untuk thread berikutnya
            start = end + 1; // 334 + 1 = 335
        }

        // 4. Memulai eksekusi paralel
        for (Thread t : threads) {
            t.start();
        }

        // 5. Main Thread menunggu semua thread pekerja selesai (Synchronization)
        for (Thread t : threads) {
            t.join();
        }

        // 6. Output Hasil Akhir
        System.out.println("-------------------------------------------------");
        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Total Penjumlahan (1 sampai " + maxNumber + ") = " + totalSum);
        
        scanner.close();
    }
}