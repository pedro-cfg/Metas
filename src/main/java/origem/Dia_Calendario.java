package origem;

public class Dia_Calendario extends Conjunto
{
    private Bloco bloco;
    private Texto texto;
    private Data data;

    Dia_Calendario(Data d)
    {
        super();
        data = d;
        inicia();
    }

    public void inicia()
    {
        int larguraTela = gerenciador.getLargura();
        int alturaTela = gerenciador.getAltura();
        largura = altura = larguraTela*9/100;
        x = larguraTela/20+larguraTela*7/60+data.getColuna()*larguraTela/9-largura/2;
        y = alturaTela*3/20+alturaTela*8/60+data.getLinha()*alturaTela/15-largura/2;
        y+=alturaTela/15-largura/2+largura;
        bloco = new Bloco();
        bloco.setPosicao(x,y);
        bloco.setTamanho(largura, altura);
        bloco.setArred(larguraTela/36, larguraTela/36);
        bloco.setCor(cores.getCor("Branco"));
        texto = new Texto();
        texto.setCor(cores.getCor("Preto"));
        texto.setTamanho(largura*7/10);
        String s = new Integer(data.getDia()).toString();
        texto.setTexto(s);
        texto.setPosicao(x+(largura-gerenciador.getLarguraFonte(texto))/2, y+largura*4/5);
    }

    public void insere_Elementos(Lista l)
    {
        l.insere_Elemento(bloco);
        l.insere_Elemento(texto);
    }
    
    @Override
    public void toque()
    {
        
    }
}
