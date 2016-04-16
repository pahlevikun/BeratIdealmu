package com.ctproject.dbase;

/**
 * Created by farhan on 10/1/15.
 */
public class Alarm {

    //private variables
    int _id_alarm;
    String _alarm_nama;
    String _alarm_pagi;
    String _alarm_siang;
    String _alarm_malam;

    // Empty constructor
    public Alarm(){

    }
    // constructor
    public Alarm(int idAlarm, String namaAlarm, String alarmPagi, String alarmSiang, String alarmMalam){
        this._id_alarm = idAlarm;
        this._alarm_nama = namaAlarm;
        this._alarm_pagi = alarmPagi;
        this._alarm_siang = alarmSiang;
        this._alarm_malam = alarmMalam;
    }

    // constructor
    public Alarm(String namaAlarm, String alarmPagi, String alarmSiang, String alarmMalam){
        this._alarm_nama = namaAlarm;
        this._alarm_pagi = alarmPagi;
        this._alarm_siang = alarmSiang;
        this._alarm_malam = alarmMalam;
    }

    // getting ID
    public int getIDAlarm(){
        return this._id_alarm;
    }

    // setting id
    public void setIDAlarm(int idAlarm){
        this._id_alarm = idAlarm;
    }

    // getting name
    public String getNamaAlarm(){
        return this._alarm_nama;
    }

    // setting name
    public void setNamaAlarm(String alarmNama){
        this._alarm_nama = alarmNama;
    }

    // getting phone number
    public String getAlarmPagi(){
        return this._alarm_pagi;
    }

    // setting phone number
    public void setAlarmPagi(String alarmPagi){
        this._alarm_pagi = alarmPagi;
    }

    // setting phone number
    public void setAlarmSiang(String alarmSiang){
        this._alarm_siang = alarmSiang;
    }

    // getting phone number
    public String getAlarmSiang(){
        return this._alarm_siang;
    }

    // getting phone number
    public String getAlarmMalam(){
        return this._alarm_malam;
    }

    // setting phone number
    public void setAlarmMalam(String alarmMalam){
        this._alarm_malam = alarmMalam;
    }
}
