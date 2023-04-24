//package origem;
package com.example.greetingcard;

public abstract class Elemento
{
    protected int x,y;
    protected float alpha;
    protected GGrafico gerenciador;

    Elemento()
    {
        x=0;
        y=0;
        alpha = 1.f;
        gerenciador = Principal.getGGrafico();
    }

    public void setPosicao(int xn, int yn)
    {
        x = xn;
        y = yn;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setAlpha(float f)
    {
        alpha = f;
    }

    public float getAlpha()
    {
        return alpha;
    }

    public abstract void Desenha();
}