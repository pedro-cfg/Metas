//package origem;
package com.example.metas;

public class Quadrado extends Bloco
{
    private int grossura;

    Quadrado()
    {
        super();
        grossura = 5;
    }

    public void setGrossura(int i)
    {
        grossura = i;
    }

    public int getGrossura()
    {
        return grossura;
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
