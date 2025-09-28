package com.mycompany.reservasi_lapangan_minisoccer.service;

import com.mycompany.reservasi_lapangan_minisoccer.model.Reservasi;
import java.util.ArrayList;

public class ReservasiService {
    private final ArrayList<Reservasi> reservasiList = new ArrayList<>();

    public void tambahReservasi(Reservasi reservasi) {
        reservasiList.add(reservasi);
        System.out.println("Reservasi berhasil ditambahkan!");
    }

    // Overloading -> tambah reservasi dengan diskon
    public void tambahReservasi(Reservasi reservasi, double diskon) {
        double total = reservasi.hitungTotalBiaya();
        double totalDiskon = total - (total * diskon / 100);
        reservasiList.add(reservasi);
        System.out.println("Reservasi berhasil ditambahkan dengan diskon " + diskon + "%, Total: Rp " + totalDiskon);
    }

    public ArrayList<Reservasi> getAllReservasi() {
        return reservasiList;
    }

    public void hapusReservasi(int index) {
        if (index >= 0 && index < reservasiList.size()) {
            reservasiList.remove(index);
            System.out.println("Reservasi berhasil dihapus!");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void ubahReservasi(int index, Reservasi reservasiBaru) {
        if (index >= 0 && index < reservasiList.size()) {
            reservasiList.set(index, reservasiBaru);
            System.out.println("Reservasi berhasil diubah!");
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}
