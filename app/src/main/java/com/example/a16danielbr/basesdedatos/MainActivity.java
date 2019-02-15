package com.example.a16danielbr.basesdedatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String BDname;
    private int BDversion;
    private SQLiteDatabase BDusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDname = "BDusuarios";
        BDversion = 1;

        BDHelper bdhelper = new BDHelper(this,BDname,null,BDversion);

        BDusuarios = bdhelper.getWritableDatabase();

        //BDusuarios.execSQL("Insert into tUsuarios (codigo,nombre) values (3,'Keenehan-Serqueira')");
        //BDusuarios.execSQL("Insert into tUsuarios (codigo,nombre) values (4,'AL Faisan Estofado')");

        //BDusuarios.execSQL("Delete from tUsuarios where codigo = 2;");
        //BDusuarios.execSQL("Update tUsuarios set nombre= 'Serqueira a secas' where codigo=3;");

        //ContentValues nuevoRegistro = new ContentValues();
        //nuevoRegistro.put("codigo", "10");
        //nuevoRegistro.put("nombre", "usuario 10");
        //BDusuarios.insert("tUsuarios", null, nuevoRegistro);

        Cursor c = BDusuarios.rawQuery("SELECT * FROM tUsuarios WHERE codigo=10", null);
        if (c.moveToFirst()) {
            int a = c.getInt(0);
            String n = c.getString(1);
            Toast.makeText(this, "Nombre: " + a + " " + n, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Usuario inexistente", Toast.LENGTH_LONG).show();
        }
        c.close();

        BDusuarios.close();


    }
}
