package origem;

public class Menu_Inicio extends Estado
{
    private int num, meta;
    private Texto num_texto, meta_texto;
    private Texto[] titulo;
    private Linha linha;
    private Botao_Inicio botao;

    Menu_Inicio()
    {
        super();
        num = 0;
        meta = 200;
    }

    public void inicia()
    {
        inicializa_Elementos();
        inicializa_Tudo();
    }

    public void insere_Elementos()
    {
        lista_elem.insere_Elemento(fundo);
        lista_elem.insere_Elemento(capa);
        for(int i=0;i<3;i++)
            lista_elem.insere_Elemento(titulo[i]);
        lista_elem.insere_Elemento(num_texto);
        lista_elem.insere_Elemento(meta_texto);
        lista_elem.insere_Elemento(linha);
        botao.insere_Elementos(lista_elem);
    }

    public void insere_Conjuntos()
    {
        lista_conj.insere_Conjunto(botao);   
    }

    public void inicializa_Tudo()
    {
        int larguraTela = gerenciador.getLargura();
        int alturaTela = gerenciador.getAltura();

        titulo = new Texto[3];
        for(int i=0;i<3;i++)
        {
            titulo[i] = new Texto();
            titulo[i].setCor(cores.getCor("Preto"));
            titulo[i].setTamanho(larguraTela*17/100);
            titulo[i].setFonte("Serif");
            titulo[i].setNegrito(true);
        }
        titulo[0].setTexto("Contador");
        titulo[0].setPosicao((larguraTela-gerenciador.getLarguraFonte(titulo[0]))/2, alturaTela*18/100);
        titulo[1].setTexto("de");
        titulo[1].setPosicao((larguraTela-gerenciador.getLarguraFonte(titulo[1]))/2, alturaTela*26/100);
        titulo[2].setTexto("Metas");
        titulo[2].setPosicao((larguraTela-gerenciador.getLarguraFonte(titulo[2]))/2, alturaTela*34/100);

        num_texto = new Texto();
        num_texto.setCor(cores.getCor("Preto"));
        num_texto.setTamanho(larguraTela*10/100);
        num_texto.setTexto(new Integer(num).toString());
        num_texto.setPosicao((larguraTela-gerenciador.getLarguraFonte(num_texto))/2, alturaTela*51/100);

        meta_texto = new Texto();
        meta_texto.setCor(cores.getCor("Preto"));
        meta_texto.setTamanho(larguraTela*10/100);
        meta_texto.setTexto(new Integer(meta).toString());
        meta_texto.setPosicao((larguraTela-gerenciador.getLarguraFonte(meta_texto))/2, alturaTela*57/100);

        linha = new Linha();
        linha.setCor(cores.getCor("Preto"));
        linha.setGrossura(3);
        linha.setPosicao(larguraTela*35/100, alturaTela*52/100);
        linha.setPos2(larguraTela*65/100, alturaTela*52/100);

        botao = new Botao_Inicio(true);
        botao.setParametros(larguraTela*30/100,alturaTela*80/100, larguraTela*40/100, alturaTela*4/100 );  
        botao.setTexto("Calendário");
        botao.inicia();
    }

    public void setNum(int n)
    {
        num = n;
    }

    public int getNum()
    {
        return num;
    }

    public void atualizaTextNum()
    {
        num_texto.setTexto(new Integer(num).toString());
        num_texto.setPosicao((gerenciador.getLargura()-gerenciador.getLarguraFonte(num_texto))/2, gerenciador.getAltura()*51/100);
    }

    @Override
    public void atualiza()
    {
        limpa_lista();
        atualizaTextNum();
        insere_Elementos();
        insere_Conjuntos();
    } 
}
