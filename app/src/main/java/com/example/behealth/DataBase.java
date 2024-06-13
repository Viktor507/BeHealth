package com.example.behealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {


    String sqlCrear = "create table Consumo(fecha text primary key, cantidad text)";
    String sqlEliminar = "delete from Consumo";



    public DataBase(Context con, String DbRegistro, SQLiteDatabase.CursorFactory factory, int
            version) {
        super(con, DbRegistro, factory, version);
    }

    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(sqlCrear);
    }


    public Cursor viewData() {
        SQLiteDatabase bd = this.getReadableDatabase();
        String query = "Select * from Consumo";
        Cursor cursor = bd.rawQuery(query, null);

        return cursor;

    }

    public void eliminar() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sqlEliminar);

    }


    public Boolean insertar(String d, String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put("fecha", d);
        cV.put("cantidad", s);
        db.insert("Consumo", null, cV);
        return true;

    }


    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS Consumo");
    }

}
