package com.example.lucas_pc.calculoimc;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // criacao do objeto minha fonte que gera a personalizacao da fonte
        Typeface minhaFonte = Typeface.createFromAsset(getAssets(),"fonte2.ttf");

        // criacao do objeto texto, onde a fonte customizada sera alocada
        TextView texto = (TextView) findViewById(R.id.tVDescricaoLogo);
        texto.setTypeface(minhaFonte);

        // criacao do objeto urlDescricao, reponsavel por direcionar uma url que contem a descricao de imc
        TextView urlDescricao = (TextView) findViewById(R.id.tVURL);
        urlDescricao.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        // metodo que realiza o direcionamento de url
        urlDescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri endereco = Uri.parse("https://pt.wikipedia.org/wiki/%C3%8Dndice_de_massa_corporal");
                Intent intent = new Intent(Intent.ACTION_VIEW, endereco);

                startActivity(intent);
            }
        });

        Button trocaActivity = (Button) findViewById(R.id.buttonCalculo);


        trocaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 Intent intent =  new Intent(TelaPrincipal.this,TelaCalculo.class);
                 startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
