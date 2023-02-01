package origem;

public class Seta extends Conjunto
{
    private Imagem seta;
    private boolean esquerda;

    Seta(boolean b)
    {
        super();
        seta = new Imagem();
        esquerda = b;
    }

    public void setTamanho()
    {
        seta.setTamanho(largura, altura);
        seta.setPosicao(x, y);
    }

    public void setImagem(String s)
    {
        seta.setTextura(s);
    }

    public Imagem getImagem()
    {
        return seta;
    }

    @Override
    public void toque()
    {
        interacao.atualiza_Calendario(esquerda?(-1):1);
    }
}
