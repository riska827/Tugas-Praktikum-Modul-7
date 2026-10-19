/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;

public class EBook extends Koleksi implements DapatDinilai {
    private int ukuranFileMB;

    public EBook(String judul, String pengarang, int tahunTerbit, int ukuranFileMB) {
        super(judul, pengarang, tahunTerbit);
        this.ukuranFileMB = ukuranFileMB;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[E-Book]    Judul: %-15s | Pengarang: %-10s | Tahun: %d | Ukuran: %d MB%n",
                this.judul, this.pengarang, this.tahunTerbit, this.ukuranFileMB);
    }

    @Override
    public void caraPinjam() {
        System.out.println("-> Info Pinjam: E-Book dipinjam dengan cara di-download melalui aplikasi/situs web.");
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Aturan Denda: Tidak ada denda. Akses otomatis dicabut jika masa pinjam habis.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN E-BOOK] Buku digital ini mendapat rating " + bintang + "/5 Bintang di aplikasi.");
    }
}

