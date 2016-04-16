package com.ctproject.dbase;

public class BeratIdeal {

    //private variables
    int _id;
    String _berat;
    String _tinggi;
    String _kalkulasi;
    String _jeniskelamin;
    String _kesimpulan;
    String _tanggal;
    String _waktu;

    // Empty constructor
    public BeratIdeal() {
    }

    // constructor
    public BeratIdeal(int id, String berat, String tinggi, String kalkulasi, String jeniskelamin, String kesimpulan, String tanggal, String waktu) {
        this._id = id;
        this._berat = berat;
        this._tinggi = tinggi;
        this._kalkulasi = kalkulasi;
        this._jeniskelamin = jeniskelamin;
        this._kesimpulan = kesimpulan;
        this._tanggal = tanggal;
        this._waktu = waktu;
    }

    // constructor
    public BeratIdeal(String berat, String tinggi, String kalkulasi, String jeniskelamin, String kesimpulan, String tanggal, String waktu) {
        this._berat = berat;
        this._tinggi = tinggi;
        this._kalkulasi = kalkulasi;
        this._jeniskelamin = jeniskelamin;
        this._kesimpulan = kesimpulan;
        this._tanggal = tanggal;
        this._waktu = waktu;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getBerat() {
        return this._berat;
    }

    // setting name
    public void setBerat(String berat) {
        this._berat = berat;
    }

    // getting phone number
    public String getTinggi() {
        return this._tinggi;
    }

    // setting phone number
    public void setTinggi(String tinggi) {
        this._tinggi = tinggi;
    }

    // getting phone number
    public String getKalkulasi() {
        return this._kalkulasi;
    }

    // setting phone number
    public void setKalkulasi(String kalkulasi) {
        this._kalkulasi = kalkulasi;
    }

    // getting phone number
    public String getJeniskelamin() {
        return this._jeniskelamin;
    }

    // setting phone number
    public void setJeniskelamin(String jeniskelamin) {
        this._jeniskelamin = jeniskelamin;
    }

    // getting phone number
    public String getKesimpulan() {
        return this._kesimpulan;
    }

    // setting phone number
    public void setKesimpulan(String kesimpulan) {
        this._kesimpulan = kesimpulan;
    }

    // getting phone number
    public String getTanggal() {
        return this._tanggal;
    }

    // setting phone number
    public void setTanggal(String tanggal) {
        this._tanggal = tanggal;
    }

    // getting phone number
    public String getWaktu() {
        return this._waktu;
    }

    // setting phone number
    public void setWaktu(String waktu) {
        this._waktu = waktu;
    }

}