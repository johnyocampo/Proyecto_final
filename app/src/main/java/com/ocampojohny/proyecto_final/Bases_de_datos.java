package com.ocampojohny.proyecto_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by johny on 19/01/2016.
 */
public class Bases_de_datos extends AppCompatActivity{


  public  BaseHelper baseHelper;

    public Bases_de_datos(){
        baseHelper= new BaseHelper(this, "Demodb", null, 1);

    }

    SQLiteDatabase db = baseHelper.getWritableDatabase();

    public String[] cargar() {

        String[] arreglo= new String[getCantidad()];
        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
        SQLiteDatabase db= baseHelper.getWritableDatabase();
        if(db!=null){

            Cursor c= db.rawQuery("select * from personas", null);

            int i=0;
            if (c.moveToFirst()){
                do {

                    String linea=c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getInt(3);
                    arreglo[i]=linea;
                    i++;

                }while(c.moveToNext());

            }

        }

        return arreglo;
    }



    public int getCantidad() {


        int cantidad = 0;


        if (db != null) {

            Cursor c = db.rawQuery("select * from personas", null);
            cantidad = c.getCount();
            String[] arreglo = new String[cantidad];
            int i = 0;
            if (c.moveToFirst()) {
                do {

                    String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getInt(3);
                    arreglo[i] = linea;
                    i++;

                } while (c.moveToNext());

            }


        }

        return cantidad;
    }}

