package com.ocampojohny.proyecto_final;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by johny on 18/01/2016.
 */
public class BD_login extends AppCompatActivity {


    EditText ETnombre,ETusuario,ETpassword,ETemail;
    Button BTenviar_datos;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);

        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
        db= baseHelper.getWritableDatabase();

        ETnombre = (EditText) findViewById(R.id.etreg_nombre);
        ETusuario = (EditText) findViewById(R.id.etrg_usuario);
        ETpassword = (EditText) findViewById(R.id.etreg_paswword);
        //bcargar = (Button) findViewById(R.id.btcargar);
        ETemail = (EditText) findViewById(R.id.etreg_email);
        BTenviar_datos = (Button) findViewById(R.id.btenviar_datos);}

        //bcargar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Lista_datos.class);
//                startActivity(intent);
//
//            }
//        });}






    public void eliminar(View view) {



        //Recuperamos los valores de los campos de texto
        String cod = ETnombre.getText().toString();

        //Alternativa 1: método sqlExec()
//        String sql = "DELETE FROM personas WHERE Nombre=" + cod;
//        db.execSQL(sql);

        //Alternativa 2: método delete()
        db.delete("personas", "Nombre= ?", new String[]{cod});

    }


//    public void modificar(View view){
//
//
//        String nombre=ETnombre.getText().toString();
//        String Apellido=ETapellido.getText().toString();
//        //int edad= Integer.parseInt(ETedad.getText().toString());
//
//        ETnombre.setHint("Ingrese nuevo nombre");
//        ETapellido.setHint("ingrese nuevo apellido");
//        ETedad.setHint("ingrese nueva edad");
//
//        ContentValues valores_a_modificar = new ContentValues();
//        valores_a_modificar.put("Nombre", nombre);
//        valores_a_modificar.put("Apellido", Apellido);
//        //valores_a_modificar.put("Edad", edad);
//        db.update("personas", valores_a_modificar, "Nombre= ?", new String[]{nombre});
//
//    }
//    public void buscar(View view){
//
//        String dato__buscar;
//        dato__buscar=ETnombre.getText().toString()+" "+ETapellido.getText().toString();
//        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
//        SQLiteDatabase db= baseHelper.getWritableDatabase();
//        if(db!=null) {
//
//            Cursor c = db.rawQuery("select * from personas", null);
//            int cantidad = c.getCount();
//            String[] arreglo = new String[cantidad];
//            int i = 0;
//            if (c.moveToFirst()) {
//                do {
//
//                    String linea = c.getString(1)+" "+c.getString(2);
//
//                    if(linea.equals(dato__buscar)){
//                        ETapellido.setText("Exito");
//
//                    }
//
//                } while (c.moveToNext());
//
//            }
//
//
//        }
//    }


    public void Guardar_datos(View view){

        String nombre=ETnombre.getText().toString();
        String password=ETpassword.getText().toString();
        String usuario=ETusuario.getText().toString();
        String email=ETemail.getText().toString();

        BaseHelper baseHelper= new BaseHelper(this,"Demodb",null,1);
        SQLiteDatabase db= baseHelper.getWritableDatabase();
        if(db!=null){

            ContentValues registro_nuevo=new ContentValues();
            registro_nuevo.put("Nombre", nombre);
            registro_nuevo.put("Usuario", usuario);
            registro_nuevo.put("Password", password);
            registro_nuevo.put("Email", email);
            long i=db.insert("personas",null,registro_nuevo);
            if (i>0){
                Toast.makeText(this,"Tus datos han sido enviados", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
