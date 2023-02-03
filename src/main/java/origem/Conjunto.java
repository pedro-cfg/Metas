package origem;

public abstract class Conjunto 
{
    protected int x,y,largura,altura;
    protected GGrafico gerenciador;
    protected GInteracao interacao;
    protected Cores cores;

    Conjunto()
    {
        gerenciador = Principal.getGGrafico();
        interacao = Principal.getGInteracao();
        cores = Principal.getCores();
    }

    public void setParametros(int i, int j, int l, int a)
    {
        x=i;
        y=j;
        largura=l;
        altura=a;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getLargura()
    {
        return largura;
    }

    public int getAltura()
    {
        return altura;
    }

    public abstract void toque();
}
