package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cor preto, vermelho, roxo, marrom; 
    private static Bloco fundo, teste1, teste2, teste3;
    private static Imagem teste;
    private static Lista lista;

    public static void main(String[] args)
    {
        System.out.println("Teste");
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
        preto = new Cor();

        marrom = new Cor();
        marrom.setCor(110, 40, 0);

        vermelho = new Cor();
        vermelho.setCor(255, 0, 0);

        roxo = new Cor();
        roxo.setCor(100, 100, 200);
    }

    public static void Inicializa_Elementos()
    {   
        fundo = new Bloco(gerenciador);
        fundo.setTamanho(gerenciador.getLargura(), gerenciador.getAltura());
        fundo.setPosicao(0, 0);
        fundo.setCor(marrom);
        lista.Insere_Elemento(fundo);

        teste1 = new Bloco(gerenciador);
        teste1.setCor(vermelho);
        teste1.setTamanho(100, 100);
        teste1.setPosicao(100, 200);
        lista.Insere_Elemento(teste1);

        teste2 = new Bloco(gerenciador);
        teste2.setCor(roxo);
        teste2.setTamanho(100, 100);
        teste2.setPosicao(200, 400);
        lista.Insere_Elemento(teste2);

        teste3 = new Bloco(gerenciador);
        teste3.setCor(preto);
        teste3.setTamanho(100, 100);
        teste3.setPosicao(0, 0);
        lista.Insere_Elemento(teste3);

        teste = new Imagem(gerenciador);
        teste.setTamanho(200, 200);
        teste.setPosicao(150, 500);
        teste.setTextura("src/main/java/imagens/java.png");
        lista.Insere_Elemento(teste);
    }
}
