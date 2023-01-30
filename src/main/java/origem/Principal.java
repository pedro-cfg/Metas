package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cor bege, branco, preto; 
    private static Bloco capa;
    private static Calendario[] calendario;
    private static Data[] d;
    private static Imagem fundo, teste;
    private static Texto texto;
    private static Lista lista;

    public static void main(String[] args)
    {
        lista = new Lista();
        gerenciador = new GGrafico(lista);
        interacao = new GInteracao(gerenciador);
        inicializa_Datas();
        inicializa_Cores();
        inicializa_Elementos();
        interacao.setElemento(teste);
        insere_Elementos_Calendario();
        gerenciador.Redesenha();
    }

    public static void inicializa_Cores()
    {
        preto = new Cor();
        preto.setCor(0, 0, 0);

        bege = new Cor();
        bege.setCor(254, 229, 162);

        branco = new Cor();
        branco.setCor(255, 255, 255);
    }

    public static void inicializa_Datas()
    {
        Data.atualiza();
        int ano = Data.getAnoAtual();
        int cont = 0;
        boolean bi = false;
        if(ano%4==0 && ano%100!=0 || ano%4==0 && ano%100==0 && ano%400==0)
            bi = true;
        d = new Data[bi?366:365];
        for(int i = 1;i <= 12; i++)
        {
            if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
            {
                for(int j=1;j<=31;j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
            else if(i==4||i==6||i==9||i==11)
            {
                for(int j=1;j<=30;j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
            else
            {
                for(int j=1;j<=(bi?29:28);j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
        }
    }

    public static void inicializa_Elementos()
    {   
        fundo = new Imagem(gerenciador);
        fundo.setTamanho(gerenciador.getLargura(), gerenciador.getAltura());
        fundo.setPosicao(0, 0);
        fundo.setTextura("src/main/java/imagens/verde.png");

        capa = new Bloco(gerenciador);
        capa.setCor(bege);
        capa.setTamanho(gerenciador.getLargura()*90/100,gerenciador.getAltura()*70/100);
        capa.setPosicao(gerenciador.getLargura()*5/100,gerenciador.getAltura()*15/100);
        capa.setArred(gerenciador.getLargura()*5/100, gerenciador.getLargura()*5/100);

        Calendario.setMes(12);
        Calendario.setAno(Data.getAnoAtual());
        Calendario.setDatas(d);
        calendario = new Calendario[49];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                calendario[i*7+j] = new Calendario(gerenciador);
                calendario[i*7+j].setCores(branco,preto);
                calendario[i*7+j].inicia(i,j);
            }
        }
        Calendario.iniciaTextMes(gerenciador, preto);

        texto = new Texto(gerenciador);
        texto.setPosicao(0, 100);
        texto.setTexto("Teste");
        texto.setCor(branco);
        texto.setTamanho(100);

        teste = new Imagem(gerenciador);
        teste.setTamanho(200, 200);
        teste.setPosicao(150, 500);
        teste.setTextura("src/main/java/imagens/java.png");
    }

    public static void insere_Elementos_Calendario()
    {
        lista.Insere_Elemento(fundo);
        lista.Insere_Elemento(capa);
        for(int i=0;i<49;i++)
        {
                calendario[i].insereLista(lista);
        }
        lista.Insere_Elemento(Calendario.getTextMesTexto());
        lista.Insere_Elemento(texto);
        lista.Insere_Elemento(teste);
    }
}
