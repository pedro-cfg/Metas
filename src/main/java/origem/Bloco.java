package origem;

public class Bloco extends Elemento
{
    private int arredX, arredY;

    Bloco(GGrafico g)
    {
        super(g);
        arredX = arredY = 0;
        tipo = "Bloco";
    }

    public void setArred(int xn, int yn)
    {
        arredX = xn;
        arredY = yn;
    }

    public int getArredX()
    {
        return arredX;
    }

    public int getArredY()
    {
        return arredY;
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha_Bloco(this);
    }
}
