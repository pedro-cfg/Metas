package origem;

public class Linha extends Elemento
{
    private int x2, y2, grossura;
    private Cor cor;

    Linha()
    {
        super();
    }

    public void setPos2(int x, int y)
    {
        x2 = x;
        y2 = y;
    }

    public int getX2()
    {
        return x2;
    }

    public int getY2()
    {
        return y2;
    }

    public void setCor(Cor c)
    {
        cor = c;
    }

    public Cor getCor()
    {
        return cor;
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
