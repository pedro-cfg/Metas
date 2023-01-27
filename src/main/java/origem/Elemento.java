package origem;

public abstract class Elemento 
{
    protected int x,y,largura,altura;
    protected Cor cor;
    protected String tipo;
    protected GGrafico gerenciador;

    Elemento(GGrafico g)
    {
        x=0;
        y=0;
        largura=0;
        altura=0;
        cor = new Cor();
        tipo = null;
        gerenciador = g;
    }

    public void setPosicao(int xn, int yn)
    {
        x = xn;
        y = yn;
    }

    public void setTamanho(int larg, int alt)
    {
        largura = larg;
        altura = alt;
    }

    public void setCor(Cor c)
    {
        cor = c;
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

    public Cor getCor()
    {
        return cor;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void Desenha()
    {

    }
}