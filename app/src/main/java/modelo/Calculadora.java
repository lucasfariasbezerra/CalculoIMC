package modelo;

import com.example.lucas_pc.calculoimc.R;

import java.text.DecimalFormat;

/**
 * Created by lucas-pc on 09/04/16.
 */

// essa classe ira realizar o calculo e mostrar o resultado na tela
public class Calculadora
{
    private double imc; // variavel que guardara o valor do imc
    private Usuario pessoa; // obejeto do tipo Usuario que guardara os dados da pessoa


    public Calculadora()
    {

    }

    public Calculadora(Usuario pessoa)
    {

        this.pessoa = pessoa;
    }


    public double getImc()
    {
        return imc;
    }

    public void setImc(double imc)
    {
        this.imc = imc;
    }

    public Usuario getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Usuario pessoa)
    {
        this.pessoa = pessoa;
    }


    // metodo que realizara o calculo de imc
    public void calcularImc()
    {


        this.imc =   this.pessoa.getPeso()  / (this.pessoa.getAltura()*this.pessoa.getAltura());
    }

    // metodo que retornara uma string referente ao resultado
    public String diagnostico()
    {
        DecimalFormat valorFormatado = new DecimalFormat("#.##");


        String resultado =  " IMC = " + valorFormatado.format(this.imc) + " Kg/m2. ";

        if(this.imc < 18.5)
        {
            resultado += this.getPessoa().getNome() + " ,Voce esta abaixo do peso";
        }
        else if(this.imc >= 18.5 && this.imc < 25)
        {
            resultado += this.getPessoa().getNome() + " ,Voce esta no peso normal";
        }
        else if(this.imc >= 25 && this.imc < 30)
        {
            resultado += this.getPessoa().getNome() + " ,Voce esta acima do peso";
        }
        else
        {
            resultado += this.getPessoa().getNome() + " ,Voce esta obeso!!Procure um medico";
        }

        return resultado;

    }

    // metodo inteiro que irá retornar a imagem referente ao resultado
    public int imagem()
    {
        int imagem;

        if(this.imc < 18.5)
        {
           imagem = R.drawable.skinny;
        }
        else if(this.imc >= 18.5 && this.imc < 25)
        {
            imagem = R.drawable.normal_weight;
        }
        else if(this.imc >= 25 && this.imc < 30)
        {
            imagem = R.drawable.fat;
        }
        else
        {
            imagem = R.drawable.obese;
        }

        return imagem;

    }
}
