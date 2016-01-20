package com.ocampojohny.proyecto_final;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */

    public TextView textView;
    public BaseHelper baseHelper;
    public int acumulado=0;
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem,mItem2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle(mItem.content);
            }
        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.item_detail, container, false);


        if (mItem != null) {

            textView=((TextView) rootView.findViewById(R.id.textView_superior1));
            ((TextView) rootView.findViewById(R.id.textView_superior1)).setText(mItem.textoEncima1);
            ((TextView) rootView.findViewById(R.id.textView_inferior1)).setText(mItem.textoDebajo1);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen1)).setImageResource(mItem.idImagen1);


            ((TextView) rootView.findViewById(R.id.textView_superior2)).setText(mItem.textoEncima2);
            ((TextView) rootView.findViewById(R.id.textView_inferior2)).setText(mItem.textoDebajo2);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen2)).setImageResource(mItem.idImagen2);

            ((TextView) rootView.findViewById(R.id.textView_superior3)).setText(mItem.textoEncima3);
            ((TextView) rootView.findViewById(R.id.textView_inferior3)).setText(mItem.textoDebajo3);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen3)).setImageResource(mItem.idImagen3);
        }
        return rootView;
    }


    public void boton1(View view){


        mItem2 = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        switch (mItem2.nombre) {
            case R.string.itemAseo: {
                acumulado = acumulado + 4500;
            }
            break;
            case R.string.itempersonal: {
                acumulado = acumulado + 1850;
            }
            break;
            case R.string.itemgranos: {
                acumulado = acumulado + 1900;
            }
            break;
            case R.string.itembebidas: {
                acumulado = acumulado + 5000;
            }
            break;
        }

        textView.setText(acumulado);


    }
}
