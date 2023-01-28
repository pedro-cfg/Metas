package origem;

public class Imagem extends Elemento
{
    private Textura tex;
    private int largura, altura;

    Imagem(GGrafico g)
    {
        super(g);
        tex = new Textura();
    }
    
    public void setTextura(String s)
    {
        tex.setImagem(s);
    }

    public Textura getTextura()
    {
        return tex;
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

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
