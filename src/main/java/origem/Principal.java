package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cores cores;
    private static Lista elementos, conjuntos;
    private static Menu_Calendario menu_calendario;

    public static void main(String[] args)
    {
        while(gerenciador == null)
        {
            elementos = new Lista();
            conjuntos = new Lista();
            gerenciador = new GGrafico(elementos);
            interacao = new GInteracao();
            cores = new Cores();
            menu_calendario = new Menu_Calendario();
            menu_calendario.inicia();
            menu_calendario.insere_Elementos_Calendario();
            interacao.Inicia(menu_calendario);
        }
        gerenciador.redesenha();
    }

    public static GGrafico getGGrafico()
    {
        return gerenciador;
    }

    public static GInteracao getGInteracao()
    {
        return interacao;
    }

    public static Cores getCores()
    {
        return cores;
    }

    public static Lista getListaElementos()
    {
        return elementos;
    }

    public static Lista getListaConjuntos()
    {
        return conjuntos;
    }
}
