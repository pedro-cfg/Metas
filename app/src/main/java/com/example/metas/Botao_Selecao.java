//package origem;
package com.example.metas;

public class Botao_Selecao extends Conjunto
{
    private Imagem botao;
    private boolean verde;

    Botao_Selecao(boolean b)
    {
        super();
        botao = new Imagem();
        verde = b;
        //botao.setAlpha(0.9f);
    }

    public void setTamanho()
    {
        botao.setTamanho(largura, altura);
        botao.setPosicao(x, y);
    }

    public void setImagem(int s)
    {
        botao.setTextura(s);
    }

    public Imagem getImagem()
    {
        return botao;
    }

    public boolean getVerde()
    {
        return verde;
    }

    @Override
    public void toque()
    {
        try {
            interacao.interage(this);
        } catch (Exception e) {
           
        }
    }
}
