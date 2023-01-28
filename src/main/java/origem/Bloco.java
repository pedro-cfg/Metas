package origem;

public class Bloco extends Elemento
{
    private int arredX, arredY, largura, altura;
    
    private Cor cor;

    Bloco(GGrafico g)
    {
        super(g);
        arredX = arredY = largura = altura = 0;

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

    public void setCor(Cor c)
    {
        cor = c;
    }

    public Cor getCor()
    {
        return cor;
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
