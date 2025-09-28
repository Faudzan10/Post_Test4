package com.mycompany.reservasi_lapangan_minisoccer.model;

public class ReservasiVIP extends Reservasi {
    private double biayaTambahan;

    public ReservasiVIP(String namaPelanggan, String tanggal, String jamMulai, int durasiJam) {
        super(namaPelanggan, tanggal, jamMulai, durasiJam, 100000); // harga VIP 100rb/jam
        this.biayaTambahan = 25000; // contoh tambahan
    }

    @Override
    public double hitungTotalBiaya() {
        return (durasiJam * hargaPerJam) + biayaTambahan;
    }

    public String getKeuntungan() {
        return "- Harga Rp 100.000/jam + fasilitas premium\n"
             + "- Fasilitas: Lapangan rumput sintetis, Air mineral, Ruang tunggu VIP\n"
             + "- Cocok untuk turnamen & main serius";
    }
}
