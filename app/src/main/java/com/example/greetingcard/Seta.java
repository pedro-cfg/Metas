//package origem;
package com.example.greetingcard;

public class Seta extends Conjunto
{
    private Imagem seta;
    private boolean esquerda;

    Seta(boolean b)
    {
        super();
        seta = new Imagem();
        esquerda = b;
    }

    public void setTamanho()
    {
        seta.setTamanho(largura, altura);
        seta.setPosicao(x, y);
    }

    public void setImagem(int s)
    {
        seta.setTextura(s);
    }

    public Imagem getImagem()
    {
        return seta;
    }

    public boolean getEsquerda()
    {
        return esquerda;
    }

    @Override
    public void toque()
    {
        interacao.interage(this);
    }
}
