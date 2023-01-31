package origem;

public abstract class Estado 
{
    protected GGrafico gerenciador;
    protected Imagem fundo;
    protected Bloco capa;
    protected Lista lista;
    protected Cores cores;

    Estado(GGrafico g, Cores c)
    {
        gerenciador = g;
        cores = c;
    }

    public void inicializa_Elementos()
    {   
        lista = new Lista();
        gerenciador.setLista(lista);

        fundo = new Imagem(gerenciador);
        fundo.setTamanho(gerenciador.getLargura(), gerenciador.getAltura());
        fundo.setPosicao(0, 0);
        fundo.setTextura("src/main/java/imagens/verde.png");

        capa = new Bloco(gerenciador);
        capa.setCor(cores.getCor("Laranja"));
        capa.setAlpha(0.5f);
        capa.setTamanho(gerenciador.getLargura()*90/100,gerenciador.getAltura()*70/100);
        capa.setPosicao((gerenciador.getLargura()-capa.getLargura())/2,(gerenciador.getAltura()-capa.getAltura())/2);
        capa.setArred(gerenciador.getLargura()*5/100, gerenciador.getLargura()*5/100);
    }

}
