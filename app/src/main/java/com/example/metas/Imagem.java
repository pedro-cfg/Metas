//package origem;
package com.example.metas;

public class Imagem extends Elemento
{
    private int tex;
    private int largura, altura;

    Imagem()
    {
        super();
    }
    
    public void setTextura(int s)
    {
        tex = s;
    }

    public int getTextura()
    {
        return tex;
    }

    public void setTamanho(int larg, int alt)
    {
        largura = larg;
        altura = alt;
    }

    public int getLargura()
    {
        return largura;
    }

    public int getAltura()
    {
        return altura;
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
