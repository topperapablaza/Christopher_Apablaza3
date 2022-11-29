package com.example.christopher_apablaza3.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class AutosDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="autos.db";
    private static final int DB_VERSION=1;

    public AutosDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqltxt="CREATE TABLE AUTOS(" +
                "UID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "MODELO TEXT, "+
                "MARCA TEXT, "+
                "MATRICULA TEXT, "+
                "TIPO TEXT, "+
                "FECHA TEXT, "+
                "ESTADO INTEGER);";
        sqLiteDatabase.execSQL(sqltxt);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void ingresarAuto(Auto auto) throws ParseException {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("MODELO", auto.getModelo());
        valores.put("MARCA", auto.getMarca());
        valores.put("MATRICULA", auto.getMatricula());
        valores.put("TIPO", auto.getTipo());
        valores.put("FECHA", String.valueOf(auto.getFecha()));

        if (auto.isEstado() == Auto.UNFAVORITO) {
            valores.put("ESTADO", 1);
        } else {
            valores.put("ESTADO", 0);
        }
        db.insert("AUTOS", null, valores);
    }




    public ArrayList<Auto> listaProductos() throws ParseException {
        SQLiteDatabase db=getReadableDatabase();
        ArrayList<Auto> autos=new ArrayList<>();
        Cursor cursor=db.query("AUTOS",
                new String[]{"UID","MODELO","MARCA","MATRICULA","TIPO","FECHA","ESTADO"},
                null, null, null, null,null
        );
        cursor.moveToFirst();
        int estadoInt;
        boolean estado=Auto.FAVORITO;
        do{
            estadoInt=cursor.getInt(6);
            if(estadoInt==1)
                estado=Auto.UNFAVORITO;
            else
                estado=Auto.FAVORITO;
            autos.add(new Auto(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    estado));
        }while (cursor.moveToNext());
        cursor.close();
        db.close();
        return autos;
    }

    public Auto getAuto(String uid){
        Auto auto;
        SQLiteDatabase db=getReadableDatabase();
        String sqlTxt= "SELECT * FROM AUTOS WHERE UID=?";//ese signo de pregunta indica el valor que yo le dare para que tome como referencia
        String[] argumentos=new String[] {uid};
        try{
            Cursor cursor=db.rawQuery(sqlTxt,argumentos);
            cursor.moveToFirst();
            boolean estado=Auto.FAVORITO;
            if(cursor.getInt(6)==1)
                estado=Auto.UNFAVORITO;
            auto=new Auto(cursor.getString(0), cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5), estado);
        }
        catch (SQLException | ParseException ex){
            auto=null;
        }
        return auto;
    }

}
