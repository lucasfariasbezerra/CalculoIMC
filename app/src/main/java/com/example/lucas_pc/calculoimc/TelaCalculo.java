package com.example.lucas_pc.calculoimc;

import android.app.AlertDialog;
import android.content.Context;
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

import java.io.IOException;
import java.util.InputMismatchException;

import modelo.Calculadora;
import modelo.Usuario;

public class TelaCalculo extends AppCompatActivity {


    EditText ePeso,eAltura,eNome; // criação dos objetos que manipularão os dados da editText
    TextView tResultado; // criação dos objeto que exibira o resultado da TextView
    ImageView ivResultado; // criação do obejeto que manipulara as imagens da pasta drawable
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculo);

         /* as 4 linhas abaixo referenciam as variaveis
            criadas aos componentes do arquivo tela_principal.xml

         */
         ePeso = (EditText)  findViewById(R.id.editTextPeso);
         eAltura = (EditText) findViewById(R.id.editTextAltura);
         eNome = (EditText) findViewById(R.id.editTextNome);



        Button bCalculo = (Button) findViewById(R.id.BtnResultado);




        // metodo que inplementa o evento click listener do botao calculo
        bCalculo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                  try
                  {
                      Usuario pessoa = new Usuario(); // instanciação do objeto pessoa
                      Calculadora c = new Calculadora(); // instanciação do objeto calculadora


                      // as 3 linhas abaixo atribuem os valores da edit text de acordo com o tipo das variaves
                      double peso = Double.parseDouble(ePeso.getText().toString());
                      double altura = Double.parseDouble(eAltura.getText().toString());
                      String nome = eNome.getText().toString();


                      /* estruturas condicionais que realizam a checagem da concictencia das
                         informações preenchidas pelos usuários
                      */
                      if(peso<0 || peso>600)
                      {
                          mensagem("ALERTA","faixa de peso invalida");
                      }
                      else if(altura < 0.5 || altura > 3)
                      {
                          mensagem("ALERTA", "faixa de altura invalida");
                      }
                      else if(nome.equals(""))
                      {
                          mensagem("ALERTA","Identifique-se");
                      }
                      else
                      {

                          /*
                              as tres linhas de comando realizam a
                              inserção dos valores no objeto pesoa
                           */
                          pessoa.setAltura(altura);
                          pessoa.setNome(nome);
                          pessoa.setPeso(peso);


                          // linha que insere o objeto pessoa no objeto calculadora
                          c.setPessoa(pessoa);

                          // linha que realiza o calculo de imc
                          c.calcularImc();




                          /*  as 2 linhas abaixo referenciam as variaveis
                              criadas aos componentes do arquivo tela_principal.xml
                           */
                          ivResultado = (ImageView) findViewById(R.id.iVREsultado);
                          tResultado = (TextView) findViewById(R.id.tVResultado);

                          // criação do objeto Typeface que instanciará uma fonte customizada da pasta assets
                          Typeface minhaFonte = Typeface.createFromAsset(getAssets(),"fonte2.ttf");

                          // inserção da fonte customizada na textView
                          tResultado.setTypeface(minhaFonte);

                          // atribuição do resultado do calculo por meio do metodo c.diagnostico()
                          tResultado.setText(c.diagnostico());

                          // atribuição da imagem reerente ao resultado pro meio do metodo  c.imagem()
                          ivResultado.setImageResource(c.imagem());

                      }


                  }
                  catch(Exception e)
                  {
                    mensagem("ALERTA","Dados nao preenchidos");
                  }








            }
        });







    }


    public  void mensagem(String titulo, String mensagem)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setNeutralButton("OK", null);
        alert.show();

    }


}
