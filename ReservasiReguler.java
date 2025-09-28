package com.mycompany.reservasi_lapangan_minisoccer.model;

public class ReservasiReguler extends Reservasi {

    public ReservasiReguler(String namaPelanggan, String tanggal, String jamMulai, int durasiJam) {
        super(namaPelanggan, tanggal, jamMulai, durasiJam, 50000); // harga reguler 50rb/jam
    }

    @Override
    public double hitungTotalBiaya() {
        return durasiJam * hargaPerJam;
    }

    public String getKeuntungan() {
        return "- Harga terjangkau Rp 50.000/jam\n"
             + "- Fasilitas: Lapangan standar, Air mineral\n"
             + "- Cocok untuk bermain santai";
    }
}
