/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7;

public abstract class Koleksi {
    protected String judul;
    protected String pengarang;
    protected int tahunTerbit;
    
    public static int totalKoleksiBerhasilDibuat = 0;
    
    public Koleksi(String judul, String pengarang, int tahunTerbit){
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        
        totalKoleksiBerhasilDibuat++;
    }
    
    public String getJudul(){
        return this.judul;
    }
    
    public String getPengarang(){
        return this.pengarang;
    }
    
    public int getTahunTerbit(){
        return this.tahunTerbit;
    }
    
    public void setJudul(String Judul){
        this.judul = judul;
    }
    
    public void setPengarang(String Pengarang){
        this.pengarang = pengarang;
    }
    
    public void setTahunTerbit(int tahunTerbit){
        if(tahunTerbit > 0){
            this.tahunTerbit = tahunTerbit;
        }else{
            System.out.println("Tahun terbit tidak valid");
        }
    }
    
    public void tampilkanInfo(){
        System.out.printf("Judul: %-20s | Pengarang: %-15s | Tahun: %d%n", judul, pengarang, tahunTerbit);
    }
    
    public void caraPinjam(){
        System.out.println("Barang dipinjam secara fisik ke meja administrasi");
    }
    
    public abstract void hitungDendaKeterlambatan();
}
