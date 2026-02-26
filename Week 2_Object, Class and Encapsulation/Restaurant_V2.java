public class Restaurant_V2 {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    public static byte id = 0;

    public Restaurant_V2() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // getter nama, harga, dan stok terpisah

    public String getNama (int id){
        return this.nama_makanan[id];
    }

    public double getHarga (int id){
        return this.harga_makanan[id];
    }

    public double getStok (int id){
        return this.stok[id];
    }

    // Setter nama, harga, dan stok terpisah

    public void setNama(int id, String nama){
        this.nama_makanan[id] = nama;
    }

    public void setHarga(int id, double harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh minus!");
        } else {
            this.harga_makanan[id] = harga;
        }
    }

    public void setStok(int id, int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh minus!");
        } else {
            this.stok[id] = stok;
        }
    }

    public static void nextId() {
        id++;
    }

    // Validasi tidak ada stok kosong
    public boolean stokKosong(int id){
        if (stok[id] == 0){
            return true;
        } else {
            return false;
        }
    }

    // Tampilkan menu
    public void tampilkanMenu (){
        for (int i = 0; i < id; i++){
            if (!stokKosong(i)){
                System.out.println(
                    nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
                );
            }
        }
    }

    // Pemesanan Makanan 
    public void pesanMakanan(String nama, int jumlahPesan) {
        for (int i = 0; i <= id; i++) {
            if (nama.equals(nama_makanan[i])) {
                if (stok[i] >= jumlahPesan) {
                    System.out.println("Berhasil memesan " + jumlahPesan + " " + nama);
                    stok[i] -= jumlahPesan;
                } else {
                    System.out.println("Stok " + nama + " tidak cukup!");
                }
                return;
            }
        }
        System.out.println("Menu " + nama + " tidak ditemukan.");
    }
}


