package origem;

public class Elemento 
{
    private int x,y,largura,altura;
    private Cor cor;

    Elemento()
    {
        x=0;
        y=0;
        largura=0;
        altura=0;
        cor = new Cor();
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

    public void setCor(int r, int g, int b)
    {
        cor.setCor(r, g, b);
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

    public void Desenha(GGrafico ger)
    {
        ger.Atualiza_Elemento(this);
        ger.Desenha();
    }
}

class Cor 
{
    private int vermelho,verde,azul;

    Cor()
    {
        vermelho = verde = azul = 0;
    }

    public void setCor(int r, int g, int b)
    {
        vermelho = r;
        verde = g;
        azul = b;
    }

    public int getVermelho()
    {
        return vermelho;
    }

    public int getVerde()
    {
        return verde;
    }

    public int getAzul()
    {
        return azul;
    }
}
