package com.example.juancarlosaguilar.notas;

/**
 * Created by Juan Carlos Aguilar on 8/6/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class Handler_Notas extends SQLiteOpenHelper {
    public Handler_Notas(Context ctx) {
        super(ctx, "Notas", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "CREATE TABLES notas(ID INTEGER PRIMATY KEY AUTOINCREMENT, title TEXT, content TEXT)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST notas");
        onCreate(db);
    }

    public void addnotas(String title, String cont)
    {
        ContentValues vals = new ContentValues();
        vals.put("title", title);
        vals.put("content", cont);
        this.getWritableDatabase().insert("notas",null,vals);
    }

    public Cursor getnotas()
    {

        String[] cols={"ID","title","content"};
        Cursor c =this.getReadableDatabase().query("notas",cols , null, null, null, null, null);
       return c;
    }

    public void removerNota(int ID)
    {
        this.getWritableDatabase().delete("notas","ID = "+ID,null);
    }
    public void  cerrar()
    {
        this.close();
    }


}