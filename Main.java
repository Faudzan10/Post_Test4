package com.mycompany.reservasi_lapangan_minisoccer;

import com.mycompany.reservasi_lapangan_minisoccer.model.*;
import com.mycompany.reservasi_lapangan_minisoccer.service.ReservasiService;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ReservasiService service = new ReservasiService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMENU UTAMA RESERVASI ZANOD MINI SOCCER:");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Ubah Reservasi");
            System.out.println("4. Hapus Reservasi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1–5): ");
            int menu = inputInt();

            switch (menu) {
                case 1 -> tambahReservasi();
                case 2 -> lihatReservasi();
                case 3 -> ubahReservasi();
                case 4 -> hapusReservasi();
                case 5 -> { System.out.println("Terima kasih!"); return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahReservasi() {
        System.out.println("\n=== TAMBAH RESERVASI ===");
        String nama = inputString("Nama Pemesan: ");
        String tanggal = inputString("Tanggal (dd-mm-yyyy): ");
        String jam = inputString("Jam mulai (HH:MM): ");
        int durasi = inputPositif("Durasi (jam): ");

        System.out.println("\nPilih jenis reservasi:");
        System.out.println("1. Reguler (Rp 50.000/jam)");
        System.out.println("2. VIP (Rp 100.000/jam)");
        System.out.print("Pilihan (1–2): ");
        int jenis = inputInt();

        Reservasi reservasi;
        if (jenis == 1) {
            ReservasiReguler reg = new ReservasiReguler(nama, tanggal, jam, durasi);
            reservasi = reg;
            System.out.println("\nKeuntungan Reservasi Reguler:\n" + reg.getKeuntungan());
        } else {
            ReservasiVIP vip = new ReservasiVIP(nama, tanggal, jam, durasi);
            reservasi = vip;
            System.out.println("\nKeuntungan Reservasi VIP:\n" + vip.getKeuntungan());
        }

        service.tambahReservasi(reservasi);
        System.out.println("Detail: [" + reservasi.getClass().getSimpleName().toUpperCase() + "] "
                + "Nama: " + reservasi.getNamaPelanggan()
                + " | Tanggal: " + reservasi.getTanggal()
                + " | Jam: " + reservasi.getJamMulai()
                + " | Durasi: " + reservasi.getDurasiJam() + " jam"
                + " | Total: Rp " + reservasi.hitungTotalBiaya());
    }

    private static void lihatReservasi() {
        var list = service.getAllReservasi();
        if (list.isEmpty()) {
            System.out.println("Belum ada reservasi.");
            return;
        }
        System.out.println("\n=== DAFTAR RESERVASI ===");
        for (int i = 0; i < list.size(); i++) {
            Reservasi r = list.get(i);
            System.out.println((i+1) + ". " + r.getNamaPelanggan() + " | " + r.getTanggal() + " | " 
                               + r.getJamMulai() + " | " + r.getDurasiJam() + " jam | Rp " + r.hitungTotalBiaya());
        }
    }

    private static void ubahReservasi() {
        lihatReservasi();
        System.out.print("Pilih nomor reservasi yang ingin diubah: ");
        int index = inputInt() - 1;

        String nama = inputString("Nama baru: ");
        String tanggal = inputString("Tanggal baru (dd-mm-yyyy): ");
        String jam = inputString("Jam baru (HH:MM): ");
        int durasi = inputPositif("Durasi baru (jam): ");

        System.out.print("Pilih jenis (1=Reguler, 2=VIP): ");
        int jenis = inputInt();

        Reservasi baru = (jenis == 1)
                ? new ReservasiReguler(nama, tanggal, jam, durasi)
                : new ReservasiVIP(nama, tanggal, jam, durasi);

        service.ubahReservasi(index, baru);
    }

    private static void hapusReservasi() {
        lihatReservasi();
        System.out.print("Pilih nomor reservasi yang ingin dihapus: ");
        int index = inputInt() - 1;
        service.hapusReservasi(index);
    }

    // ===== Helper Validasi =====
    private static String inputString(String pesan) {
        String input;
        while (true) {
            System.out.print(pesan);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input tidak boleh kosong! Silakan isi kembali.");
        }
    }

    private static int inputInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Harus berupa angka!");
            sc.nextLine();
        }
        int val = sc.nextInt(); sc.nextLine();
        return val;
    }

    private static int inputPositif(String pesan) {
        int val;
        do {
            System.out.print(pesan);
            while (!sc.hasNextInt()) {
                System.out.println("Harus berupa angka positif!");
                sc.nextLine();
            }
            val = sc.nextInt(); sc.nextLine();
            if (val <= 0) System.out.println("Harus lebih dari 0!");
        } while (val <= 0);
        return val;
    }
}
