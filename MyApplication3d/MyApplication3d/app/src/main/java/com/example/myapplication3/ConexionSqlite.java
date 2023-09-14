package com.example.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import EMPRESA.ANDROID.BEAN.ProductoBean;
import EMPRESA.ANDROID.DAO.ProductoDAO;

public class ConexionSqlite extends SQLiteOpenHelper {
    public ConexionSqlite(Context context){
        super(context,"VENTASBD.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE venta(idventa INTEGER PRIMARY KEY AUTOINCREMENT,marca INTEGER NOT NULL, talla INTEGER NOT NULL,numpares INTEGER NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS venta";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public void insertarVenta(ProductoDAO PDao){
        int marca = PDao.getObjProductoBean().getMarca();
        int talla = PDao.getObjProductoBean().getTalla();
        int numpares = PDao.getObjProductoBean().getNumpares();
        ContentValues valores = new ContentValues();
        valores.put("marca",marca);
        valores.put("talla",talla);
        valores.put("numpares",numpares);
        this.getWritableDatabase().insert("venta",null,valores);
    }
    public void vaciarTabla(){
        this.getWritableDatabase().execSQL("DELETE FROM venta");
    }
    public void eliminarVenta(int idventa){
        this.getWritableDatabase().execSQL("DELETE FROM venta where idventa ='"+idventa+"'");
    }
    public void modificarVenta(ProductoDAO PDao, int idventa){
        int marca = PDao.getObjProductoBean().getMarca();
        int talla = PDao.getObjProductoBean().getTalla();
        int numpares = PDao.getObjProductoBean().getNumpares();
        String sql = "UPDATE venta SET marca='"+marca+"',talla='"+talla+"',numpares='"+numpares+"' WHERE idventa='"+idventa+"'";
        this.getWritableDatabase().execSQL(sql);
    }
    public ArrayList<ProductoDAO> listarVentas(){
        ArrayList<ProductoDAO> ventas = new ArrayList<ProductoDAO>();
        SQLiteDatabase db = this.getReadableDatabase();
        String columnas[] = {"idventa","marca","talla","numpares"};
        Cursor c = db.query("venta",columnas,null,null,null,null,null);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            ProductoBean pb = new ProductoBean();
            pb.setIdventa(c.getInt(0));
            pb.setMarca(c.getInt(1));
            pb.setTalla(c.getInt(2));
            pb.setNumpares(c.getInt(3));
            ProductoDAO PDao = new ProductoDAO();
            //PDao.CalcularOperacion(pb);
            PDao.setObjProductoBean(pb);
            ventas.add(PDao);
        }
        return ventas;
    }
    public int tamanoVenta(){
        SQLiteDatabase db = this.getReadableDatabase();
        String columnas[] = {"idventa","marca","talla","numpares"};
        Cursor c = db.query("venta",columnas,null,null,null,null,null);
        return c.getCount();
    }
    public void abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();
    }
}
