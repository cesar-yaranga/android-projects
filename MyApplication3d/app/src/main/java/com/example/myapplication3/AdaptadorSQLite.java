package com.example.myapplication3;

import android.content.Context;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import EMPRESA.ANDROID.DAO.ProductoDAO;

public class AdaptadorSQLite extends BaseAdapter {
    Context context;
    ArrayList<ProductoDAO> ventas;
    LayoutInflater inflater;
    public AdaptadorSQLite(Context ctx,ArrayList<ProductoDAO> ventas){
        this.context = ctx;
        this.ventas = ventas;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return ventas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.compaslistview,null);
        TextView lblmensaje = (TextView) view.findViewById(R.id.lblmensaje);
        ventas.get(i).CalcularOperacion(ventas.get(i).getObjProductoBean());
        int marca = ventas.get(i).getObjProductoBean().getMarca();
        ImageView imgview = (ImageView) view.findViewById(R.id.imgicono);
        imgview.setImageResource(marca==0?R.drawable.nike:marca==1?R.drawable.adidas:R.drawable.fila);
        lblmensaje.setText(ventas.get(i).getMensaje());
        return view;
    }
}
