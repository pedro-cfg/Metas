package origem;

public class Cor 
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
