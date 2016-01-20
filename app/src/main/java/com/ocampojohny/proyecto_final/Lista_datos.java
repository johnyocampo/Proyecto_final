package com.ocampojohny.proyecto_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista_datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        cargar();
    }


    public void cargar(){

        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
        SQLiteDatabase db= baseHelper.getWritableDatabase();
        if(db!=null){

            Cursor c= db.rawQuery("select * from personas", null);
            int cantidad=c.getCount();
            String[] arreglo= new String[cantidad];
            int i=0;
            if (c.moveToFirst()){
                do {

                    String linea=c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4);
                    arreglo[i]=linea;
                    i++;

                }while(c.moveToNext());

            }

            ArrayAdapter<String>adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista=(ListView)findViewById(R.id.lista);
            lista.setAdapter(adapter);
        }

    }


}








