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
import android.view.MenuInflater;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    Handler_Notas handler = new Handler_Notas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View boton = findViewById(R.id.AgregarNota);
        boton.setOnClickListener(this);
    }


    public void onClick(View btn) {
        if (btn.getId() == findViewById(R.id.AgregarNota).getId()) {
            EditText t,c;
            t=(EditText)findViewById(R.id.addTitulo);
            c=(EditText)findViewById(R.id.addcontent);
            handler.addnotas(t.getText().toString(),c.getText().toString());
            Intent i= new Intent(this, showNotasActivity.class);
            startActivity(i);
        }
    }
}



