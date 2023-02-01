package origem;

public class Menu_Calendario extends Estado
{
    private Calendario calendario;
    private Bloco[] blocos;
    private Texto[] dia;
    private Texto mes;
    private Seta setaesq, setadir;

    Menu_Calendario()
    {
        super();
        calendario = new Calendario();
    }

    public void inicia()
    {
        inicializa_Elementos();
        calendario.geraDatas();
        inicializa_Calendario();
        insere_Conjuntos();
    }

    public void insere_Elementos_Calendario()
    {
        lista_elem.insere_Elemento(fundo);
        lista_elem.insere_Elemento(capa);
        for(int i=0;i<42;i++)
            lista_elem.insere_Elemento(blocos[i]);
        for(int i=0;i<7;i++)
            lista_elem.insere_Elemento(dia[i]);
        lista_elem.insere_Elemento(mes);
        lista_elem.insere_Elemento(setadir.getImagem());
        lista_elem.insere_Elemento(setaesq.getImagem());
        calendario.insere_elementos_lista(lista_elem);
    }

    public void insere_Conjuntos()
    {
        lista_conj.insere_Conjunto(setadir);
        lista_conj.insere_Conjunto(setaesq);
        calendario.insere_conjuntos_lista(lista_conj);
    }

    public void inicializa_Calendario()
    {
        blocos = new Bloco[42];
        int larguraTela = gerenciador.getLargura();
        int alturaTela = gerenciador.getAltura();
        int largura = larguraTela*9/100;
        int x, y;
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                x = larguraTela/20+larguraTela*7/60+j*larguraTela/9-largura/2;
                y = alturaTela*3/20+alturaTela*8/60+i*alturaTela/15-largura/2;
                y+=alturaTela/15-largura/2+largura;

                blocos[i*7+j] = new Bloco();
                blocos[i*7+j].setPosicao(x,y);
                blocos[i*7+j].setTamanho(largura, largura);
                blocos[i*7+j].setArred(larguraTela/36, larguraTela/36);
                blocos[i*7+j].setAlpha(0.5f);
                blocos[i*7+j].setCor(cores.getCor("Cinza"));
            }
        }
        dia = new Texto[7];
        y = alturaTela*3/20+alturaTela*8/60;
        for(int i=0;i<7;i++)
        {
            x = larguraTela/20+larguraTela*7/60+i*larguraTela/9-largura/2;
            dia[i] = new Texto();
            dia[i].setTamanho(blocos[1].getLargura()*7/10);
            dia[i].setPosicao(x, y);
            dia[i].setCor(cores.getCor("Preto"));
        }
        dia[0].setTexto("D");
        dia[1].setTexto("S");
        dia[2].setTexto("T");
        dia[3].setTexto("Q");
        dia[4].setTexto("Q");
        dia[5].setTexto("S");
        dia[6].setTexto("S");
        for(int i=0;i<7;i++)
            dia[i].setPosicao(dia[i].getX()+(largura-gerenciador.getLarguraFonte(dia[i]))/2, dia[i].getY()+largura*4/5);  
        mes = new Texto();
        mes.setCor(cores.getCor("Preto"));
        mes.setTamanho(gerenciador.getLargura()/10);
        mes.setTexto(getTextoMes(calendario.getMes()));
        mes.setPosicao((larguraTela-gerenciador.getLarguraFonte(mes))/2, alturaTela*24/100);
        y = alturaTela*20/100;
        x = larguraTela*8/10;
        setadir = new Seta(false);
        setadir.setParametros(x, y, largura, largura);
        setadir.setImagem("src/main/java/imagens/seta.png");
        setadir.setTamanho();
        x = larguraTela*2/10 - largura;
        setaesq = new Seta(true);
        setaesq.setParametros(x, y, largura, largura);
        setaesq.setImagem("src/main/java/imagens/setainv.png");
        setaesq.setTamanho();
    }

    private String getTextoMes(int mes)
    {
        switch(mes)
        {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
        }
        return "ERRO";
    }


    public void atualizaCalendario(int adi)
    {
        int novo = calendario.getMes() + adi;
        if(novo > 0 && novo < 13){
            calendario.setMes(novo);
            mes.setTexto(getTextoMes(novo));
            mes.setPosicao((gerenciador.getLargura()-gerenciador.getLarguraFonte(mes))/2, gerenciador.getAltura()*24/100);
        }
    }
}
