package com.ocampojohny.proyecto_final;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by johny on 18/01/2016.
 */
public class Bienvenida extends AppCompatActivity {

    EditText ETnombre,ETpassword;
    Button BTingresar,BTRegistrarse,BTmostrar_lista;
    TextView textView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        BTRegistrarse=(Button)findViewById(R.id.btregistrarse);
//        BTmostrar_lista=(Button)findViewById(R.id.btcargar);
        BTingresar=(Button)findViewById(R.id.btingresar);
        ETnombre=(EditText)findViewById(R.id.etnombre);
        ETpassword=(EditText)findViewById(R.id.etpassword);
        textView=(TextView)findViewById(R.id.tvmensage_login);



        BTRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bienvenida.this,BD_login.class);
                startActivity(intent);
            }
        });

//        BTmostrar_lista.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Bienvenida.this,Lista_datos.class);
//                startActivity(intent);
//            }
//        });



        }


    public void buscar_persona(View view){

        String dato__buscar;

        dato__buscar=ETnombre.getText().toString()+" "+ETpassword.getText().toString();


        
        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
        SQLiteDatabase db= baseHelper.getWritableDatabase();
        boolean persona_registrada=false;

        if(db!=null) {

            Cursor c = db.rawQuery("select * from personas", null);
            int cantidad = c.getCount();
            String[] arreglo = new String[cantidad];
            int i = 0;

            if (c.moveToFirst()) {
                do {

                    String linea=c.getString(2)+" "+c.getString(3);
                    arreglo[i]=linea;
                    i++;
                    if(linea.equals(dato__buscar)){
                        //ETpassword.setText("Exito");
                        persona_registrada=true;

                    }

                } while (c.moveToNext());


                }

            }
        if(dato__buscar.equals(" ")){}

        else{
        if(persona_registrada){
            Intent intent=new Intent(Bienvenida.this,ItemListActivity.class);
            startActivity(intent);

        }}
    }}


