package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import EMPRESA.ANDROID.DAO.ProductoDAO;

public class ListarCompras extends AppCompatActivity {
    ListView lstvcompras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_compras);
        lstvcompras = (ListView) findViewById(R.id.lstvcompras);
        //Adaptador adaptador = new Adaptador(getApplicationContext(),MainActivity.compras);
        AdaptadorSQLite adaptadorSQL = new AdaptadorSQLite(getApplicationContext(),MainActivity.con.listarVentas());
        lstvcompras.setAdapter(adaptadorSQL);
        lstvcompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ProductoDAO> ventas = MainActivity.con.listarVentas();
                //String mensaje = "Pos:"+i+" id:"+ventas.get(i).getObjProductoBean().getIdventa();
                MainActivity.con.eliminarVenta(ventas.get(i).getObjProductoBean().getIdventa());
                String mensaje = "Venta Eliminada";
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                lstvcompras.setAdapter(adaptadorSQL);
            }
        });
    }

}