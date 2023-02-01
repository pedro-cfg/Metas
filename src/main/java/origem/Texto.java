package origem;

public class Texto extends Elemento
{
    private String texto, fonte;
    private Cor cor;
    private boolean negrito;
    private int tamanho;

    Texto()
    {
        super();
        fonte = "Segoe Script";
        negrito = false;
        tamanho = 12;
    }

    public void setTexto(String t)
    {
        texto = t;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setFonte(String f)
    {
        fonte = f;
    }

    public String getFonte()
    {
        return fonte;
    }

    public void setCor(Cor c)
    {
        cor = c;
    }

    public Cor getCor()
    {
        return cor;
    }

    public void setNegrito(boolean b)
    {
        negrito = b;
    }

    public boolean getNegrito()
    {
        return negrito;
    }

    public void setTamanho(int t)
    {
        tamanho = t;
    }

    public int getTamanho()
    {
        return tamanho;
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
