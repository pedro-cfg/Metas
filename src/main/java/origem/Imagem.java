package origem;

public class Imagem extends Elemento
{
    private Textura tex;

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

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
