package origem;

public class Quadrado extends Bloco
{
    Quadrado()
    {
        super();
    }

    @Override
    public void Desenha()
    {
        gerenciador.Desenha(this);
    }
}
