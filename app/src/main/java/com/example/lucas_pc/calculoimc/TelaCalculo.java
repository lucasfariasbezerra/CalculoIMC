package com.example.lucas_pc.calculoimc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import modelo.Calculadora;
import modelo.Usuario;

public class TelaCalculo extends AppCompatActivity {


    EditText ePeso,eAltura,eNome;
    TextView tResultado;
    ImageView ivResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculo);

         ePeso = (EditText)  findViewById(R.id.editTextPeso);
         eAltura = (EditText) findViewById(R.id.editTextAltura);
         eNome = (EditText) findViewById(R.id.editTextNome);



        Button bCalculo = (Button) findViewById(R.id.BtnResultado);





        bCalculo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Usuario pessoa = new Usuario();
                Calculadora c = new Calculadora();


                double peso = Double.parseDouble(ePeso.getText().toString());
                double altura = Double.parseDouble(eAltura.getText().toString());
                String nome = eNome.getText().toString();

                pessoa.setAltura(altura);
                pessoa.setNome(nome);
                pessoa.setPeso(peso);

                c.setPessoa(pessoa);

                c.calcularImc();




               ivResultado = (ImageView) findViewById(R.id.iVREsultado);
               tResultado = (TextView) findViewById(R.id.tVResultado);

                Typeface minhaFonte = Typeface.createFromAsset(getAssets(),"fonte2.ttf");

                tResultado.setTypeface(minhaFonte);

                tResultado.setText(c.diagnostico());
                ivResultado.setImageResource(c.imagem());


            }
        });







    }

}
