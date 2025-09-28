package com.mycompany.reservasi_lapangan_minisoccer.model;

public abstract class Reservasi {
    protected String namaPelanggan;
    protected String tanggal;
    protected String jamMulai;
    protected int durasiJam;
    protected double hargaPerJam;

    public Reservasi(String namaPelanggan, String tanggal, String jamMulai, int durasiJam, double hargaPerJam) {
        this.namaPelanggan = namaPelanggan;
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.durasiJam = durasiJam;
        this.hargaPerJam = hargaPerJam;
    }

    // Abstract method (harus diimplementasi di subclass)
    public abstract double hitungTotalBiaya();

    // Getter
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getTanggal() { return tanggal; }
    public String getJamMulai() { return jamMulai; }
    public int getDurasiJam() { return durasiJam; }
    public double getHargaPerJam() { return hargaPerJam; }
}
