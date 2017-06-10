package com.example.juancarlosaguilar.notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Menu.*;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.view.View;
import android.database.Cursor;
import android.widget.TextView;

/**
 * Created by Juan Carlos Aguilar on 8/6/2017.
 */

public class showNotasActivity extends Activity {


    Handler_Notas handler = new Handler_Notas(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotas);


Cursor c =handler.getnotas();
        String titulo, contenido;
        c.moveToLast();
        titulo=c.getString(c.getColumnIndex("title"));
        contenido=c.getString(c.getColumnIndex("content"));

        TextView title,content;
        title=(TextView)findViewById(R.id.verTitulo);
        content=(TextView)findViewById(R.id.verContenido);
        title.setText(titulo);
        content.setText(contenido);

    }
}
