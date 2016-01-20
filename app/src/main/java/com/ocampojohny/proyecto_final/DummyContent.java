package com.ocampojohny.proyecto_final;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent extends AppCompatActivity{


  public static Bases_de_datos bases_de_datos;

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();



    static {


        addItem(new DummyItem("1",R.string.itemAseo, R.drawable.fab,R.drawable.limpido,
                R.drawable.axion,
                R.string.Tfab,R.string.Tlimpdio,R.string.Taxion,R.string.Pfab,R.string.Plimpido,R.string.Paxion));

        addItem(new DummyItem("2",R.string.itempersonal, R.drawable.protex,R.drawable.colgate,
                R.drawable.shamppo,
                R.string.Tjabon_baño,R.string.Tcrema_dental,R.string.Tshampoo,
                R.string.Pjabon_baño,R.string.Pcrema,R.string.Pshampoo));

        addItem(new DummyItem("3",R.string.itemgranos, R.drawable.arroz,R.drawable.frijol_aburra,
                R.drawable.cominos,
                R.string.Tarroz,R.string.Tfrijol,R.string.Tespecias,
                R.string.Parroz,R.string.Pfrijol,R.string.Pspecias));

        addItem(new DummyItem("4",R.string.itembebidas, R.drawable.cocacola,R.drawable.mr_tee,
                R.drawable.del_valle,
                R.string.Tcoca_cola,R.string.TMrte,R.string.Tdel_valle,
                R.string.Pcocacola,R.string.Pmrtee,R.string.Pdelvalle));

//        addItem(new DummyItem("5",R.string.itemcarrito, R.drawable.basilica,R.drawable.casabarrientos,
//                R.drawable.pantalla_de_agua,
//                R.string.Tbasilica,R.string.Tcasa_barrientos,R.string.Tpantalla_de_agua,
//                R.string.Dbasilica,R.string.Dcasa_barrientos,R.string.Dpantalla_de_agua));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public int nombre;
        public int idImagen1, idImagen2,idImagen3;
        public int textoEncima1;
        public int textoEncima2;
        public int textoEncima3;
        public int textoDebajo1,textoDebajo2,textoDebajo3;
        float lat, longitud;



        public DummyItem(String id, int nombre, int idImagen1,int idImagen2,int idImagen3, int textoEncima1,
        int textoEncima2, int textoEncima3, int textoDebajo1, int textoDebajo2,
        int textoDebajo3) {
                this.id = id;
                this.nombre = nombre;
                this.idImagen1 = idImagen1;
                this.idImagen2 = idImagen2;
                this.idImagen3 = idImagen3;
                this.textoEncima1 = textoEncima1;
                this.textoEncima2 = textoEncima2;
                this.textoEncima3 = textoEncima3;
                this.textoDebajo1 = textoDebajo1;
                this.textoDebajo2 = textoDebajo2;
                this.textoDebajo3 = textoDebajo3;
        }



    }
}
