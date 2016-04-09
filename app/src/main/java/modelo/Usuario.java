package modelo;

/**
 * Created by lucas-pc on 09/04/16.
 */

// essa classe instancia todos os dados referentes ao usuario
public class Usuario
{
    private String nome;
    private double peso;
    private double altura;

    public Usuario ()
    {

    }

    public Usuario(String nome,double peso,double altura)
    {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
