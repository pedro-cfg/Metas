package origem;

public class Calendario {
    private Bloco bloco;
    private GGrafico gerenciador;
    private int linha, coluna;

    Calendario(GGrafico g)
    {
        gerenciador = g;
        bloco = new Bloco(g);
    }

    public void inicia(int i, int j)
    {
        linha = i;
        coluna = j;
        int larguraTela = gerenciador.getLargura();
        int alturaTela = gerenciador.getAltura();
        int ladoBloco = larguraTela*9/100;

        bloco.setTamanho(ladoBloco, ladoBloco);
        bloco.setPosicao(larguraTela/20+larguraTela*7/60+coluna*larguraTela/9-ladoBloco/2,alturaTela*3/20+alturaTela*11/60+linha*alturaTela/15-ladoBloco/2);
        bloco.setArred(larguraTela/36, larguraTela/36);
    }

    public void setCorBloco(Cor c)
    {
        bloco.setCor(c);
    }

    public void insereLista(Lista l)
    {
        l.Insere_Elemento(bloco);
    }

    public Bloco getBloco()
    {
        return bloco;
    }
    
}
