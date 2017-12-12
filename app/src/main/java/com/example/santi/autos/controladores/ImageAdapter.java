package com.example.santi.autos.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.santi.autos.R;
import com.example.santi.autos.entidades.Products;

import java.util.List;

/**
 * Created by Santi on 11/12/2017.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private static LayoutInflater inflater = null;
    List<Products> datos;
    int[] datosImg;

    public ImageAdapter(Context c, List<Products> datos, int[] imagenes) {
        mContext = c;
        this.datos = datos;
        datosImg = imagenes;

        inflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return datosImg.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.activity_add_car, null);
        TextView nombre = (TextView) vista.findViewById(R.id.tvProducto);
        TextView rating = (TextView) vista.findViewById(R.id.tRating);

        ImageView imageView = (ImageView) vista.findViewById(R.id.ivImagen);
        RatingBar ratingBar = (RatingBar) vista.findViewById(R.id.rbBarra);

        nombre.setText(datos.get(position).getNombre());
        rating.setText(new Integer(datos.get(position).getCriticoRate()).toString());
        imageView.setImageResource(datosImg[position]);
        ratingBar.setRating(Float.valueOf((new  Double(datos.get(position).getCustomerRate()).toString())));
        imageView.setTag(position);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // IMPLEMEMTAR
            }
        });

        return vista;
    }
}
