package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static Elemento teste1, teste2, teste3;
    private static Lista lista;

    public static void main(String[] args)
    {
        System.out.println("Teste");
        lista = new Lista();
        gerenciador = new GGrafico(lista);
        Inicializa_Elementos();
        gerenciador.Desenha();
    }

    public static void Inicializa_Elementos()
    {   
        teste1 = new Elemento();
        teste1.setCor(255, 0, 0);
        teste1.setTamanho(100, 100);
        teste1.setPosicao(100, 200);
        lista.Insere_Elemento(teste1);

        teste2 = new Elemento();
        teste2.setCor(100, 100, 200);
        teste2.setTamanho(100, 100);
        teste2.setPosicao(200, 400);
        lista.Insere_Elemento(teste2);

        teste3 = new Elemento();
        teste3.setCor(0, 0, 0);
        teste3.setTamanho(100, 100);
        teste3.setPosicao(0, 0);
        lista.Insere_Elemento(teste3);

        //teste
    }
}
