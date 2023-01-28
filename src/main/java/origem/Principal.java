package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cor bege, branco; 
    private static Bloco capa;
    private static Calendario[] calendario;
    private static Imagem fundo, teste;
    private static Texto texto;
    private static Lista lista;

    public static void main(String[] args)
    {
        lista = new Lista();
        gerenciador = new GGrafico(lista);
        interacao = new GInteracao(gerenciador);
        Inicializa_Cores();
        Inicializa_Elementos();
        interacao.setElemento(teste);
        gerenciador.Redesenha();
    }

    public static void Inicializa_Cores()
    {
        bege = new Cor();
        bege.setCor(254, 229, 162);

        branco = new Cor();
        branco.setCor(255, 255, 255);
    }

    public static void Inicializa_Elementos()
    {   
        fundo = new Imagem(gerenciador);
        fundo.setTamanho(gerenciador.getLargura(), gerenciador.getAltura());
        fundo.setPosicao(0, 0);
        fundo.setTextura("src/main/java/imagens/verde.png");
        lista.Insere_Elemento(fundo);

        capa = new Bloco(gerenciador);
        capa.setCor(bege);
        capa.setTamanho(gerenciador.getLargura()*90/100,gerenciador.getAltura()*70/100);
        capa.setPosicao(gerenciador.getLargura()*5/100,gerenciador.getAltura()*15/100);
        capa.setArred(gerenciador.getLargura()*5/100, gerenciador.getLargura()*5/100);
        lista.Insere_Elemento(capa);

        calendario = new Calendario[42];
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                calendario[i*5+j] = new Calendario(gerenciador);
                calendario[i*5+j].setCorBloco(branco);
                calendario[i*5+j].inicia(i,j);
                calendario[i*5+j].insereLista(lista);
            }
        }

        texto = new Texto(gerenciador);
        texto.setPosicao(100, 100);
        texto.setTexto("Teste");
        texto.setCor(branco);
        texto.setTamanho(100);
        lista.Insere_Elemento(texto);

        teste = new Imagem(gerenciador);
        teste.setTamanho(200, 200);
        teste.setPosicao(150, 500);
        teste.setTextura("src/main/java/imagens/java.png");
        lista.Insere_Elemento(teste);
    }
}
