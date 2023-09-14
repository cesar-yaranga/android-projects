package com.example.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import EMPRESA.ANDROID.DAO.ProductoDAO;

public class Adaptador extends BaseAdapter {
    Context context;
    ArrayList<ProductoDAO> compras = new ArrayList<ProductoDAO>();
    LayoutInflater inflater;
    public Adaptador(Context ctx,ArrayList<ProductoDAO> compras){
        this.context = ctx;
        this.compras = compras;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return compras.size();
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
        lblmensaje.setText(compras.get(i).getMensaje());
        /*
        0: NIKE
        1: ADIDAS
        2: FILA
         */
        ImageView imgview = (ImageView) view.findViewById(R.id.imgicono);
        int marca =compras.get(i).getMarca();
        imgview.setImageResource(marca==0?R.drawable.nike:marca==1?R.drawable.adidas:R.drawable.fila);
        /*if (compras.get(i).getMarca()==0)
            imgview.setImageResource(R.drawable.nike);
        if (compras.get(i).getMarca()==1)
            imgview.setImageResource(R.drawable.adidas);
        if (compras.get(i).getMarca()==2)
            imgview.setImageResource(R.drawable.fila);*/
        return view;
    }
}
