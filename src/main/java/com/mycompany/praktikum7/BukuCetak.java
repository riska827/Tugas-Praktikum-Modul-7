/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;

public class BukuCetak extends Koleksi implements DapatDipinjam, DapatDinilai {
    private int jumlahHalaman;

    public BukuCetak(String judul, String pengarang, int tahunTerbit, int jumlahHalaman) {
        super(judul, pengarang, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Buku Cetak] Judul: %-15s | Pengarang: %-10s | Tahun: %d | Halaman: %d Hal%n",
                this.judul, this.pengarang, this.tahunTerbit, this.jumlahHalaman);
    }

    @Override
    public void caraPinjam() {
        System.out.println("-> Info Pinjam: Buku cetak wajib diambil fisik bukunya di meja administrasi perpustakaan.");
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Aturan Denda: Rp 2.000 / hari keterlambatan.");
    }

    @Override
    public void prosesPinjamFisik() {
        System.out.println("-> [PROSES PINJAM] Anggota menyerahkan buku fisik & kartu perpus ke Kasir.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN BUKU] Buku fisik ini mendapat rating " + bintang + "/5 Bintang.");
    }
}

