package origem;

public abstract class Elemento 
{
    protected int x,y;
    protected GGrafico gerenciador;

    Elemento(GGrafico g)
    {
        x=0;
        y=0;
        gerenciador = g;
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

    public void Desenha()
    {

    }
}