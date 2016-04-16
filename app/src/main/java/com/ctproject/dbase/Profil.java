package com.ctproject.dbase;

/**
 * Created by farhan on 10/1/15.
 */
public class Profil {

    //private variables
    int _id_identitas;
    String _nama_identitas;
    String _tempat_identitas;
    String _tanggal_identitas;
    String _quote_identitas;
    String _jeniskelamin_identitas;
    String _golongandarah_identitas;

    // Empty constructor
    public Profil(){

    }
    // constructor
    public Profil(int idIdentitas, String namaIdentitas, String tempatIdentitas, String tanggalIdentitas, String quoteIdentitas, String jeniskelaminIdentitas, String golongandarahIdentitas){
        this._id_identitas = idIdentitas;
        this._nama_identitas = namaIdentitas;
        this._tempat_identitas = tempatIdentitas;
        this._tanggal_identitas = tanggalIdentitas;
        this._quote_identitas = quoteIdentitas;
        this._jeniskelamin_identitas = jeniskelaminIdentitas;
        this._golongandarah_identitas = golongandarahIdentitas;
    }

    // constructor
    public Profil(String namaIdentitas, String tempatIdentitas, String tanggalIdentitas, String quoteIdentitas, String jeniskelaminIdentitas, String golongandarahIdentitas){
        this._nama_identitas = namaIdentitas;
        this._tempat_identitas = tempatIdentitas;
        this._tanggal_identitas = tanggalIdentitas;
        this._quote_identitas = quoteIdentitas;
        this._jeniskelamin_identitas = jeniskelaminIdentitas;
        this._golongandarah_identitas = golongandarahIdentitas;
    }

    // getting ID
    public int getID(){
        return this._id_identitas;
    }

    // setting id
    public void setID(int idIdentitas){
        this._id_identitas = idIdentitas;
    }

    // getting name
    public String getNama(){
        return this._nama_identitas;
    }

    // setting name
    public void setNama(String namaIdentitas){
        this._nama_identitas = namaIdentitas;
    }

    // getting phone number
    public String getTempat(){
        return this._tempat_identitas;
    }

    // setting phone number
    public void setTempat(String tempatIdentitas){
        this._tempat_identitas = tempatIdentitas;
    }

    // getting phone number
    public String getTanggal(){
        return this._tanggal_identitas;
    }

    // setting phone number
    public void setTanggal(String tanggalIdentitas){
        this._tanggal_identitas = tanggalIdentitas;
    }

    // getting phone number
    public String getQuote(){
        return this._quote_identitas;
    }

    // setting phone number
    public void setQuote(String alamatIdentitas){
        this._quote_identitas = alamatIdentitas;
    }

    // getting phone number
    public String getJeniskelamin(){
        return this._jeniskelamin_identitas;
    }

    // setting phone number
    public void setJeniskelamin(String jeniskelaminIdentitas){
        this._jeniskelamin_identitas = jeniskelaminIdentitas;
    }

    // getting phone number
    public String getGolongandarah(){
        return this._golongandarah_identitas;
    }

    // setting phone number
    public void setGolongandarah(String golongandarahIdentitas){
        this._golongandarah_identitas = golongandarahIdentitas;
    }
}
