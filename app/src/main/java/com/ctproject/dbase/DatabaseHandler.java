package com.ctproject.dbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Versi Database
    public static final int DATABASE_VERSION = 1;

    // Nama Database
    public static final String DATABASE_NAME = "BeratIdealmu";

    // Nama tabel
    public static final String TABLE_BERATIDEAL = "beratidealmu";
    public static final String TABLE_PROFIL = "profil";
    public static final String TABLE_ALARM = "alarm";

    // Tabel BeratIdeal
    public static final String KEY_ID = "id";
    public static final String KEY_BERAT = "berat";
    public static final String KEY_TINGGI = "tinggi";
    public static final String KEY_JENISKELAMIN = "jeniskelamin";
    public static final String KEY_KALKULASI = "kalkulasi";
    public static final String KEY_KESIMPULAN = "kesimpulan";
    public static final String KEY_TANGGAl = "tanggal";
    public static final String KEY_WAKTU = "waktu";

    //Tabel Profil
    public static final String KEY_ID_IDENTITAS = "id";
    public static final String KEY_NAMA_IDENTITAS = "nama";
    public static final String KEY_TEMPAT_IDENTITAS = "tempat";
    public static final String KEY_TANGGAL_IDENTITAS = "tanggal";
    public static final String KEY_QUOTE_IDENTITAS = "quote";
    public static final String KEY_JENISKELAMIN_IDENTITAS = "jenis_kelamin";
    public static final String KEY_GOLONGANDARAH_IDENTITAS = "golongan_darah";

    //Tabel Alarm
    public static final String KEY_ID_ALARM = "id";
    public static final String KEY_NAMA_ALARM = "alarm";
    public static final String KEY_PAGI = "pagi";
    public static final String KEY_SIANG = "siang";
    public static final String KEY_MALAM = "malam";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_BERATIDEALMU = "CREATE TABLE " + TABLE_BERATIDEAL + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BERAT + " TEXT,"
                + KEY_TINGGI +  " TEXT," + KEY_KALKULASI + " TEXT," + KEY_JENISKELAMIN + " TEXT,"
                + KEY_KESIMPULAN + " TEXT,"+ KEY_TANGGAl + " TEXT," + KEY_WAKTU + " TEXT" + ")";
        String CREATE_TABLE_PROFIL = "CREATE TABLE " + TABLE_PROFIL + "("
                + KEY_ID_IDENTITAS + " INTEGER PRIMARY KEY," + KEY_NAMA_IDENTITAS + " TEXT,"
                + KEY_TEMPAT_IDENTITAS + " TEXT," + KEY_TANGGAL_IDENTITAS + " TEXT,"
                + KEY_QUOTE_IDENTITAS + " TEXT," + KEY_JENISKELAMIN_IDENTITAS + " TEXT,"
                + KEY_GOLONGANDARAH_IDENTITAS +  " TEXT" + ")";
        String CREATE_TABLE_ALARM = "CREATE TABLE" + TABLE_ALARM + "("
                + KEY_ID_ALARM + " INTEGER PRIMARY KEY," + KEY_NAMA_ALARM + "TEXT,"
                + KEY_PAGI + "TEXT," + KEY_SIANG+ "TEXT," + KEY_MALAM + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_BERATIDEALMU);
        db.execSQL(CREATE_TABLE_PROFIL);
        db.execSQL(CREATE_TABLE_ALARM);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BERATIDEAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALARM);

        // Create tables again
        onCreate(db);
    }

    public void hapusDBaseBeratIdeal() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_BERATIDEAL);
    }

    public void hapusDBaseProfil() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PROFIL);
    }

    public void hapusDBaseAlarm() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ALARM);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addberatIdeal(BeratIdeal beratIdeal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BERAT, beratIdeal.getBerat());
        values.put(KEY_TINGGI, beratIdeal.getTinggi());
        values.put(KEY_KALKULASI, beratIdeal.getKalkulasi());
        values.put(KEY_JENISKELAMIN, beratIdeal.getJeniskelamin());
        values.put(KEY_KESIMPULAN, beratIdeal.getKesimpulan());
        values.put(KEY_TANGGAl, beratIdeal.getTanggal());
        values.put(KEY_WAKTU, beratIdeal.getWaktu());

        // Inserting Row
        db.insert(TABLE_BERATIDEAL, null, values);
        db.close(); // Closing database connection
    }

    public void addprofil(Profil profil) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_IDENTITAS, profil.getNama());
        values.put(KEY_TEMPAT_IDENTITAS, profil.getTempat());
        values.put(KEY_TANGGAL_IDENTITAS, profil.getTanggal());
        values.put(KEY_QUOTE_IDENTITAS, profil.getQuote());
        values.put(KEY_JENISKELAMIN_IDENTITAS, profil.getJeniskelamin());
        values.put(KEY_GOLONGANDARAH_IDENTITAS, profil.getGolongandarah());

        // Inserting Row
        db.insert(TABLE_PROFIL, null, values);
        db.close(); // Closing database connection
    }

    public void addalarm(Alarm alarm) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_ALARM, alarm.getNamaAlarm());
        values.put(KEY_PAGI, alarm.getAlarmPagi());
        values.put(KEY_SIANG, alarm.getAlarmSiang());
        values.put(KEY_MALAM, alarm.getAlarmMalam());
    }

    // Getting single contact
    BeratIdeal getberatIdeal(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BERATIDEAL, new String[]{KEY_ID,
                        KEY_BERAT, KEY_TINGGI}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        BeratIdeal beratIdeal = new BeratIdeal(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
        // return contact
        return beratIdeal;
    }

    Profil getProfil(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROFIL, new String[]{KEY_ID_IDENTITAS,
                        KEY_NAMA_IDENTITAS, KEY_TEMPAT_IDENTITAS}, KEY_ID_IDENTITAS + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Profil profil = new Profil(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        // return contact
        return profil;
    }

    /*Alarm getAlarm(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ALARM, new String[]{KEY_ID_ALARM,
                        KEY_NAMA_ALARM}, KEY_ID_ALARM + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Alarm alarm = new Profil(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return alarm;
    }*/

    // Getting All Contacts
    public List<BeratIdeal> getAllBerats() {
        List<BeratIdeal> beratIdealList = new ArrayList<BeratIdeal>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BERATIDEAL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BeratIdeal beratIdeal = new BeratIdeal();
                beratIdeal.setID(Integer.parseInt(cursor.getString(0)));
                beratIdeal.setBerat(cursor.getString(1));
                beratIdeal.setTinggi(cursor.getString(2));
                beratIdeal.setKalkulasi(cursor.getString(3));
                beratIdeal.setJeniskelamin(cursor.getString(4));
                beratIdeal.setKesimpulan(cursor.getString(5));
                beratIdeal.setTanggal(cursor.getString(6));
                beratIdeal.setWaktu(cursor.getString(7));
                // Adding contact to list
                beratIdealList.add(beratIdeal);
            } while (cursor.moveToNext());
        }

        // return contact list
        return beratIdealList;
    }

    public List<Profil> getAllProfils() {
        List<Profil> profilList = new ArrayList<Profil>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PROFIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Profil profil = new Profil();
                profil.setID(cursor.getInt(0));
                profil.setNama(cursor.getString(1));
                profil.setTempat(cursor.getString(2));
                profil.setTanggal(cursor.getString(3));
                profil.setQuote(cursor.getString(4));
                profil.setJeniskelamin(cursor.getString(5));
                profil.setGolongandarah(cursor.getString(6));

                // Adding contact to list
                profilList.add(profil);
            } while (cursor.moveToNext());
        }

        // return contact list
        return profilList;
    }

    // Updating single contact
    public int updateberatIdeal(BeratIdeal beratIdeal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BERAT, beratIdeal.getBerat());
        values.put(KEY_TINGGI, beratIdeal.getTinggi());
        values.put(KEY_KALKULASI, beratIdeal.getKalkulasi());
        values.put(KEY_JENISKELAMIN, beratIdeal.getJeniskelamin());
        values.put(KEY_KESIMPULAN, beratIdeal.getKesimpulan());
        values.put(KEY_TANGGAl, beratIdeal.getTanggal());
        values.put(KEY_WAKTU, beratIdeal.getWaktu());

        // updating row
        return db.update(TABLE_BERATIDEAL, values, KEY_ID + " = ?",
                new String[]{String.valueOf(beratIdeal.getID())});
    }

    public int updateProfil(Profil profil) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA_IDENTITAS, profil.getNama());
        values.put(KEY_TEMPAT_IDENTITAS, profil.getTempat());
        values.put(KEY_TANGGAL_IDENTITAS, profil.getTanggal());
        values.put(KEY_QUOTE_IDENTITAS, profil.getQuote());
        values.put(KEY_JENISKELAMIN_IDENTITAS, profil.getJeniskelamin());
        values.put(KEY_GOLONGANDARAH_IDENTITAS, profil.getGolongandarah());

        // updating row
        return db.update(TABLE_PROFIL, values, KEY_ID_IDENTITAS + " = ?",
                new String[]{String.valueOf(profil.getID())});
    }

    // Deleting single contact
    public void deleteberatIdeal(BeratIdeal beratIdeal) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BERATIDEAL, KEY_ID + " = ?",
                new String[]{String.valueOf(beratIdeal.getID())});
        db.close();
    }
    public void deleteProfil(Profil profil) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROFIL, KEY_ID_IDENTITAS + " = ?",
                new String[]{String.valueOf(profil.getID())});
        db.close();
    }

    // Getting contacts Count
    public int getberatIdealsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BERATIDEAL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int getProfilCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PROFIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}