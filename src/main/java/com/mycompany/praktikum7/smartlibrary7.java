/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;
import java.util.Scanner;

public class smartlibrary7 {
    
    public static void cariKoleksi(String judul, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari Koleksi dengan Judul: " + judul);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getJudul().equalsIgnoreCase(judul)) { 
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Buku tidak ditemukan.");
    }

    public static void cariKoleksi(int tahunTerbit, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("Mencari Koleksi dengan Tahun Terbit: " + tahunTerbit);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getTahunTerbit() == tahunTerbit) { 
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Buku tidak ditemukan.");
    }
    
    public static void simulasiPinjam(Koleksi item){
        item.caraPinjam();
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Koleksi[] daftarKoleksi = new Koleksi[10];
            
            int jumlahKoleksi = 0;
            boolean isRunning = true;
            
            System.out.println("========================================");
            System.out.println("    SELAMAT DATANG DI SMART LIBRARY!    ");
            System.out.println("========================================");            
            
            while(isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Koleksi");
                System.out.println("2. Lihat Daftar Koleksi");
                System.out.println("3. Cari Koleksi");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu: 1-4: ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch(pilihan) {
                    case 1 -> {
                        if (jumlahKoleksi < daftarKoleksi.length) {
                            System.out.println("\n-- Pilih Jenis Koleksi --");
                            System.out.println("1. Buku Cetak Fisik");
                            System.out.println("2. E-Book Digital");
                            System.out.println("3. Majalah");
                            System.out.print("Pilihan (1/2/3): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("Masukkan Judul: ");
                            String judulBaru = scanner.nextLine();

                            System.out.print("Masukkan Pengarang/Penerbit: ");
                            String pengarangBaru = scanner.nextLine();

                            System.out.print("Masukkan Tahun Terbit: ");
                            int tahunBaru = scanner.nextInt();
                            scanner.nextLine();

                            if (jenis == 1) {
                                System.out.print("Masukkan Jumlah Halaman: ");
                                int halaman = scanner.nextInt();
                                scanner.nextLine();
                                daftarKoleksi[jumlahKoleksi] = new BukuCetak(judulBaru, pengarangBaru, tahunBaru, halaman);
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Ukuran File (MB): ");
                                int ukuran = scanner.nextInt();
                                scanner.nextLine();
                                daftarKoleksi[jumlahKoleksi] = new EBook(judulBaru, pengarangBaru, tahunBaru, ukuran);
                            } else if (jenis == 3) {
                                System.out.print("Masukkan Edisi/Bulan: ");
                                String edisi = scanner.nextLine();
                                daftarKoleksi[jumlahKoleksi] = new Majalah(judulBaru, pengarangBaru, tahunBaru, edisi);
                            }

                            jumlahKoleksi++;
                            System.out.println("Sukses! Koleksi berhasil ditambahkan.");
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        } else {
                            System.out.println("Maaf, kapasitas rak Koleksi sudah penuh!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi di Perpustakaan ---");
                        if (jumlahKoleksi == 0) {
                            System.out.println("Belum ada Koleksi yang tersimpan");
                        } else {
                            for (int i = 0; i < jumlahKoleksi; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarKoleksi[i].tampilkanInfo();
                                simulasiPinjam(daftarKoleksi[i]);
                           
                                daftarKoleksi[i].hitungDendaKeterlambatan();
                             
                                if (daftarKoleksi[i] instanceof DapatDipinjam) {
                                    DapatDipinjam itemFisik = (DapatDipinjam) daftarKoleksi[i];
                                    itemFisik.prosesPinjamFisik();
                                }
                       
                                if (daftarKoleksi[i] instanceof DapatDinilai) {
                                    DapatDinilai itemBisaDinilai = (DapatDinilai) daftarKoleksi[i];
                                    itemBisaDinilai.beriRating(5);
                                }
                                
                                System.out.println();
                            }
                            System.out.println("* Total Item Perpustakaan: " + Koleksi.totalKoleksiBerhasilDibuat);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine(); 
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Buku --");
                        System.out.println("1. Cari berdasarkan Judul Teks (String)");
                        System.out.println("2. Cari berdasarkan Tahun (Integer)");
                        System.out.print("Pilih (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        if (modeCari == 1) {
                            System.out.print("Masukkan Judul: ");
                            String kataKunci = scanner.nextLine();
                            cariKoleksi(kataKunci, daftarKoleksi, jumlahKoleksi);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Tahun: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariKoleksi(angkaKunci, daftarKoleksi, jumlahKoleksi);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan Smart Library!");
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-4.");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}