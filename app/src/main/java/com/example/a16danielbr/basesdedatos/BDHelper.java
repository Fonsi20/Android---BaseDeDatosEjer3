package com.example.a16danielbr.basesdedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a16danielbr on 08/02/2019.
 */

public class BDHelper extends SQLiteOpenHelper {

    String SQLCrear="create table tUsuarios(codigo INTEGER PRIMARY KEY, nombre VARCHAR(20))";
    String SQLEliminar="drop table if exists tUsuarios";

    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCrear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLEliminar);
    }
}
